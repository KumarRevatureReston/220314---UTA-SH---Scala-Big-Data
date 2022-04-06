import java.sql.{Connection, DriverManager}

object ScalaJdbcConnectSelect{
    val driver = "org.postgresql.Driver"
    val url = "jdbc:postgresql://localhost:5432/scala_db"
    val username = "postgres"
    val password = "asdf123"
    var connection: Connection = null
    
    // connecting to database
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)
    
    def updateTable(sql: String): Unit = {
        val statement = connection.createStatement()
        statement.executeUpdate(sql)
    }
    
    def main(args: Array[String]): Unit = {
        var userInput = " "
        print(""""C" to create new database, "R" to read current database, "I" to insert into database, "U" to update database, "D" to delete row from database, or "E" to exit""")
        print("\nEnter Input: ")
        userInput = scala.io.StdIn.readLine()
        
        //create
        if (userInput == "c" || userInput == "C") {
            CRUD.create()
            //println("create")
        }
        
        //read
        else if (userInput == "r" || userInput == "R") {
            CRUD.readMyFile.foreach(println)
            //println("read")
        }
        
        //insert
        else if (userInput == "I" || userInput == "i"){
            CRUD.insert()
        }
        
        //update
        else if (userInput == "u" || userInput == "U") {
            CRUD.update()
            println("update")
        }
        
        //delete
        else if (userInput == "d" || userInput == "D") {
            CRUD.delete()
            println("delete")
        }
        
        //exit
        else if  (userInput == "e" || userInput == "E") {
            println("Thank you")
        }
        
        else{
            println("Not an option, please try again")
        }
        //exit
    }
}