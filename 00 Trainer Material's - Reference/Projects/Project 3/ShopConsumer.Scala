// SparkStreamWindow.scala
// $KAFKA_HOME/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic shops_records
// $KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server sandbox-hdp.hortonworks.com:6667 --topic shops_records
// spark-submit --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.3.0,net.liftweb:lift-json_2.11:3.5.0 kafkaspark_2.11-0.1.0-SNAPSHOT.jar --class example.ShopConsumer
// OR
// cp kafkaspark_2.11-0.1.0-SNAPSHOT.jar shopconsumer.jar
// spark-submit --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.3.0,net.liftweb:lift-json_2.11:3.5.0 shopconsumer.jar --class example.ShopConsumer

package example

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

object ShopConsumer {
  def main_sc(args: Array[String]): Unit = {

    println("Creating SparkSession object...")
    val spark = SparkSession.builder
      .appName("StructuredConsumerWindowing")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    println("Define our input stream...")
    // val kafkaEndpoint = "localhost:9092"                    // Default.
    val kafkaEndpoint = "sandbox-hdp.hortonworks.com:6667" // Hortonworks.

    val inputStream = spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", kafkaEndpoint)
      .option("auto.offset.reset", "latest")
      .option("value.deserializer", "StringDeserializer")
      .option("subscribe", "shops_records")
      .load

    println("The schema from the stream dataframe...")
    inputStream.printSchema()

    println(
      "Convert Kafka topic input stream value, that has a binary type, into a meaningful dataframe..."
    )
    val schema = StructType(
      List(
        StructField("transactionTimestamp", TimestampType, true),
        StructField("shopId", IntegerType, true),
        StructField("productId", IntegerType, true),
        StructField("amount", IntegerType, true),
        StructField("totalCost", DoubleType, true)
      )
    )
    val initial = inputStream.selectExpr("CAST(value AS STRING)").toDF("value")
    initial.printSchema()

    println("Convert this String, into its JSON representation...")
    val aggregation_one = initial.select(from_json(col("value"), schema))
    aggregation_one.printSchema()

    println("Select the embedded values...")
    val aggregation = initial
      .select(from_json(col("value"), schema).alias("tmp"))
      .select("tmp.*")
    aggregation.printSchema()

    println("Define the window size and watermark...")
    val windows = aggregation
      //.withWatermark("transactionTimestamp", "5 minutes")
      .withWatermark("transactionTimestamp", "1 minute")
      .groupBy(
        //window(col("transactionTimestamp"), "1 minute", "1 minute"),
        window(col("transactionTimestamp"), "5 seconds", "5 seconds"),
        col("shopId")
      )

    println("Create a dataframe with multiple aggregations...")
    import org.apache.spark.sql.functions._
    val aggregatedDF = windows.agg(sum("totalCost"), count("*"))

    println("Write the aggregated data into a sink...")
    val dfcount = aggregatedDF.writeStream
      .outputMode("complete")
      .option("truncate", false)
      .format("console")
      .start()
    dfcount.awaitTermination()
  }
}
