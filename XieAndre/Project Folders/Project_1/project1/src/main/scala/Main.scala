import java.sql.DriverManager
import java.sql.Connection
import scala.annotation.meta.setter

import com.github.tototoshi.csv._
import java.io.File
import java.io.FileNotFoundException
import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.FileReader
import java.lang.ExceptionInInitializerError
import org.postgresql.util.PSQLException
import org.apache.hive.jdbc.HiveDriver

import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.LogManager

import java.sql.ResultSetMetaData
import scala.io.StdIn.readLine


object HSQL{
  val driver = "org.apache.hive.jdbc.HiveDriver"
  var url = ""
  var username = "" //i.e "postgres"
  var password = ""

  var connection: Connection = null

  def setCreds(newUser: String, newPassword: Array[Char], newDatabase: String, ini_url: String = "jdbc:hive2://localhost:10000/default") = {
    username = newUser
    password = newPassword.mkString
    url = ini_url + newDatabase
    // make the connection
    Class.forName(driver)
    //connect to hive database 

    connection = DriverManager.getConnection(url, username, password)
  }


  def executeQuery(query: String): Unit = {
    val statement = connection.createStatement()
    statement.executeQuery(query)
  }

  def select(query: String, print: Boolean = false, printLimit: Int = 50): Seq[Any] = {

    var swap = ""
    var select_split = query.split(" ")
    select_split.foreach(arg => {
      swap = arg.replace(",", "")
      select_split.drop(select_split.indexOf(arg))
      select_split.update(select_split.indexOf(arg), swap)
    })

    var columns = select_split.slice(1, select_split.indexOf("FROM"))
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(query)
    var rows = Seq[Object]()
    val rsMetaData = resultSet.getMetaData()
    val count = rsMetaData.getColumnCount()
    var rowNames = Seq[String]()
    val colName = ""
    for (i <- 1 to count)
    {
      var nextColName = colName
      nextColName += rsMetaData.getColumnName(i)
      //adds spacing to end of column name
      for (j <- nextColName.length to 16)
      {
        nextColName += " "
      }
      rowNames = rowNames :+ nextColName
    }
    if (print) {
      println(rowNames.toString.substring(4))
      println("---------------------------------------------------------------------------------------")
      while(resultSet.next()){
        var row = Seq[String]()
        for (i <- 1 to resultSet.getMetaData.getColumnCount) {
          val spacing = 16
          var dataString = "NULL"
          if (resultSet.getString(i) != null)
          {
            dataString = resultSet.getString(i)
          }
          var newDataString = dataString
          for (j <- dataString.length to spacing)
          {
            newDataString += " "
          }
          row = row :+ newDataString

        }
        rows = rows :+ row
      }
      //remove the "List" from start of each row

      rows.take(printLimit).foreach{ r => println(r.toString.substring(4))}
      println("---------------------------------------------------------------------------------------")
    }
    if(print){
      if(rows.length > printLimit){
        println("... and " + (rows.length-printLimit) + " more rows.")
      }
    }

    rows
  }

  def verifyConnection(): Boolean = {
    try {
      val statement = connection.createStatement()
      statement.executeQuery("SELECT 1")
      true
    } catch {
      case e: Exception => false
    }
  }

}



object Main{

  def main(args: Array[String]): Unit = {
    println("Password: ")
    //val password = System.console().readPassword()
    val password = "hive".toCharArray()

    //HSQL.setCreds("hive", password, "test", "jdbc:hive2://localhost:10000/")

    //HSQL.setCreds("hive", password, "test", "jdbc:hive2://sandbox-hdp.hortonworks.com:2181/default")
    /*
    if (HSQL.verifyConnection()) {
      println("Successfully connected to Hive.")
    */  

    println("========================================APP START========================================")
    Application.app()
  } 
}

object Application {

  def app():Unit = {
    println("type a command\n     S - SELECT|     U - UPDATE|     D - DELETE|      I - INSERT|       Q - QUIT\n\n")
    try {
      var response = readLine()
      if (response.equalsIgnoreCase("S")) {
        Application.select()
      } else if (response.equalsIgnoreCase("U")) {
        Application.update()
      } else if (response.equalsIgnoreCase("D")) {
        Application.delete()
      } else if (response.equalsIgnoreCase("I")) {
        Application.insert()
      } else if (response.equalsIgnoreCase("Q")) {
        println("========================================END APP========================================")
      } else {
        throw new InvalidInputException
      }
    } catch {
      case e: InvalidInputException => {
        println("     INVALID INPUT\n\n     VALID INPUTS ARE 'S', 'U', 'D', 'I', 'Q'\n     TRY AGAIN")
        Application.app()
      }
    }
  }
  def select():Unit = {
    println("Type the Select statement that you would like to run")

    var response = readLine()
    response.replace(";", " ")
    if (response.equalsIgnoreCase("Q")) {

      println("RETURNING TO MAIN MENU")
      Application.app()

    } else {
      HSQL.select(s"$response", true)
      println()
      Application.app()
    }
  }

  def update():Unit = {
    println("Type the Update statement that you would like to run")

    var response = readLine()
    response.replace(";", "")

    if (response.equalsIgnoreCase("Q")) {
      println("RETURNING TO MAIN MENU")
      Application.app()

    } else {
      HSQL.executeQuery(s"$response")
      println()
      Application.app()
    }
  }

  def delete():Unit = {
    println("Type the Delete statement that you would like to run")

    var response = readLine()
    response.replace(";", "")

    if (response.equalsIgnoreCase("Q")) {
      println("RETURNING TO MAIN MENU")
      Application.app()

    } else {
      HSQL.executeQuery(s"$response")
      println()
      Application.app()
    }
  }

  def insert():Unit = {
    println("Type the Insert statement that you would like to run")

    var response = readLine()
    response.replace(";", "")

    if (response.equalsIgnoreCase("Q")) {
      println("RETURNING TO MAIN MENU")
      Application.app()

    } else {
      HSQL.executeQuery(s"$response")
      println()
      Application.app()
    }
  }

}

class InvalidInputException extends Exception {}
