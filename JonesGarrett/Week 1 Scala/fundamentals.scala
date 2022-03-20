import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer

object test{
  def overloadTest(x:Int):Int = x
//  def overloadTest(x:String):String = x

  def overloadTest2(x:Double):Double = 1.21111

  def myFunc(){
    println("myFunc")
    println("|")


    def overloadTest(x:Int):Int = {
      println("|___overloadTest(Int)")
      x
    }
    def overloadTest2(x:Double):Double = {
      println("|___overloadTest2(Double) value of int: " + x)
      x
    }
    //def overloadTest2(x: String):String= {
    //  println("overloadTest(Double) value of string: "+x)
    //  x
    //}


    overloadTest(1)

    //overloadTest("1")
    overloadTest2(1.111111)
    //overloadTest2("test")
    //
    
    //val arr = Array(1,2,3,4,5)
    //println(arr(0))
  }
}

object scala_fundamentals {
  // Steps 1-34 for ScalaFundamentals.txt
  def stepsOneThroughThirtyFour() = {
    println("--Q1--")
    10+2 //1 Returns 12 and does nothing else.  It is a pure expression.
    println("--Q2--")
    val msg = "Hello, world!" //2 msg is inferred to be an immutable String
    println("--Q3--")
    //msg="Hello!" //3 msg is immutable, so it cannot be reassigned, make var msg instead 

    println("--Q4--")
    var msg2 = "Hello, world!" //4 msg2 is a mutable String
    println("--Q5--")
    msg2 = "Just hello" //5 msg2 is mutable, so it can be reassigned

    println("--Q6--")
    //msg2 = 3 //6 msg2 is a String, so it cannot be reassigned to an Int
    println("--Q7--")
    val x = {val a=10; val b=100; b-a} //7 Returns 90.  {} defines a code block inside of which a=10, b=100, the last expression or return is b-a which evaluates to Int 90.

    println("--Q8--")
    val file = scala.io.Source.fromFile("test.txt").mkString //8 Returns the contents of test.txt as a String.  The file needs to exist in the current directory where the line is called from since no path is provided.
    println("--Q9--")
    val m = { print("foo"); 1 } //9 Returns 1.  print("foo") is evaluated, but the last expression is 1, so it is returned. 1 is equivalent to Boolean true in conditional statments.

    println("--Q10--")
    //var x = 5 //10 x is already defined as a val, so it cannot be reassigned to a var.  A diff var name is required.
    
    val s = if (x > 0 && x < 6) 1 else 0


    println("--Q11--")
    //vim Demo_1.scala //11 This is not a scala statement, this is a command line statement.  This command opens the Demo_1.scala file in the Vim terminal text editor.
    
    /* 11 This is the main code block for the Demo_1.scala  It would not work in the current case, but if you add this code block without comments to a .scala file and compile it then it would run.  The program would evaluate if x < 20 to be true and execute the if block code. 
     * The current program contains a similar main block where this object and method are called.
     * Object Demo_1 {
     *  def main(args: Array[String]) {
     *  var x = 15;
     *  if (x < 20) {
     *  println("This is an if statement");
     *  }
     * }
     * }
     * */

    println("--Q12--")
    val t = if (x > 0 && x < 6) 1 else 0 //12 Returns 0 because x is not less than 6.
    assert(t == 0)

    println("--Q13--")
    var args = "hello" // 13 args is a String, this will work in the current scope, but it would not work in the main function because args is already defined as an Array[String].
    println("")

    println("--Q14--")
    args.foreach(arg=>println(arg)) //14 This is a for loop.  It iterates through each character in the String args and prints it.  The foreach method is a method of the String class.))  The arrow function allows you to pass the argument `arg` to the println function alongside other arguments with the higher order function.
    //14, NOTE: If you run this in main function it would print out each WORD in the args array not each character.  
    args.foreach(arg=>println(arg.toString+" <--- My char")) //I.e. You could also run

    
    println("--Q15--")
    val args2 = Array("Command", "Line", "Arguments")//15 Here I just made it imitate args in main.  if args were an empty array then any attempt to use foreach on it would generate an error.
    args2.foreach(println)//15  

    println("--Q16--")
    for(i<-1 to 5)
      println(i) //16 This is a for loop.  It iterates through each number in the range 1 to 5 and prints it.  The for loop is a method of the Range class.
    

    println("--Q17--")
    val in = "hello world" 
    var sum = 0 
    for (i<-0 until in.length) sum+=i //17 This is a for loop.  It iterates through each index in the String in and adds the index number to the sum.  The for loop is a method of the String class.
    println(sum)

    println("--Q18--")
    for (i<-1 to 3; j<-1 to 3)
      println(10*i+j) //18 This is a for loop.  It iterates through each number in the range 1 to 3 and prints it.  
      // 1st itertaion i = 1 and j = 1, 2nd i = 1 and j = 2, 3rd i = 1 and j = 3, 4th i = 2 and j = 1, 5th i = 2 and j = 2, 6th i = 2 and j = 3, 7th i = 3 and j = 1, 8th i = 3 and j = 2, 9th i = 3 and j = 3
    
    println("--Q19--")
    for(i<-1 to 3; j<-1 to 3 if i==j) println(10*i+j) //19 
    // There are only 3 time in which i and j equal each other. 
    //
    
    //20
    println("--Q20--")
    println("x_   _i_j_")
    for(i<-1 to 3; x=4-i;j<- x to 3) println(x+"  10*"+i+"*"+""+j+"="+10*i*j)
    
    //21
    println("--Q21--")
    //val x = for(i<-1 to 20)yield i*2.5 --- x has already been defined.
    val g = for(i<-1 to 20)yield i*2.5
    for (i<-g) println(i)

    //22
    // nested functions are supported
    println("--Q22--")
    def sayHello(){
      println("hello")
    }

    //def sum is already defined as a variable so this function has to be named differently.  It cannot overload a variable.
    def sum2(a: Int, b: Int): Int = {
      a + b
    }

    //def sum2(a: Int, b: String): Any = {
      //Overloads sum2 to take in any type of argument.
     // println("hello")
    //}
    

    // NOTE: In this specific instance, the sum2 method cannot be overloaded so the func name was changed.
    def sum3(a: Int, b: String): Any = {
      //Overloads sum2 to take in any type of argument.
      println("hello")
    }

    def func(): Int={
      return 7
    }
    sayHello()
    println(sum2(2,5))
    println("Call to func: "+func())
    sum3(2,"hello")


    //23
    println("--Q23--")
    def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n-1)

    //Object Demo {
    //  def main(args: Array[String]) {...
    //  }
    //}
    //FAIL: Cannot resolve factorial. you cannot define a function outside a class or object
    //Here I have defined factorial inside the fundamentals object so it works.
    println(factorial(5))

    //24
    println("--Q24--")
    def rect_area(length: Float, breadth: Float)
    {
      val area = length * breadth; println(area)
    }
    rect_area(2.0f, 3.0f)

    //25
    println("--Q25--")
    var a = Array(1,2,3)
    //println(a(4)) //FAIL: outside the range of the array.  Need to make arr a bigger or create another bigger array.
    var b = new Array[Int](5)//Array of 5 integers
    //add all the elements of arr a to b
    for(i<-0 until a.length) b(i) = a(i) //copy over the elements of a to b
    a = b

    println(a(0))
    println(a(4))
    println("Array a after extension: "+a.mkString(","))

    val aa = new Array[Int](10)
    val ss = new Array[String](10)
    val st = Array("Hello", "world")

    //26
    println("--Q26--")
    val aaa = ArrayBuffer[Int]()
    aaa += 1
    aaa +=(2,3,5)
    println(aaa)
    aaa ++=Array(6,7,8)
    println(aaa)

    //27
    println("--Q27--")
    val listx = 1 :: 2 :: 3 :: Nil
    println(listx ::: List(1,2,3))
    println(listx ::: List(1,2.0,33D,4000L))
    println(listx ::: List.range(1,10))
    println(listx ::: List.fill(3)("foo"))
    println("Concatenate list objects: " :: listx :: List(1,2,3) :: List(1,2.0,33D,4000L) :: List.range(1,10)::: List.fill(3)("foo"))
    ("String1" :: 1 :: "String2" :: Nil).foreach(println)// quick way to print elements out.


    // adding and removing elements from a list buffer
    var fruits = new ListBuffer[String]()
    fruits += "apples"
    fruits += ("strawberries", "kiwi")
    println(fruits)
    fruits -= ("apples", "kiwi")
    println(fruits)

    val fruitsList = fruits.toList
    println(fruitsList)

    // Combining lists together.
    val x2 = List(3)
    val y2 = 1 :: 2 :: x2
    val z = -1 :: y2
    println("Value of z: "+z) 

    val originalList1 = List(7, 8, 4, 3, 2)
    val newList1 = originalList1.filter(_ > 3) // insert any element that is greater than 3.
    println("Value of newList1: "+newList1)

    val p = List(111, 200, 321)
    val q = List(4, -5, 60)
    var r = p ++ q
    r = p ::: q






    //28
      






    println("--Q26--")
    println("--Q26--")
    println("--Q26--")





   


  }

  def helloWorld() {
    println("Hello, world!")
  }

  def sumtest(a: Int, b: Int): Int = {
    a + b
  }

  def sum(a: Int, b: String): Any = {
    //Overloads sum2 to take in any type of argument.
    println("hello")
  }

  def readFile(){
    val file = scala.io.Source.fromFile("test.txt").mkString
    println(file)
  }
}






object one{
  def addTwo(x: Int, y: Int): Int={
  // Question 1 
    if(x == y){
      // NOTE: return keyword can also be used for verbosity but beware early return in complex blocks.
      return (x+y)*3
    } else {
      return x+y
    }
  }

  def questionTwo(s: String): String = {
    // Question 2 - Write a scala function that takes a new string with the last char added at the front and back of a given string of length 1 or more.
    var lastChar = s.last
    if(s.length > 0){
      //return 
      lastChar+s+lastChar
      
    } else {
      //return
      s
    }
  }

  def questionThree(n: Int): Int = {
    // Question 3 - Write a scala function which gets the absolute difference between n and 51.
    if(n > 51){
      return (n-51).abs
    } else {
      return (51-n).abs
    }
  }

  def questionFour(x: Int, y: Int): Boolean = {
    // Question 4 - Write a scala function which returns true if one of them is 30 or if their sum is 30.
    if ( x == 30  || y == 30 || x+y == 30){
      return true
    } else {
      return false
    }

  } 

  def questionFive(x: Int): Boolean = {
    // Question 5 - check a given integer and return true if it is within 20 of 100 or 200.
    var diff = x-100
    var diff2 = x-200
    if(diff.abs <= 20 || diff2.abs <= 20){
      return true
    } else {
      return false
    }
    

  }

  def main(args: Array[String]) {
    // Write a Scala program that prints the sum of two integer values.  If the two values are the same, then return triple their sum.
    
    
    
    //Question 1

    println("Given x = 2, y = 3, the sum is: " + addTwo(2, 3))
    println("Given x = 2, y = 2, the sum is tripled: " + addTwo(2, 2))
    //--Unit tests
    assert(addTwo(2, 3) == 5, "addTwo(2, 3) should be 5")
    assert(addTwo(2, 2) == 12, "addTwo(2, 2) should be 12")


    // Question 2
    var s = "Hello"
    println("Passing string 'Hello' function returned:  "+questionTwo(s))
    //--Unit tests
    assert(questionTwo("Hello") == "oHelloo", "questionTwo(s) should be oHelloo")
    assert(questionTwo("Vim > VSCODE") == "EVim > VSCODEE", "questionTwo(s) should be oHelloo")


    // Question 3
    var absVal = questionThree(51)
    println("Passing 51, absolute difference of 51 and 51 is: "+absVal)
    absVal = questionThree(55)
    println("Passing 55, absolute difference of 55 and 51 is: "+absVal)
    //--Unit tests
    assert(questionThree(-10) == 61, "questionThree(-10) should be 61")
    assert(questionThree(51) == 0, "questionThree(51) should be 0")
    assert(questionThree(50) == 1, "questionThree(50) should be 1")
    assert(questionThree(60) == 9, "questionThree(60) should be 9")
    assert(questionThree(41) == 10, "questionThree(41) should be 10")
    

    // Question 4
    var sumCheck = questionFour(30, 30)
    println("Passing 30, 30, sumCheck should return True: "+sumCheck)
    sumCheck = questionFour(15, 15)
    println("Passing 15, 15 sumCheck should return True: "+sumCheck)
    sumCheck = questionFour(15, 20)
    println("Passing 15, 20 sumCheck should return False: "+sumCheck)
    //--Unit tests
    assert(questionFour(30, 10) == true, "questionFour should be true, param x == 30")
    assert(questionFour(15, 30) == true, "questionFour should be true, param y == 30")
    assert(questionFour(15, 15) == true, "questionFour should be true, param sum(x,y) == 30")
    assert(questionFour(16, 15) == false, "questionFour should be false, param sum(x,y) != 30")

    // Queston 5
    var diffCheck = questionFive(100)
    println("Passing 100, diffCheck should return True: "+diffCheck)
    diffCheck = questionFive(200)
    println("Passing 200, diffCheck should return True: "+diffCheck)
    diffCheck = questionFive(150)
    println("Passing 150, diffCheck should return false: "+diffCheck)
    diffCheck = questionFive(-50)
    println("Passing -50, diffCheck should return false: "+diffCheck)
    //--Unit tests
    assert(questionFive(100) == true, "questionFive should be true, param x == 100")
    assert(questionFive(200) == true, "questionFive should be true, param x == 200")
    assert(questionFive(180) == true, "questionFive should be true, param x == 180")
    assert(questionFive(160) == false, "questionFive should be false, param x == 160")
    assert(questionFive(79) == false, "questionFive should be false, param x == 79")


    //Now try to use arrow functions

    //Question 6 
    var ifString = (s: String) => {
      // Write a function which takes a string and returns the string unchanged if it begins with if else append if to the front of the string.
      if(s.substring(0,2) == "if"){
        s
      } else {
        "if"+s
      }
    }
    println("Passing 'if' as a string, ifString should return 'if': "+ifString("if"))
    //--Unit tests
    assert(ifString("if") == "if", "Given String 'if', ifString should return: if")
    assert(ifString("ifTest") == "ifTest", "Given String 'ifTest', ifString should return: ifTest")
    assert(ifString("Test") == "ifTest", "Given String 'Test', ifString should return: ifTest")

    //Question 7
    var removeChar = (s: String, pos: Int) => {
      // Write a funciton that removes a string char at given position
      if(pos < 0 || pos > s.length-1){
        // Position out of bounds, ignore.
        s
      } else {
        s.substring(0,pos)+s.substring(pos+1)
      }
    }
    println("Passing 'Hello' and pos = 2, removeChar should return 'Helo': "+removeChar("Hello", 2))
    //--Unit tests
    assert(removeChar("Hello", 0) == "ello", "Given String 'Hello', removeChar(0) should return: ello")
    assert(removeChar("Hello", 1) == "Hllo", "Given String 'Hello', removeChar(1) should return: Hllo")
    assert(removeChar("Hello", 2) == "Helo", "Given String 'Hello', removeChar(2) should return: Helo")
    assert(removeChar("Hello", -1) == "Hello", "Given String 'Hello', removeChar(-1) should return: Hello")
    assert(removeChar("Hello", 10) == "Hello", "Given String 'Hello', removeChar(10) should return: Hello")


    //Question 8
    var swapChars = (s: String) => {
      // Write a function that swaps the first and last chars of a string
      if(s.length < 2){
        // String is too short, ignore.
        s
      } else {
        s.substring(s.length-1)+s.substring(1,s.length-1)+s.substring(0,1)
      }
    }
    println("Given 'Hello', swapChars should return 'oellH': "+swapChars("Hello"))
    //--Unit tests
    assert(swapChars("Hello") == "oellH", "Given String 'Hello', swapChars should return: oellH")
    assert(swapChars("Hello World") == "dello WorlH", "Given String 'Hello World', swapChars should return: dello WorlH")
    assert(swapChars("") == "", "Given String '', swapChars should return: ")
    
    //val scala_fundamentals = new basicSteps()

    scala_fundamentals.helloWorld()
    scala_fundamentals.readFile()
    scala_fundamentals.stepsOneThroughThirtyFour()
    // Create an array of strings
    var myArray = Array("Hello", "World", "!")



    //println("=========Overloaded method testing=========")
    //test.myFunc()


  } // End of main

} // End of object
