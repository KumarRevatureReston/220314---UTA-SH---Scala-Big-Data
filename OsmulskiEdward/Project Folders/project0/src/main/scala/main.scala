import java.sql.DriverManager
import java.sql.Connection
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import java.lang.Math._

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
    //var row = File.getRow(0,file) //row 23 has an example of an apostrophe used, row 39 has a comma both screw up the data input, row 2736 has weird formatted word
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


    //APPLICATION
    println("\n\n")
    println("This is the beginning of the application use of this program\n\n")
    println("----------Air Travel Planner----------\n")
    PSQL.update("CREATE TABLE IF NOT EXISTS flights ( id text, origin text, origin_longitude_deg double precision, origin_latitude_deg double precision, time_departure int, destination text, destination_longitude_deg double precision, destination_latitude_deg double precision, estimated_journey_time text, time_arrival int) ")


    println("What is this flight's identifier?")
    var id:String = readLine()
    id = s""""$id""""
    id = id.replace("\"","\'")
    PSQL.update(s"INSERT INTO flights (id) VALUES (${id});")


    println("What is the flight's origin?")
    var origin:String = readLine()
    println("What is that airport's identifier code?")
    var ident:String = readLine()
    var origin_original = origin
    origin = s""""$origin"""".replace("\"", "\'")
    ident = s""""$ident"""".replace("\"", "\'")
    var resultArr = PSQL.select(s"SELECT id, ident, name, latitude_deg, longitude_deg, municipality, iso_country FROM airports WHERE name = ${origin} AND ident = ${ident};")
    //println("Is this information correct? [Y/N]")
    //var response:String = readLine()                              //work it in later
    //if (response.equals("N"))
    var origin_longitude_deg = resultArr(4).toDouble
    var origin_latitude_deg = resultArr(3).toDouble
    var origin_new = s"${resultArr(1)} ${origin_original}"
    origin_new = s""""${origin_new}""""
    origin_new = origin_new.replace("\"","\'")
    PSQL.update(s"UPDATE flights SET origin = ${origin_new}, origin_longitude_deg = ${origin_longitude_deg}, origin_latitude_deg = ${origin_latitude_deg} WHERE id = ${id};")

    println("When is departure scheduled?\nFormat as 24-hr time. i.e 0900 for 9AM")
    var time_departure = readInt()
    PSQL.update(s"UPDATE flights SET time_departure = ${time_departure};")

    println("What is the flight's destination?")
    var destination:String = readLine()
    println("What is that airport's identifier code?")
    var ident2:String = readLine()
    var destination_original = destination
    destination = s""""${destination}"""".replace("\"","\'")
    ident2 = s""""$ident2"""".replace("\"", "\'")
    resultArr = PSQL.select(s"SELECT id, ident, name, latitude_deg, longitude_deg, municipality, iso_country FROM airports WHERE name = ${destination} AND ident = ${ident2};")
    //println("Is this information correct? [Y/N]")
    //var response2:String = readLine()
    //if (response.equals("N")
    var destination_longitude_deg = resultArr(4).toDouble
    var destination_latitude_deg = resultArr(3).toDouble
    var destination_new = s"${resultArr(1)} ${destination_original}"
    destination_new = s""""${destination_new}"""".replace("\"","\'")
    PSQL.update(s"UPDATE flights SET destination = ${destination_new}, destination_longitude_deg = ${destination_longitude_deg}, destination_latitude_deg = ${destination_latitude_deg} WHERE id = ${id};")

    var long_1 = origin_longitude_deg/(180/Math.PI)
    var lat_1 = origin_latitude_deg/(180/Math.PI)

    var long_2 = destination_longitude_deg/(180/Math.PI)
    var lat_2 = destination_latitude_deg/(180/Math.PI)

    var distance:Double = 3963.0 * Math.acos( (Math.sin(lat_1) * Math.sin(lat_2)) + (Math.cos(lat_1) * Math.cos(lat_2) * Math.cos(long_2 - long_1)))
    val airspeed_747:Double = 580
    var time = distance/airspeed_747
    var hours = Math.floor(time)
    var minutes = Math.round(((time-hours)*60))
    var estimated_journey_time = s"'${hours} hours & ${minutes} minutes'"
    hours = hours*100
    var time_arrival = (time_departure + hours + minutes).toInt
    if (time_arrival >= 2400)
      time_arrival = time_arrival - 2400
    PSQL.update(s"UPDATE flights SET estimated_journey_time = ${estimated_journey_time}, time_arrival = ${time_arrival} WHERE id = ${id}")

    PSQL.select(s"SELECT * FROM flights WHERE id = ${id}")
    //println("Does all this look correct? [Y/N]")
    println("\n\nThe schedule ordered by time of departure:")
    PSQL.select("SELECT * FROM flights ORDER BY time_departure")



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

  def select(query:String): Seq[String] = {

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
