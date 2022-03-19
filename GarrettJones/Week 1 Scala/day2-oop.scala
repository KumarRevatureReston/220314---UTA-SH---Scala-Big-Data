import scala.collection.mutable._


//5, defines a class called A with not attributes.  The only function is a print function.
class A{
  println("A created.") // called once upon creation
}

class B extends A{
  println("B created.") // called once upon creation)
}

class C extends B{
  println("C created.")
}

class Ctr{
  // Ctr class is a blueprint for objects
  private var value = 6
  def incr() {value += 1}
  def curr() = value
}

class Duck {
  // Duck class with attribute variable size
  var size = 1

}

class Employee(empId: Int, name: String, salary: Double) {
  // Declare employee constructor w/ overloaded constructors
  def this(empId: Int, name: String) {
    this(0, "", 0.0)
    println("Two-argument auxiliary constructor")
  }

  def this(empId: Int) {
    this(0, "", 0.0)
    println("One-argument auxiliary constructor")
  }
  
  def this(){
    this(0)
    println("Zero-argument auxiliary constructor")
  }
  println("Employee constructor")

}



object scala_class_day2{

  def main(args: Array[String]): Unit = {
    println("Hello world")


    //1 
    val ctr1 = new Ctr  // instantiate a new object of type Ctr
    ctr1.incr(); println(ctr1.curr()) // Increment and print the class attribute value
    ctr1.incr(); println(ctr1.curr())


    //2
    var f = new Duck
    f.size = 10 // f.size is a attribute variable of Duck
    println(f.size)

    val emp2 = new Employee() // zero-argument auxiliary constructor
    val john = new Employee(1, "John", 1000.0) // instantiate a new object of type Employee with first constructor

    //3
    val salaries = Seq(20000, 70000, 40000)
    val doubleSalary = (x: Int) => x * 2  // Create a function that doubles the salary
    val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000) Pass the function to map.
    println(newSalaries)

    //4
    //f is a function which takes and returns an Int
    def sum(f: Int => Int, a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sum(f, a + 1, b)
    }

    def sumInts(a: Int, b: Int): Int = sum(x => x, a, b)
    def sumSquares(a: Int, b: Int): Int = sum(x => x * x, a, b)
    def sumPowersOfTwo(a: Int, b: Int): Int = sum(x => Math.pow(2, x).toInt, a , b)

    println(sumInts(1, 3))

    //5
    //class A at top
    val a = new A
    val b = new B // calls both A and B class.
    val c = new C // calls A, B and C class.

    //8 error handling
    def fail(message: String): String = {
        try{
          throw new RuntimeException(message) // Trys to thorw an exception, passes in our custom message for describing the error.  Which occurs causing code to enter the catch block.
      }  catch {
        // code enters here if exception is thrown.  The functin is expecting a String.  So the Exception function will print out what is on the right side of hte arrow function.
        //case e : Exception => 43
        case e : Exception => "Error: " + e.getMessage + " .  This line is printed to the console. "
      }
    }

    // error function call
    println(fail("Error: My error message"))

    // parses Seq of numbers returns the sum of the seq divided by seq length, if seq empty then print then return onEmpty.
    def mean_1(xs: IndexedSeq[Double], onEmpty: Double): Double = if (xs.isEmpty) onEmpty else xs.sum / xs.length
    val seq = IndexedSeq(1.0, 2.0, 3.0)
    //println(mean_1(IndexedSeq(1, 2, 3, 4), 0))
    println(mean_1(seq, 1))  // prints 2.0   (1 + 2 + 3) / 3

  }
}

