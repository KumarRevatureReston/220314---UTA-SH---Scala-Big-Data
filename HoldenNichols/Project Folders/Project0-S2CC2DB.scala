import java.sql.DriverManager
import java.sql.Connection
import scala.annotation.meta.setter
import scala.io.StdIn

object PostGreSQL {
  val driver = "org.postgresql.Driver"
  val url = "jdbc:postgresql://localhost:5432/MyPracticeCreation" //MyPracticeCreation is the database I used.
  val username = "postgres"
  val password = "Password"
  var connection: Connection = null


  // connecting to database
  Class.forName(driver)
  connection = DriverManager.getConnection(url, username, password)
  
  def updateTable(sql: String): Unit = {
    val statement = connection.createStatement()
    statement.executeUpdate(sql)
  }

  // return 2d array of strings

  def selectFromTable(query: String): Any = {



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


    var rows = Seq[String]()
    
    var row = () 

    while(resultSet.next()){
      
      println("____________________________________________________")
      for (i <- 1 to resultSet.getMetaData.getColumnCount) {
        
        
        rows = rows :+ resultSet.getString(i)
        println("   "+resultSet.getString(i))
        
      }
    }
    rows
  }

  def closeConnection(): Unit = {
    connection.close()
  }

} // end postgresql

object CSVREAD{
  def readFile(file: String): Seq[String] = {
    val bufferedSource = io.Source.fromFile(file)
    val lines = (for (line <- bufferedSource.getLines) yield line).toSeq
    bufferedSource.close
    lines
  }
  
}
//PostGreSQL.selectFromTable("Select * FROM foodstores1 ORDER BY ID ASC;")// Displays full table, prints prior to removale of duplicates
//PostGreSQL.selectFromTable("Select * FROM foodstores1 ORDER BY ID DESC;")
// ====MAIN=====
object Test {
  def main(args: Array[String]): Unit = {

  val file = CSVREAD.readFile("C:/Users/Holden/Downloads/supermarkets/supermarkets.csv")
  val TableCreation = PostGreSQL.updateTable("CREATE TABLE IF NOT EXISTS foodstores2(ID int,Address varchar(50)," +
      "City varchar(20),State varchar(50),Country varchar(20),Name varchar(30),Employees int);") //creates blank table

   println("Welcome to S2CC2DB")
   println("Here is the Current CSV file being used for this program:")
   println("_____________________________")
   
   
    
    println(file)
    var space = println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-")
    var prompt2 =println("would you like to see the created blank table? Y or N:")
    var input2 = StdIn.readLine()
      match{
        case "Y"|"y"|"yes"|"Yes"|"YES" => PostGreSQL.updateTable("CREATE TABLE IF NOT EXISTS foodstores2(ID int,Address varchar(50), City varchar(20),State varchar(50),Country varchar(20),Name varchar(30),Employees int);")
          println("This is just a gag, the return for the function to create the table is UNIT") //displays the blank table output if the table does not already exist
        case "N"|"n"|"no"|"No"|"NO" => println("okay we will skip displaying the new table")
      }

    println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-")

    println("would you like to see the table with the CSV file inserted? Y or N:")
    var input3 = StdIn.readLine()
      match{
        case "Y"|"y"|"yes"|"Yes"|"YES" => println("Would you like the table presented in ASC or DESC order? ASC or DESC:")
        var sub3input1 = StdIn.readLine()
          match {
            case "ASC"|"asc" => PostGreSQL.selectFromTable("Select * FROM foodstores2 ORDER BY ID ASC;")
            case "DESC"|"desc" => PostGreSQL.selectFromTable("Select * FROM foodstores2 ORDER BY ID DESC;")
          }
        case "N"|"n"|"no"|"No"|"NO" => println("okay we will skip displaying table")
      }
      println("")
    println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-")

    println("would you like to ensure the csv was inserted into the database? This will insert the contents of the file once more. Y or N:")
    var dupinput = StdIn.readLine()
      match{
        case "Y"|"y"|"yes"|"Yes"|"YES" => PostGreSQL.updateTable("Copy foodstores2 (ID, Address, City, State, Country, Name, Employees)" +
                                                                      "FROM 'C:/Users/Holden/Downloads/supermarkets/supermarkets.csv' DELIMITER ',' CSV HEADER;")
        case "N"|"n"|"no"|"No"|"NO" => println("okay we will skip adding in possible duplicates")
      }
    println("Okay we will now display what your database looks like currently.")
    PostGreSQL.selectFromTable("Select * FROM foodstores2 ORDER BY ID ASC;")
    println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-")

    println("would you like to ensure there was no duplicated recordings in your database? Y or N:")
    var input4 = StdIn.readLine()
      match{
        case "Y"|"y"|"yes"|"Yes"|"YES" => PostGreSQL.updateTable("DELETE FROM foodstores2 a USING foodstores2 b WHERE a=b and a.ctid < b.ctid;") //displays the blank table output if the table does not already exist
        case "N"|"n"|"no"|"No"|"NO" => println("okay we will skip removing possible duplicates")
      } 
    println("Okay we will now display what your database looks like currently. Would you like it in ASC or DESC order? ASC or DESC:")
    var input5 = StdIn.readLine()
          match {
            case "ASC"|"asc" => PostGreSQL.selectFromTable("Select * FROM foodstores2 ORDER BY ID ASC;")
            case "DESC"|"desc" => PostGreSQL.selectFromTable("Select * FROM foodstores2 ORDER BY ID DESC;")
          }
    println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-")
    println("This concludes implementing your file into an database via the Scala and Postgres SQL languages.")
    

        

    PostGreSQL.closeConnection()
  }
}







/*println("Would you like to delete any columns from your table? Y or N:")
    var del_input = StdIn.readLine()
    match{
        case "Y"|"y"|"yes"|"Yes"|"YES" => println("What Column would you like to delete? ID, Address, City, State, Country, Name, Employees:")
         var subdelinput = StdIn.readLine()
          match {
            case "ID" => PostGreSQL.updateTable("ALTER TABLE foodstores1 DROP COLUMN ID;")
            case "Address" => PostGreSQL.updateTable("ALTER TABLE foodstores1 DROP COLUMN Address;")
            case "City" => PostGreSQL.updateTable("ALTER TABLE foodstores1 DROP COLUMN City;")
            case "State" => PostGreSQL.updateTable("ALTER TABLE foodstores1 DROP COLUMN State;")
            case "Country" =>PostGreSQL.updateTable("ALTER TABLE foodstores1 DROP COLUMN Country;")
            case "Name" => PostGreSQL.updateTable("ALTER TABLE foodstores1 DROP COLUMN Name;")
            case "Employees" => PostGreSQL.updateTable("ALTER TABLE foodstores1 DROP COLUMN Employees;")
            case _ => println("There is no column by that name, no column will be dropped.")
          }    
        case "N"|"n"|"no"|"No"|"NO" => println("okay we will not delete any columns from the table")
      } */