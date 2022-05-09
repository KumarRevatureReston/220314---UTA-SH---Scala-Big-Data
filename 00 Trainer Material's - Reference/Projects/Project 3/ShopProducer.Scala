// ShopProducer.scala
// $KAFKA_HOME/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic shops_records
// $KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server sandbox-hdp.hortonworks.com:6667 --topic shops_records
// spark-submit --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.3.0,net.liftweb:lift-json_2.11:3.5.0 kafkaspark_2.11-0.1.0-SNAPSHOT.jar --class example.ShopProducer
// OR
// cp kafkaspark_2.11-0.1.0-SNAPSHOT.jar shopproducer.jar
// spark-submit --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.3.0,net.liftweb:lift-json_2.11:3.5.0 shopproducer.jar --class example.ShopProducer

package example

import example.Domain.SalesRecord
import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import net.liftweb.json._
import net.liftweb.json.Serialization.write

object ShopProducer {
  def main_sp(args: Array[String]): Unit = {
    val props: Properties = new Properties()
    //props.put("bootstrap.servers","localhost:9092")
    props.put("bootstrap.servers", "sandbox-hdp.hortonworks.com:6667")
    props.put(
      "key.serializer",
      "org.apache.kafka.common.serialization.StringSerializer"
    )
    props.put(
      "value.serializer",
      "org.apache.kafka.common.serialization.StringSerializer"
    )

    val producer = new KafkaProducer[String, String](props)
    val topic = "shops_records"
    try {
      for (i <- 0 to 15) {
        println(s"Running cycle # $i...")
        val shopData = ProducerGenerator.generateRecords(1000).toList
        implicit val formats = DefaultFormats
        //val shopDataJson = write(shopData)
        //println(shopDataJson)
        // val shopId = (parse(shopDataJson) \ "shopId").extract[String]
        // val record = new ProducerRecord[String, String](topic,
        //     shopDataJson
        // )
        shopData.map(r => {
          val jsonString = write(r)
          println(jsonString)
          val json = parse(jsonString)
          val record = new ProducerRecord[String, String](topic, jsonString)

          val metadata = producer.send(record)
          printf(
            s"sent record(key=%s value=%s) " +
              "meta(partition=%d, offset=%d)\n",
            record.key(),
            record.value(),
            metadata.get().partition(),
            metadata.get().offset()
          )
        })

        val ms = 10000
        println(s"Completed cycle # $i...")
        println(s"Going to sleep for $ms milliseconds...")
        Thread.sleep(ms)
      }
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      producer.close()
    }
  }
}
