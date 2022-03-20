//1.Try/Catch
object question1{

  def main(args: Array[String]) {
    val name = Map("abc" -> "author","pqr" -> "coder")               //This creates a val 'name' that is assigned a map with 2 key-value pairs


    val x = name.get("abc")                                          //This sets a val 'x' equal to the value corresponding to the key "abc"
    val y = name.get("xyz")                                          //This sets a val 'y' equal to the value corresponding to the key "xyz"


    println(x)                                                       //This prints out the value of x to the terminal. It will print Some(author)
    println(y)                                                       //This prints out the value of y to the terminal. It will print None since
                                                                     //there is no key corresponding to the value "xyz" and thus no value either.
  }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//2. without Exception Handling
class ExceptionExample{                                              //This class Exception example contains a method called divide that takes in
  def divide(a:Int, b:Int) = {                                       //2 integer values and divides the first by the second. Then prints the
    a/b             // Exception occurred here                       //the statement "Rest of the code is executing..."
    println("Rest of the code is executing...")
  }
}
object question2{                                                    //In the main method an object of the class ExceptionExample is created and
  def main(args:Array[String]){                                      //named 'e'. Next the object is used to call the method divide(), passing in
    var e = new ExceptionExample()                                   //the values 100 and 0. 
    e.divide(100,0)                                                   
                                                                     //Becuase of the values passed into the divide() method and the how they are
  }                                                                  //manipulated the program will throw a divide by zero ArithmeticException and
}                                                                    //stop the program. The println statement will never run.

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//3. with Exception Handling
class ExceptionExample{ 
  def divide(a:Int, b:Int) = {                                       //The only thing different between this question and the one above is the
    try{                                                             //inclusion of a try-catch block within the method divide(). The try-catch
      a/b                                                            //block enables the an exception to be caught and handled without stopping
    }catch{                                                          //the flow of the program. The try block will try to run the program as 
      case e: ArithmeticException => println(e)                      //before and the catch block will catch the thrown ArithmeticException. It
    }                                                                //will then proceed to the print the exception and the contents of the 
    println("Rest of the code is executing...")                      //println statement outside the try-catch block.
  }
}                                                                    //The output will be:
object question3{                                                    //java.lang.ArtihmeticException: / by zero
  def main(args:Array[String]){                                      //Rest of the code is executing...
    var e = new ExceptionExample()
    e.divide(100,0)
    
  }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//4. Finally
class ExceptionExample{
  def divide(a:Int, b:Int) = {                                       //This program is the same as above but it also declares a var 'arr' which
    try{                                                             //an array with 2 elements within the try-block. It also tries to access the
      a/b                                                            //10th element of that array, which doesn't exist, so it throws an Array-
      var arr = Array(1,2)                                           //IndexOutOfBoundsException.
      arr(10)                                                        
    }catch{                                                          //This program also has 2 new catch cases in the catch block. The first new
      case e: ArithmeticException => println(e)                      //exception will catch all general exceptions, and the second will catch any
      case ex: Exception =>println(ex)                               //throwable object caused by an unknown exception. It will also print out
      case th: Throwable =>println("found a unknown exception"+th)   //"found a unkown exception". 
    }
    finally{                                                         //A finally block was also included which will execute regardless of whether
      println("Finaly block always executes")                        //an exception was caught or not. It will print "Finaly block always executes.
    }
    println("Rest of the code is executing...") 
  }
}


object question4{
  def main(args:Array[String]){                                      //The output will be:
    var e = new ExceptionExample()                                   //java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 2
    e.divide(100,10)                                                 //Finaly block always executes
                                                                     //Rest of the code is executing...
  }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//5. Pattern Matching
object question5 {                                                   //This program creates a var 'result' that takes the value returned from the
  def main(args: Array[String]) {                                    //search function by passing in the string "Hello". It subsequently also 
    var result = search ("Hello")                                    //prints this var to the terminal.
    print(result)
  }                                                                  //The search function takes in any datatype and feeds it to a pattern
  def search (a:Any):Any = a match{                                  //matching expression that compares what was passed in to a few different
    case 1 => println("One")                                         //cases. If no case matches with the input the expression will use the
    case "Two" => println("Two")                                     //default case and print "No". The case "Hello" matches, so the program
    case "Hello" => println("Hello")                                 //will print "Hello". Since this function does not return any value the 
    case _ => println("No")                                          //var 'result' will remain empty.
  }                                                                  
}                                                                    //the output will be:
                                                                     //Hello
                                                                     //()

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//6. list
val numbersList: List[Int] = List(1, 2, 3 ,4)                        //This creates a integer list with 4 elements called 'numbersList'
val emptyList: List[Int] = List()                                    //This creates an empty integer list called 'emptyList'

val numbersList: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil                 //This creates a list by concatenating separate integers using the double
                                                                     //colon ( :: ) symbol. Additionally, you can concatenate a list to that list
                                                                     //using the triple colon ( ::: ) symbol, like so:
                                                                     //val numbersList2:List[Int] = numbersList ::: List(5,6,7)
object question6 {
  def main(args:Array[String]) {
    val names= "Harry" :: ("Adam" :: ("Jill" :: Nil))                //This creates a list, 'names', by concatenating several strings into a list.
    val age = Nil                                                    //This creates an empty val variable.
    println( "Head of names array : " + names.head )                 //This will return the first value of the List 'names'
    println( "Tail of names array : " + names.tail )                 //This will return all values succeeding the first in the list 'names'
    println( "Check if names is empty : " + names.isEmpty )          //This return a boolean showing if the list 'names' is empty or not
    println( "Check if age is empty : " + age.isEmpty )              //This does the same as above but for the empty val 'age'
  }
}
