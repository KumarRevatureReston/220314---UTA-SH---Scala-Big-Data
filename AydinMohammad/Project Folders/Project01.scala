import scala.io.Sourcer
import scala.concurrent.ExecutionContext.Implicits.global
import slick.driver.MySQLDriver.backend.{Database => SlickDB}
import slick.driver.MySQLDriver.api._
import slick.driver.MySQLDriver.backend
import scala.concurrent.{Future, Await}
import scala.concurrent.Await
import scala.concurrent.duration._




object Hello_World { 

  def main(args: Array[String]): Unit = {

   
  case class Myairport(

ident :String , 
 _type :String, 
name :String, 
latitude_deg :Double, 
longitude_deg :Double, 
elevation_ft :Int, 
continent : String,
scheduled_service :String, 
gps_code :String,
id :Long = 0L
)

//defining Table row classe for  database schema to describe the structure of the tables:
class AirportTable(tag: Tag) extends Table[Myairport](tag, "myairport") {

 def ident =column[String]("ident") 
 def _type =column[String]("_type")
 def name =column[String]("name")
 def latitude_deg = column [Double]("latitude_deg")
 def longitude_deg = column[Double]("longitude_deg") 
 def elevation_ft = column[Int]("elevation_ft")
 def continent =column[String]("continent")
 def scheduled_service =column[String]("scheduled_service") 
 def gps_code =column[String]("gps_code")
 def id = column[Long]("id",O.PrimaryKey,O.AutoInc)


  def * = (ident,_type,name,latitude_deg,longitude_deg,elevation_ft,continent,scheduled_service,gps_code,id).mapTo[Myairport];
                    }
//db has the configration of my database
//mySQLdb is a json object defiend in applicatin.conf that specifies my database configs
val db = Database.forConfig("mySQLdb")

//TableQuery[AirportTable], is a subtype of Query type that Slick uses to represent select, update, and delete queries.
val airports = TableQuery[AirportTable]


//helper method to excute my queries
def exec[T](action: DBIO[T]): T =
  Await.result(db.run(action), 4.seconds)

//adding a new record to the database.

//for multiple rows
 val multiAirport = Seq(
 Myairport("o4td","small airport","istanbul",36.1152992249,-97.079498291,50,"asia","yes","04SC"),
  Myairport("o9td","heliport","jordan",78.992882,-37.083736,50,"asia","no","02SC"),
  Myairport("o2td","small airport","china",31.73829,-90.73737,50,"asia","no","08SC"),
  Myairport("o1td","small airport","syria",36.1152992249,-97.079498291,50,"asia","yes","01SC")
)

exec(airports++=multiAirport)

//selecting an airport according to its name using filter() function
exec(airports.filter(_.name==="istanbul").result)


//select specific columns using map() function
val query = airports.filter(_.name==="istanbul").
  map(t=>(t.name,t._type,t.scheduled_service))

exec(query.result)



// is exist?
val containsist = for {
  m <- airports
  if m.name like "%Klaverack Airport%"
} yield m

val ist: DBIO[Boolean] =
  containsist.exists.result

  //sort by take() filter()  
  exec(airports.filter(_.elevation_ft<40).sortBy(_.elevation_ft).take(5).result).foreach(println)

  //count airports using length
  println("the number of airports ="+exec(airports.length.result)) 
 println("the number of airports that have elevation higher than 50ft="+exec(airports.filter(_.elevation_ft>50).length.result)) 

 //update a row
 val updateAir = airports.filter(_.name==="istanbul").map(air=>(air._type,air.scheduled_service))
 exec(updateAir.update("heliport","no"))
 println("row has been updated")
 exec(airports.filter(_.name==="istanbul").result)




   //delete a row 
    println("the number of airports with istanbul name befor delete = "+exec(airports.filter(_.name==="istanbul").length.result)) 
   val removeAir: DBIO[Int] =
  airports.filter(_.name === "istanbul").delete
  exec(removeAir) 
 println("the number of airports with istanbul name after delete= "+exec(airports.filter(_.name==="istanbul").length.result)) 




 }  

}             
                