import org.apache.spark.SparkConf
import org.apache.spark._
import org.apache.spark.sql._
//import org.apache.spark.sql.hive.HiveContext
//import org.apache.spark.sql.hive.orc._

import java.sql.DriverManager
import java.sql.Connection
import scala.annotation.meta.setter

import java.io.File
import java.io.FileNotFoundException
import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.FileReader
import java.lang.ExceptionInInitializerError
//import org.postgresql.util.PSQLException
//import org.apache.hive.jdbc.HiveDriver

import java.sql.ResultSetMetaData

import java.sql.ResultSetMetaData

object HelloWorld {
    
    def main(args: Array[String]): Unit = {
        val logFile = "file:///tmp/words.txt" // Should be some file on your system
        val conf = new SparkConf().setAppName("Simple Application").setMaster("spark://174.103.197.148:4040")
        val sc = new SparkContext(conf)
        val logData = sc.textFile(logFile, 2).cache()
        val numAs = logData.filter(line => line.contains("a")).count()
        val numBs = logData.filter(line => line.contains("b")).count()
        println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
    }
    
}
