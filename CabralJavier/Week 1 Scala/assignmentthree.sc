//1.Try/Catch
{

  def main(args: Array[String]) //defines a new method
  {
    val name = Map("abc" -> "author","pqr" -> "coder")
    //creating a map which creates keys between elements in the paramaters.


    val x = name.get("abc") //when 'abc' is called then the 'Author" will be presented
    val y = name.get("xyz")// there is no connection(map) for 'xyz' so nothing will be printed for xyz


    println(x) //outputs author
    println(y) //outputs nothing due to lack of map or connection
  }
}

//2. without Exception Handling
class ExceptionExample{ //creating a new class
  def divide(a:Int, b:Int) = { //defining the methods of this new class
    a/b             // Exception occurred here
    println("Rest of the code is executing...") //due to the exception the output lets users know that this will not
    //occur but the rest of the code is executing
  }
}
object MainObject{ // mainObject has been created
  def main(args:Array[String]) = { //defining the method of the new object
    var e = new ExceptionExample() //new mutable variable 'e' has been created using the methods of 'ExceptionExample'
    e.divide(100,0) //an exception occurs due to 100 not being able to be divided by 0
  }
}

3. class ExceptionExample{//creating a class for a 'ExceptionExample'
  def divide(a:Int, b:Int) = { //defining a method that will divide the values of a and b
    try{ //raises the parameters for possible exception based on following expressions
      a/b //Ints cannot be divided by 0 which will raise an exception
    }catch{ //used to catch the following exceptions
      case e: ArithmeticException => println(e) //creating the case for e that will notify users that this is an
        //arithemticexception
    }
    println("Rest of the code is executing...") //the output that is letting user know that the rest of code can work except for thise one
  }
}
object MainObject{ // mainObject has been created
  def main(args:Array[String]){ //defining the method of the new object
    var e = new ExceptionExample() ////new mutable variable 'e' has been created using the methods of 'ExceptionExample'
    e.divide(100,0) //an exception occurs due to 100 not being able to be divided by 0

  }
}

//4. Finally
class ExceptionExample{ // create new class "ExceptionExample"
  def divide(a:Int, b:Int) = { ////defining a method that will divide the values of a and b
    try{//raises the parameters for possible exception based on following expressions
      a/b //an exception do to the program not running a mathematical value
      var arr = Array(1,2) //mutable value for 'arr' is an array with two elements
      arr(10) //the array has been increased to 10 elements
    }catch{ //expressions that the program catches to rais exceptions
      case e: ArithmeticException => println(e) // an expression that raises exceptions for case e
      case ex: Exception =>println(ex) // case ex will output exceptions
      case th: Throwable=>println("found a unknown exception"+th) //the throwable will acknowledge that there is
        //an exception in the program
    }
    finally{ //the last statement and final output created due to exceptions raised
      println("Finaly block always executes") //this the output letting the user know that the finally part of exception has been executed.
    }
    println("Rest of the code is executing...")//final output of the exception
  }
}


object MainObject{
  def main(args:Array[String]){
    var e = new ExceptionExample()
    e.divide(100,10)

  }
}

//5.Pattern Matching
object MainObject { //new class for 'MainObject" has been created
  def main(args: Array[String]) { //defining the main methods for this new class
    var result = search ("Hello") //mutable value for 'result' has been created to search for "Hello"
    print(result) //outputing the value of "result"
  }
  def search (a:Any):Any = a match{ //defining the method for search to find a match for 'a'
    case 1  => println("One") //a case that will output "One"
    case "Two" => println("Two")// a case that will output "Two"
    case "Hello" => println("Hello") //a case that will output "Hello"
    case _ => println("No") //"a case that will out put "No"
    //because we are looking for a specific match for "Hello" then case "Hello" will have the only output

  }
}

//6. list
val numbersList: List[Int] = List(1, 2, 3 ,4) //immutable list has been created with 4 Ints
val emptyList: List[Int] = List() // immutable empty list has been created with Ints yet to be valued with in the list

val numbersList: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil // connecting the elements with in the list and giving the last element a null value


object Student { //the object student has been called
  def main(args:Array[String]) { //defining the methods to be implemented with in Student
    val names= "Harry" :: ("Adam" :: ("Jill" :: Nil)) // the object student has connected 4 elements in order
    val age = Nil //the age will not have a real value
    println( "Head of names array : " + names.head ) //looks for the last elements in the list which is harry
    println( "Tail of names array : " + names.tail )//looks for all elements after the first element which is adam and jill
    println( "Check if names is empty : " + names.isEmpty )//looks to see if the array in 'names' is emppty which false because it has 3 names
    println( "Check if age is empty : " + age.isEmpty )//aims to see if the age value is empty which is true because its null
  }
}

//7.set
val emptySet: Set[Int] = Set() //immutable value for emptySet which will be Int datatype

val numbersSet: Set[Int] = Set(1, 2, 3, 4) //immutable value of numberSet which conts Int 1,2,3,4

object Student { //object Student has been called
  def main(args: Array[String]) { //a new method has been created for Student
    val name = Set("Smith", "Brown", "Allen")//the immutable value for name whic contains a set with 3 names in it
    val id: Set[Int] = Set()//immutable value for id which will contain Int datatype

    println( "Head of name : " + name.head ) //this will output the first name, 'Smith"
    println( "Tail of name : " + name.tail )//this will output names after Smith which is Brown,and Allen
    println( "Check if name is empty : " + name.isEmpty )// checks to see if are no names in the set which is false
    println( "Check if id is empty : " + id.isEmpty )//checks to see if id set is empty which is true
  }
}

//8. Merge two Set
import scala.collection.immutable._ //importing collections function that is immutable
object MainObject{ //object mainObject has been created
  def main(args:Array[String]){ //defining main methods for mainObject
    val games = Set("Cricket","Football","Hocky","Golf")//immutable value for 'games' creates a set with for specific sports names
    val alphabet = Set("A","B","C","D","E") //creating a set for various letters
    val mergeSet = games ++ alphabet            // Merging two sets
    println("Elements in games set: "+games.size)   // Return size of collection
    //the outputs will be the number of games inside of the set(collection) which 4
    println("Elements in alphabet set: "+alphabet.size)
    //this will output the number of alphabets in the set which is 5
    println("Elements in mergeSet: "+mergeSet.size)// this will output number of elements in total from 'alphabet' and 'games' which is 9
    println(mergeSet) //this will out all the elements inside of the mergeSet
  }
}


//9. Concatenating lists
object Country { //creating the object 'Country'
  def main(args:Array[String]) { //defing the main methods for the object 'Country'
    val country_1 =  List("States","Britain","New Zealand")
    //creating an immutable value for 'country_1" which is a list of 4 string elements
    val country_2 = List("Austria","Belgium","Canada")
    //creating an immutable value for 'country_1" which is a list of 3 string elements
    val country = country_1 ::: country_2 // combines both list together with country_1 elements before country_2 elements
    println( "country_1 ::: country_2 : " + country ) //"outputs all elements with country_1 before country _2"

    val cont = country_1.:::(country_2) //creating immutable value for 'cont' which connects country_1 and country_2
    println( "country_1.:::(country_2) : " + cont )
    val con = List.concat(country_1, country_2) //immutable value for con connects both list into one
    println( "List.concat(country_1, country_2) : " + con  ) //uses concact to bring both list together with elements in
    // the order of the list in paramaters which country_1 elements before country_2.

  }
}


//10. Story Telling : Scala’s pattern matching
//https://towardsdatascience.com/how-to-use-scalas-pattern-matching-362a01aa32ca
  //Someone can take a lead and do a code walk through on Pattern Matching
object animalKingdom { //create an object 'animalKingdom
  def main(args: Array[String])= { //defining the main method
    val safari: Map[String, Int] = Map( //creating immutable value for safari that will be matched with String and Int
      "lion" -> 100, //the lion a string will be matched by the Int of 100
      "elephant" -> 500, //the elephant  string will be matched by the Int of 500
      "zebra" -> 1000, //the zebra string will be matched by the Int of 1000
      "cheetah" -> 60, //the cheetah string will be matched by the Int of 60
    )


    def findAnimalAndRun(animalName: String): Option[Int] = {
      //defining a function for 'findAnimalAndRun" that will include "animalName" string and Option to see if there is an Int match to the string
      safari.get(animalName)
      //calls upon the elements in safari and uses ".get" to search for String elements and matching Int
    }

    println(findAnimalAndRun("lion")) //
    //this output uses the findAnimalAndRun function to search within 'animalName' strings to see if can find a match for lion
    //it will find a match for lion, which will output 100 because it is an Option[Int]
    println(findAnimalAndRun("turtle")) // Unfortunately, there are no turtles in this safari so there will be no match
  }
}
