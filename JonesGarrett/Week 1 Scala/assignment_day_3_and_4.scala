
class ExceptionExample{

  def divide(a: Int, b: Int): Double = {
    try{
      if (b == 0) throw new ArithmeticException("Division by zero") // if b is 0, throw an exception
      else a / b  // if b is not 0, return the result

      var arr = Array(1,2,3)
      arr(4) // Create an ArrayIndex out of bounds exception
    } catch {
      // if exception print an error message
      case e: ArrayIndexOutOfBoundsException => println("ArrayIndexOutOfBoundsException")
      return 0.0 // by default return 0.0

      case e: ArithmeticException => println("Arithmetic Exception")
      return 0.0 // by default return 0.0

      case e: Exception => println("Exception occurred in division function: " + e)
      return 0.0 // by default return 0.0

      case e: Throwable => println("Throwable occurred in division function: " + e) 
      return 0.0 // by default return 0.0

    } finally { // Question 5
      println("Divide function completed")  // prints regardless of exception
    }
  }
}

class Student(val name: String, val age: Int) {
  var classmates: Set[String] = Set()

  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

  // define the students classmates
  def setClassmates(cls: Set[String]) = {
    println("Student classmates is set to " + cls)
    classmates = cls
  }
}

object RevatureStudent extends Student{
  val company = "Revature"

  def apply() = new Student("John Doe") // default constructor for RevatureStudent
  def apply(name: String, age: Int) = new Student(name, age) // constructor for RevatureStudent
}

object Main{

  def httpGet(url: String): String = {
    try{
      val response = scala.io.Source.fromURL(url)
      response.mkString
    } catch {
      case e: Exception => println("Exception occurred in httpGet function: " + e)
      return ""
    } finally {
      println("httpGet function completed")
    }
  }

  def search(a: Any): Any = a match{
    case 1 => "One"
    case 2 => "Two"
    case "Hello" => "World"
    case "TestAPI" => httpGet("http://jsonplaceholder.typicode.com/todos/1") // sends fake api request
    case "GetTODO" => httpGet("http://jsonplaceholder.typicode.com/todos/2")
    case _ => "Unknown"
  }

  def main(args: Array[String]): Unit = {
    //Question 1
    val name = Map("abc" -> "author", "pqr" -> "coder")

    val x = name.get("abc")
    val y = name.get("xyz")

    println(x) //prints Some("author") if key exists
    println(y) // prints None because xyz is not present in the map
    //-----
    //
    
    //Question 2
    var e = new ExceptionExample() // instantiating the class
    val result: Double = e.divide(10,2)
    println(result)

    //Question 3
    // Generate an exception by trying to divide by 0
    val result2: Double = e.divide(5,0)
    println(result)

    //Question 4
    val result3: Double = e.divide(100,10)

    //Question 5
    println(search(1)) //Returns "One"
    println(search(2)) //Returns "Two"
    println(search("Hello")) //Returns "World"
    println(search("TestAPI")) //Returns the JSON response from the API
    println(search("GetTODO")) //Returns the JSON response from the API

    //Question 6 lists
    val numbersList: List[Int] = List(1,2,3,4,5,6,7,8,9,10)
    val emptyList: List[Int] = List()
    // :: is the cons operator
    // ::: is the concat operator
    val concatList: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil //Nil is the empty list used for stopping
    (numbersList :: emptyList :: concatList :: Nil).foreach(println) // Prints out all the lists

    //Question 7 set
    val emptySet: Set[Int] = Set()

    val numbersSet: Set[Int] = Set(1,2,3,4)
    val test: Set[Int] = Set()

    var Garrett = RevatureStudent("Garrett", 25)
    Garrett.setClassmates(Set("Bill", "Tom", "John")) // Class function takes a set as an argument
    println(Garrett.name)
    Garrett.classmates.foreach(println) // Prints out the set of classmates


    //Question 10
    // TODO Study case class more
    case class Fruit(val name: String, val color: String)

    val apple = Fruit("apple", "red")
    val banana = Fruit("banana", "yellow")
    val orange = Fruit("orange", "orange")
    val greenApple = Fruit("apple", "green")
    val badBanana = Fruit("banana", "brown")

    val fruits: List[Fruit] = List(apple, greenApple, orange, banana, badBanana) // List of fruits

    // Loop through the list of fruits and treat them differently based on color and type.
    fruits.foreach(fruit => println(fruit match {
      case Fruit("apple", color) => if (color == "red") "red apple is $1.00" else if ( color == "green" ) "green apple is $0.50" else "apple is not for sale."
      case Fruit("orange", color) => if (fruit.color == "orange") "orange is $0.75" else "It's not an orange"
      case Fruit("banana", color) => if (fruit.color == "yellow") "yellow banana is $1.25" else "The banana has gone bad."
      case _ => "Fruit not available."
    }))




  }

}

