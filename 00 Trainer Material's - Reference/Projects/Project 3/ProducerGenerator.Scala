// ProducerGenerator.scala
// spark-submit --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.3.0,net.liftweb:lift-json_2.11:3.5.0 kafkaspark_2.11-0.1.0-SNAPSHOT.jar --class example.ProducerGenerator
package example

import java.util.Date

import example.Domain.SalesRecord
import scala.util.Random
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object ProducerGenerator {
  val productCost: Map[Int, Double] =
    Map(1 -> 9.99, 2 -> 40, 3 -> 15, 4 -> 22, 5 -> 34)
  val shopsProb: Map[Int, Double] = Map(1 -> 0.5, 2 -> 0.5)

  val productsByShopProb: Map[Int, Map[Int, Double]] = Map(
    1 -> Map(1 -> 0.3, 2 -> 0.35, 3 -> 0.15, 4 -> 0.2),
    2 -> Map(1 -> 0.35, 2 -> 0.35, 3 -> 0.15, 4 -> 0.15)
  )

  val numberItemsProb: Map[Int, Double] = Map(1 -> 0.75, 2 -> 0.2, 3 -> 0.05)

  val randomDelay = new Random()

  import java.text.SimpleDateFormat

  val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")

  def main_pg(args: Array[String]): Unit = {
    println("Generating record...")
    val rec = generateRecords(1).toList
    printRec(rec)

    val rec10 = generateRecords(10).toList
    printRec(rec10)
  }

  def printRec(rec: Seq[SalesRecord]) {
    println("Printing the record...")
    println(rec)

    import net.liftweb.json._
    import net.liftweb.json.Serialization.write
    implicit val formats = DefaultFormats
    rec.map(r => {
      val jsonString = write(r)
      println(jsonString)
      val json = parse(jsonString)
      val shopId = json \ "shopId"
      println(shopId.extract[String])
    })
  }

  // Function to generate records.
  def generateRecords(
      numberRecords: Int,
      late: Boolean = false
  ): Seq[SalesRecord] = {
    val randomPartners = new Random()

    val output = (1 to numberRecords).map { i =>
      val shopId: Int = randomValue(shopsProb)
      val product = randomValue(productsByShopProb(shopId))
      val numberOfItems = randomValue(numberItemsProb)
      val now = System.currentTimeMillis()
      val delay = randomDelay.nextInt(50)
      val timestamp = now
      val time = sdf.format(new Date(timestamp))
      SalesRecord(
        time,
        shopId,
        product,
        numberOfItems,
        productCost(product) * numberOfItems
      )
    }
    output
  }

  def randomValue[A](dist: Map[A, Double]): A = {
    val p = scala.util.Random.nextDouble
    val it = dist.iterator
    var accum = 0.0
    while (it.hasNext) {
      val (item, itemProb) = it.next
      accum += itemProb
      if (accum >= p)
        return item // return so that we don't have to search through the whole distribution
    }
    sys.error(f"This should never happen") // needed so it will compile
  }
}
