// I went through the code and fixed it so that it would compile and run in one file
//1)classes & Objects

class Ctr {
  private var value = 6
  def incr() {value +=1}
  def curr() = value
}
object ctrlObject extends App {
  val ctr1 = new Ctr // or
  new Ctr()
  ctr1.incr()
  print(ctr1.curr)
}
//----------------------------------
class Duck {
  var size = 1
}

object DuckObject extends App {
  var f = new Duck()
  f.size = 10
  println(f.size)
}
//-----------------------------------

//2)Structure of classes

//The auxiliary constructor in Scala is used for constructor overloading and defined as a method usingthis  name.

class Employee1(empId: Int,name: String,salary :Double){
  def this(empId:Int,name:String)
  {
    this(0,"",0.0) // here it invokes primary constructor.
    println("Two-argument auxiliary constructor")
  }
  def this(empId:Int)
  {
    this(0,"",0.0) // here it invokes primary constructor.
    println("One-argument auxiliary constructor")
  }
  def this()
  {
    this(0) // here it invokes one-argument auxiliary constructor.
    println("Zero-argument auxiliary constructor")
  }
  println("Primary construtor")
}

object EmployeeObject {
  val emp3 = new Employee()
}
//In Scala, we can also create a primary constructor with a default value. If you don’t provide value, then it will take the default value, which is provided in the primary constructor.  Otherwise, the value we provide is from an instance created with the help of a parameter name of the class. Here is an example:

class Employee(empId: Int = 0,name: String = "",salary :Double = 0.0){
  println(s"empId = $empId , empName = $name , salary = $salary")
}

object EmployeeObject2 {
  val emp = new Employee()
  //empId = 0 , empName = , salary = 0.0

  val emp1 = new Employee(name = "Smith")
  //empId = 0 , empName = Smith , salary = 0.0


  val emp2 = new Employee(name = "Smith", empId = 9)
  //empId = 9 , empName = Smith , salary = 0.0
}

//---------------------------------

//3)Higher order functions

//Higher order functions take other functions as parameters or return a function as a result
//This is possible because functions are first-class values in Scala.
object salariesObject {
  val salaries = Seq(20000, 70000, 40000)
  val doubleSalary = (x: Int) => x * 2
  val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)

  val salaries1 = Seq(20000, 70000, 40000)
  val newSalaries1 = salaries1.map(x => x * 2)
}
//----------------------------------------------

//4)functional programming

// three args are passed in:
// 1) 'f' - a function that takes an Int and returns an Int
// 2) 'a' - an Int
// 3) 'b' - an Int
object sumObject {
  def sum(f: Int => Int, a: Int, b: Int): Int = if (a > b) 0 else f(a) + sum(f, a + 1, b)

  // these three functions use the sum() function
  def sumInts(a: Int, b: Int): Int = sum(id, a, b)

  def sumSquares(a: Int, b: Int): Int = sum(square, a, b)

  def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b)

  // three functions that are passed into the sum() function
  def id(x: Int): Int = x

  def square(x: Int): Int = x * x

  def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)

  // this simply prints the number 10
  println("sum ints 1 to 4 = " + sumInts(1, 4))
}
//-------------------------------------------------
//5)Inheritance

//Multilevel Inheritance Example – 1

class A{
  println("A")
  }
//defined class A
class B extends A {
  println("B")
}
//defined class B
class C extends B{
  println("C")
  }
//defined class C
object cObject {
  new C()
}
//A
//B
//C
//res1: C = C@347f8029


//-------------------------
//Example- Hierarchical Inheritance
class A1{
  println("A")
  }
//defined class A
class B1 extends A{
  println("B")
  }
//defined class B
class C1 extends A{
  println("C")
  }
//defined class C
object B1Object {
  new B1()
}
//A
//B
//res2: B = B@64c1a76e
object C1Object {
  new C1()
}
//A
//C
//res3: C = C@193f5509
//--------------------------------------------
object Multiple{
  def main(args: Array[String]):Unit={
    trait A{
      var length:Int= _
      def action={
        length=length+5
      }
    }
    trait B{
      var height:Int = _
      def action={
        height = height + 1
      }
    }
    class C extends A with B{
      length=3;
      height+=6;
      override def action={
        super[A].action
        super[B].action
      }
    }
    var c=new C
    c.action
    println(c.height)
    println(c.length)
  }
}


//---------------------------------------------------
//6)Singleton

object Reservations {
  var lastNum = 0;
  val num2 = 2;
  def newReservationNum() = { lastNum +=1; lastNum }
}
//---------------------------------------------------

//7)Exception handling
// Scala program of try-catch Exception
import java.io.IOException

// Creating object
object GFG1
{
  // Main method
  def main(args:Array[String])
  {
    try
    {
      var N = 5/0

    }
    catch
    {
      // Catch block contain cases.
      case i: IOException =>
      {
        println("IOException occurred.")
      }
      case a : ArithmeticException =>
      {
        println("Arithmetic Exception occurred.")
      }

    }

  }
}

// Scala program of finally Exception

// Creating object
object GFG
{
  // Main method
  def main(args: Array[String])
  {
    try
    {
      var N = 5/0
    }
    catch
    {
      // Catch block contain case.
      case ex: ArithmeticException =>
      {
        println("Arithmetic Exception occurred.")
      }
    }
    finally
    {
      // Finally block will execute
      println("This is final block.")
    }
  }
}




//8)Error handling with Try
object failingfnObject {
  def failingFn(i: Int): Int = {
    val y: Int = throw new Exception("fail!")
    try {
      val x = 42 + 5
      x + y
    }
    catch {
      case e: Exception => 43
    }
  }

  def failingFn2(i: Int): Int = {
    try {
      val x = 42 + 5
      x + ((throw new Exception("fail!")): Int)
    }
    catch {
      case e: Exception => 43
    }
  }

  def mean_1(xs: IndexedSeq[Double], onEmpty: Double): Double =
    if (xs.isEmpty) onEmpty
    else xs.sum / xs.length

}
//9)Features

//It has a sophisticated type inference system.
//  Its syntax is concise but still readable — we call it expressive.
//It’s a pure object-oriented programming (OOP) language. Every variable is an object, and every “operator” is a method.
//  It’s also a functional programming (FP) language, so functions are also variables, and you can pass them into other functions. You can write your code using OOP, FP, or combine them in a hybrid style.
//  Scala source code compiles to “.class” files that run on the JVM.
//Scala also works extremely well with the thousands of Java libraries that have been developed over the years.
//A great thing about Scala is that you can be productive with it on Day 1, but it’s also a deep language, so as you go along you’ll keep learning, and finding newer, better ways to write code. Some people say that Scala will change the way you think about programming (and that’s a good thing).
//A great Scala benefit is that it lets you write concise, readable code. The time a programmer spends reading code compared to the time spent writing code is said to be at least a 10:1 ratio, so writing code that’s concise and readable is a big deal. Because Scala has these attributes, programmers say that it’s expressive.
//-------------------------------------------------------------------------------------------------
//10)Curring in scala
//Currying in Scala is simply a technique or a process of transforming a function. This function takes multiple arguments into a function that takes single argument. It is applied widely in multiple functional languages.
// Scala program add two numbers
// using Currying function

object Curry
{
  // transforming the function that
  // takes two(multiple) arguments into
  // a function that takes one(single) argument.
  def add2(a: Int) = (b: Int) => a + b;

  // Main method
  def main(args: Array[String])
  {
    println(add2(20)(19));
  }
}

//----------------------------------------
//11)Pattern Matching & Regular Expressions
object matchTestObject {
  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }

  matchTest(3) // prints other
  matchTest(1)


  import scala.util.matching.Regex

  val numberPattern: Regex = "[0-9]".r

  numberPattern.findFirstMatchIn("awesomepassword") match {
    case Some(_) => println("Password OK")
    case None => println("Password must contain a number")
  }


  import scala.util.matching.Regex

  val keyValPattern: Regex = "([0-9a-zA-Z- ]+): ([0-9a-zA-Z-#()/. ]+)".r

  val input: String =
    """background-color: #A03300;
      |background-image: url(img/header100.png);
      |background-position: top center;
      |background-repeat: repeat-x;
      |background-size: 2160px 108px;
      |margin: 0;
      |height: 108px;
      |width: 100%;""".stripMargin

  for (patternMatch <- keyValPattern.findAllMatchIn(input))
    println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")
}