import java.sql.DriverManager
import java.sql.Connection
import scala.annotation.meta.setter

import com.github.tototoshi.csv._
import java.io.File
import java.io.FileNotFoundException
import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.FileReader
import java.lang.ExceptionInInitializerError
import org.postgresql.util.PSQLException

import java.sql.ResultSetMetaData

trait OutputFunctions {

  def printRed(str: String, newLine: Boolean = true) = {
    if (newLine) {
      Console.println("\u001b[31m" + str + "\u001b[0m")
    } else {
      Console.print("\u001b[31m" + str + "\u001b[0m")
    }
  }
  def printYellow(str: String, newLine: Boolean = true) = {
    if (newLine){
      Console.println("\u001b[33m" + str + "\u001b[0m")
    } else {
      Console.print("\u001b[33m" + str + "\u001b[0m")
    }
  }
  def printGreen(str: String, newLine: Boolean = true) = {
    if (newLine){
      Console.println("\u001b[32m" + str + "\u001b[0m")
    } else {
      Console.print("\u001b[33m" + str + "\u001b[0m")
    }
  }

}

object PostGreSQL extends OutputFunctions{
  val driver = "org.postgresql.Driver"
  //var url = "jdbc:postgresql://localhost:5432/uni_students" //uni_students is the database I used.
  var url = ""
  var username = "" //i.e "postgres"
  var password = ""

  var connection: Connection = null


  // setters
  def setPassword(newPassword: String) = {
    password = newPassword
  }
  def setUser(newUser: String) = {
    username = newUser
  }
  def setDatabase(newDatabase: String) = {
    url = "jdbc:postgresql://localhost:5432/" + newDatabase
  }

  // Must be run for initial setup.
  def setCreds(newUser: String, newPassword: Array[Char], newDatabase: String) = {
    username = newUser
    password = newPassword.mkString
    url = "jdbc:postgresql://localhost:5432/" + newDatabase
    // make the connection
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)
  }

  def getUser(printResult: Boolean = false) = {
    if (printResult) {
      println("Username: " + username)
    }
    username
  }
  def getDatabase(printResult: Boolean = false) = {
    if (printResult) {
      println(url.split("/").last)
    }
    url
  }




  // formats the seq of data to be inserted into the database
  def createTableFromSeq(seq: Seq[Any], table: String) = {
    val tableName = table.replaceAllLiterally("-", "_")
    println("Creating table " + tableName + "...")

    var createTable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + seq.mkString(", ") + ");"
    createTable = createTable.replaceAllLiterally("\"", "")
    createTable = createTable.replaceAllLiterally("-", "_")
    val statement = connection.createStatement()
    statement.executeUpdate(createTable)
    println("Success")

    //Returns CREATE TABLE tableName (seq , columns, . . .)
    createTable
  }
  
  def updateTable(sql: String): Unit = {
    val statement = connection.createStatement()
    statement.executeUpdate(sql)
  }


  def selectFromTable(query: String, print: Boolean = false, printLimit: Int = 20): Seq[Any] = {

    var swap = ""
    var select_split = query.split(" ")
    select_split.foreach(arg => {
      swap = arg.replace(",", "")
      select_split.drop(select_split.indexOf(arg))
      select_split.update(select_split.indexOf(arg), swap)
    })

    var columns = select_split.slice(1, select_split.indexOf("FROM"))
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(query)
    var rows = Seq[Object]()
    val rsMetaData = resultSet.getMetaData()
    val count = rsMetaData.getColumnCount()
    var rowNames = Seq[String]()
    val colName = ""
    for (i <- 1 to count)
    {
      var nextColName = colName
      nextColName += rsMetaData.getColumnName(i)
      //adds spacing to end of column name
      for (j <- nextColName.length to 16)
        {
          nextColName += " "
        }
        rowNames = rowNames :+ nextColName
    }
    if (print) {
      println(rowNames)
      println("---------------------------------------------------------------------------------------")
      while(resultSet.next()){
        var row = Seq[String]()
        for (i <- 1 to resultSet.getMetaData.getColumnCount) {
          val spacing = 16
          var dataString = "NULL"
          if (resultSet.getString(i) != null)
          {
            dataString = resultSet.getString(i)
          }
          var newDataString = dataString
          for (j <- dataString.length to spacing)
            {
              newDataString += " "
            }
          row = row :+ newDataString

        }
        rows = rows :+ row
      }
      rows.take(printLimit)foreach{ r => println(r)}
      println("---------------------------------------------------------------------------------------")
    }

    rows
  }

  def closeConnection(): Unit = {
    connection.close()
  }

} // end postgresql


object UnitTest{
  val columnSequence = Seq("id int", "name varchar(255)", "age int", "gpa double")

  def testUpdate(): Unit ={
    // example of inserting a lot of data into a table.
    val myStudents = Array((20, "Student1"), (21, "Student2"), (22, "Student3"), (23, "Student4"))
    //for each element in the array, insert into the table
    myStudents.foreach(arg => {
      PostGreSQL.updateTable("INSERT INTO students (id, name) VALUES ("+arg._1+", '"+arg._2+"');")
    })
  }

  def testSelect(): Unit = {
    // getting a selection rom a table.  Returns a List of Strings
    val myArr=PostGreSQL.selectFromTable("SELECT id, name FROM students;") // prints students table
    var myArr2=PostGreSQL.selectFromTable("SELECT * FROM students;") // prints students table
    
    //prints a list of rows
    println(myArr)

    PostGreSQL.updateTable("DROP TABLE students;")
    PostGreSQL.updateTable("CREATE TABLE students (id INT, name VARCHAR(255));")
  }

} 








object CSV extends OutputFunctions{

  def typeCast(list: List[Any], printResult: Boolean = false): List[Any] = {
    //Takes a list and detects the values in that list and casts them to the appropriate psql type.
    var swap = List[String]()

    list.foreach(arg => {
      if (arg.toString.matches("-?\\d+(\\.\\d+)?")) {
        // insert arg + "double precision" to swap 
        swap = swap :+ arg + " double precision"
      } else if (arg.toString.matches("[0-9]+")) {
        swap = swap :+ arg + " int"
        //arg = arg + " int"
      } else if (arg.toString.matches("true|false")) {
        //arg = arg + " boolean"
        swap = swap :+ arg + " boolean"
      } else {
        swap = swap :+ arg + " varchar(255)"
        "It's a string"
      }
    })

    if(printResult) println(swap)

    swap
  }



  // Returns 2d List of CSV file.
  def readCSV(file: String, printResult: Boolean = false, printLimit: Int = 20): List[List[Any]] = {
    // import File 
    val reader = CSVReader.open(new File(file))

    //type cast each ()() to its appropriate datatype 
    val result = reader.all()

    reader.close()

    if (printResult) {
      // print the first 20 rows, or until the end of the file if less than 20 rows.
      val upperLimit = if (result.length < printLimit) result.length else printLimit
      result.take(upperLimit).foreach(println)  

      printYellow("...and " + (result.length - 20) + " more.")
    }

    if (result(1).length == result(0).length ) {
      "CSV file is valid."
    } else if (result(1).length == 0){
      throw new Exception("Row 1 is empty.  For column typecasting, there must be at least one row of data.")
    } else {
      throw new AssertionError("Preliminary check failed.  CSV file is invalid.")
    }

    //return
    result

  }



  // Given a "columnName" returns Array[String] w/ all the values in that column.
  def getColumn(columnID: String, csvArray: List[List[Any]], printResult: Boolean=false, printLimit: Int = 20): List[Any] = {

    var column = csvArray.map(row => row(csvArray(0).indexOf(columnID)))

    if (printResult) {
      val upperLimit = if (column.length < printLimit) column.length else printLimit
      column.take(upperLimit).foreach(println)
      println()
      printGreen("Total values in column: " + column.length)
    }

    column
  }



  // Given a columnNumber, returns Array[String] w/ all the values in that column.
  def getColumn(columnID: Int, csvArray: List[List[Any]], printResult: Boolean, printLimit: Int): List[Any] = {

    // return the entire column 
    var column = csvArray.map(row => row(columnID))
    if (printResult) {
      val upperLimit = if (column.length < printLimit) column.length else printLimit
      column.take(upperLimit).foreach(println)
      println()
      printGreen("Total values in column: " + column.length)
    }

    column
  }



  // Given row number, returns a List[String] of all the values in that row.
  def getRow(rowNum: Int, csvArray: List[List[Any]], printResult: Boolean = false, printLimit: Int = 40): List[Any] = {
    // get a row from csv file using 2d array
    if (printResult){
      val upperLimit = if (csvArray(rowNum).length < printLimit) csvArray(rowNum).length else printLimit
      csvArray(rowNum).take(printLimit).foreach(v => print(v + ", "))
      println()
      printGreen("Total values in row: " + csvArray(rowNum).length)
    }

    csvArray(rowNum)
  }

  // Asks user to define each columns datatype, default is VARCHAR.
  def getTableColumns(tableName: String, csvArray: List[List[Any]], printResult: Boolean = false): List[Any] = {
    var columnNames = csvArray(0)
    // for each name in columns look for Strings: "varchar", "int", "double", "boolean"
    // if not found throw an error 
    
    var userInput = List[Any]()
    println("Columns in table, default(enter) is VARCHAR: ")
    var i = 0
    val rowOne = csvArray(1)
    columnNames.foreach(col => {

      print("Enter type for column " + col + " ref value in row one " +rowOne(i) +": ")
      var input = scala.io.StdIn.readLine()
      if (input == "") {
        input = col + " VARCHAR"
      } else if (input.toUpperCase.matches("Do*") ) {
        print(" DOUBLE PRECISION")
        input = col + " DOUBLE PRECISION"
      } else if (input.toUpperCase.matches("B*") ) {
        print(" BOOLEAN")
        input = col + " BOOLEAN"
      } else if (input.toUpperCase.matches("DA*") ) {
        print(" DATE")
        input = col + " DATE"
      } else if (input.toUpperCase.matches("EXIT") || input.toUpperCase.matches("QUIT") || input.toUpperCase.matches("Q *")) {
        sys.addShutdownHook(println("Escape character detected.  Exiting..."))
        scala.sys.exit()
      } else {
        input = col + " " + input
      }

      userInput = userInput :+ input
      i += 1
    })

    println(userInput)

    userInput

  }

  //Give a list of strings, returns a lsit of strings in CREATE TABLE format.
  def createTable(columns: List[Any], tableName: String): String = {
    //Ex
    //val columns = Seq("id int", "name varchar(255)", "age int", "gpa double")
    //val tableName = "students"

    val sql = PostGreSQL.createTableFromSeq(columns, tableName)
    sql
  }


  // ENTRY point for this object.
  def importCSV(file: String, printResult: Boolean = false, upperLimit: Int = 20)={
    //imports file with one function call.
    
    val tablename = file.split("/").last.split("\\.").head //name of csv file
    var csv = readCSV(file)
    val createStatement = getTableColumns(tablename, csv)
    createTable(createStatement, tablename)
    try{
      PostGreSQL.updateTable("COPY " + tablename + " FROM '" + file + "' DELIMITER ',' CSV HEADER;")
    } catch {
      case e: Exception => println(e)
    }
  }



}


object CsvDir extends OutputFunctions {

  def getFiles(dir: String="src/main/scala/csv"): List[String] = {
    //returns a list of all files in a directory , by default "src/main/scala/csv"
    var d = new File(dir)
    if (d.exists){
      true
    } else {
      var winDir = dir.replace("/", "\\")
      var d = new File(winDir)
    }

    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).map(_.getAbsolutePath).toList
    } else {
      throw new Exception("Directory does not exist.")
    }
  }


  // Main entry point for this object.
  def importFiles(dir: String="src/main/scala/csv") = {
    val files = getFiles(dir)
    files.foreach(file => {
      printGreen("Importing file: " + file)
      CSV.importCSV(file)
    })
  }

  def getDir():String = {
    val currentDir = new java.io.File(".").getCanonicalPath

    currentDir

  }



}

object CLI extends OutputFunctions {
  def cli_main()={
    eventLoop()
  }

  // The eventloop for user input in CLI.
  def eventLoop(): Unit ={
    printGreen("===Welcome to the CSV Importer===")
    printGreen("Enter 'help' for a list of commands.")

    val options = List("import", "help", "exit", "outputGovernor")
    val helpText = List("import <csv file>", "help", "exit", "outputGovernor")
    var run = true
    var input = ""
    var prompt = "=(QUERY)=> "
    var outputGovernor = 20

    //Database creds
    var user = ""
    var password = Array[Char]()
    var database = ""


    println("---Enter options line-by-line---")
    while(run){
      input = scala.io.StdIn.readLine(prompt)

      // regex look for \dt to show tables
      
      if(input.toUpperCase.matches("^( ?)+SELECT(.?)+|^( ?)+.DT( ?)+")){
        //INPUT = SELECT * FROM tableName
        //TODO option to print more lines
        try{
          if(input.toUpperCase.matches("^( ?)+.DT( ?)+")){
            PostGreSQL.selectFromTable("SELECT tablename FROM pg_catalog.pg_tables WHERE tablename NOT LIKE 'pg%';", true, outputGovernor)
          } else {
            PostGreSQL.selectFromTable(input, true, outputGovernor)
          }
        } catch {
          case e: PSQLException => println(e)
          case e: NullPointerException => println("You need to login to a database first. Enter 'login'")
        }

      } else if (input.toUpperCase.matches("^( ?)+LOGIN( ?)+")){
        try{
          //get password from user without showing it 
          print("Enter database to use: ")
          database = scala.io.StdIn.readLine()
          print("Enter User: ")
          user = scala.io.StdIn.readLine()
          print("Enter Password: ")
          password = System.console().readPassword()
          PostGreSQL.setCreds(user, password, database)
          println("Login successful.")
        } catch {
          case e: PSQLException => println(e)
          case e: ExceptionInInitializerError => println("Failed to connect.  Check your credentials or connection."+"\n Current settings:"+"\n"+user+"\n"+database+" IP/Port: localhost@5432")
        }

      } else if (input.toUpperCase.matches("^( ?)+CREATE(.?)+|^( ?)+INSERT(.?)+|^( ?)+UPDATE(.?)+|^( ?)+DELETE(.?)+|^( ?)+DROP(.?)+|^( ?)+ALTER(.?)+")){
        // INSERT DELETE, UPDATE, ALTER, DROP
        try{
          PostGreSQL.updateTable(input)
          printGreen("Successfully executed query.")
        } catch {
          case e: PSQLException => println(e)
          case e: ExceptionInInitializerError => ""
          case e: NullPointerException => println("You need to login to a database first. Enter 'login'")

        }

      } else if (input.toUpperCase.matches("^( ?)+IMPORT(.?)+")){
        //IMPORT CSV
        if(input.toUpperCase.matches("^( ?)+IMPORT( ?)+[/\\w+]+.+")){
          //IMPORT CSV file.csv
          printGreen("Importing file: " + input.split(" ").last)
          val file = input.split(" ")(1)
          try{
            assert(PostGreSQL.getUser() != "", "You need to login to a database first. Enter 'login'")
            CSV.importCSV(file)
          } catch {
            case e: FileNotFoundException => println(e)
          }

        //} else if(input.toUpperCase.matches("^( ?)+IMPORT(.?)+\\s+\\w+\\.csv( ?)+")){
        } else if(input.toUpperCase.matches("^( ?)+IMPORT +ALL ?+")){
          //IMPORT CSV dir/
          try{
            assert(PostGreSQL.getUser() != "", "You need to login to a database first. Enter 'login'")
            CsvDir.importFiles()
          } catch {
            case e: AssertionError => println(e)
            case e: FileNotFoundException => println(e)
          }
        } else {
          //IMPORT CSV
          printYellow("Please enter a file name.")
        }

      } else if (input.toUpperCase.matches("^( ?)+SET(.?)+")){
        //SET outputGovernor = 20
        if(input.toUpperCase.matches("( ?)+SET +OUTPUTGOVERNOR +\\d+")){
          outputGovernor = input.split(" ").last.toInt
          println("Output govenor set to: " + outputGovernor)
        } else {
          printYellow("Please enter a number.")
        }
      } else if (input.toUpperCase.matches("^( ?)+HELP(.?)+")){
        //HELP
        print("Options: ")
        options.foreach(option => printYellow(option + " ", false))
        println()

        if (input.toUpperCase.matches("^( ?)+HELP(.?)+\\s+\\w+")){
          //HELP <command>
          val command = input.split(" ")(1)
          if (options.contains(command)){
            helpOptions(options, options.indexOf(command))
          } else {
            printYellow("Command not found.")
          }
        } else {
          //HELP
          printYellow("\nPlease enter a command. I.e. 'help import'")
        }

      } else if (input.toUpperCase.matches("^( ?)+EXIT(.?)+|^( ?)+Q(.?)+|^( ?)+QUIT(.?)+")){
        printRed("Exiting...")
        try{
          PostGreSQL.closeConnection()
        } catch {
          case e: PSQLException => ""
          case e: ExceptionInInitializerError => ""
          case e: NullPointerException => ""
        }
        run = false
      } else if (input.toUpperCase.matches(" ?")){
        "pass"
      } else {
        printRed("Invalid command.")
      }
    }
  }

  def helpOptions(options: List[String], optionIndex: Int)={
    val helpText: List[String] = List("import <csv file> OR import all. \n <Import all> imports all .csv files found in the main.scala csv folder.",
      "help lists options",
      "exit, q, or quit exits the program.",
      "outputGovernor sets the number of lines to print when using the 'select' command. Default is 20.  You can change this with 'set outputGovernor <number>'")

    //Prints help text for each option.
    try{
      options.zip(helpText).foreach(option => {
        if (option._1 == options(optionIndex)){
          print(option._1 + " USAGE: " + option._2)
          
        } 
        //print(option._1 + ": " + option._2)
      })
      println()
    } catch {
      case e: IndexOutOfBoundsException => printYellow("Invalid option. Help text not found.")
    }
  }
}



// ====MAIN=====
object CsvImporter extends OutputFunctions{


  def main(args: Array[String]): Unit = {

    //PostGreSQL.updateTable("DROP TABLE IF EXISTS airports;")
    //CsvDir.importFiles()
    //var result = PostGreSQL.selectFromTable("SELECT * FROM airports ;", true, 10)
    
    CLI.cli_main()

    try{
      PostGreSQL.closeConnection()
    } catch {
      case e: PSQLException => ""
      case e: ExceptionInInitializerError => ""
      case e: NullPointerException => ""
    }

  }
}



