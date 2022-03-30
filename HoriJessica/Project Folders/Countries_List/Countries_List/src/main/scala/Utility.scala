import java.sql.{Connection, DriverManager}

object Utility {

  def getPostgresConnection():Connection={
    classOf[org.postgresql.Driver]
    val con_str = "jdbc:postgresql://localhost:5432/countries"
    val userName="postgres"
    val password= "1234567890"
    DriverManager.getConnection(con_str,userName,password)
  }
}