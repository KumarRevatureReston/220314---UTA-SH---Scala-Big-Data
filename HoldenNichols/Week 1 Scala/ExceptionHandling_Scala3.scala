import scala.util.{Try,Success,Failure}
object Scala_exceptions{
    def main(args:Array[String])
    {                           /* Problem 1 */
        val name =Map("abc" -> "author","pqr" -> "coder" )

        val x =name.get("abc")
        val y = name.get("xyz")

        
    try { println(x) /*;prntln(y) */  }
        catch {
            case _: Exception => println("The key you are trying to print the value of does not exist within the dictionary for variable name")
        }
// when running properly, will print the first value associated with the key "abc" from variable x, which is "author" and will provide a print out for the caught exception from
// variable y as variable y requests a key "xyz", that does not exist within the variable name dictionary, this prompts a not found exception, which when properly written with a try catch
// would provide a case for the exception to match the criteria for and print out the string "The key you are trying to print the value of does not exist within the dictionary for variable name"

// without Exception Handling    /* Problem 2 */
    class ExceptionExample{  
    def divide(a:Int, b:Int) = {  
        a/b            // Exception occurred here, there is a java.lang.ArtithmeticException occuring as b is equivalent to 0 and a divison by 0 is not possible.
        
        println("Rest of the code is executing...")  
        }  
     }   
        var e = new ExceptionExample()  
        e.divide(100,/*0*/1)  
//    With proper exception handeling emplimented within this block of code, the print statement after the a/b computation would execute and we would see the output
// string "Rest of the code is executing..." as a means of showing that the exception was properly handled

                                            /* Problem 3 */
    class ExceptionExample3{  
    def divide3(a:Int, b:Int) = {  
        try{  
            a/b             //exception occurs here once again, an ArtithmeticException as we can not divide by the integer value 0
        }catch{  
            case e: ArithmeticException => println(e)  
        }  
        println("Rest of the code is executing...")  
    }  
}  
    var e3 = new ExceptionExample3()  
        e3.divide3(100,0)
    }
// the exception is caught this time due to it being within try and is caught by the catch with case e, which is specific to ArthmeticExceptions only, this case sends us to the print function as
// our output and we see the exception statment being print into the consule, we know that the code continues after the exception is thrown and caught since the following line of code after the
// the exception has a print line as a means of notifying us that the code continued on and that the exception was caught properly. How the exception here was caught is how we should implement
// the try and catch into problem 2.
}
   