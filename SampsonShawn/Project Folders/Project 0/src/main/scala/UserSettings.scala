import java.sql.DriverManager
import java.sql.Connection

trait UserSettings {

  // connect to the database named "mysql" on the localhost
  val driver = "org.postgresql.Driver"
  val baseUrl = "jdbc:postgresql://localhost:5432/"
  val username = "postgres"
  val password = "dbPass"
  val path = "C:\\Users\\samps\\IdeaProjects\\Project01\\src\\main\\scala\\"

  // there's probably a better way to do this
  var connection:Connection = null

}



