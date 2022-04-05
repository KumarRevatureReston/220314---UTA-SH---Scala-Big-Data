import java.sql.DriverManager
import java.sql.Connection
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import java.lang.Math._

object Main {
  def main(args: Array[String]): Unit = {


    //this sets the path for the csv file
    println("What is the absolute path to the file?")
    var file:String = readLine()
    //val file = "C:/Users/esosmulski/Downloads/airports2.csv" //This was used during testing so that I didn't have to reinput the file path
    //val file = Source.fromResource("airports2.csv")  //if you wanted to set the val file as bufferedsource


    //reading the csv file then checking how many records there are
    val input = File.getLines(file)
    val size = input.length


    //CREATE =====creating the table airports
    PSQL.update("CREATE TABLE IF NOT EXISTS airports (id int, ident text, type text, name text, latitude_deg double precision, longitude_deg double precision, elevation_ft int, " +
      "continent text, iso_country text, iso_region text, municipality text, scheduled_service text, gps_code text, iata_code text, local_code text, home_link text, " +
      "wikipedia_link text, keywords text);"
    )


    //UPDATE =====populating the table (currently commented out since the table already exists and it takes a while to upload the whole thing)
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


    //APPLICATION
    println("\n\n")
    println("This is the beginning of the application use of this program\n\n")

    Application.app()


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

  //////////SELECT W/O PRINTING STATEMENTS////////////////////////////////////////

  def selectNoPrint(query:String): Seq[String] = {
    val select = connection.createStatement()
    val result = select.executeQuery(query)

    var row = Seq[String]()
    while(result.next()) {
      for(i <- 1 to result.getMetaData.getColumnCount) {

        row = row :+ result.getString(i)

      }
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

object Application{

  def app():Unit = {

    println("\n\n")
    println("----------Air Travel Planner----------\n")
    PSQL.update("CREATE TABLE IF NOT EXISTS flights ( airline text, flight_number text, origin text, origin_longitude_deg double precision, origin_latitude_deg double precision, time_departure int, destination text, destination_longitude_deg double precision, destination_latitude_deg double precision, estimated_journey_time text, time_arrival int);")

    try {
      println("Would you like to update or view the scheduler?")
      var response: String = readLine()
      if (response.equalsIgnoreCase("update")) {

        Application.update()

      } else if (response.equalsIgnoreCase("view")) {

        Application.view()

      } else if (response.equalsIgnoreCase("Q")) {


      } else {

        throw new invalidInputException

      }

    } catch {

      case e: invalidInputException => {
        println("Valid inputs are 'update', 'view', or 'q' to quit")
        println("Please try again")
        Application.app()
      }

    }

  }

  def update():Unit = {

    try {

      println("Would you like to create, cancel, or update flight details?")
      var response = readLine()
      if (response.equalsIgnoreCase("create")) {

        println()
        Scheduler.create()

      } else if (response.equalsIgnoreCase("update") || response.equalsIgnoreCase("update flight") || response.equalsIgnoreCase("update flight details") || response.equalsIgnoreCase("update details")) {

        println()
        Scheduler.update()

      } else if (response.equalsIgnoreCase("cancel")) {

        println()
        Scheduler.delete()

      } else if (response.equalsIgnoreCase("Q")) {

        Application.app()

      } else {

        throw new invalidInputException

      }

    } catch {

      case e: invalidInputException => {
        println("Valid inputs are 'create', 'cancel', 'update', or 'q' to quit")
        println("Please try again\n")
        Application.update()
      }

    }

  }

  def view():Unit ={

    try {

      println("Would you like to see the schedule or look up a record?")
      var response:String = readLine()
      if (response.equalsIgnoreCase("schedule")) {

        println()
        ScheduleQuery.fullTable()

      } else if (response.equalsIgnoreCase("look up") || response.equalsIgnoreCase("record") || response.equalsIgnoreCase("look up a record")) {

        println()
        ScheduleQuery.record()

      } else if (response.equalsIgnoreCase("Q")) {

        Application.app()

      } else {

        throw new invalidInputException

      }

    } catch {

      case e: invalidInputException => {
        println("Valid inputs are 'schedule', 'look up', or 'q' to quit")
        println("Please try again\n")
        Application.view()
      }

    }

  }

}

object Scheduler{

  //////////SCHEDULE A NEW FLIGHT////////////////////////////////////////

  def create():Unit = {

    var id:String = Scheduler.flightIdent()

    Scheduler.departureOrigin(id)

    var time = Scheduler.departureTime(id)

    Scheduler.arrivalDestination(id)

    Scheduler.calculations(id, time)

    PSQL.select(s"SELECT * FROM flights WHERE flight_number = ${id};")

  }

  def flightIdent():String = {

    println("What is this flight's identifier?")
    var id:String = readLine()

    var airline:String =""
    id.substring(0,2) match {
      case "AA" => airline = "'American Airlines'"
      case "UA" => airline = "'United Airlines'"
      case "WN" => airline = "'Southwest Airlines'"
      case "DL" => airline = "'Delta Airlines'"
      case "B6" => airline = "'Jetblue Airways'"
      case "NK" => airline = "'Spirit Airlines'"
      case "BA" => airline = "'British Airways'"
      case "RV" => airline = "'Air Canada'"
      case "AF" => airline = "'Air France'"
      case "LH" => airline = "'Lufthansa'"
      case "QF" => airline = "'Qantas'"
      case "JL" => airline = "'Japan Airlines'"
      case _ => airline = "NULL"
    }

    id = s""""$id"""".replace("\"","\'")
    PSQL.update(s"INSERT INTO flights (airline, flight_number) VALUES (${airline}, ${id});")
    id

  }

  def departureOrigin(id:String):Unit = {

    println("What is the flight's origin airport?")
    var origin:String = readLine()
    departureIdent(id, origin)

  }

  def departureIdent(id:String, origin:String):Unit = {

    println("What is that airport's identifier code?")
    var ident:String = readLine()
    departureAirportsQuery(id, origin, ident)

  }

  def departureAirportsQuery(id:String, origin:String, ident:String):Unit = {

    var flights_query = s""""${ident} ${origin}"""".replace("\"","\'")
    var query_origin = s""""$origin"""".replace("\"", "\'")
    var query_ident = s""""$ident"""".replace("\"", "\'")
    var resultArr = Seq[String]()

    try {

      resultArr = PSQL.select(s"SELECT id, ident, name, latitude_deg, longitude_deg, municipality, iso_country FROM airports WHERE id = ${query_origin} AND ident = ${query_ident};")
      println()
      if (resultArr.isEmpty) {
        throw new invalidInputException
      }

    } catch {

      case e: invalidInputException => {
        println("Invalid airport name and/or identifier\nPlease try again\n")
        Scheduler.departureOrigin(id)
      }

    }

    println("Is this information correct? [Y/N]")
    var response:String = readLine()

    if (response.equals("N") || response.equals("n")) {

      println("Please try again\n")
      Scheduler.departureOrigin(id)

    } else {

      var origin_longitude_deg = resultArr(4).toDouble
      var origin_latitude_deg = resultArr(3).toDouble
      PSQL.update(s"UPDATE flights SET origin = ${flights_query}, origin_longitude_deg = ${origin_longitude_deg}, origin_latitude_deg = ${origin_latitude_deg} WHERE flight_number = ${id};")

    }

  }

  def departureTime(id:String):Int = {

    println("When is departure scheduled?\nFormat as 24-hr time. i.e 0900 for 9AM")
    var time_departure = readInt()
    PSQL.update(s"UPDATE flights SET time_departure = ${time_departure} WHERE flight_number = ${id};")
    time_departure

  }

  def arrivalDestination(id:String):Unit = {

    println("What is the flight's destination?")
    var destination:String = readLine()
    arrivalIdent(id, destination)

  }

  def arrivalIdent(id:String, destination:String):Unit = {

    println("What is that airport's identifier code?")
    var ident:String = readLine()
    arrivalAirportsQuery(id, destination, ident)

  }

  def arrivalAirportsQuery(id:String, destination:String, ident:String):Unit = {

    var flights_query = s""""${ident} ${destination}"""".replace("\"","\'")
    var query_destination = s""""$destination"""".replace("\"", "\'")
    var query_ident = s""""$ident"""".replace("\"", "\'")
    var resultArr = Seq[String]()

    try {

      resultArr = PSQL.select(s"SELECT id, ident, name, latitude_deg, longitude_deg, municipality, iso_country FROM airports WHERE name = ${query_destination} AND ident = ${query_ident};")
      println()
      if (resultArr.isEmpty) {
        throw new invalidInputException
      }

    } catch {

      case e: invalidInputException => {
        println("Invalid airport name and/or identifier\nPlease try again\n")
        Scheduler.arrivalDestination(id)
      }

    }

    println("Is this information correct? [Y/N]")
    var response:String = readLine()

    if (response.equals("N") || response.equals("n")) {

      println("Please try again\n")
      Scheduler.arrivalDestination(id)

    } else {

      var destination_longitude_deg = resultArr(4).toDouble
      var destination_latitude_deg = resultArr(3).toDouble
      PSQL.update(s"UPDATE flights SET destination = ${flights_query}, destination_longitude_deg = ${destination_longitude_deg}, destination_latitude_deg = ${destination_latitude_deg} WHERE flight_number = ${id};")

    }

  }

  def calculations(id:String, time_departure:Int):Unit = {

    var resultArr = PSQL.selectNoPrint(s"SELECT origin_longitude_deg, origin_latitude_deg, destination_longitude_deg, destination_latitude_deg FROM flights WHERE flight_number = ${id};")

    var long_1 = (resultArr(0).toDouble)/(180/Math.PI)
    var lat_1 = (resultArr(1).toDouble)/(180/Math.PI)

    var long_2 = (resultArr(2).toDouble)/(180/Math.PI)
    var lat_2 = (resultArr(3).toDouble)/(180/Math.PI)

    var distance:Double = 3963.0 * Math.acos( (Math.sin(lat_1) * Math.sin(lat_2)) + (Math.cos(lat_1) * Math.cos(lat_2) * Math.cos(long_2 - long_1)))
    val speed747:Double = 580
    var time = distance/speed747

    var hours = Math.floor(time)
    var minutes = Math.round((time-hours)*60)
    var estimated_journey_time = s"'${hours} hours & ${minutes} minutes'"

    hours = hours*100
    var time_arrival = (time_departure + hours + minutes).toInt
    if (time_arrival >= 2400) {
      time_arrival = time_arrival - 2400
    }

    PSQL.update(s"UPDATE flights SET estimated_journey_time = ${estimated_journey_time}, time_arrival = ${time_arrival} WHERE flight_number = ${id};")

  }

  def confirmation(id:String):Unit = {

    PSQL.select(s"SELECT * FROM flights WHERE flight_number = ${id};")
    println("\nDoes This look correct? [Y/N]")
    var response:String = readLine()
    if (response.equalsIgnoreCase("N")) {

      println("Please try again\n")
      PSQL.update(s"DELETE FROM flights WHERE flight_number = ${id};")
      Scheduler.flightIdent()

    } else {

      Application.app()

    }

  }

  //////////CANCELLING A FLIGHT////////////////////////////////////////

  def delete():Unit = {

    println("What is the flight's identifier that you want to cancel?")
    var id:String = readLine()
    if (id.equalsIgnoreCase("Q")) {

      Application.update()

    }
    id = s""""${id}"""".replace("\"", "\'")

    try{

      var resultArr = PSQL.select(s"SELECT * FROM flights WHERE flight_number = ${id};")
      if (resultArr.isEmpty) {
        throw new invalidInputException
      }

    } catch {

      case e: invalidInputException => {
        println("Invalid flight identifier\nPlease try again\n")
        Scheduler.delete()
      }

    }

    println("Is this the flight you want to cancel? [Y/N]")
    var response = readLine()

    if (response.equalsIgnoreCase("N")) {

      println("Please try again")
      Scheduler.delete()

    } else if (response.equalsIgnoreCase("Q")) {

      Application.update()

    } else {

      PSQL.update(s"DELETE FROM flights WHERE flight_number = ${id};")
      Application.app()

    }


  }

  //////////UPDATING FLIGHT DETAILS////////////////////////////////////////

  def update():Unit = {

    println("What is the flight identifier of the flight plan you wish to edit?")
    var id:String = readLine()
    if (id.equalsIgnoreCase("Q")) {

      Application.update()

    }
    id = s""""${id}"""".replace("\"","\'")

    try {

      var resultArr = PSQL.select(s"SELECT * FROM flights WHERE flight_number = ${id};")
      if (resultArr.isEmpty) {
        throw new invalidInputException
      }

    } catch {

      case e: invalidInputException => {
        println("Invalid flight identifier\nPlease try again\n")
        Scheduler.update()
      }

    }

    println("Is this the flight plan you want to edit? [Y/N]")
    var response = readLine()
    if (response.equalsIgnoreCase("N")) {

      println("Please try again")
      Scheduler.update()

    } else if (response.equalsIgnoreCase("Q")) {

      Application.update()

    } else {

      Scheduler.updateParam(id)

    }


  }

  def updateParam(id:String):Unit = {

    println("Which field would you like to change?\nflight number\nflight origin\nflight destination\ndeparture time")
    var response = readLine()

    try {
      if (response.equalsIgnoreCase("flight number")) {

        Scheduler.updateIdent(id)

      } else if (response.equalsIgnoreCase("flight origin") || response.equalsIgnoreCase("origin")) {

        Scheduler.updateOrigin(id)

      } else if (response.equalsIgnoreCase("flight destination") || response.equalsIgnoreCase("destination")) {

        Scheduler.updateDestination(id)

      } else if (response.equalsIgnoreCase("departure time") || response.equalsIgnoreCase("time")) {

        Scheduler.updateDepartureTime(id)

      } else if (response.equalsIgnoreCase("Q")) {

        Application.update()

      } else {

        throw new invalidInputException

      }
    } catch {

      case e: invalidInputException => {
        println("Valid inputs are 'flight number', 'flight origin', 'flight destination', 'departure time', or 'q' to quit")
        println("Please try again\n")
        Scheduler.updateParam(id)
      }

    }

  }

  def updateIdent(id:String):Unit = {

    println("What is the flight's new identifier?")
    var newId = readLine()
    if (newId.equalsIgnoreCase("Q")) {
      Application.update()
    }
    newId = s""""${newId}"""".replace("\"", "\'")

    var newAirline = ""
    newId.substring(0,2) match {
      case "AA" => newAirline = "'American Airlines'"
      case "UA" => newAirline = "'United Airlines'"
      case "WN" => newAirline = "'Southwest Airlines'"
      case "DL" => newAirline = "'Delta Airlines'"
      case "B6" => newAirline = "'Jetblue Airways'"
      case "NK" => newAirline = "'Spirit Airlines'"
      case "BA" => newAirline = "'British Airways'"
      case "RV" => newAirline = "'Air Canada'"
      case "AF" => newAirline = "'Air France'"
      case "LH" => newAirline = "'Lufthansa'"
      case "QF" => newAirline = "'Qantas'"
      case "JL" => newAirline = "'Japan Airlines'"
      case _ => newAirline = "NULL"
    }

    PSQL.update(s"UPDATE flights SET airline = ${newAirline}, flight_number = ${newId} WHERE flight_number = ${id};")

    println("Updated flight plan:")
    PSQL.select(s"SELECT * FROM flights WHERE flight_number = ${newId};")
    Application.app()

  }

  def updateOrigin(id:String):Unit = {

    println("What is the flight's new origin airport?")
    var origin = readLine()
    if (origin.equalsIgnoreCase("Q")) {

      Application.update()

    } else {

      Scheduler.updateOrigin2(id, origin)

    }

  }

  def updateOrigin2(id:String, origin:String):Unit = {

    println("What is the flight's new airport identifier?")
    var ident = readLine()
    if (ident.equalsIgnoreCase("Q")) {

      Application.update()

    } else {

      Scheduler.updateOrigin3(id, origin, ident)

    }

  }

  def updateOrigin3(id:String, origin:String, ident:String):Unit = {

    var flights_query = s""""${ident} ${origin}"""".replace("\"","\'")
    var query_origin = s""""$origin"""".replace("\"", "\'")
    var query_ident = s""""$ident"""".replace("\"", "\'")
    var resultArr = Seq[String]()

    try {

      resultArr = PSQL.select(s"SELECT id, ident, name, latitude_deg, longitude_deg, municipality, iso_country FROM airports WHERE id = ${query_origin} AND ident = ${query_ident};")
      println()
      if (resultArr.isEmpty) {
        throw new invalidInputException
      }

    } catch {

      case e: invalidInputException => {
        println("Invalid airport name and/or identifier\nPlease try again\n")
        Scheduler.updateOrigin(id)
      }

    }

    println("Is this origin airport information correct? [Y/N]")
    var response:String = readLine()

    if (response.equalsIgnoreCase("N")) {

      println("Please try again\n")
      Scheduler.updateOrigin(id)

    } else {

      var origin_longitude_deg = resultArr(4).toDouble
      var origin_latitude_deg = resultArr(3).toDouble
      PSQL.update(s"UPDATE flights SET origin = ${flights_query}, origin_longitude_deg = ${origin_longitude_deg}, origin_latitude_deg = ${origin_latitude_deg} WHERE flight_number = ${id};")
      Scheduler.updateOrigin4(id)

    }

  }

  def updateOrigin4(id:String):Unit = {

    var resultArr = PSQL.selectNoPrint(s"SELECT origin_longitude_deg, origin_latitude_deg, destination_longitude_deg, destination_latitude_deg, time_departure FROM flights WHERE flight_number = ${id};")

    var long_1 = (resultArr(0).toDouble)/(180/Math.PI)
    var lat_1 = (resultArr(1).toDouble)/(180/Math.PI)

    var long_2 = (resultArr(2).toDouble)/(180/Math.PI)
    var lat_2 = (resultArr(3).toDouble)/(180/Math.PI)

    var time_departure = resultArr(4)

    var distance:Double = 3963.0 * Math.acos( (Math.sin(lat_1) * Math.sin(lat_2)) + (Math.cos(lat_1) * Math.cos(lat_2) * Math.cos(long_2 - long_1)))
    val speed747:Double = 580
    var time = distance/speed747

    var hours = Math.floor(time)
    var minutes = Math.round((time-hours)*60)
    var estimated_journey_time = s"'${hours} hours & ${minutes} minutes'"

    hours = hours*100
    var time_arrival = (time_departure + hours + minutes).toInt
    if (time_arrival >= 2400) {
      time_arrival = time_arrival - 2400
    }

    PSQL.update(s"UPDATE flights SET estimated_journey_time = ${estimated_journey_time}, time_arrival = ${time_arrival} WHERE flight_number = ${id};")
    PSQL.select(s"SELECT * FROM flights WHERE flight_number = ${id};")
    Application.app()

  }

  def updateDestination(id:String):Unit = {

    println("What is the flight's new destination airport?")
    var destination = readLine()
    if (destination.equalsIgnoreCase("Q")) {

      Application.update()

    } else {

      Scheduler.updateDestination2(id, destination)

    }

  }

  def updateDestination2(id:String, destination:String):Unit = {

    println("What is the flight's new airport identifier?")
    var ident = readLine()
    if (ident.equalsIgnoreCase("Q")) {

      Application.update()

    } else {

      Scheduler.updateDestination3(id, destination, ident)

    }

  }

  def updateDestination3(id:String, destination:String, ident:String):Unit = {

    var flights_query = s""""${ident} ${destination}"""".replace("\"", "\'")
    var query_destination = s""""$destination"""".replace("\"", "\'")
    var query_ident = s""""$ident"""".replace("\"", "\'")
    var resultArr = Seq[String]()

    try {

      resultArr = PSQL.select(s"SELECT id, ident, name, latitude_deg, longitude_deg, municipality, iso_country FROM airports WHERE name = ${query_destination} AND ident = ${query_ident};")
      println()
      if (resultArr.isEmpty) {
        throw new invalidInputException
      }

    } catch {

      case e: invalidInputException => {
        println("Invalid airport name and/or identifier\nPlease try again\n")
        Scheduler.updateDestination(id)
      }

    }

    println("Is this destination airport information correct? [Y/N]")
    var response: String = readLine()

    if (response.equalsIgnoreCase("N")) {

      println("Please try again\n")
      Scheduler.updateDestination(id)

    } else {

      var destination_longitude_deg = resultArr(4).toDouble
      var destination_latitude_deg = resultArr(3).toDouble
      PSQL.update(s"UPDATE flights SET destination = ${flights_query}, destination_longitude_deg = ${destination_longitude_deg}, destination_latitude_deg = ${destination_latitude_deg} WHERE flight_number = ${id};")
      Scheduler.updateDestination4(id)

    }

  }

  def updateDestination4(id:String):Unit = {

    var resultArr = PSQL.selectNoPrint(s"SELECT origin_longitude_deg, origin_latitude_deg, destination_longitude_deg, destination_latitude_deg, time_departure FROM flights WHERE flight_number = ${id};")

    var long_1 = (resultArr(0).toDouble)/(180/Math.PI)
    var lat_1 = (resultArr(1).toDouble)/(180/Math.PI)

    var long_2 = (resultArr(2).toDouble)/(180/Math.PI)
    var lat_2 = (resultArr(3).toDouble)/(180/Math.PI)

    var time_departure = resultArr(4)

    var distance:Double = 3963.0 * Math.acos( (Math.sin(lat_1) * Math.sin(lat_2)) + (Math.cos(lat_1) * Math.cos(lat_2) * Math.cos(long_2 - long_1)))
    val speed747:Double = 580
    var time = distance/speed747

    var hours = Math.floor(time)
    var minutes = Math.round((time-hours)*60)
    var estimated_journey_time = s"'${hours} hours & ${minutes} minutes'"

    hours = hours*100
    var time_arrival = (time_departure + hours + minutes).toInt
    if (time_arrival >= 2400) {
      time_arrival = time_arrival - 2400
    }

    PSQL.update(s"UPDATE flights SET estimated_journey_time = ${estimated_journey_time}, time_arrival = ${time_arrival} WHERE flight_number = ${id};")
    PSQL.select(s"SELECT * FROM flights WHERE flight_number = ${id};")
    Application.app()

  }

  def updateDepartureTime(id:String):Unit = {

    println("When is departure scheduled?\nFormat as 24-hr time. i.e 0900 for 9AM")
    var time_departure = readInt()
    PSQL.update(s"UPDATE flights SET time_departure = ${time_departure} WHERE flight_number = ${id};")
    Scheduler.updateDepartureTime2(id)

  }

  def updateDepartureTime2(id:String):Unit = {

    var resultArr = PSQL.selectNoPrint(s"SELECT origin_longitude_deg, origin_latitude_deg, destination_longitude_deg, destination_latitude_deg, time_departure FROM flights WHERE flight_number = ${id};")

    var long_1 = (resultArr(0).toDouble)/(180/Math.PI)
    var lat_1 = (resultArr(1).toDouble)/(180/Math.PI)

    var long_2 = (resultArr(2).toDouble)/(180/Math.PI)
    var lat_2 = (resultArr(3).toDouble)/(180/Math.PI)

    var time_departure = resultArr(4)

    var distance:Double = 3963.0 * Math.acos( (Math.sin(lat_1) * Math.sin(lat_2)) + (Math.cos(lat_1) * Math.cos(lat_2) * Math.cos(long_2 - long_1)))
    val speed747:Double = 580
    var time = distance/speed747

    var hours = Math.floor(time)
    var minutes = Math.round((time-hours)*60)
    var estimated_journey_time = s"'${hours} hours & ${minutes} minutes'"

    hours = hours*100
    var time_arrival = (time_departure + hours + minutes).toInt
    if (time_arrival >= 2400) {
      time_arrival = time_arrival - 2400
    }

    PSQL.update(s"UPDATE flights SET estimated_journey_time = ${estimated_journey_time}, time_arrival = ${time_arrival} WHERE flight_number = ${id};")
    PSQL.select(s"SELECT * FROM flights WHERE flight_number = ${id};")
    Application.app()

  }

}

object ScheduleQuery{

  def fullTable():Unit = {

    PSQL.select(s"SELECT * FROM flights ORDER BY time_departure;")
    Application.app()

  }

  def record():Unit = {

    println("What is the flight number of the flight you would like to view?")
    var id:String = readLine()
    if (id.equalsIgnoreCase("Q")) {

      Application.view()

    }
    id = s""""${id}"""".replace("\"","\'")

    PSQL.select(s"SELECT * FROM flights WHERE flight_number = ${id};")
    Application.app()

  }

}

class invalidInputException extends Exception {}
