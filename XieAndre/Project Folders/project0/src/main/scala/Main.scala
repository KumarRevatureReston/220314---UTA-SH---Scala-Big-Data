import java.sql.DriverManager
import java.sql.Connection
import scala.annotation.meta.setter
import scala.annotation.varargs
import io.StdIn._

trait OutputFunctions {
  def printRed(str: String) = {
    Console.println("\u001b[31m" + str + "\u001b[0m")
  }
}

object PostGreSQL extends OutputFunctions {
  val driver = "org.postgresql.Driver"
  val url = "jdbc:postgresql://localhost:5432/airports"
  val user_name = "postgres"
  val password = "Blowfish2365@!"
  var connection: Connection = null

  assert(password != "password", printRed("Please change the password in PostGreSQL.scala"))

  // make the connection
  Class.forName(driver)
  connection = DriverManager.getConnection(url, user_name, password)
  
  def updateTable(sql: String): Unit = {
    val statement = connection.createStatement()
    statement.executeUpdate(sql)
  }

  // return 2d array of strings
  def selectFromTable(query: String): Any = {
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(query)

    println("   "+"id"+"\t"+"name"+"\t"+"continent")
  
    while(resultSet.next()){

      var row = ""
      for (i <- 1 to resultSet.getMetaData.getColumnCount) {
        row = row + "   " + resultSet.getString(i)
      }
      println(row)
    }

    //BRUTE FORCE SOLUTION
    /*
    var i = 0
    while (resultSet.next()) {
      val id = resultSet.getInt("id")
      val name = resultSet.getString("name")
      val continent = resultSet.getString("continent")

      println(i.toString + "\t" + id.toString() + "\t" + name + "\t" + continent)
      i = i + 1
    }
    */
  }


  def closeConnection(): Unit = {
    connection.close()
  }
}

// ====MAIN=====
object Project0 extends App{

    println("Scala Postgre Examples")
    println("1. Create Table")
    println("2. Insert to Table")
    println("3. Delete from Table")
    println("4. Show Table")
    println("5. Drop Table")
    println("Input any other number to exit")

    val input = readInt

    val y = Array((1, "Dummy_1", "NA"), (2, "Dummy_2", "NA"), (3, "Dummy_3","CN"), (4, "Dummy_4", "JP"))
    println("Trying input...")

    if (input == 1){
      //CREATE TABLE
      PostGreSQL.updateTable("CREATE TABLE airports_test (id INT, name TEXT, continent TEXT);")
      val myArr=PostGreSQL.selectFromTable("SELECT * FROM airports_test;")
    } else if (input == 2){
      //INSERT DATA TO TABLE
      y.foreach(arg => {
      PostGreSQL.updateTable("INSERT INTO airports_test (id, name, continent) VALUES ("+arg._1+", '"+arg._2+"', '"+arg._3+"');")
      })
      val myArr=PostGreSQL.selectFromTable("SELECT * FROM airports_test;")
    } else if (input == 3){
      //REMOVING DATA FROM TABLE
      y.foreach(arg => {
      PostGreSQL.updateTable("DELETE FROM airports_test WHERE continent = 'NA';")
      })
      val myArr=PostGreSQL.selectFromTable("SELECT * FROM airports_test;")
    } else if (input == 4){
      //READ FROM TABLE
      val myArr=PostGreSQL.selectFromTable("SELECT * FROM airports_test;")
    } else if (input == 5){
      //DROPS THE TABLE
      PostGreSQL.updateTable("DROP TABLE airports_test;")
      println("Table has been deleted")
    } else {
      //EXITS 
      sys.exit()
    }

    PostGreSQL.closeConnection()
}