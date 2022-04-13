import java.sql.Connection
//import slick.driver.H2Driver.api._
//import scala.concurrent.ExecutionContext.Implicits.global
//import slick.jdbc.PostgresProfile.api._
//import slick.jdbc.JdbcBackend.Database

object CrudUtil {


//  def createDatabaseQuery(): Unit = {
//    val connection = Utility.getPostgresConnection()
//    val sql = " CREATE DATABASE countries; "
//    val st = connection.createStatement()
//    val count = st.executeUpdate(sql)
//  }

  def createQuery(): Int = {
    //to do try catch finally
    var connection: Connection = null
    var count = 0
    try {
      connection = Utility.getPostgresConnection()
      val sql = " CREATE TABLE country_list(id INT, code VARCHAR(2), name VARCHAR(100), continent VARCHAR(100), wikipedia_ VARCHAR(255), keywords VARCHAR(100));"
      val st = connection.createStatement()
      count = st.executeUpdate(sql)
    } //close try
    catch {
      case e: Exception => println("Exception " + e.printStackTrace())
    } //close catch
    finally {
      if (connection != null) connection.close()
    }
    count
  }


  def copyCSVQuery(): Int = {
    //to do try catch finally
    var connection: Connection = null
    var count = 0
    try {
      connection = Utility.getPostgresConnection()
      val sql = " copy country_list FROM 'C://Users/Jessica/Desktop/countries.csv' DELIMITER ',' CSV header; "
      val st = connection.createStatement()
      count = st.executeUpdate(sql)
    } //close try
    catch {
      case e: Exception => println("Exception " + e.printStackTrace())
    } //close catch
    finally {
      if (connection != null) connection.close()
    }
    count
  }

  def readQuery(): Unit = {
    val connection = Utility.getPostgresConnection()
    val sql = " SELECT * FROM country_list; "
    val st = connection.createStatement()
    val rs = st.executeQuery(sql)

    while (rs.next()) {
      val id = rs.getInt(1)
      val code = rs.getString(2)
      val name = rs.getString(3)
      val continent = rs.getString(4)
      val wikipedia_ = rs.getString(5)
      val keywords = rs.getString(6)
     println(id, code, name, continent, wikipedia_, keywords)
    }
  }

  def insertQuery(): Unit ={
    val connection = Utility.getPostgresConnection()
    val sql = " INSERT INTO country_list (id, code, name, continent,  wikipedia_, keywords) VALUES ('111222', 'MI', 'My Island', 'No Where', 'https://www.wikipedia.com/myisland', 'A private island'); "
    val st = connection.createStatement()
    val count = st.executeUpdate(sql)
    println(count)
  }

  def deleteQuery(): Unit = {
    val connection = Utility.getPostgresConnection()
    val sql = " DELETE FROM country_list WHERE id='111222' "
    val st = connection.createStatement()
    val count = st.executeUpdate(sql)
    println("Data deleted ", count)
  }

  def deleteTableQuery(): Unit = {
    val connection = Utility.getPostgresConnection()
    val sql = " DROP TABLE country_list; "
    val st = connection.createStatement()
    val count = st.executeUpdate(sql)
    println(count)
  }

  def updateQuery(): Unit = {
    val connection = Utility.getPostgresConnection()
    val sql = " UPDATE country_list SET name='Biggest Island' WHERE id='111222'; "
    val st = connection.createStatement()
    val count = st.executeUpdate(sql)
    println(count)
  }
}
