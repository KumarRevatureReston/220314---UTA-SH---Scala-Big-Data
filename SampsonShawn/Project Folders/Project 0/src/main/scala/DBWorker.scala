import java.sql.{Connection, DatabaseMetaData, DriverManager, PreparedStatement, ResultSet, SQLException, Statement}
import scala.io.{BufferedSource, Source}
import scala.language.postfixOps
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.matching.Regex

object DBWorker extends UserSettings{

  def main(args: Array[String]) {


    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(baseUrl + "test_db", username, password)
      val statement: Statement = connection.createStatement()

      // CLI Interface
      //println(!args.isEmpty)

      if ( !args.isEmpty && args(0).toUpperCase != "COPY") {
          database(args(0), args(1))
      }else if ( !args.isEmpty ){
          database(args(0), args(1), args(2))
        }

      //Use sqle (execute) or sqlselect to access all sql commands

      //1. Create table and upload csv file
      //database("COPY","airports.csv","airports")

      //2. Write a SQL query to display all the documents in the collection restaurants.
      //database("sqlq", "SELECT * FROM airports")

      //3. Write a SQL query to display the fields id and type from airports
      //database("sqlq", "SELECT id,type FROM airports ORDER BY type DESC")

      //4. Write a SQL query to display the fields id, type, but exclude the field _id for all the documents in the collection heliport.
      //database("sqlq", "SELECT id,type FROM airports WHERE type != 'heliport'")

      //5. Update a field in the airports table with new data
      //database("sqle", "UPDATE airports SET type = 'small_airport' WHERE id = '6526'")
      //database("sqlq", "SELECT * FROM airports WHERE id = '6526'")

      //6. Delete a row where id = '6526'
      //database("sqle", "DELETE FROM airports WHERE id = '6526'")
      //database("sqlq", "SELECT * FROM airports WHERE id = '6526'")

      //7. Empty the database airports
      //database("sqle", "TRUNCATE TABLE airports")
      //database("sqlq", "SELECT * FROM airports")

      //8. Delete a table
      //database("sqle", "DROP TABLE airports")
      //database("sqlq", "SELECT * FROM airports")

      //9. Create another shorter table
      //database("sqle", "create table if not exists test_table(column1 int, column2 int) " )
      //database("sqlq", "SELECT * FROM test_table")

      //10. Insert new row into new table
      //database("sqlq", "INSERT INTO test_table(column1, column2) VALUES (5, 7) RETURNING *" )

      //11. Delete second table
      //database("sqle", "DROP TABLE test_table")

      //12. Find airport based on location
      //database("sqlq", "select name from airports where (type = 'small_airport') and (latitude_deg between 31 and 34) and (longitude_deg between -98 and -96 )")



    } catch {
      case e => e.printStackTrace
    } finally {
      connection.close()
    }

    def database(command:String, sqlString1:String = "", name:String = ""): Unit ={

      try {
        // make the connection
        Class.forName(driver)
        connection = DriverManager.getConnection(baseUrl + "test_db", username, password)
        val statement: Statement = connection.createStatement()


        command.toUpperCase  match {
          case "COPY" => {
            val fileName = path + sqlString1
            //println(fileName)
            uploadCsvFile(statement, fileName, name )

          }
          case "SQLE" | "SQLQ" => sqlCommand(statement, command, sqlString1)
        }

      } catch {
        case e => e.printStackTrace
      } finally {
        connection.close()
      }

    }

    def uploadCsvFile(statement: Statement,filePath:String,tableName:String, columnList:String = ""): Unit ={

      val file = Source.fromFile(filePath)
      // run the table creator in case table does not already exist
      csvTableCreator(file, tableName, statement)

      // upload the contents of the csv file using postgres to upload file
      val uploadString = {
        val aString = new StringBuilder("")
        aString ++= "COPY "
        aString ++= tableName
        if(columnList != "") aString ++= s"(${columnList})"
        aString ++= s" FROM '${filePath}'"
        aString ++= " DELIMITER ',' CSV HEADER"
        aString.toString
      }
      //println(uploadString)

      // run the upload csv file command
      statement.execute(uploadString)
      println("Data Added To Table From File")

    }

    def csvTableCreator(file: BufferedSource, tableName: String, statement: Statement): Unit = {


      // Get a sample of values to parse into a full set of values, to use regex to determine data type
      val sampleLines = {

        // need to make sure if lines to get is equal to 100 but there are only 5 lines it will get all lines
        val linesToGet = 500
        val returnValue = file.getLines.take(linesToGet).toList
        returnValue
      }

      // set header list
      val header = sampleLines.head.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)").toList

      // break each line into list of lists at the "," but not if , appears between quotes
      val sampleLines2 = (for (list <- sampleLines.tail) yield list.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)").toList)
      //println(sampleLines2)
      // return a complete set of values so it can be pattern matched to determine value dataType
      val completeSampleValue = {
        var completeSampleList = ArrayBuffer.fill[String](header.length)("DEFAULT")
        var n = 0
        for (x <- 0 to sampleLines2.length - 1) {
          for (y <- 0 to sampleLines2(x).length - 1) {
            if (sampleLines2(x)(y) != "") {
              completeSampleList(y) = sampleLines2(x)(y)
            }
          }
        }
        //println(completeSampleList.toList)
        completeSampleList.toList
      }
      // Work on setting a value to a case that pattern matches each value of completeSampleValue to sql datatypes
      val dataTypes = {
        var tmpList = ArrayBuffer.fill[String](header.length)("DEFAULT")
        for (x <- 0 to completeSampleValue.length - 1) {
          val intPattern = new Regex("^\\d+$")
          val intPatternN = new Regex("-^\\d+$")
          val float = new Regex("(?:\\d+(?:\\.\\d*)?|\\.\\d+)")
          val floatN = new Regex("(?:-\\d+(?:\\.\\d*)?|\\.\\d+)")
          completeSampleValue(x) match {
            case intPattern() | intPatternN() => tmpList(x) = "INT"
            case float() | floatN() => tmpList(x) = "NUMERIC"
            case _ => tmpList(x) = "VARCHAR(500)"
          }
        }
        tmpList.toList
      }
      //println("dataTypes" + dataTypes)
      // create a string for setting up the columns using header and data types
      val columnsString = {
        val aString = new StringBuilder("")
        aString ++= s"CREATE TABLE IF NOT EXISTS ${tableName} ("
        for ( x <- 0 to header.length -1){


          aString ++= header(x).replaceAll("(^\")|(\"$)","")
          aString ++= " "
          aString ++= dataTypes(x)
          if (x != header.length -1) aString ++= ", "
        }
        aString ++= s");"
        aString.toString
      }
      // Attempt to create the table if it does not exist
      statement.execute(columnsString)
      println("Table Created")
    }

    def sqlCommand(statement: Statement, sqlCommand:String, command:String): Unit ={

      if (sqlCommand.toUpperCase == "SQLQ"){
        val resultSet = statement.executeQuery(command)
        if ( resultSet != null) { printReturnData(resultSet) }
      }else if( sqlCommand.toUpperCase == "SQLE"){
        val resultSet = statement.execute(command)
        if ( resultSet != null) { println("SQL Ran Successfully") }
      }else{
        println("not a proper command")
      }




    }

    def getColumnNames(resultSet: ResultSet): List[String] ={
      // get column names
      val rsmd = resultSet.getMetaData
      val columnCount = rsmd.getColumnCount

      val columnNames = {
        var columnNameList = ArrayBuffer.fill[String](columnCount)("DEFAULT")
        for (x <- 0 to columnCount - 1) {
          columnNameList(x) = rsmd.getColumnName(x + 1)
        }
        columnNameList.toList
      }
      //println(columnNames)
      columnNames
    }

    def printReturnData(resultSet: ResultSet): Unit ={

      var rows = Seq[Object]()
      val columnNames: List[String] = getColumnNames(resultSet)
      println(columnNames)
      println("________________________________")

      while(resultSet.next()){
        var row = Seq[String]()
        for (x <- 1 to resultSet.getMetaData.getColumnCount) {
          var dataRow = "NULL"
          if (resultSet.getString(x) != null)
          {
            dataRow = resultSet.getString(x)
          }
          var newRowData = dataRow
          row = row :+ newRowData

        }
        rows = rows :+ row
      }
      rows.foreach{ r => println(r)}



    }


  }
}

