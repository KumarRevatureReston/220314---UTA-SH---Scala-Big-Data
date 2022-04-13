
import java.sql.{SQLException, Connection, DriverManager, ResultSet, Statement}
import scala.collection.mutable.ArrayBuffer
import scala.io.{BufferedSource, Source}
import scala.language.postfixOps
import scala.util.matching.Regex
import java.sql.ResultSetMetaData

object HiveWorker extends UserSettings{

  def main(args: Array[String]): Unit = {

    try {

      // temp hardcode table to be used
      //val tableName = "user_info"  // this is going to have to be separated from the query

      // CLI Interface

      if (!args.isEmpty && args(0).toUpperCase != "COPY") {
        if (args.length == 2) {
          database(args(0), args(1))
        } else if (args.length == 1) {
          database(args(0))
        } else {
          println("Not a valid command.")
        }
      } else if (!args.isEmpty) {
        database(args(0), args(1), args(2))
      }

      //database("SELECT user_id, avg_rating FROM ( SELECT user_id, CAST(AVG(rating) AS DECIMAL(10,2)) AS avg_rating FROM ratings INNER JOIN movies ON ratings.movie_id = movies.movie_id WHERE movies.release_date RLIKE '.*(1993).*' GROUP BY user_id) tmp ORDER BY avg_rating DESC LIMIT 25")
      //database("SELECT movie_title, CAST(AVG(rating) AS DECIMAL(10,2)) AS avg_rating FROM ratings INNER JOIN movies ON ratings.movie_id = movies.movie_id WHERE movies.release_date RLIKE '.*(1993).*' GROUP BY ratings.movie_id, movie_title ORDER BY avg_rating DESC LIMIT 25")
      //database("SELECT movie_title, avg_rating, views FROM (SELECT movie_title, CAST(AVG(rating) AS DECIMAL(10,2)) AS avg_rating, COUNT(rating) AS views FROM ratings INNER JOIN movies ON ratings.movie_id = movies.movie_id GROUP BY ratings.movie_id, movie_title ) tmp WHERE views >= 50 GROUP BY movie_title, avg_rating, views ORDER BY avg_rating DESC, views DESC LIMIT 25")

    } catch {
      case e => e.printStackTrace
    } finally {
      con.close()
    }

    def database(command: String, sqlString1: String = "", name: String = ""): Unit = {

      try {

        command.toUpperCase match {
          case "COPY" => {
            val fileName = path + sqlString1
            //println(fileName)
            uploadCsvFileController(stmt, fileName, name)

          }
          case "E" | "Q" | "U" => sqlCommand(stmt, command.toUpperCase, sqlString1)
          case _ => sqlCommandFilter(stmt, command)
        }

      } catch {
        case e => e.printStackTrace  //println("Case 1")
      } finally {
        con.close()
      }

    }

    def uploadCsvFileController(statement: Statement, filePath: String, tableName: String, columnList: String = ""): Unit = {

      val file = Source.fromFile(filePath)
      val tableExists = statement.executeQuery("SHOW TABLES LIKE 'airports'")
      val filePath2 = s""" "${filePath}" """  // seen a recommendation to use dbl quotes instead of single.. did not work
      //println(tableExists.next().getClass)
      //println(filePath2)

      if(tableExists.next()){

        //println("if ran")

        // upload the contents of the csv file using postgres to upload file
        //LOAD DATA LOCAL INPATH '/home/yourcsvfile.csv' OVERWRITE INTO TABLE Staff;
              val uploadString = {
                val aString = new StringBuilder("")
                aString ++= "LOAD DATA LOCAL INPATH "
                aString ++= filePath2
                aString ++= s" OVERWRITE INTO TABLE ${tableName}"
                aString.toString
              }

              println(uploadString)
              // run the upload csv file command
              //statement.execute(uploadString)
              println("Currently unable to load data into hive from .csv file on local drive.")

      }else{

        //println("else ran")
        // run the table creator in case table does not already exist
        csvTableCreator(file, tableName, statement, filePath, columnList)

      }

    }

    def csvTableCreator(file: BufferedSource, tableName: String, statement: Statement, filePath: String, columnList: String): Unit = {

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
        for (x <- 0 to header.length - 1) {

          aString ++= header(x).replaceAll("(^\")|(\"$)", "")
          aString ++= " "
          aString ++= dataTypes(x)
          if (x != header.length - 1) aString ++= ", "
        }
        aString ++= s")"
        aString.toString
      }
      // Attempt to create the table if it does not exist
      println(columnsString)
      statement.execute(columnsString)
      println("Table Created")
      uploadCsvFileController(statement, filePath, tableName, columnList)
    }

    def sqlCommandFilter(statement: Statement, sqlString: String): Unit = {

      //parse string for keywords, also check for the returning keyword
      //println(sqlString)

      val returning = sqlString.toUpperCase.contains("RETURNING")
      //println(s"returning = ${returning}")
      val keywordString = sqlString.toUpperCase

      val executeKeyword: String = {
        if (keywordString.contains("CREATE") || keywordString.contains("ALTER") || keywordString.contains("DROP") || keywordString.contains("TRUNCATE") ||
          keywordString.contains("RENAME") || keywordString.contains("GRANT") || keywordString.contains("REVOKE") || keywordString.contains("COMMIT") ||
          keywordString.contains("ROLLBACK") || keywordString.contains("SAVEPOINT")) {
          if (returning == false) {
            println("DDL E")
            "E"
          } else {
            println("DDL Q")
            "Q"
          }
        } else if (keywordString.contains("SELECT")) {
          println("SELECT")
          "Q"
        } else if (keywordString.contains("INSERT") || keywordString.contains("UPDATE") || keywordString.contains("DELETE")) {
          if (returning == false) {
            println("DML U")
            "U"
          } else {
            println("DML Q")
            "Q"
          }
        } else {
          "Please enter a valid command."
        }
      }

      if (executeKeyword != "Please enter a valid command.") {
        sqlCommand(statement, executeKeyword, sqlString)
      } else {
        println(executeKeyword)
      }

    }

    def sqlCommand(statement: Statement, sqlCommand: String, command: String): Unit = {

      if (sqlCommand == "Q") {
        val resultSet = statement.executeQuery(command)
        if (resultSet != null) {
          printReturnData(resultSet)
        }
      } else if (sqlCommand == "E") {
        val resultSet = statement.execute(command)
        if (resultSet != null) {
          println("SQL Execute Ran Successfully")
          //println(resultSet)
        }
      } else if (sqlCommand == "U") {
        val resultSet = statement.executeUpdate(command)
        println(s"${resultSet} rows have been updated.")
      }

    }

    def getColumnNames(resultSet: ResultSet): List[String] = {
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

    def printReturnData(resultSet: ResultSet): Unit = {

      var rows = Seq[Object]()
      val columnNames: List[String] = getColumnNames(resultSet)
      println(columnNames)
      println("________________________________")

      while (resultSet.next()) {
        var row = Seq[String]()
        for (x <- 1 to resultSet.getMetaData.getColumnCount) {
          var dataRow = "NULL"
          if (resultSet.getString(x) != null) {
            dataRow = resultSet.getString(x)
          }
          var newRowData = dataRow
          row = row :+ newRowData

        }
        rows = rows :+ row
      }
      rows.foreach { r => println(r) }

    }

    def verifyConnection(stmt:Statement, con:Connection ): Boolean = {
      try {
        val stmt = con.createStatement()
        stmt.executeQuery("SELECT 1")
        true
      } catch {
        case e: Exception => false
      }
    }
  }
}
