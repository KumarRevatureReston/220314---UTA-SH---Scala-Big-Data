
import java.sql.{Connection, DriverManager}

trait UserSettings {

  // connect to the database named "mysql" on the localhost
  //val driver = "org.postgresql.Driver"
  val driverName = "org.apache.hive.jdbc.HiveDriver";

  Class.forName(driverName);

  val databaseName = "moviesinfo"
  val username = "hive"
  val password = "hive"
  val path = "C:\\Users\\jamcc\\IdeaProjects\\RevProject_1\\src\\main\\scala\\"


  val con = DriverManager.getConnection(s"jdbc:hive2://localhost:10000/${databaseName}", username, password);
  val stmt = con.createStatement();


}



