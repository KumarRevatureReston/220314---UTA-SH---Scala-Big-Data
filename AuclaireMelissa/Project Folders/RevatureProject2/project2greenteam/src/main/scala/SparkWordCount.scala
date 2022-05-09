import org.apache.spark.sql.SparkSession

object Main {
  def rollNo(N: Int, A: Array[Int]): Int = {
    var result: Int = -404
    // write my logic here


    return result
  }
  def main(args: Array[String]) {
    // INPUT [uncomment & modify if required]
    val N: Int = scala.io.StdIn.readLine.toInt
    var A = new Array [Int](N);
    for(i<- 0 to N-1)
    {
      A(i) = scala.io.StdIn.readLine.toInt
    }
    // OUTPUT [uncomment & modify if required]
    println(rollNo(N,A))
  }
}


object SparkWordCount extends App {
  val spark = SparkSession.builder.master("local[*]")
    .appName("Spark Word Count").getOrCreate()

  val lines = spark.sparkContext.parallelize(
    Seq("Spark Intellij Idea Scala test one",
      "Spark Intellij Idea Scala test two",
      "Spark Intellij Idea Scala test three"))

  val counts = lines.flatMap(line => line.split(" "))
    .map(word => (word, 1))
    .reduceByKey(_ + _)

  counts.foreach(println)
}
