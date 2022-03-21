import scala.collection.immutable._

object Week_One_Try_Catch {
    
    def main(args: Array[String]): Unit = {
        //1.Try/Catch
        /*val name = Map("abc" -> "author","pqr" -> "coder") //maps keys to values
        
        val x = name.get("abc")
        val y = name.get("xyz")
        
        println(x)//prints Some(author) instead this may be due to abc being the some value and author is what it is mapped to
        println(y)//prints none because there is currently no value mapped to xyz key. only abc and pqr*/
        
        //2. without Exception Handling
        //var e = new ExceptionExample()
        //e.divide(100, 0) //tries to divide by 0 ExceptionExample.divide
        
        //5. Pattern Matching
        //var result = search("Hello")//Searches for Hello and finds it
        //print(result)// Prints back hello that was found
        
        //6 list
        /*//val numbersList: List[Int] = List(1, 2, 3 ,4)//creates a 4 element list
        val emptyList: List[Int] = List()//creates an empty list
    
        val numbersList: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil //creates a list with the final entry empty
    
        val names= "Harry" :: ("Adam" :: ("Jill" :: Nil))
        val age = Nil
        println( "Head of names array : " + names.head )//prints harry
        println( "Tail of names array : " + names.tail )//prints(Adam, Jill)
        println( "Check if names is empty : " + names.isEmpty )//prints false because there are 3 names and 1 nil entry
        println( "Check if age is empty : " + age.isEmpty )//prints true because Nil is considered empty*/
        
        //7 Set
        /*val emptySet: Set[Int] = Set()
        val numbersSet: Set[Int] = Set(1, 2, 3, 4)
    
        val name = Set("Smith", "Brown", "Allen")
        val id: Set[Int] = Set()
    
        println( "Head of name : " + name.head )//Prints Smith
        println( "Tail of name : " + name.tail )//Prints Brown, Allen
        println( "Check if name is empty : " + name.isEmpty ) //prints false
        println( "Check if id is empty : " + id.isEmpty ) //prints true because the set is empty*/
        
        //8 Merge two sets
        /*val games = Set("Cricket", "Football", "Hocky", "Golf")
        val alphabet = Set("A", "B", "C", "D", "E")
        val mergeSet = games ++ alphabet // Merging two sets
        println("Elements in games set: " + games.size) // Return size of collection 4
        println("Elements in alphabet set: " + alphabet.size) // Returns size of collection 5
        println("Elements in mergeSet: " + mergeSet.size) //Merges the 2 sets together
        println(mergeSet) //Prints the merged set, in alphabetical order*/
        
        //9 Concatenating list
        /*val country_1 =  List("States","Britain","New Zealand") //Creates a 3 element list
        val country_2 = List("Austria","Belgium","Canada") //Creates a 3 element list
    
        val country = country_1 ::: country_2 //combines the 2 lists
        println( "country_1 ::: country_2 : " + country ) //prints the list in the order they are listed
    
        val cont = country_1.:::(country_2)
        println( "country_1.:::(country_2) : " + cont ) //prints the list in alphabetical order
        val con = List.concat(country_1, country_2)
        println( "List.concat(country_1, country_2) : " + con  ) //prints in the order they are listed*/
        
        
        
    }
    
    /*def search(a: Any): Any = a match {
        case 1 => println("One")
        case "Two" => println("Two")
        case "Hello" => println("Hello")
        case _ => println("No")
    }*/
}

//2
/*class ExceptionExample {
    def divide(a: Int, b: Int): Unit = {
        a / b // Exception occurred here
        println("Rest of the code is executing...")
    }
}*/

//3 Exception Example
/*class ExceptionExample{
    def divide(a:Int, b:Int) = {
        try{
            a/b
        }catch{
            case e: ArithmeticException => println(e) //catches exception so rest of code can execute
        }
        println("Rest of the code is executing...")
    }
}*/

//4. Finally
/*class ExceptionExample{
    def divide(a:Int, b:Int) = {
        try{
            a/b //first tries to execute code
            var arr = Array(1,2)
            arr(10)
        }catch{
            case e: ArithmeticException => println(e) //prints error
            case ex: Exception =>println(ex)
            case th: Throwable=>println("found a unknown exception"+th)
        }
        finally{
            println("Finaly block always executes")//this executes first after finding error
        }
        println("Rest of the code is executing...")//this executes after finally block
    }
}*/