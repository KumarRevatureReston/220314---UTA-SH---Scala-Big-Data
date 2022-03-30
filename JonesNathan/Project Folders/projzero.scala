import java.sql.{Connection, DriverManager, ResultSet}

/*
object pgsqlconn extends App {
  println("Postgres connector")         //remove this later perhaps

  //classOf[org.postgresql.Driver]  //this doesnt seem to be doing anything
  val conn_url = "jdbc:postgresql://localhost:5432/uni_students"
  val conn = DriverManager.getConnection(conn_url, "postgres", "password")      //password removed
  try {
    val stm = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

    val rs = stm.executeQuery("SELECT * from undergrads")

    while(rs.next) {
      println(rs.getString("std_id"))
    }
 } finally {
     conn.close()
  }
}
*/


object CSV{
  def readCSV(file: String): Seq[String] = {
    val bufferedSource = io.Source.fromFile("C:/Users/natha/databases/airports4.csv") //2 is untampered
    val lines = (for (line <- bufferedSource.getLines) yield line).toSeq
    //val lines = bufferedSource.getLines
    //lines.foreach(arg => println(arg))
    bufferedSource.close
    lines //.toSeq
  }
}


object projectZero {
  def main(args: Array[String]): Unit = {
        val s = CSV.readCSV("/C:/Users/natha/databases/airports.csv")   
        val conn_url = "jdbc:postgresql://localhost:5432/uni_students"
        val conn = DriverManager.getConnection(conn_url, "postgres", "password")    //set password to val somewhere else
        println("Reset database? Yes(y), No(n)")
        var userinput = scala.io.StdIn.readLine()
        if (userinput == "y"){
          println("Are you certain? Yes(y), No(n)")
          var logincount = 0
          while (logincount < 1){
          var userinput = scala.io.StdIn.readLine()
          if (userinput == "y"){
            createTable.column(conn, s)       //creates or resets the original database
            println("Resetting/Creating Database")
            logincount = 1   
          }
          if (userinput == "n"){
            println("Database will not be reset")
            println("Proceeding")
            logincount = 1
          }
          else {
            println("Please enter (y/n)")
          }
        } 
      }
        else { println("Database will not be reset")
        println("Proceeding")
        }
        
        //Start of CRUD process loop
        var crudloop = 0
        while (crudloop < 1){
          println("Specify CRUD operation: Create/Read/Update/Delete/Quit AS c/r/u/d/q")
          userinput = scala.io.StdIn.readLine()
          println("")
          if (userinput == "c"){           
            createRecord.ins(args)
          }
          if (userinput == "r"){
            readRecord.read(args)
          }  
          if (userinput == "u"){
            updateRecord.shift(args)
          }
          if (userinput == "d"){
            deleteRecord.erase(args)
          }
          if (userinput == "q"){
            println("quit program")
            crudloop = 1
          }
          else { println("Please enter c, r, u, d, or q")
          //println("");
        };  
      }           
    conn.close()                //last line
  }
}

object createTable {
    def column(conn: Connection, s: Seq[String] ) = {
        val stm = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)  
        val col = s(0).split(",")
        var ddd = ""
        for (n <- col) {
            if (ddd.isEmpty()) {
              ddd = n + " VARCHAR(20)"
            } else {
              ddd = ddd + ", " + n + " VARCHAR(200)"      //loop to continually increase string ddd
            }
          }
        val droptable = "DROP TABLE IF EXISTS airplanes2;"
        stm.execute(droptable)
        val columncreate = "CREATE TABLE IF NOT EXISTS airplanes2 ("+ddd+");"
        stm.execute(columncreate)                       //command to create the table

        var inc = 0;
        while(inc < s.length-1){           //increment to run INSERT over sets of data
          inc= inc + 1;
          var rec = s(inc).split(",").map(_.replaceAll("'",""))     //.map(_.replaceAll("\"",""))
          var record = ""
          if (rec.length <= 18) {     //newly added, know that it is 18
            for (n <- rec){                 
              if (record.isEmpty()){          //specifically for first statement
                record = record + "'" + n + "'"
              } else{
                record = record + ",'" + n + "'"
              }
            }
            var push = "INSERT INTO airplanes2 VALUES("+record+");"
            stm.execute(push)
          }
          else{
          }
          //var push = "INSERT INTO airplanes2 VALUES("+record+");"            
          record = ""
        }
    }
}



object createRecord{
  def ins(args: Array[String]){
    val conn_url = "jdbc:postgresql://localhost:5432/uni_students"
    val conn = DriverManager.getConnection(conn_url, "postgres", "password")                 //removed password
    val stm = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    
    println("Provide column names to insert data into in form of: column1, column2, ...")
    var userinput = scala.io.StdIn.readLine()
    println("Provide values in form of: 'value1', 'value2', ...")
    var userinput2 = scala.io.StdIn.readLine()
    var pushSmall = "INSERT INTO airplanes2("+userinput+") VALUES ("+userinput2+");"
    println(pushSmall)
    println("")
    stm.execute(pushSmall)    

    conn.close()
  }
}

object readRecord{
  def read(args: Array[String]){
    val conn_url = "jdbc:postgresql://localhost:5432/uni_students"
    val conn = DriverManager.getConnection(conn_url, "postgres", "password")              //removed password
    val stm = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

    println("Provide column names to read/select data from in form of: (column1, column2, ...) OR * for all")
    var userinput = scala.io.StdIn.readLine()
    println("Provide conditional statement if desired. Ex: WHERE/ORDER BY column1 ASC")
    var userinput2 = scala.io.StdIn.readLine()
    var view = "SELECT "+userinput+" FROM airplanes2 "+userinput2+ ";"
    println(view)
    println("")
    //stm.execute(view)     //look at executeupdate
    var results = stm.executeQuery(view)
    if (results.next()){
      println("Record Found")
      //println(results.getString(1) + " " + results.getString(2))
      val md = results.getMetaData()
      var colcount :Int = md.getColumnCount()
      var curcolumn :Int = 0
      while (curcolumn < colcount) {
        curcolumn = curcolumn + 1
        print(md.getColumnName(curcolumn) + ":" + results.getString(curcolumn) + " | ")
        println(" ")
      }
    } else{
      println("Record not found")
    }

    conn.close()
  }
}

object updateRecord{
  def shift(args: Array[String]){
    val conn_url = "jdbc:postgresql://localhost:5432/uni_students"
    val conn = DriverManager.getConnection(conn_url, "postgres", "password")              //removed password
    val stm = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    
    println("Provide reassignment target and new value in form of: column1 = 'value1', column2 = 'value2',... WHERE column = 'ExistingValue'...")
    var userinput = scala.io.StdIn.readLine()
    var change = "UPDATE airplanes2 SET "+userinput+ ";"
    println(change)
    println("")
    stm.execute(change)

    conn.close()
  }
}

object deleteRecord{
  def erase(args: Array[String]){
    val conn_url = "jdbc:postgresql://localhost:5432/uni_students"
    val conn = DriverManager.getConnection(conn_url, "postgres", "password")            //removed password
    val stm = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    
    println("Provide delete data in form of: column = 'value'")
    var userinput = scala.io.StdIn.readLine()
    var dele = "DELETE FROM airplanes2 WHERE "+userinput+";"
    println(dele)
    println("")
    stm.execute(dele)   

    conn.close()
  }
}
