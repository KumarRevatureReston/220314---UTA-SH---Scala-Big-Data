package assignment_3and4

import scala.collection.immutable._

// This refers to the Assignment_day_3_and_4.txt worksheet file handed posted
// to our Discord channel.

// 1. Try/Catch
object Assignment3and4 {
  def main(args: Array[String]): Unit = {
    // 1 Try/Catch
    val name = Map("abc" -> "author", "pqr" -> "coder")
    val x = name.get("abc")
    val y = name.get("xyz")

    println(x)
    println(y)
  }
}

// 2. Without Exception Handling
class ExceptionExample {
  def divide(a:Int, b:Int): Unit = {
    a/b
    println("Rest of the code is executing...")
  }
}
object MainObject {
  def main(args: Array[String]): Unit = {
    var e = new ExceptionExample()
    e.divide(100,0)
  }
}

// 3. class Exception Example
class ClassExceptionExample {
  def divide(a:Int, b:Int) = {
    try {
      a/b
    } catch {
      case e: ArithmeticException => println(e)
    }
    println("Rest of the code is executing")
  }
}
object MainObjectClass {
  def main(args:Array[String]): Unit = {
    var e = new ClassExceptionExample()
    e.divide(100,0)
  }
}


// 4. Finally
class FinallyExample {
  def divide(a:Int, b:Int): Unit = {
    try {
      a/b
      var arr = Array(1,2)
      arr(10)
    } catch {
      case e: ArithmeticException => println(e)
      case ex: Exception => println(ex)
      case th: Throwable => println("found a unknown exception" + th)
    } finally {
      println("Finally block always executes")
    }
    println("Rest of the code is executing...")
  }
}

object MainObjectFinally {
  def main(args:Array[String]): Unit = {
    var e = new FinallyExample()
    e.divide(100,10)
  }
}


// 5. Pattern Matching
object MainObjectPatternMatching {
  def main(args: Array[String]): Unit = {
    var result = search("Hello")
    println(result)
  }
  def search(a:Any):Any = a match {
    case 1 => println("One")
    case "Two" => println("Two")
    case "Hello" => println("Hello")
    case _ => println("No")
  }
}


// 6. List
object SixthObj {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1,2,3,4)
    val emptyList: List[Int] = List()
    val numbersList: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil
  }
}

object StudentSix {
  def main(args: Array[String]): Unit = {
    val names = "Harry" :: ("Adam" :: ("Jill" :: Nil))
    var age = Nil
    println("Head of names array : " + names.head)
    println("Tail of names array : " + names.tail)
    println("Check if names is empty : " + names.isEmpty)
    println("Check if age is empty : " + age.isEmpty)
  }
}

// 7. Set
object SeventhObj {
  def main(args: Array[String]): Unit = {
    val emptySet: Set[Int] = Set()
    val numbersSet: Set[Int] = Set(1,2,3,4)
  }
}

object StudentSeven {
  def main(args: Array[String]): Unit = {
    val name = Set("Smith", "Brown", "Allen")
    val id: Set[Int] = Set()

    println("Head of name : " + name.head)
    println("Tail of name : " + name.tail)
    println("Check if name is empty : " + name.isEmpty)
    println("Check if id is empty : " + id.isEmpty)
  }
}

// 8. Merge two sets
object Eigthbject {
  def main(args:Array[String]): Unit = {
    val games = Set("Cricket", "Football", "Hocky", "Golf")
    val alphabet = Set("A", "B", "C", "D", "E")
    val mergeSet = games ++ alphabet // Merging two sets
    println("Elements in games set: " + games.size) // Return size of collection
    println("Elements in alphabet set: " + alphabet.size)
    println("Elements in a mergeSet: " + mergeSet.size)
    println(mergeSet)
  }
}

// 9. Concatenating lists
object Country {
  def main(args:Array[String]): Unit = {
    val country_1 = List("States", "Britain", "New Zealand")
    val country_2 = List("Austria", "Belgium", "Canada")

    val country = country_1 ::: country_2
    println("country_1 ::: country_2 : " + country)

    val cont = country_1.:::(country_2)
    println("country.:::(country_2) : " + cont)
    val con = List.concat(country_1, country_2)
    println("List.concat(country_1, country_2) : " + con)
  }
}

// Story Telling : Scala's Pattern Matching
// https://towardsdatascience.com/how-to-use-scalas-pattern-matching-362a01aa32ca
// Someone can take a lead and do a code walk through on Pattern Matching