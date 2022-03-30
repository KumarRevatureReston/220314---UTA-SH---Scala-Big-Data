//Creating Future
import scala.util.{Success, Failure}
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.io.Source
import java.sql.DriverManager
import java.sql.Connection
import java.sql.ResultSet
import java.sql._

object Hello_World {
  
  def main(args: scala.Array[String]): Unit = {
    Db.start()
    update()
  }

  def update() : Unit = {
    
    var execute = true
    
    while (execute) {
      
      try {

        Console.println("Commands: create, read, update, delete, list, import, exit")
        Console.println("Enter command:")

        val input = scala.io.StdIn.readLine()
        
        if (input == null || input.isEmpty()) {
          Console.println("Command not recognized.")
        }
        else if (input == "quit" || input == "exit" || input == "stop") { 
          execute = false
        }
        else if (input == "create") {
          Console.println("CREATE -> Enter name for new person:")
          var newPerson = scala.io.StdIn.readLine()
          if (newPerson == null || newPerson.isEmpty()) {
            Console.println("Invalid name. Create cancelled.")
          }
          else {
            Db.query(s"INSERT INTO people (id, name) VALUES (${Db.nextId()}, '${newPerson.replace("'","''")}')")
            Console.println("Person created.")
          }
        }
        else if (input == "read") {
          Console.println("READ -> Enter id:")
          var id = scala.io.StdIn.readLine()
          if (id == null || id.isEmpty()) {
            Console.println("Invalid id. read cancelled.")
          }
          else {
            Console.println("Result:")
            Db.printPerson(Db.result(s"SELECT * FROM people WHERE id = $id"))
          }
        }
        else if (input == "update") {
          Console.println("UPDATE -> Enter id:")
          var id = scala.io.StdIn.readLine()
          if (id == null || id.isEmpty()) {
            Console.println("Invalid id. update cancelled.")
          }
          else {
            Console.println("Enter name:")
            var name = scala.io.StdIn.readLine()
            if (name == null || name.isEmpty()) {
              Console.println("Invalid name. update cancelled.")
            }
            else {
              Db.query(s"UPDATE people SET name = '${name.replace("'","''")}' WHERE id = $id")
              Console.println("Updated person.")
            }
          }
        }
        else if (input == "delete") {
          Console.println("DELETE -> Enter id:")
          var id = scala.io.StdIn.readLine()
          if (id == null || id.isEmpty()) {
            Console.println("Invalid id. delete cancelled.")
          }
          else {
            Db.query(s"DELETE FROM people WHERE id = $id")
            Console.println("Person deleted.")
          }
        }
        else if (input == "list") {
          Db.printPeople()
        }
        else if (input == "import") {
          Db.importPeople()
        }
        else {
          Console.println("Command not recognized.")
        }    
      }
      catch {
        case a : Any => Console.println("An error occured. Try again.")
      }

    }

    Console.println("Application stopped.")

  }

}

object Db {

  var connection : Connection = null;

  var nextIdValue = 100

  def start() : Unit = {
    println("Connecting to database")
    Class.forName("org.postgresql.Driver")
    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", 
    "postgres", 
    "*Alpha777"
    )
    println("Successfully connected to database")
  }

  def query(sqlQuery: String) {
    val query = connection.createStatement()
    query.executeUpdate(sqlQuery)
  }

  def result(sqlQuery: String): ResultSet = {
    val query = connection.createStatement()
    return query.executeQuery(sqlQuery)
  }

  def nextId() : Int = {
    nextIdValue += 1
    return nextIdValue
  }

  def printPeople() {
    printPerson(result("SELECT * FROM people"))
  }

  def printPerson(result: ResultSet) : Unit = {
    while(result.next()) {
      println(s"${result.getString(1)} ${result.getString(2)}")
    }
  }

  def importPeople() : Unit = {
    query("DELETE FROM people")
    println("Importing data from csv")
    val source = Source.fromFile("MOCK_DATA.csv")
    for (line <- source.getLines) {
      val vals = line.split(",")
      val queryString = "INSERT INTO people (id, name) VALUES (" + vals(0).trim() + ", '" + vals(1).trim() + "')"
      //println(s"DB: $queryString")
      query(queryString)
    }
    source.close()
    println("Successfully imported data from csv")
  }

}
