    //1. Try/Catch
        //get either results in some or none; boolean
        //since abc was found, it resulted in Some(author); but since there was no xyz, it resulted in None
object TryCatch {
	def main(args: Array[String]) {
        val name = Map("abc" -> "author","pqr" -> "coder")
        val x = name.get("abc")
        val y = name.get("xyz")
        println(x)  
        println(y)  
	}
}

    //2. without Exception Handling
    //ArithmeticException: divide by zero error as a result because it's not possible to divide any number by 0
    //changed 0 to 5 and caused "Rest of the code is executing..." to be printed since the program could run a/b
class ExceptionExample {  
    def divide(a:Int, b:Int) = {  
        a/b  
        println("Rest of the code is executing...")
    }
}
object MainObject {  
    def main(args: Array[String]){  
        
        var e = new ExceptionExample()  
        e.divide(100,5)
    }  
}


    //3. class
    //the same ArithmeticException error occurs as in the last question, so I changed the 0 to a 5
    //it makes no difference if the divide is in a seperate object or class, the expression still runs the same
object ExeptionExample3 {
    def divide(a:Int, b:Int) = {  
        try {  
            a/b  
        }
        catch {  
            case e: ArithmeticException => println(e)  
        }  
        println("Rest of the code is executing...")  
    }  
}  
object MainObject2 {  
    def main(args:Array[String]){  
        var e = new ExceptionExample()  
        e.divide(100,5)
    }  
}  

    //4. Finally
    //the finally always executes, no matter if the try and catch fails
    //the result should be that both println printed, but only the last one is printing
    //the finally block should always execute
class ExceptionExample2 {  
    def divide(a:Int, b:Int) = {  
        try {  
            a/b  
            var arr = Array(1,2)  
            arr(10)  
        }catch {  
            case e: ArithmeticException => println(e)  
            case ex: Exception =>println(ex)  
            case th: Throwable=>println("found a unknown exception"+th)  
        }  
        finally {  
            println("Finally block always executes")  
        }  
        println("Rest of the code is executing...")  
    }  
}   
object MainObject3 {  
    def main(args:Array [String]){  
        var e = new ExceptionExample()  
        e.divide(100,10)
    } 
}  

    //5. Pattern Matching
    //since "Hello" is one of the cases, the result is Hello
object MainObject4 {  
   def main(args: Array [String]) {  
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

    //6. list
    //shows a many different ways to make a list
object ListEx {
    def main(args: Array [String]) {
        val numbersList: List[Int] = List(1, 2, 3 ,4)
        val emptyList: List[Int] = List()
        val numbersList2: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil
    }
}
    //shows how a list can work with words rather than numbers
    //names.head shows only the first value of the list while names.tail shows all those that aren't the first
    //Nil means empty and since age is empty but names is not, it causes the results to come back as such when checked with names/age.isEmpty
object Student {
def main(args:Array [String]) {
    val names= "Harry" :: ("Adam" :: ("Jill" :: Nil))
    val age = Nil
    println( "Head of names array : " + names.head )
    println( "Tail of names array : " + names.tail )
    println( "Check if names is empty : " + names.isEmpty )
    println( "Check if age is empty : " + age.isEmpty )
   }
}

    //7. set
    //shows an empty set and a numbered set for examples
object SetEx {
    def main(args: Array [String]) {
        val emptySet: Set[Int] = Set() 
        val numbersSet: Set[Int] = Set(1, 2, 3, 4)
    }
}
    //this shows basically the same as Question 6 except empty sets need to be formatted differently than empty lists
object Student2 {
   def main(args: Array [String]) {
      val name = Set("Smith", "Brown", "Allen")
      val id: Set[Int] = Set()
      println( "Head of name : " + name.head )
      println( "Tail of name : " + name.tail )
      println( "Check if name is empty : " + name.isEmpty )
      println( "Check if id is empty : " + id.isEmpty )
   }
}

    //8. Merge two Set
    //the .size for all three shows that the size of games and alphabet combined equals the size of mergeSet
    //this shows that games ++ alphabet successfully merged the two sets into one
import scala.collection.immutable._ 

object MainObject5 {  
        def main(args:Array [String]){  
            val games = Set("Cricket","Football","Hocky","Golf")  
            val alphabet = Set("A","B","C","D","E")   
            val mergeSet = games ++ alphabet            // Merging two sets  
            println("Elements in games set: "+games.size)   // Return size of collection  
            println("Elements in alphabet set: "+alphabet.size)   
            println("Elements in mergeSet: "+mergeSet.size)  
            println(mergeSet)  
        }  
    }  


    //9. Concatenating lists
    //country and con both merge country_1 and country_2 in the respective order
    //cont prepends country_2 to country_1
object Country {
	def main(args:Array [String]) {
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


    //10. Story Telling : Scala’s pattern matching
    //the video helped me understand pattern matching better and I wish I would've watched sooner!
        //https://towardsdatascience.com/how-to-use-scalas-pattern-matching-362a01aa32ca
