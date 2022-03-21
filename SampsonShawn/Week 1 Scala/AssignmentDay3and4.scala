package notepad3

object AssignmentDay3and4 extends App {


  //1.Try/Catch
  {

    def tryCatch(args: Array[String]) = {
      val name = Map("abc" -> "author","pqr" -> "coder")

      val x = name.get("abc")
      val y = name.get("xyz")

      println(x)
      println(y)
    }
  }
}

//2. without Exception Handling
class ExceptionExample{
  def divide(a:Int, b:Int) = {
    a/b             // Exception occurred here
    println("Rest of the code is executing...")
  }
}
object MainObject extends App {
  def notMain(args:Array[String])={
    var e = new ExceptionExample()
    e.divide(100,0)
  }
}

//3.
class ExceptionExample2 {
  def divide(a:Int, b:Int) = {
    try{
      a/b
    }catch{
      case e: ArithmeticException => println(e)
    }
    println("Rest of the code is executing...")
  }
}
object MainObject2 extends App {
  def notMain(args:Array[String])={
    var e = new ExceptionExample()
    e.divide(100,0)
  }
}

//4. Finally
class ExceptionExample3{
  def divide(a:Int, b:Int) = {
    try{
      a/b
      var arr = Array(1,2)
      arr(10)
    }catch{
      case e: ArithmeticException => println(e)
      case ex: Exception =>println(ex)
      case th: Throwable=>println("found a unknown exception"+th)
    }
    finally{
      println("Finaly block always executes")
    }
    println("Rest of the code is executing...")
  }
}

object MainObject3 extends App {
  def notMain(args:Array[String])={
    var e = new ExceptionExample()
    e.divide(100,10)

  }
}

//5.Pattern Matching
object MainObject4 extends App {
  def notMain(args: Array[String]) ={
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
object ListObj extends App {
  val numbersList: List[Int] = List(1, 2, 3, 4)
  val emptyList: List[Int] = List()

  val numbersList2: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil
}

object Student extends App {
  def notMain(args:Array[String]) = {
    val names = "Harry" :: ("Adam" :: ("Jill" :: Nil))
    val age = Nil
    println( "Head of names array : " + names.head )
    println( "Tail of names array : " + names.tail )
    println( "Check if names is empty : " + names.isEmpty )
    println( "Check if age is empty : " + age.isEmpty )
  }
}

//7.set

object setObj extends App {
  val emptySet: Set[Int] = Set()

  val numbersSet: Set[Int] = Set(1, 2, 3, 4)
}

object Student2 extends App {
  def notMain(args: Array[String]) = {
    val name = Set("Smith", "Brown", "Allen")
    val id: Set[Int] = Set()

    println( "Head of name : " + name.head )
    println( "Tail of name : " + name.tail )
    println( "Check if name is empty : " + name.isEmpty )
    println( "Check if id is empty : " + id.isEmpty )
  }
}

//8. Merge two Set
import scala.collection.immutable._
object MainObject5 extends App {
  def notMain(args:Array[String])={
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
object Country extends App {
  def notMain(args:Array[String]) = {
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

/*
10. Story Telling : Scala’s pattern matching
https://towardsdatascience.com/how-to-use-scalas-pattern-matching-362a01aa32ca
Someone can take a lead and do a code walk through on Pattern Matching
*/



