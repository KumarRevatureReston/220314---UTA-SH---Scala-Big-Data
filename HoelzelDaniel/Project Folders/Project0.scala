import java.sql.DriverManager
import java.sql.Connection
import scala.annotation.meta.setter
import scala.io.StdIn
import java.sql.{Connection, DriverManager}
import java.lang.Math._

object ScalaJdbcConnectSelect extends App {
    val driver = "org.postgresql.Driver"
    val url = "jdbc:postgresql://localhost:5432/scala_db"
    val username = "postgres"
    val password = "asdf123"
    var connection: Connection = null
    
    // connecting to database
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)
    
    def updateTable(sql: String): Unit = {
        val statement = connection.createStatement()
        statement.executeUpdate(sql)
    }
}

object Project0{
        def main(args: Array[String]): Unit = {
            
            val count = CRUD.create()
            println(count)
            
            //read
            CRUD.read()
            println(count)
    
            // update
            CRUD.update()
            println(count)
    
            //delete
            CRUD.delete()
            println(count)
    }
}//end of Project0 object

object CRUD{
    
    //create
    def  create(): Int = {
        var connection: Connection = null
        var count = 0
        try {
            connection = ScalaJdbcConnectSelect.connection
            val sql = "CREATE TABLE IF NOT EXISTS countries(id INT, code VARCHAR(2), name VARCHAR(100), wikipedia VARCHAR(255), keywords VARCHAR(50));"
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
    
    //read
    def read(): Unit = {
        val connection = ScalaJdbcConnectSelect.connection
        val sql = " SELECT * FROM countries"
        val st = connection.createStatement()
        val resultsetexecuteQuery = st.executeQuery(sql)
    }
    
    //update
    def update(): Unit = {
        val connection = ScalaJdbcConnectSelect.connection
        val sql = " UPDATE countries SET name='Africa' WHERE id='123456'; "
        val st = connection.createStatement()
        val resultsetexecuteQuery = st.executeQuery(sql)
    }
    
    //delete
    def delete(): Unit = {
        val connection = ScalaJdbcConnectSelect.connection
        val sql = " DELETE FROM countries WHERE name='Dan's Island'; "
        val st = connection.createStatement()
        val resultsetexecuteQuery = st.executeQuery(sql)
    }
}//end of CRUD object
