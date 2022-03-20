
//1)classes & Objects

class Ctr { //using a class for blueprint of objects under "Ctr"
  private var value = 6 //assigning a private variable for class "Ctr"
  def incr() {value +=1} //defining a new function named incr which has a value of
  def curr() = value//defining a a function for curr which has the value of an integer
}

val ctr1 = new Ctr //applying the constructors from class 'Ctr' so that 'ctr1' is an object of the Ctr class.
new Ctr() //using constructors to apply to new methods.
ctr1.incr() //using the function of incr to apply to ctr1 which will has create the value of 1
print(ctr1.curr) //this will designate the value of ctr1 and inserts its value on the function of curr.
//----------------------------------
class Duck { //using the blueprint of objects under Duck
  var size = 1 // the class of Duck has been given 1 element through the use of "size" which is mutable
}

var f = new Duck //mutable variable f has the value of a new object under the Duck class
f.size =10// Now the the number of elements within the object "f" contains 10 elements
println(f.size) //this will activate the all the elements in 'f'


//-----------------------------------

//2)Structure of classes

//The auxiliary constructor in Scala is used for constructor overloading and defined as a method using this  name.

class Employee(empId: Int,name: String,salary :Double){ // creating a class for employees that contains three elements with two ints and
  // and one string.
  def this(empId:Int,name:String) //this is the primary constructor which elements we can use for auxiliary constructors.
  {
    this(0,"",) // here it invokes primary constructor.
    //this invokes a primary because it uses all the data types from the primary constructors
    println("Two-argument auxiliary constructor")
  }
  def this(empId:Int) //this uses the value of of one the data
  {
    this(0) // here it invokes primary constructor.
    //this provides one of the data types from the primary constructor that allows us to create the one arguement auxillary constructor
    println("One-argument auxiliary constructor")
  }
  def this() //there is no real value from the primary constructor
  {
    this(0) // here it does not produce a constructor because the primary constructor above does not provide a match.
    println("Zero-argument auxiliary constructor")
  }
  println("Primary construtor") //this will return the value "primary constructor" which is (0,"",0)
}

val emp = new Employee()

//in Scala, we can also create a primary constructor with a default value. If you don’t provide value, then it will take the default value, which is provided in the primary constructor.  Otherwise, the value we provide is from an instance created with the help of a parameter name of the class. Here is an example:

  scala> class Employee(empId: Int = 0,name: String = "",salary :Double = 0.0){
  //the line above uses a scala class to dertermine the elements inside of the  Employee and assigns, ints, string and double.
  println(s"empId = $empId , empName = $name , salary = $salary")
  //creates an output that determines the value of each element inside of the constructor
}

scala> val emp = new Employee() //a new object out of the Employee class has been created with default values for Employees
empId = 0 , empName = , salary = 0.0 // assigning values to each of the elements in the new object of the class

scala> val emp1 = new Employee(name = "Smith") //creating a immutable value for "emp1' which contains attributes from class Employee
//assigning the value of the name string to be Smith
empId = 0 , empName = Smith , salary = 0.0 // this is giving values for each of the elements inside of the empId object.


scala> val emp1 = new Employee(name = "Smith", empId = 9) //immutable object emp1 is assigning the value of each element within object.
empId = 9 , empName = Smith , salary = 0.0//  is giving values for each of the elements inside of the empId object.

//---------------------------------

//3)Higher order functions

//Higher order functions take other functions as parameters or return a function as a result
//This is possible because functions are first-class values in Scala.

val salaries = Seq(20000, 70000, 40000) // creating immutable value of salaries to create a sequence of 3 inferred ints.
val doubleSalary = (x: Int) => x * 2
//immutable value doubleSalary which creates a int value for x to be multiplied by 2
val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
//creating keys that match salaries to double salary so that the integers are being doubled using the value of x.
val salaries = Seq(20000, 70000, 40000) // creating immutable value of salaries to create a sequence of 3 inferred ints.
val newSalaries = salaries.map(x => x * 2) // newsalaries is using the methods of salaries due to the map connection so
//it can use value of x which is 'x *2" to double new salaries
//----------------------------------------------

//4)functional programming

// three args are passed in:
// 1) 'f' - a function that takes an Int and returns an Int
// 2) 'a' - an Int
// 3) 'b' - an Int
def sum(f: Int => Int, a: Int, b: Int): Int = if (a > b) 0 else f(a) + sum(f, a + 1, b)
//defining a function for sum, that gives the value of int returning int for 'f', 'a' is an int, and 'b' is an int.
//then uses a conditional statement that if the value of 'a' is less than then it will return 0
//if 'a' is not less than 'b' then f will take the value of a then will reintroduce the function of sum, but instead 'a' plus 1

// these three functions use the sum() function
def sumInts(a: Int, b: Int): Int = sum(id, a, b) //uses the function from above for 'id', 'a',  'b'
def sumSquares(a: Int, b: Int): Int = sum(square, a, b)// attempt to find the square of ints 'a', 'b'
def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b) //very similar to square where the values increase by poweroftwo

// three functions that are passed into the sum() function
def id(x: Int): Int = x  //defining the 'id' function which is a value passed in sum()
def square(x: Int): Int = x * x //defining the sqaure of x
def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)
//defining the function of poweroftwo which includes a conditonal statement that states that if 'x' is equal to 0 then it will be 1
//if not then it will output 2 times the result of x - 1

// this simply prints the number 10
println("sum ints 1 to 4 = " + sumInts(1,4))

//-------------------------------------------------
//5)Inheritance

//Multilevel Inheritance Example – 1

scala> class A{ //This is the orginal parent class where subclasses will recieve its traits
   println("A") //the output of the class above. When class "A" is called it will print "A"
   }
defined class A //Calls out the function of class 'A'
scala> class B extends A{  // this means that class 'B' will recieve the traits from class 'A'
   println("B") //similar outputs due to class 'B' being a subclass of 'A'
  }
defined class B // Calls out the function of the class 'B'
scala> class C extends B{ //Class C is taking the characteristics and traits of class B
  println("C") //outputs are similar because class C retrieved its traits from Class B
   }
defined class C //calling out the function of class c
scala> new C() //within class c there will be a new object which takes traits from class C
A
B
C

//'A', 'B', 'C' are all the parent classes whose traits will be inherited by the object of new C
res1: C = C@347f8029 // Creating a new value for the 'C' which can also use its parent class functions.


//-------------------------
//Example Hierarchical Inheritance
  scala> class A{ //creating the class 'A' which will be used as the parent Class.
  | println("A") //when class 'A' is called it will output 'A'
  | }
defined class A //calling out the functions of class 'A'
scala> class B extends A{ //Class 'B' is inheriting the functions of it parent Class 'A'
  | println("B") //The output is now similar to Class 'A'
  | }
defined class B //The functions of class B is called
scala> class C extends A{ ////Class 'C' is inheriting the functions of it parent Class 'A'
  | println("C") // //The output is now similar to Class 'A'
  | }
defined class C// The functions of Class 'C' have been defined.

scala> new B() //within class c there will be a new object which takes traits from class B
A
B

// new B is using traits from Class A and B
res2: B = B@64c1a76e // 'res2' value is not the function of 'B' which is used on the new variable.
scala> new C() //within class c there will be a new object which takes traits from class C
A
C
//// new B is using traits from Class A and C
res3: C = C@193f5509 //// 'res2' value is not the function of 'C' which is used on the new variable.
//--------------------------------------------
object Multiple{ // creating a new object called 'Multiple' to be given elements and methods
  def main(args: Array[String]):Unit={ //defining a new function for object 'Multiple'
    trait A{ //creating a new trait called 'A' for class Multiple
      var length:Int= _ //the length of elements in the new variable has yet be defined
      def action={ //calling the function of action
        length=length+5  //the variable will have the number of elements it contains to be increased by 5
      }
    }
    trait B{ ////creating a new trait called 'B' for class Multiple
      var height:Int = _ //the height of elements in the new variable has yet be defined
      def action={ //calling the function of action
        height = height + 1 //the variable will have the height of the Int increased by 1
      }
    }
    class C extends A with B{ //Class C is extending both of its Parent Classes to inherit their traits
      length=3; //the value of the lenght is now 3
      height+=6;// the value of the height of the variable is now 6
      override def action={
        super[A].action
        super[B].action

        //calling out traits 'A' and 'B' to use their action functions for Class C's lenght and height
      }
    }
    var c=new C // object c is using the traits and functions of Class C
    c.action //now object c has the same functions to use on its own variables.
    println(c.height) //outputs the results of heights which should be '4' because of the action input inherited from super classes
    println(c.length) ////outputs the results of length which should be '11' because of the action input inherited from super classes
  }
}


//---------------------------------------------------
//6)Singleton

object Reservations { //creating a new object reservations
  var lastNum = 0; //mutable value for 'lastNum' which will equal 0
  val num2 = 2; //immutable value for 'num2' which will equal 2
  def newReservationNum() = { lastNum +=1; lastNum }
  // defining newReservationNum to contain the function that outputs lastNum as '1' and the original lastNum value.
  //This is a singleton value because it creates a new object to have the function to carry out expressions using variables and
  // and traits from the former object.
}
//---------------------------------------------------

//7)Exception handling
// Scala program of try-catch Exception
import java.io.IOException

// Creating object
object GFG
{
  // Main method
  def main(args:Array[String])
  {
    try //this is creating the parameters that will have the statement that can  lead to an error
    {
      var N = 5/0 // mutable value of 'N' will have value of 5 divided by 0 which can't mathematically happen.

    }
    catch //Now when the value of 'N' is 5/0 then it will proceed to throw exceptions to let user know what the problem is
    {
      // Catch block contain cases.
      case i: IOException =>
      {
        println("IOException occurred.")
        //created the first case to give an output that would stop the function of the program and let them know what kind of issue
        // if going on
      }
      case a : ArithmeticException =>
      {
        println("Arithmetic Exception occurred.")
        //case a was created to be more specific on the issue that is occuring when the value does not make mathematical sense
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

def failingFn(i: Int): Int = { //defines new method for failingFn variable 'i' which is an Int
  val y: Int = throw new Exception("fail!") //immutable value of y will throw an exception
  try { //this enact the progam to look for specific statements or expressions for exceptions
    val x = 42 + 5 //immutable value of x which is 42 + 5
    x + y //adding x plus y
  }
  catch { case e: Exception => 43 }

  //trying a statement will lead to the catch case that throws an excepetion is the answer to the statements are less than 43
}

def failingFn2(i: Int): Int = {
  try {
    val x = 42 + 5
    x + ((throw new Exception("fail!")): Int)
  }
  catch { case e: Exception => 43 }
}

def mean_1(xs: IndexedSeq[Double], onEmpty: Double): Double =
  //defining a methos for mean_1 that finds 'Double' for elements in IndexedSeq as well as empty double.
  if (xs.isEmpty) onEmpty //if 'xs' sequence is empty then it will be onEmpty
  else xs.sum / xs.length //if its not empty then add the sum of the sequence elements and divide it by the lenght of elemts


//9)Features

//It has a sophisticated type inference system.
 // Its syntax is concise but still readable — we call it expressive.
//It’s a pure object-oriented programming (OOP) language. Every variable is an object, and every “operator” is a method.
  //It’s also a functional programming (FP) language, so functions are also variables, and you can pass them into other functions. You can write your code using OOP, FP, or combine them in a hybrid style.
 // Scala source code compiles to “.class” files that run on the JVM.
//Scala also works extremely well with the thousands of Java libraries that have been developed over the years.
//A great thing about Scala is that you can be productive with it on Day 1, but it’s also a deep language, so as you go along you’ll keep learning, and finding newer, better ways to write code. Some people say that Scala will change the way you think about programming (and that’s a good thing).
//A great Scala benefit is that it lets you write concise, readable code. The time a programmer spends reading code compared to the time spent writing code is said to be at least a 10:1 ratio, so writing code that’s concise and readable is a big deal. Because Scala has these attributes, programmers say that it’s expressive.
-------------------------------------------------------------------------------------------------
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

----------------------------------------
11)Pattern Matching & Regular Expressions

def matchTest(x: Int): String = x match {
  case 1 => "one"
  case 2 => "two"
  case _ => "other"
}
matchTest(3)  // prints other
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
