package scala_class

import java.io.IOException
import scala.util.matching.Regex


// This refers to the scala_class.txt worksheet file handed posted to our Discord channel.

object FirstScala {

  def lb(): Unit = {
    println()
  }

  def main(args: Array[String]): Unit = {

    // 1 Classes and Objects
    class Ctr {
      private var value = 6
      def incr() = {
        value += 1
      }
      def curr() = value
    }
    val ctr1 = new Ctr // or new Ctrl()
    ctr1.incr()
    println(ctr1.curr)
    lb()

    // 2 Structure of Classes
    class Employee(empId: Int, name: String, salary: Double) {
      def this(empId: Int, name: String) {
        this(0,"",0.0) // here it invokes primary constructor
        println("Two-argument auxiliary constructor")
      }
      def this(empId:Int) {
        this(0,"",0.0) // here it invokes primary constructor
        println("One-argument auxiliary constructor")
      }
      def this() {
        this(0) // here it invokes one-argument auxiliary constructor
        println("Zero argument auxiliary constructor")
      }
      println("Primary Constructor")
    }
    val emp = new Employee()
    lb()


    // 3 Higher order functions
    // Higher order functions take other functions as parameters or return a function as a reuslt
    // This is possible because functions are first-class values in Scala
    val salaries = Seq(20000, 70000, 40000)
    val doubleSalary = (x:Int) => x * 2
    //val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
    val newSalaries = salaries.map(x => x * 2)
    println(newSalaries)
    lb()


    // 4 Functional Programming
    // three args are passed in
    def sum(f:Int => Int, a: Int, b: Int): Int = if(a > b) 0 else f(a) + sum(f, a + 1, b)
    def sumInts(a: Int, b: Int): Int = sum(id, a, b)
    def sumSquares(a: Int, b: Int): Int = sum(square, a, b)
    def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b)
    def id(x: Int): Int = x
    def square(x: Int): Int = x * x
    def powerOfTwo(x: Int): Int = if(x == 0) 1 else 2 * powerOfTwo(x - 1)
    println("sum ints 1 to 4 = " + sumInts(1,4))
    lb()


    // 5 Inheritance
    // Multilevel Inheritance Example - 1
    class A {
      println("A")
    }
    class B extends A {
      println("B")
    }
    class C extends A {
      println("C")
    }
    new B() // A B
    new C() // A C
    lb()


    // 6 - Singleton

    object Reservations {
      var lastNum = 0
      val num2 = 2
      def newReservationNum() = { lastNum += 1; lastNum }
      println(newReservationNum())
    }
    lb()


    // 7 Exception Handling
    // Scala program of try-catch Exception
    object GFG {
      def main(args:Array[String]): Unit = {

        try {
          var N = 5/0
        }
        catch {
          case i: IOException => {
            println("IOException occured.")
          }
          case a: ArithmeticException => {
            println("Arithmetic Exception Occured")
          }
        }
      }
    }
    var a:Array[String] = new Array[String](3)
    var b = new Array[String](3)
    GFG.main(b)


    // 8 Error handling with Try
    def failingFn(i: Int):Int = {
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
      if(xs.isEmpty) onEmpty
      else xs.sum / xs.length
    failingFn2(12)
    lb()


    // 9 Scala Features
    /*
    It has a sophisticated type inference system.

    Its syntax is concise but still readable — we call it expressive.

    It’s a pure object-oriented programming (OOP) language.

    Every variable is an object, and every “operator” is a method.

    It’s also a functional programming (FP) language, so functions are also variables, and you can pass
    them into other functions. You can write your code using OOP, FP, or combine them in a hybrid style.
    Scala source code compiles to “.class” files that run on the JVM.

    Scala also works extremely well with the thousands of Java libraries that have been developed over the years.

    A great thing about Scala is that you can be productive with it on Day 1, but it’s also a deep language, so as you
    go along you’ll keep learning, and finding newer, better ways to write code. Some people say that Scala will change
    the way you think about programming (and that’s a good thing).

    A great Scala benefit is that it lets you write concise, readable code. The time a programmer spends reading code
    compared to the time spent writing code is said to be at least a 10:1 ratio, so writing code that’s concise and
    readable is a big deal. Because Scala has these attributes, programmers say that it’s expressive.
    */

    // 10 Currying in Scala
    // Scala program add two numbers using currying
    object Curry {
      // transforming the function that takes two(multiple) arguments into a function that takes one(single) argument.
      def add2(a: Int) = (b: Int) => a + b
      def main(args: Array[String]): Unit = {
        println(add2(20)(19))
      }
    }
    Curry.main(b)
    lb()


    // 11 Pattern Matching & Regular Expressions
    def matchTest(x: Int): String = x match {
      case 1 => "one"
      case 2 => "two"
      case _ => "other"
    }
    println(matchTest(3)) // prints other
    println(matchTest(1))

    val numberPattern: Regex = "[0-9]".r
    numberPattern.findFirstMatchIn("awesomepassword") match {
      case Some(_) => println("Password OK")
      case None => println("Password must contain a number")
    }

    val keyValPattern: Regex = "([0-9a-zA-Z- ]+): ([0-9a-zA-Z-#()/. ]+)".r
    val input:String =
    """background-color: #A03300;
       |background-image: url(img/header100.png);
       |background-position: top center;
       |background-repeat: repeat-x;
       |background-size: 2160px 108px;
       |margin: 0;
       |height: 108px;
       |width: 100%;""".stripMargin
    for(patternMatch <- keyValPattern.findAllMatchIn(input))
      println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")
    lb()


  }
}