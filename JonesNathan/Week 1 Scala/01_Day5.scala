//remove the comment lines to make code functional, distinct lines of code will be seperated by ------


//import scala.concurrent.Future
//import scala.concurrent.ExecutionContext.Implicits.global
//object Addition extends App {
    //val firstNum = 5
    //val secondNum = 6
    //val addition = Future {
        //Thread.sleep(500)
        //firstNum + secondNum
    //}
    //println(addition.isCompleted)             //false
    //println(addition.value)                   //none
//}
//------output of false because the addition is not completed at the time the function is evaluated.
//------"None" is given since the function does not have a value to evaluate


//import scala.concurrent.{Future}
//import scala.concurrent.ExecutionContext.Implicits.global
//import scala.util.{Failure, Success}
//object Addition extends App {
    //val firstNum = 5
    //val secondNum = 6
    //val addition = Future {

        //firstNum + secondNum
    //}
    //Thread.sleep(100)
    //addition.onComplete {
        //case Success(value) => println("addition=" + value)
        //case Failure(e)     => println("not complete yet")
    //}
//}
//------output of addition=11 because the addition function completes successfully.


//import scala.concurrent.duration.Duration
//import scala.concurrent.{Await, Future}
//import scala.concurrent.ExecutionContext.Implicits.global

//object Example {
    //def taskHello: Future[Unit] = {
        //Future{
            //printInfo("Starting Task-Hello")
            //println("Hello")
            //printInfo("Finished Task-Hello")
        //}
    //}
    //def main(args: Array[String]): Unit = {
        //printInfo("Start Program")
        //val task: Future[Unit] = taskHello
        //printInfo("Continue")
        //Await.result(task, Duration.Inf)
    //}
    //def printInfo(txt: String): Unit = {
        //val thread = Thread.currentThread.getName
        //println("s"${LocalDateTime.now"} [$thread] $txt")      //this line of code is not functional since localdatetime is not defined or found, needs to be suppressed
    //}
//}
//------output of only Hello because of the non-functional line


//object option{
	//def main(args: Array[String]){
		//val name = Map("abc" -> "Kumar","pqr" -> "Revature")
		//val x = name.get("abc")                                 //outputs value of Kumar since .get pulls the value
		//val y = name.get("xyz")                                 //output of none since no match to be found
		//println(x)  
		//println(y)  
	//}
//}
//------output of x and y that are created by the .get functions that are applied to the val of "name"


//object EitherExample extends App{       //extends App to pull from collections/library
	//def Name(name: String): Either[String, String] ={
		//if (name.isEmpty)
			//Left("No Name")
		//else
			//Right(name)
	//}
	//println(Name("Kumar"))              //prints right along with name that is entered
	//println(Name(""))                   //prints left along with string indicating no name was given
//}
//------output is very similar to what an if_else statement can do on its own, but is limited to two cases