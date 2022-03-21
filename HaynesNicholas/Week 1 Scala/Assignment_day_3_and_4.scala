1.Try/Catch
{

	def main(args: Array[String])
	{
		  val name = Map("abc" -> "author","pqr" -> "coder")

		
		  val x = name.get("abc")
		  val y = name.get("xyz")


		  println(x)  // returns Some(author)
		  println(y)  // returns None
	}
}

2. without Exception Handling
class ExceptionExample{  
    def divide(a:Int, b:Int) = {   // Creates a method to divide int a by int b
            a/b             // Exception occurred here  
        println("Rest of the code is executing...")  // prints after code is executed
    }  
}  
object MainObject{  
    def main(args:Array[String]){  
        var e = new ExceptionExample()  // creates new instance of class
        e.divide(100,0)  // attempts to divide by 0, causing ArithmeticException error to be thrown
        // The code is never completed
    }  
}

3. with Exception Handling
class ExceptionExample{  
    def divide(a:Int, b:Int) = {  // Creates a method to divide int a by int b
        try{  
            a/b  // Exception occurred here  
        }catch{  
            case e: ArithmeticException => println(e)  // catches ArithmeticException e and prints it
        }  
        println("Rest of the code is executing...")  // prints after code is executed
    }  
}  
object MainObject{  
    def main(args:Array[String]){  
        var e = new ExceptionExample()  // creates new instance of class
        e.divide(100,0)  // attempts to divide by 0, but error is caught
        // The code is successfully compiled
    }  
}  

4. Finally
class ExceptionExample{  
    def divide(a:Int, b:Int) = {  
        try{  
            a/b  //if you did println(a/b), it would return 10 before the OutOfBoundsException
            var arr = Array(1,2)  
            arr(10)  // Exception is thrown here because 10 is out of bounds for arr length of 2
        }catch{  
            case e: ArithmeticException => println(e)  // This will be thrown if you try to divide by 0
            case ex: Exception =>println(ex)  // This will be thrown for any other known Exception
            case th: Throwable=>println("found a unknown exception"+th)  // This will be thrown if the exception is unknown
        }  
        finally{  
            println("Finaly block always executes")  // This will be thrown after a try/catch, no matter if it is completed
        }  
        println("Rest of the code is executing...")  // This prints after the rest of code is executed
    }  
}  
  
  
object MainObject{  
    def main(args:Array[String]){  
        var e = new ExceptionExample()  
        e.divide(100,10)  
   
    }  
}  

5.Pattern Matching 
object MainObject {  
   def main(args: Array[String]) {  
        var result = search ("Hello")  
        print(result)  
    }  
    def search (a:Any):Any = a match{  
        case 1  => println("One")  
        case "Two" => println("Two")  
        case "Hello" => println("Hello")  
        case _ => println("No")  
              
        }  
}

6. list
val numbersList: List[Int] = List(1, 2, 3 ,4)
val emptyList: List[Int] = List()

val numbersList: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil


object Student {
def main(args:Array[String]) {
    val names= "Harry" :: ("Adam" :: ("Jill" :: Nil))
    val age = Nil
      println( "Head of names array : " + names.head )
      println( "Tail of names array : " + names.tail )
      println( "Check if names is empty : " + names.isEmpty )
      println( "Check if age is empty : " + age.isEmpty )
   }
}

7.set
val emptySet: Set[Int] = Set() 

val numbersSet: Set[Int] = Set(1, 2, 3, 4)

object Student {
   def main(args: Array[String]) {
      val name = Set("Smith", "Brown", "Allen")
      val id: Set[Int] = Set()

      println( "Head of name : " + name.head )
      println( "Tail of name : " + name.tail )
      println( "Check if name is empty : " + name.isEmpty )
      println( "Check if id is empty : " + id.isEmpty )
   }
}

8. Merge two Set
import scala.collection.immutable._  
object MainObject{  
        def main(args:Array[String]){  
            val games = Set("Cricket","Football","Hocky","Golf")  
            val alphabet = Set("A","B","C","D","E")   
            val mergeSet = games ++ alphabet            // Merging two sets  
            println("Elements in games set: "+games.size)   // Return size of collection  
            println("Elements in alphabet set: "+alphabet.size)   
            println("Elements in mergeSet: "+mergeSet.size)  
            println(mergeSet)  
        }  
    }  


9. Concatenating lists
object Country {
	def main(args:Array[String]) {
	val country_1 =  List("States","Britain","New Zealand")
	val country_2 = List("Austria","Belgium","Canada")

	val country = country_1 ::: country_2
	println( "country_1 ::: country_2 : " + country )

	val cont = country_1.:::(country_2)
            println( "country_1.:::(country_2) : " + cont )
	val con = List.concat(country_1, country_2)
            println( "List.concat(country_1, country_2) : " + con  )

   }
}


10. Story Telling : Scala’s pattern matching
https://towardsdatascience.com/how-to-use-scalas-pattern-matching-362a01aa32ca
Someone can take a lead and do a code walk through on Pattern Matching 



  