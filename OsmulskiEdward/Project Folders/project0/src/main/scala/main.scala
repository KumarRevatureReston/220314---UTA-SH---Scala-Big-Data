import scala.io.Source
import scala.io.BufferedSource
import java.sql.DriverManager
import java.sql.Connection


object Main {
  def main(args: Array[String]): Unit = {


    //this sets the path for the csv file
    val file = "C:/Users/esosmulski/Downloads/airports2.csv"
    //val file = Source.fromResource("airports2.csv")  //if you wanted to set the val file as bufferedsource


    //reading the csv file then checking how many records there are
    val input = File.getLines(file)
    val size = input.length


    //CREATE =====creating the table airports
    PSQL.update("CREATE TABLE IF NOT EXISTS airports (id int, ident text, type text, name text, latitude_deg double precision, longitude_deg double precision, elevation_ft int, " +
      "continent text, iso_country text, iso_region text, municipality text, scheduled_service text, gps_code text, iata_code text, local_code text, home_link text, " +
      "wikipedia_link text, keywords text);"
    )
    //var row = File.getRow(0,file) //row 23 has an example of an apostrophe used, row 39 has a comma both screw up the date input, row 2736 has weird formatted word
    //row.foreach(arg => println("{_" + arg + "_}"))


    //UPDATE =====populating the table
    /*
    for(i <- 1 until size) {

      var params = File.getRow(0,file)

      var row = File.getRow(i,file)

      PSQL.update(s"Insert INTO airports (id, ident, type, name, latitude_deg, longitude_deg, elevation_ft, continent, iso_country, iso_region, municipality, scheduled_service, " +
        s"gps_code, iata_code, local_code, home_link, wikipedia_link, keywords) VALUES ( ${row(0)}, ${row(1)}, ${row(2)}, ${row(3)}, ${row(4)}, ${row(5)}, ${row(6)}, ${row(7)}, ${row(8)}, " +
        s"${row(9)}, ${row(10)}, ${row(11)}, ${row(12)}, ${row(13)}, ${row(14)}, ${row(15)}, ${row(16)}, ${row(17)});"
      )
    }
    */


    // READ =====getting a selection rom a table.  Returns a List of Strings
    println("Examples of read operations:\n")

    println("Airport id, name, iso_country, elevation_ft of airports in US under 150ft of elevation")
    PSQL.select("SELECT id, name, iso_country, elevation_ft FROM airports WHERE iso_country = 'US' AND elevation_ft <= 50;")
        //or example of aggregate function
    println("Count of all records from airports")
    PSQL.select("SELECT COUNT(*) FROM airports;")
        //or
    println("All airports in the US")
    PSQL.select("SELECT COUNT(*) FROM airports WHERE iso_country = 'US';")
        //or example of using a group by
    println("Count of airports by type in the US")
    PSQL.select("SELECT type, COUNT(*) FROM airports WHERE iso_country = 'US' GROUP BY type;")



    //UPDATE =====updating a value in the table
    println("Example of updating operations to records:\n")

        //seeing what the record says
    println("Checking to see the original record...")
    PSQL.select("SELECT id, type, name FROM airports WHERE id = 6523;")
        //updating the value of the record
    println("Updating the record...")
    PSQL.update("UPDATE airports SET type = 'airport', name = 'Total Rf Airport' WHERE id = 6523;")
        //checking that it updated
    println("Checking to see the record has been updated...")
    PSQL.select("SELECT id, type, name FROM airports WHERE id = 6523;")
        //changing it back and checking
    PSQL.update("UPDATE airports SET type = 'heliport', name = 'Total Rf Heliport' WHERE id = 6523;")


    //DELETE =====deleting a value from the table
    println("Example of Deleting a record:\n")

        //creating a record to delete
    println("Creating a record to delete...")
    PSQL.update("INSERT INTO airports (id, type, name) VALUES (99999, 'seaplane port', 'Fair Haven Seaport');")
        //pulling that record
    println("checking the record to be deleted exists...")
    PSQL.select("SELECT id, type, name FROM airports WHERE id = 99999;")
        //deleting the record
    println("deleting the record...")
    PSQL.update("DELETE FROM airports WHERE id = 99999;")
        //querying to see if the record still exists
    println("checking again if the record exists...")
    PSQL.select("SELECT id, type, name FROM airports WHERE id = 99999;")


    //DELETE =====deleting the whole table
    //PSQL.update("DROP TABLE airports;")


    PSQL.closeConnection()
  }
}


object PSQL{
  //////////OPENING/CLOSING THE CONNECTION////////////////////////////////////////

  val driver = "org.postgresql.Driver"
  val url = "jdbc:postgresql://localhost:5432/project0"
  val username = "postgres"
  val password = "Eso@07760"
  var connection: Connection = null
  Class.forName(driver)
  connection = DriverManager.getConnection(url, username, password)

  def closeConnection(): Unit = {
    connection.close()
  }

  //////////SELECT STATEMENTS////////////////////////////////////////

  def select(query:String): Any = {

    val select = connection.createStatement()
    val result = select.executeQuery(query)

    var row = Seq[String]()
    while(result.next()){
      for (i <- 1 to result.getMetaData.getColumnCount) {

        row = row :+ result.getString(i)
        printf("%-40s|", result.getString(i))

      }
      println("")
    }
    row
  }

  //////////CREATE/UPDATE/DELETE STATEMENTS////////////////////////////////////////

  def update(query: String): Unit = {
    val update = connection.createStatement()
    update.executeUpdate(query)
  }

}

object File{
  //////////READING THE ENTIRE FILE////////////////////////////////////////

  def getLines(file:String): Seq[String] = {
    val source = io.Source.fromFile(file)
    //val source = file    //if you define the val file as a bufferedsource type
    val lines = (for (line <- source.getLines) yield line).toSeq
    source.close()

    lines
  }

  //////////READING EACH LINE OF VALUES////////////////////////////////////////

  def getRow(row: Int, file:String): Seq[Any] = {
    val source = io.Source.fromFile(file)
    //val source = file //if you define the val file as a bufferedsource type
    val lines = (for (line <- source.getLines) yield line).toSeq

    val columns = lines(row).split(",")
    var seq = Seq[Any]()                                                  //new list with updated column datatypes. otherwise all will be string
    columns.foreach(column => {                                           //also formats some of the columns that had commas or quotes

      if(column.matches("-?\\d+(\\.\\d+)")){

        seq = seq:+ column.toDouble

      } else if (column.matches("[0-9]+")){

        seq = seq:+ column.toInt

      } else if (column.matches("")){

        seq = seq:+ "NULL"

      } else {

        var sqlString = s""""$column""""
        sqlString = sqlString.replace("\'","\'\'")
        sqlString = sqlString.replace("\"","\'")
        seq = seq :+ sqlString
        column
      }
    })

    while (seq.length < 18) {
      seq = seq :+ "NULL"
    }

    source.close()

    seq
  }

}
