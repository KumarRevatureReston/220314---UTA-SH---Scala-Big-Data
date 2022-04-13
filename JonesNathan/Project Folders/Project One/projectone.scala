import java.sql.{Connection, DriverManager, ResultSet, SQLException, Statement};
import com.cloudera.hive.jdbc41.HS2Driver      


object testconn {
  def main(args: Array[String]): Unit = {   
    val conn_url = "jdbc:hive2://localhost:10000/default"     
    val conn = DriverManager.getConnection(conn_url, "hive", "")   //password removed from this version                     
    val stm = conn.createStatement();
  

    stm.execute("Use default" )
    println("Using database : default" )
    println("----------")
    println("")
    
    val view = ("SELECT movies.title AS Titles, COUNT(ratings.movieid) AS Views, AVG(ratings.rating) AS Avg_Score FROM ratings, movies WHERE movies.movieid = ratings.movieid GROUP BY ratings.movieid, title HAVING COUNT(ratings.movieid) > 50 ORDER BY AVG(ratings.rating) DESC limit 25; ")
    //val view = ("SELECT rating, COUNT(rating) AS Times_Chosen FROM ratings GROUP BY rating ORDER BY COUNT(rating) DESC;")
    //val view = ("SELECT from_unixtime(unixtimestamp, 'yyyy') AS year, AVG(rating) AS average, COUNT(from_unixtime(unixtimestamp, 'yyyy')) AS Votes FROM ratings GROUP BY from_unixtime(unixtimestamp, 'yyyy') ORDER BY AVG(rating) DESC;")
    println(view)
    println("")
    var results = stm.executeQuery(view)
    var a = 0
    while (results.next()){
      //println("Record Found")
        a = a + 1
        val md = results.getMetaData()
        var colcount :Int = md.getColumnCount()
        var curcolumn :Int = 0
        while (curcolumn < colcount) {
          curcolumn = curcolumn + 1
          print(md.getColumnName(curcolumn) + ":" + results.getString(curcolumn) + " | ")
        }
        println("") 
    }
    if (a == 0) {println("No Record Found")}
    conn.close()
  }
}
