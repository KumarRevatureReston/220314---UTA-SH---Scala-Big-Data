import java.sql.Connection
//import slick.driver.H2Driver.api._
//import scala.concurrent.ExecutionContext.Implicits.global
//import slick.jdbc.PostgresProfile.api._
//import slick.jdbc.JdbcBackend.Database

object CrudUtil {

  //To do pending
  //  def copyCSVToPg(): Unit = {
  //    val connection = Utility.getPostgresConnection()
  //    //connection.unwrap()
  //  }

  def createQuery(): Int = {
    //to do try catch finally
    var connection: Connection = null
    var count = 0
    try {
      connection = Utility.getPostgresConnection()
      val sql = " CREATE TABLE countries(id INT, code VARCHAR(2), name VARCHAR(100), wikipedia_(255), keywords VARCHAR(100));"
      val st = connection.createStatement()
      count = st.executeUpdate(sql)
    } //close try
    catch {
      case e: Exception => println("Exception " + e)
    } //close catch
    finally {
      if (connection != null) connection.close()
    }
    count
  }

  def readQuery(): Unit = {
    val connection = Utility.getPostgresConnection()
    val sql = " SELECT * FROM countries"
    val st = connection.createStatement()
    val resultsetexecuteQuery = st.executeQuery(sql)
  }

  def insertQuery(): Unit ={
    val connection = Utility.getPostgresConnection()
    val sql = " INSERT INTO countries (id, code, name, wikipedia_, keywords) VALUES ('111222', 'MI', 'My Island', 'https://www.wikipedia.com/myisland', 'A private island'); "
    val st = connection.createStatement()
    val resultsetexecuteQuery = st.executeQuery(sql)
  }

  def deleteQuery(): Unit = {
    val connection = Utility.getPostgresConnection()
    val sql = " DELETE FROM countries WHERE name='My Island'; "
    val st = connection.createStatement()
    val resultsetexecuteQuery = st.executeQuery(sql)
  }

  def updateQuery(): Unit = {
    val connection = Utility.getPostgresConnection()
    val sql = " UPDATE countries SET name='Biggest Island' WHERE id='111222'; "
    val st = connection.createStatement()
    val resultsetexecuteQuery = st.executeQuery(sql)
  }
}
