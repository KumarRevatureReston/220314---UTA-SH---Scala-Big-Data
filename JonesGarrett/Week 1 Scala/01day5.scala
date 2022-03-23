trait OutputFuncs{
  //prints a message colored red
  def printRed(txt: String): Unit = {
    print(Console.RED)
    print(txt)
    print(Console.RESET)
    println()
  }
  def printGreen(txt: String): Unit = {
    print(Console.GREEN)
    print(txt)
    print(Console.RESET)
    println()
  }

  //print the current moment in time.
  def printTime(): Unit = {
    //println(s"Func FutureExample Time: ${System.currentTimeMillis()}")
    println(s"Func FutureExample Time: ${new java.util.Date()}")
    ///
  }
}


import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
object FutureAddition extends OutputFuncs{
  val firstNum = 5
  val secondNum = 10
  val addition = Future {
    Thread.sleep(1000) // 1000 milliseconds is one second.
    firstNum + secondNum
  }

  // This line will only be executed after addition is complete
  addition.onSuccess {
    case result => println(s"Func Future: The result is $result")
  }

  //This line will be executed before addition is complete
  println(s"Func Future result: ${addition.value}")
  println(s"Func Future result: ${addition.isCompleted}")

}

import scala.concurrent.duration._
import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
//Call backs
object Callback extends OutputFuncs{
  val firstNum = 5
  val secondNum = 6
  val addition = Future {
    firstNum + secondNum
  }
  Thread.sleep(100)
  addition.onComplete {
    case Success(result) => printGreen(s"Func Callback.addition: Success! The result is $result")
    case Failure(e) => printGreen(s"Func Callback.addition: Failure! The result is $e")
  }

  // declare a futureInt
  val b1 = Future {
    Thread.sleep(1000)
    42
  }
  val b2 = Future {
    Thread.sleep(1000)
    50
    
  }
  Thread sleep 3000

  // Prints the result of the futureInt
  val b3 = b1.zip(b2)
  b3.onSuccess {
    case (x, y) => printGreen(s"Func Callback.b3: The result is $x and $y")
  }
  //OR 
  for {
    x <- b1
    y <- b2
  } yield printGreen(s"Func Callback.b3: The result is $x and $y")

  val c1 = Future {
    Thread.sleep(1000)
    5
    
  }
  val c2 = Future {
    Thread.sleep(1000)
    10
  }
  // print await with duration of c1 and c2
  val c3 = c1.zip(c2)
  // await the results of c3 and 
  // print the results of c3
  // Duration is set to 2 seconds
  // print value of c3

  
  val x = Duration(2, SECONDS)
  println(s"TEST: ${x.getClass}")
  try {
    val result = Await.result(c3, x)
    printGreen(s"Func Callback.c3: The result is $result")
  } catch {
    case e: Exception => printRed(s"Func Callback.c3: The result is $e")//Couldn't get this to work no matter what, INF blocks forever and FINITE throws an error.
  }
}

object FutureExample extends OutputFuncs{

  def taskHello: Future[Unit] = {
    Future{

      printInfo("Starting task-hello")
      println("Hello")
      printInfo("Finished task-hello")
    }
  }

  def printInfo(txt: String): Unit = {
    val thread = Thread.currentThread.getName
    printTime()
    println(s"  $txt on thread $thread")


  }

  printInfo("Starting program")
  val task: Future[Unit] = taskHello
  printInfo("Continue")
  try {
    Await.result(task, Duration(3, SECONDS))
  } catch {
    case e: Exception => printRed(s"Exception: $e")
  }
}


// Example of using an option
object OptionExample extends OutputFuncs{
  val name = Map("abc" -> "Kumar","pqr" -> "Revature")
  val x = name.get("abc")
  val y = name.get("xyz")
  println(x) //Some(Kumar)
  println(y) //None
}

object EitherExample extends OutputFuncs{
  def name(name: String): Either[String, String] = {
    if (name.isEmpty()) {
      printRed(s"No name provided")
      Left(s"No name provided")
    } else {
      printGreen(s"Name provided: $name")
      Right(name)
    }
  }

  println("   "+name("Garrett"))
  println("   "+name(""))


}


object Day5 extends OutputFuncs{
  def main(args: Array[String]): Unit = {
    val f = FutureAddition // Displays parallel execution of the two futures
    val c = Callback // Displays sequential execution of the two futures
    val ef = FutureExample

    // Exception handling object calls
    OptionExample
    EitherExample





    Thread.sleep(2000) // wait for 2 seconds and check if the futures are completed
    //Check too see if the futures are completed
    println("Are threads completed after waiting 2 seconds? See below.")
    println(s"Func main: ${f.addition.isCompleted}")
    println(s"Func main: ${c.b1.isCompleted}")
    println(s"Func main: ${c.b2.isCompleted}")
    println(s"Func main: ${c.b3.isCompleted}")
    println(s"Func main: ${c.c1.isCompleted}")
    println(s"Func main: ${c.c2.isCompleted}")
    println(s"Func main: ${c.c3.isCompleted}")

    

    println("Finished")
    

  }
}
