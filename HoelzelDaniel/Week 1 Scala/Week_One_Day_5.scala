import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}
import scala.concurrent.{Await, Future}

object Week_One_Day_5 {
    def main(args: Array[String]): Unit = {
        
        //Creating Future
        /*object Addition extends App {
            val firstNum = 5
            val secondNum = 6
            val addition = Future {
                Thread.sleep(500) //makes app wait 500 milliseconds before running
                firstNum + secondNum //adds first and second number
            }
            println(addition.isCompleted) //prints this once it is completed
            println(addition.value) //prints value
        }*/
        
        //Call backs
        
        /*object Addition extends App {
            val firstNum = 5
            val secondNum = 6
            val addition = Future {
            
                firstNum + secondNum
            }
            Thread.sleep(100) //waits 100ms before executing
            addition.onComplete {
                case Success(value) => println("addition=" + value) //prints the addition 11 when it executes properly
                case Failure(e)     => println("not complete yet") //prints not complete yet when it cant execute properly
            }
        }*/
        
        // use for construct to extract values when futures complete
        /*val b1 = futureInt //doesn't currently exist but will later
        val b2 = futureInt //doesn't currently exist but will later
        for (i1 <‑ b1; i2 <‑ b2) yield println("Sum of values is " + (i1 + i2)) sums up the 2 vlaues
        Thread sleep 3000 //stops for 3000 milliseconds
    
        // wait directly for completion of futures
        val c1 = futureInt
        val c2 = futureInt
        println("Sum of values is " + (Await.result(c1, Duration.Inf) +
            Await.result(c2, Duration.Inf))) //waits for as long as needed until the result is reached
            */
        
        /*def taskHello: Future[Unit] = {
            Future {
                println("Starting Task-Hello") //prints 3rd
                println("Hello") //prints 4th
                println("Finished Task-Hello") //prints 5th
            }
        }
        
        println("Start Program") //prints 1st
        val task: Future[Unit] = taskHello //calls task hello, but it doesn't execute until after this task finishes
        println("Continue") //prints 2nd
        Await.result(task, Duration.Inf) // waits until task finishes
        
        def printInfo(txt: String): Unit = {
            val thread = Thread.currentThread.getName
            println(s"${LocalDateTime.now} [$thread] $txt")//gets local time on the machine
            */
        
        //Option
        val name = Map("abc" -> "Kumar", "pqr" -> "Revature")
        
        
        val x = name.get("abc")
        val y = name.get("xyz")
        
        
        println(x) //prints Some(Kumar)
        println(y) //prints None
        
        //Either
        def Name(name: String): Either[String, String] =
        {
    
            if (name.isEmpty) //if there is nothing that matches
        
                Left("No Name") //prints no name
    
            else
                Right(name) //if it matches, prints the name
        }
    
    
        println(Name("Kumar")) //prints Right(Kumar)
    
        println(Name("")) //prints Left(No Name)
    }
}