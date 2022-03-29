package scala_class

object Question1 {
    def main(args:Array[String]): Unit = {
            //since Ctr class has a private value, it can't be used unless the class is called
            //the value of Ctr is increased by using the expression created inside of Ctr
        class Ctr {
            private var value = 6
            def incr() {value +=1}
            def curr() = value
        }
        val ctr1 = new Ctr
        new Ctr()
        ctr1.incr()
        print(ctr1.curr)
            //part 2
            //f.size refers to expression f and makes the size of the new Duck 10
        class Duck {
            var size = 1
        }
        var f = new Duck
        f.size = 10
        println(f.size)
    }
}
object Question2 {
    def main(args:Array[String]): Unit = {
            //since expression isn't called until after println("Primary constructor"), this is executed before the def statements
        class Employee(empId: Int,name: String,salary :Double) {
            def this(empId:Int,name:String)
            {
                this(0,"",0.0)
                println("Two-argument auxiliary constructor")
            }
            def this(empId:Int)
            {
                this(0,"",0.0)
                println("One-argument auxiliary constructor")
            }
            def this()
            {
                this(0)
                println("Zero-argument auxiliary constructor")
            }
            println("Primary constructor")
        }
        val emp = new Employee()
    }
}
object Question3 {
    def main(args:Array[String]): Unit = {
            //when printed, the values show as "List()" and then the given information
            //Seq is used to return values of the created collection
            //newSalaries calls salaries expression using map keyword and causes x interger to be filled in by salaries values
            //the first three expressions cause the same results as the last two, but the first three would be read easier
        
        val salaries = Seq(20000, 70000, 40000)
        val doubleSalary = (x: Int) => x * 2
        val newSalaries = salaries.map(doubleSalary)

        val salaries2 = Seq(20000, 70000, 40000)
        val newSalaries2 = salaries.map(x => x * 2)

        println(salaries)
        println(doubleSalary)
        println(newSalaries)
        println(salaries2)
        println(newSalaries2)
    }
}
object Question4 {
    def main(args:Array[String]): Unit = {        
            //this question is basically going over the different functions that are possible in scala and how we are able to run them including running multiple in one expression
        def sum(f: Int => Int, a: Int, b: Int): Int = if (a > b) 0 else f(a) + sum(f, a + 1, b)
        def sumInts(a: Int, b: Int): Int = sum(id, a, b)
        def sumSquares(a: Int, b: Int): Int = sum(square, a, b)
        def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b)
        def id(x: Int): Int = x
        def square(x: Int): Int = x * x
        def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)
        println("sum ints 1 to 4 = " + sumInts(1,4))
    }
}

object Question5 {
    def main(args:Array[String]): Unit = {
            //By inheriting Class A in Class B, as well as inheriting Class B in Class C, when calling Class C, this includes Classes A & B
            //This causes A, B, and C to be printed
            //part one
        class A {
        println("A")
        }
        class B extends A {
        println("B")
        }
        class C extends B {
        println("C")
        }
        new C ()

            //part 2: Hierarchial Inheritance
            //classes A-C already declared so I created A2-C2
            //shows that since B2 and C2 are connect to A2 but not each other, only A and B or A and C or printed respectively
        class A2 {
            println("A")
        }
        class B2 extends A2 {
            println("B")
        }
        class C2 extends A2 {
            println("C")
        }
        new B2 ()
        new C2 ()

            //shows how hierarchial inheritance can be used in a real world application
            //this example inherits traits A3 and B3 into class C3
            //then class C3 uses the variables inside of the two traits to print the results of both by creating a new C3 and printing the variables that were created in traits A and B
            //added to that, the override action allows class C3 to override the value of the length and height that were given in the two traits since they were inherited
            //by using c.action, it means that instead of the value of length and height originally created from "new C3", it returns new values for length and height according to those specified in the override def in class C3

        trait A3 {
            var length: Int = _
            def action = {
                length = length + 5
            }
        }
        trait B3 {
            var height: Int = _
            def action = {
                height = height + 1
            }
        }
        class C3 extends A3 with B3 {
            length = 3;
            height+=6;
            override def action = {
                super[A3].action
                super[B3].action
            }
        }
        var c = new C3
        c.action
        println(c.height)
        println(c.length)
    }
}

object Question6 {
    def main(args:Array[String]): Unit = {
            //this object could be easily used elsewear by being imported or by creating a companion class since it is a singleton
        object Reservations {
            var lastNum = 0;
            val num2 = 2;
            def newReservationNum() = { lastNum +=1; lastNum }
        }
    }
}

import java.io.IOException

object Question7 {
    def main(args:Array[String]): Unit = {
            //try-catch Exception
            //the expression tries to divide 5 by 0 and since this is not possible mathmatically, this causes an arithmetic exception rather than an IO Excpetion
            //because it's an Arithmetic exception, it causes the println to be printed in case a
        try {
            var N = 5/0
        }
        catch {
            case i: IOException => {
                println("IOException occurred.")
            }
            case a: ArithmeticException => {
                println("Arithmetic Exception occurred.")
            }
        }

            //part two to question 7
            //this is similar to the first one but there is only the one case that will be the correct case and then the finally is printed after the case
        try {
            var N = 5/0
        }
        catch {
            case ex: ArithmeticException => {
                println("Arithmetic Exception occurred.")
            }
        }
        finally {
            println("This is final block.")
        }
    }
}

object Question8 {
        //when orignally running this class, it doesn't throw an error but it never actually stops running in a circle
        //the class will never stop running because the try catch is looking for an exception, which isn't satisfied by the statements
        //this exception causes the code to continue running since the value of x + y isn't 43
    def main(args: Array[String]) {
        def failingFn(i: Int): Int = {
            val y: Int = throw new Exception("fail!")
            try {
                val x = 42 + 5
                x + y
            }
            catch { case e: Exception => 43 }	
        }

        def failingFn2(i: Int): Int = {
            try {
            val x = 42 + 5
            x + ((throw new Exception("fail!")): Int)
            }
            catch { case e: Exception => 43 }
        }

        def mean_1(xs: IndexedSeq[Double], onEmpty: Double): Double =
        if (xs.isEmpty) onEmpty
        else xs.sum / xs.length
    }
}

//Question 9
    //It has a sophisticated type inference system.
    //Its syntax is concise but still readable — we call it expressive.
    //It’s a pure object-oriented programming (OOP) language. Every variable is an object, and every “operator” is a method.
    //It’s also a functional programming (FP) language, so functions are also variables, and you can pass them into other functions. You can write your code using OOP, FP, or combine them in a hybrid style.
    //Scala source code compiles to “.class” files that run on the JVM.
    //Scala also works extremely well with the thousands of Java libraries that have been developed over the years.
    //A great thing about Scala is that you can be productive with it on Day 1, but it’s also a deep language, so as you go along you’ll keep learning, and finding newer, better ways to write code. Some people say that Scala will change the way you think about programming (and that’s a good thing).
    //A great Scala benefit is that it lets you write concise, readable code. The time a programmer spends reading code compared to the time spent writing code is said to be at least a 10:1 ratio, so writing code that’s concise and readable is a big deal. Because Scala has these attributes, programmers say that it’s expressive.
        //Scala definitely seems straight forward and like a good language to begin with; although I don't have much experience with other languages so I can't really compare it to much.


object Question10 {
        //the fact that it can take an equation and use the equation inside of another equation without restating it is simiar to calling an expression/statement
        //this process looks like it will make things faster, easier to read, and make our jobs easier overall
    def add2(a: Int) = (b: Int) => a + b
    def main(args:Array[String]) {
        println(add2(20)(19))
    }
}

object Question11 {
        //it's similar to the try catch, but it matches the variable to a case
        //we identify the acceptable input values(0-9) in the numberPattern, then use pattern matching to ensure the provided value is included in those parameters
        //then the allowed input values, which are every possible number, letter, and most other characters in the case of keyValPattern
        //then we make sure that the pattern provided falls within the given parameters
        //then if the inputted values are acceptable, they are printed

    def main(args: Array[String]) {
        def matchTest(x: Int): String = x match {
            case 1 => "one"
            case 2 => "two"
            case _ => "other"
        }
        matchTest(3)
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
            background-image: url(img/header100.png);
            background-position: top center;
            background-repeat: repeat-x;
            background-size: 2160px 108px;
            margin: 0;
            height: 108px;
            width: 100%,""".stripMargin

        for (patternMatch <- keyValPattern.findAllMatchIn(input))
        println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")

    }
}