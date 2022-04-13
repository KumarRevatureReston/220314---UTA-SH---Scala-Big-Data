//import java.io.{BufferedReader, File, FileReader}
//import org.postgresql.copy.CopyManager
//import org.postgresql.core.BaseConnection
//import org.slf4j.LoggerFactory
//import java.nio.charset.Charset

import scala.io.StdIn.readLine
import scala.util.control.Breaks.break


object Main {

  def main(args: Array[String]): Unit = {


      println("Welcome to the Postgres helper bot. How can I help today?")
      var input = readLine()
      val nothing = "finish"

      while (input != nothing) {

        println("What would you like to do next?")

  //      if (input == "create database") {
  //        println("Database created")
  //        CrudUtil.createDatabaseQuery()
  //      }

        if (input == "create table") {
          println("A table about a list of countries has been created.")
          CrudUtil.createQuery()
        }

        if (input == "add csv file") {
          println("CSV copied into database")
          CrudUtil.copyCSVQuery()
        }

        if (input == "show table") {
          println("Showed the table")
          CrudUtil.readQuery()
        }
        if (input == "insert new data") {
          println("Inserted a new record")
          CrudUtil.insertQuery()
        }
        if (input == "update the name") {
          println("Name updated")
          CrudUtil.updateQuery()
        }
        if (input == "delete record") {
          println("Record deleted")
          CrudUtil.deleteQuery()
        }
        if (input == "delete table") {
          println("Entire table deleted")
          CrudUtil.deleteTableQuery()
        }
        input = readLine()
      }
      println("Thanks for using the Postgres bot! Have a wonderful day.")

  }
}



