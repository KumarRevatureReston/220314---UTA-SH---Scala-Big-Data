import java.util.{Collections, Properties}
import org.apache.kafka.clients.consumer.KafkaConsumer
import scala.collection.JavaConverters._

//Scala Libraries
import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

//Spark Libraries
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

//Play Libraries for Json
import play.api.libs.json._

object KafkaConsumer extends App {
  val spark = SparkSession.builder.master("local[*]").appName("SparkKafkaConsumer").getOrCreate()
  import spark.implicits._

  // properties for database
  val database="greenteam";
  val table = "sales_teama"
  val username="postgres"
  val password="wagle"
  val jdbcUrl = "jdbc:postgresql://localhost:5432/"

  // properties variables for connecting to kafka
  val topics = List("teamA_ecommerce")
  val groupId = "greenteam"
  val kafkaIpPort = "localhost:9092"
  //val kafkaIpPort = "3.94.111.218:9092"

  val props:Properties = new Properties()
  props.put("group.id", groupId)
  props.put("bootstrap.servers",kafkaIpPort)
  props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("enable.auto.commit", "true")
  props.put("auto.commit.interval.ms", "1000")
  props.put("auto.offset.reset", "earliest")

  val consumer = new KafkaConsumer(props)
  try {
    consumer.subscribe(topics.asJava)
    var jsonSeq = new ListBuffer[String]
    while (true) {
      val records = consumer.poll(100)
      for (record <- records.asScala) {
        var record_string: String = record.value()
        var jsonD: JsValue = Json.parse(record_string)
        jsonSeq += record_string

      }

      if(jsonSeq.nonEmpty && jsonSeq.size > 100) {
        var test = jsonSeq.toList
        var jsonDS = test.toDS()
        var df = spark.read.json(jsonDS)

        df = df.withColumn("time", to_timestamp(col("time"), "yyyy-MM-dd HH:mm:ss")).drop("datetime")
        //df = df.withColumn("datetime", to_date(col("time"), "yyyy-MM-dd")).drop("time")


        //df.show()
        //df.printSchema()


        df.createOrReplaceTempView("orders")
        var df2 = spark.sql("select * from orders")
        var props2 = new Properties()
        props2.put("driver", "org.postgresql.Driver")
        props2.put("user", username)
        props2.put("password", password)

        df2.write.mode("append").jdbc(jdbcUrl+database, table, props2)

        df.write
          .format("jdbc")
          .option("url", jdbcUrl+database)
          .option("dbtable", table)
          .option("user", username)
          .option("password", password)
          .mode("append").save()

        jsonSeq.clear()
      }

    }
  }catch{
    case e:Exception => e.printStackTrace()
  }
  finally {
    consumer.close()
  }
}









