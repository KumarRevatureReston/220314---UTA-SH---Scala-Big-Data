import java.io.IOException
import scala.util.matching.Regex

object Week_One_Class {
    def main(args: Array[String]): Unit = {
        
        //1) classes and Objects
        val ctr1 = new Ctr // or
        new Ctr() //creates a new object ctr1 from the Ctr class
        ctr1.incr() //calls the class function incr
        println(ctr1.curr) //prints the current value of which is 7 after starting at 6 and increasing by 1 from the incr function
        
        var f = new Duck
        f.size = 10 //sets new size to duck of 10
        println(f.size) //prints new size of duck 10
        
        
        //2) Structure of classes
        val emp = new Employee()
        
        //In Scala, we can also create a primary constructor with a default value. If you don’t provide value, then it will take the default value, which is provided in the primary constructor.  Otherwise, the value we provide is from an instance created with the help of a parameter name of the class. Here is an example:
        
        //class Employee(empId: Int = 0,name: String = "",salary :Double = 0.0){
        //println(s"empId = $empId , empName = $name , salary = $salary")
        
        /*val emp = new Employee()
        empId = 0 , empName = , salary = 0.0//uses the default constructor to make new object
        
        val emp1 = new Employee(name = "Smith")//uses the 1 argument constructor to create a new object
        empId = 0 , empName = Smith , salary = 0.0
        
        val emp1 = new Employee(name = "Smith", empId = 9)//uses the 2 argument constructor to create a new object
        empId = 9 , empName = Smith , salary = 0.0*/
        
        //3) Higher order functions
        /*val salaries = Seq(20000, 70000, 40000)
        val doubleSalary = (x: Int) => x * 2 //function to double each input
        val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000) takes a function as an input into another function
        
        //val salaries = Seq(20000, 70000, 40000)
        //val newSalaries = salaries.map(x => x * 2)*/
        
        //4)functional programming
        
        // three args are passed in:
        // 1) 'f' - a function that takes an Int and returns an Int
        // 2) 'a' - an Int
        // 3) 'b' - an Int
        
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
        
        //5) Inheritance
        //Multilevel Inheritance
        //new C()//prints A B and C all on separate lines. This means each class object is created but doesn't overwrite each other in this case. C inherits B which inherits A
        
        //Hierarchical Inheritance
        //new B() //prints AB on separate lines. B is created and inherits A
        //new C() //prints AC on separate lines. C is created and inherits A
        
        trait A { // trait for class A trait is similar to interfaces
            var length: Int = _
            
            def action = {
                length = length + 5
            }
        }
        trait B { //trait for class B
            var height: Int = _
            
            def action = {
                height = height + 1
            }
        }
        class C extends A with B { //class definition for C using inheritance to have B inherit A
            length = 3;
            height += 6;
            
            override def action = {
                super[A].action //increases length by 5
                super[B].action //increases height by 1
            }
        }
        var c = new C
        c.action
        println(c.height) //prints 7 because B starts at 1 then C increases it by 6
        println(c.length) //prints 8 because C starts it at 3 and then A increases it by 5
        
        //6 Singleton //singletons are objects in which there is only one instance
        var lastNum = 0;
        val num2 = 2;
        
        def newReservationNum() = {
            lastNum += 1;
            lastNum
        }
        
        println(newReservationNum()) //prints 1 because it starts at 0 and the function adds 1
        
        //7) Exception handling
        /*try {
            var N = 5 / 0 //devide by zero exception
            
        }
        catch {
            // Catch block contain cases.
            case i: IOException => { //catch block for IOException. not used in this example
                println("IOException occurred.")
            }
            case a: ArithmeticException => { //catch block for ArithmeticException which divide by zero falls under. This block catches the error
                println("Arithmetic Exception occurred.")
            }
        }
        finally // Runs after catch statement used to continue code after an error is caught
        {
            // Finally block will execute
            println("This is final block.")
        }*/
        
        //8)Error handling with Try
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
            } // tries to catch an exception because x is a val not var
        }
        
        def mean_1(xs: IndexedSeq[Double], onEmpty: Double): Double =
            if (xs.isEmpty) onEmpty
            else xs.sum / xs.length
        
        //10) Curring in scala
        //Currying in Scala is simply a technique or a process of transforming a function. This function takes multiple arguments into a function that takes single argument. It is applied widely in multiple functional languages.
        // Scala program add two numbers
        // using Currying function
        
        
        // transforming the function that takes two(multiple) arguments into a function that takes one(single) argument.
        def add2(a: Int) = (b: Int) => a + b; //extends the function to take a second Int
        
        println(add2(20)(19));//adds the 2 ints together.
    
        //11)Pattern Matching & Regular Expressions
        def matchTest(x: Int): String = x match {
            case 1 => "one"
            case 2 => "two"
            case _ => "other"
        }
        
        matchTest(3)  // prints other
        matchTest(1) //prints one
    
        val numberPattern: Regex = "[0-9]".r //definition for what a number is
    
        numberPattern.findFirstMatchIn("awesomepassword") match { //checks if printed password matches any number 0-9
            case Some(_) => println("Password OK")
            case None => println("Password must contain a number") //number does not exist in awesomepassword so prints Password must contain a number
        }
    
        val keyValPattern: Regex = "([a-zA-Z- ]+): ([0-9a-zA-Z-#()/. ]+)".r//first group matches a-z, A-Z and -, second group matches 0-9, a-z, A-Z and symbols #()/. with key and value separated by :
    
        val input: String =
            """background-color: #A03300;
                background-image: url(img/header100.png);
                background-position: top center;
                background-repeat: repeat-x;
                background-size: 2160px 108px;
                margin: 0;
                height: 108px;
                width: 100%;""".stripMargin
    
        for (patternMatch <- keyValPattern.findAllMatchIn(input))
            println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}") //uses pattern matching to match keys to values in loop
    }
}

//1
class Ctr {
    private var value = 6
    
    def incr() {
        value += 1
    }
    
    def curr() = value
}

class Duck {
    var size = 1
}

//2
class Employee(empId: Int, name: String, salary: Double) {
    def this(empId: Int, name: String) {
        this(0, "", 0.0) // here it invokes primary constructor.
        println("Two-argument auxiliary constructor")
    }
    
    def this(empId: Int) {
        this(0, "", 0.0) // here it invokes primary constructor.
        println("One-argument auxiliary constructor")
    }
    
    def this() {
        this(0) // here it invokes one-argument auxiliary constructor.
        println("Zero-argument auxiliary constructor")
    }
    
    println("Primary construtor")
}

//5
//Multilevel inheritance
/*class A{ //defines class A
    println("A")
    }

class B extends A { //defines class B, extends A
    println("B")
}

class C extends B{ //defines class C, extends B
    println("C")
    }*/

//Hierarchical Inheritance
class A {
    println("A") //define class A
}

class B extends A { //define class B, extends A
    println("B")
}

class C extends A { //define class B, also extends A
    println("C")
}