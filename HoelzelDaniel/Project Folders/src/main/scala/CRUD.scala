import java.io.File
import java.sql.Connection
import java.util.Scanner
import scala.io.Source

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
    val filepath = "src/main/resources/airports.csv"
    val file = new File(filepath)
    val scanner = new Scanner(file)
    
    def open(path: String) = new File(path)
    
    implicit class RichFile(file: File){
        def read() = Source.fromFile(file).getLines()
    }
    val readMyFile = open(filepath).read()
    
    //insert
    def insert(): Unit = {
        val connection = ScalaJdbcConnectSelect.connection
        val sql = " INSERT INTO emps1 (id, last_name, email, gender, department, start_date, salary, job_title, region_id) VALUES ('1001', 'Daniels', 'dd@website.com', 'Male', 'Computers', '2020-01-01', '123456', 'Programmer', '3'); "
        val st = connection.createStatement()
        val resultsetexecuteQuery = st.executeQuery(sql)
    }
    
    //update
    def update(): Unit = {
        val connection = ScalaJdbcConnectSelect.connection
        val sql = " UPDATE emps1 SET last_name='Howard' WHERE id='1001'"
        val st = connection.createStatement()
        val resultsetexecuteQuery = st.executeQuery(sql)
    }
    
    //delete
    def delete(): Unit = {
        val connection = ScalaJdbcConnectSelect.connection
        val sql = " DELETE FROM emps1 WHERE last_name='Howard'; "
        val st = connection.createStatement()
        val resultsetexecuteQuery = st.executeQuery(sql)
    }
}//end of CRUD object