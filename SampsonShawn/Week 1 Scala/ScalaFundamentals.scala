package notepad1

object ScalaFundamentals extends App {

  println("-1-")// 1
  println(10+2) // adding two integers together

  println("-2-")// 2
  //val msg = "Hello World" // set immutable value of msg to String "Hello World" the type of msg is inferred
  //println(msg)

  println("-3-")// 3
  // msg = "Hello!"  // cannot chang value of msg as it is immutable (val) and previously declared
  // error cannot reassign val as it is immutable

  println("-4-")// 4
  var msg = "Hello World"  // if #2 was not commented would be a double definition and invalid
  // creates a variable msg and assigns it String type "Hello World"
  println(msg)

  println("-5-")// 5
  msg="Hello!" // reassigns the value of msg from "Hello World" to "Hello!"
  println(msg)

  println("-6-")// 6
  //msg = 3 // unable to reassign type to Int from String

  println("-7-")// 7
  //val x = {val a=10;val b=100; b-a}
  // x is equal to b-a, x is equal to 100 - 10, x=90
  //println(x)

  println("-8-")// 8
  //val file = scala.io.Source.fromFile("kumar").mkString
  // create val file, read file "kumar" and convert it to a String, set value of file to the result

  println("-9-")// 9
  val  m = { print ("foo "); 1}
  println(m)

  println("-10-")// 10
  var x = 5 // declare x as an Int of 5, This type is Inferred
  // var x is double definition with number 7

  println("-11-")// 11
  val s = if (x > 0 && x < 6) 1 else 0
  // using value of variable x from 10, if x is greater than 0 and less than 6, s = 1 else s = 0,
  println(s)

  println("-11.5-") // 11.5
  //vim Demo_1.scala

/*  Object Demo_1{
    def main(args:Array[String]) {
      var x=15;
      if( x<20) {
        println("This is if statement");
      }
    }
  }*/

  // Create object Demo_1, Define main function, define var x and set value to 15, if x less than 20
  // ( evaluates to true ) print "This is a statement" to console
  // This will print "This is if statement" to the console

  println("-12-")// 12
  val t = if (x > 0 && x < 6) "positive" else "negative"
  // set val t to result of if statement.
  // if x is greater than 0 and x is less than 6 t = "positive" else t = "negative"
  // due to x being equal to 5 t will be "positive"
  println(t)

  println("-13-")// 13
  var thisArgs = "hello" // had to change args to thisArgs due to extends App, as args is already defined under App
  // define the variable thisArgs

  println("-14-")// 14
  thisArgs.foreach(x=>println(x))
  // for each character in thisArg, x (individual character of thisArgs) = create function instance println and print x

  println("-15-")// 15
  val xList = List(1,2,3)  // modified x to xList, Create list 1,2,3
  xList.foreach{println}  // for each item in xList println -> print to console

  println("-16-")// 16
  for(i<-1 to 5) // for I in range 1 to 5
    println(i)  // print i to console

  println("-17-")// 17
  val in  = "hello world"  // set val n to String "hello world"
  //println(in.length)  // length of string is 11
  var sum = 0 // set var sum to 0
  //for (i<-0 until in.length) {println(s"Value of i = $i")}  // Show that the loop runs 11 times
  for (i<-0 until in.length) sum+=i // loop through until length of variable in, add i to sum each loop.
  // 0+1+2+3+4+5+6+7+8+9+10
  //print(sum) // print sum to console do not move to another line
  println(sum) // sum = 55 - for human readability changed to println

  println("-18-")// 18
  for( i<-1 to 3;j<-1 to 3 )  //  multiply i by ten then add j, increment j until range is met then increment i and repeat
  // 10 times for each i = 1 plus j = 1 result 11
  // 10 times for each i = 1 plus j = 2 result 12
  // 10 times for each i = 1 plus j = 3 result 13
  // 10 times for each i = 2 plus j = 1 result 21
  // 10 times for each i = 2 plus j = 2 result 22
    println(10*i+j)  // print 10 multiplied by i then add j
    // results printed = 11,12,13,21,22,23,31,32,33

  println("-19-")// 19
  for(i<-1 to 3;j<-1 to 3 if i==j) println(10*i+j) // results printed = 11,22,33
  // set i to 1, then increment j through range 1 to 3 if i is equal to j print 10*i+j
  // i = 1, j = 1 print to console 10*1+1  result 11
  // i = 1, j = 2 false
  // i = 1, j = 3 false
  // i = 2, j = 1 false
  // i = 2, j = 2 print to console 10*2+2 result 22



  println("-20-")// 20
  for(i<-1 to 3;x=4-i;j<- x to 3) println(10*i+j)
  // i = range(1,2,3), x = 3, j = range(3)
  // i = 1, x = 3, x = 3, j = 3   10*1+3 = 13
  // i = 2, x = 2, j = range (2, 3)
  // i = 2, x = 2, j = 2 = 10*2+2  = 22
  // i = 2, x = 1, j = 3 = 10*2+3  = 23
  // i = 3, x = 1, j = 1 = 10*3+1  = 31
  // i = 3, x = 1, j = 2 = 10*3+2  = 32
  // i = 3, x = 1, j = 3 = 10*3+3  = 33

  println("-21-")// 21
  //val x = for(i<-1 to 20)yield i*2.5  // commented out due to double definition
  //for (i<-x) println(i)

  // removed object
  def function1() = { // had to add = to make it work  // changed name of main due to conflict // removed args as it was not used in function
    var a=10;   // set variable a = to 10  : semicolon is not necessary
    while( a<20) {  // while a < 20 do
      println("value of a = " + a);  // print value of a = (value of a)
      a= a+1; // increment the value of a until the value is 20 - Note will not print 20
    }
  }
  function1() // added function call to run the function

  def function2() = {
    var nodb = 2; // create variable nodb and set it equal to 2
/*    do { // do  // encountering "illegal start of statement do" code structure seems fine..
      nodb += 1; // increment value of variable nodb
      println(s"nodb = $nodb"); // print string nodb = (value of nodb)

    }while (nodb < 10); // evaluate if nodb is less than 10 will print out 10 as the evaluation occurs after incrementing the variable*/
    // note: do while loops always run at least once because the true false evaluation takes place after the initial run
  }

  println("-22-") // 22

  def sum(a:Int,b:Int) = { // added = //
    println(a+b)  // print out the sum of a + b (7+5) = 12
  }

  sum(7,5) // modified parameter so the return would be different than the following function

  def func():Int={ // Method no parameters, returns integer 7
    return 7
  }
  println(func()) // printed out the return of func

  def sum(a:Int,b:Any):Any= {  // overLoading previous method sum
    println("hello")
  }
  sum(3,"joe")

  println("-23-") // 23

  def factorial(n:Int):Int={ if(n==0) 1 else n*factorial(n-1) }
  // if n == 0 return 1 else multiply n*(n-1) repeat until n = 0 then return 1
  // 5*4*3*2*1*1  = 120
  println(s"factorial function result = ${factorial(5)}") // added a function call for output to console

  // removed containing object

  def function3(args:Array[String]) = { // modified function name to avoid conflict
    var result= functionExamp(15,2) // call functionExamp with parameters 15,2 and set result to the result of functionExamp
    println(result) // print result to the console
  }

  def functionExamp(a:Int,b:Int):Int={  // pass two Integers as parameters
    if(b == 0)  // if b equals 0 return 0
      0
    else
      a+functionExamp(a,b-1)  // if b is not equal to 0, use recursion, add a to result continue until b = 0
  }
  val anArray = Array("Run")  // set an array variable
  function3(anArray)  // pass variable in function as a parameter is required, run function 3

  println("-24-") // 24

  def rect_area(length:Float,breadth:Float) = // set parameters to float
  { val area = length*breadth; println(area)} // multiply parameter 1 with parameter 2 and print it out.  // added ln to creat new line on print

  println(s"Area = ${rect_area(1.25, 2.1)}")  // the final value in this function is print, returns unit

  println("-25-") // 25

  //Arrays with values

  var arrayA = Array(1,2,3)  // modified variable name to remove conflict // create varaiable, assign array with values 1,2,3
  //arrayA(4) // causes an index out of bounds error as the length of the array is 3
  println(arrayA(0)) // prints first item in array as it is a zero based language

  //Arrays without values
  var arrayB = new Array[Int](3) // Initialize array with three Indexes, values set to Int type
  println(arrayB(1)) // added println to display output to console showing 1st position
  arrayB(1)= 2  // set second position in array to the value 2
  println(arrayB(1)) // added a println to display array position 1 to console
  println(arrayB.mkString(" ")) // output the array to the console

  val a = new Array[Int](10)      // create new array with Int for values, 10 indexes 0-9
  println(a.mkString(" ")) // output the values of a
  val s2 = new Array[String](10)  // changed var to resolve conflict // create new array with string type, 10 indexes
  println(s2.mkString(" "))  // returns null as string contents are not defined
  val st = Array("Hello","world")  // create array with two indexes, hello and world

  println("-26-") // 26
  import scala.collection.mutable.ArrayBuffer  // import a scalla collection library for ArrayBuffer
  val a2 = ArrayBuffer[Int]() // unlike array, arraybuffer can change in size // modified val name to remove conflict
  a2 +=1  // add 1 to array
  a2 +=(2,3,5) // add multiple elements to the array buffer
  a2 ++=Array(6,7,8)// add elements of another array to array buffer
  a2.foreach(print) // print out each element of the array buffer
  println("")// break line to next section in cosole

  println("-27-") // 27
  // modified val names to prevent dbl definitions
  val list = 1 :: 2 :: 3 :: Nil  // Nil is of type list, :: = cons, prepend 1, 2, 3 to Nil without changing original
  val list2 = List(1,2,3) // creat list with elements 1,2,3
  val x1 = List(1,2.0,33D,4000L)// list containing different data types
  val x2 = List.range(1,10)// create a list using range
  val x3 = List.fill(3)("foo")// create a list and fill each element with foo
  val x4 = List.tabulate(5)(n=>n*n) // create list with tabulated data for n 5x, 0*0=0(first element), 1*1=1(second) etc

  import scala.collection.mutable.ListBuffer  //import scala collection for listBuffer
  var fruits = new ListBuffer[String]() // create new empty list buffer
  fruits += "Apple" // add apple to list buffer
  fruits += ("strawberry","kiwi") // add strawberry and kiwi to list buffer
  fruits -= ("Apple","kiwi") // remove Apple and kiwi from list buffer
  val fruitslists = fruits.toList // set fruitslists to list with element strawberry


  val x5 = List(3)// set val x5 as a list with one element value of 3
  val y1 = 1 :: 2 :: x5 // set value of y1 to a list with 1, 2, 3 for elements
  val z = -1 :: y1 // set value of z to a list with -1 prepended to it

  val originalList1 = List(7,8,4,3,2)
  // create newList val and set it to a list with elements from originalList if element is greater than 3
  val newList1 = originalList1.filter(_>3)

  val p = List(111,200,321)
  val q = List(4,-5,60)
  val r1 =  p ++ q // create new list, combine list q with p in the new list
  val r2 = p ::: q //  create new list, concat them
  val r3 = List.concat(p,q) // another way to concatenate lists


  val lst = List(1,2,3,4,5,6,7,8,7)
  lst.head  // output the first item in the list
  lst.tail  // output everything after the first item in the list

  def sum(l: List[Int]):Int = { if(l == Nil) 0 else l.head + sum(l.tail)}
  // If l is Nil retrun 0 else add the first item in the list to the sum of the rest of the list items
  val y2 = sum(lst) // y2 equals return value of sum function passing in lst

  println("-28-") // 28
  var set1 : Set[Int] = Set(1,3,5,7)
  var set2 = Set(7,9,8,9)
  var set3 = Set(10,11,12,13)
  set1++set2 // concatenate set1 and set2, will remove duplicate elements

  var xet1 = Set(7,9,8,9)
  var xet2 = Set(10,11,12,13)
  xet1.++(xet2)// another way to concatenate sets

  var aet1 = Set(11,44,33,22)
  var bet1 = Set(77,99,22,88)
  aet1.&(bet1) // find the intersection of two sets (elements that exist in both sets)

  var aet2 = Set(11,44,33,22)
  var bet2 = Set(77,99,22,88)
  aet2.intersect(bet2)// another way to find intersecting elements between sets

  println("-29-") // 29
  val mapping = Map("Vishal"-> "Kumar","Vijay" -> "verma") // create a map
  mapping.keys.foreach{i=>println(i+" "+mapping(i))} // print out key and value for each element
  mapping.contains("Vishal") // returns boolean, check if map contains value

  println("-30-") // 30
/*  What is the difference between Expressions and Statements in Scala?

  A statement
    -----------------
  println("hello")

  An expression --> something that returns.
  -------------------
  val x = println("hello")*/

  println("-31-") // 31
/*  Pure functions.

  The function’s output depends only on its input variables
    It doesn’t mutate any hidden state
  It doesn’t have any “back doors”: It doesn’t read data from the outside world (including the console, web services, databases, files, etc.), or write data to the outside world

  Impure functions.

  Read hidden inputs, i.e., they access variables and data not explicitly passed into the function as input parameters
    Write hidden outputs
  Mutate the parameters they are given
    Perform some sort of I/O with the outside world

  Example is an assignment.............*/

  println("-32-") // 32
  //Filtering and transformation

  val m1 = List(5, 12, 3, 13)

  //Applying filter method
  val result = m1.filter(_ < 10)
  // make result list with elements less than 10

  // Displays output
  println(result)
  //---------------------------------------------
  val map1 = Map(3 -> "geeks", 4 -> "for", 2 -> "cs")

  // Applying transform method
  val mapResult = map1.transform((key,value) => value.toUpperCase)
  // create new val, make all values of map1 uppercase

  // Displays output
  println(mapResult)

  println("-33-") // 33
  //FlatMap
  val name = Seq("Nidhi", "Singh")
  val result1 = name.map(_.toLowerCase)

  val result2 = result1.flatten
  //List(n, i, d, h, i, s, i, n, g, h)

  name.flatMap(_.toLowerCase)
  //List(n, i, d, h, i, s, i, n, g, h)

  println("-34-") // 34
  //1. Write a Scala program to compute the sum of the two given integer values. If the two values are the same, then return triples their sum.
  println("--1")

  def sumTriple(a:Int, b:Int) = {
    if (a == b) (a+b)*3
    else a+b
  }
  println(sumTriple(2,2))
  println(sumTriple(2,3))

  //2. Write a Scala program to create a new string with the last char added at the front and back of a given string of length 1 or more
  println("--2")
  def stringFunction(aString:String): String = {
    if (aString.length >= 1) {
      val lastChar = aString.charAt(aString.length - 1)
      lastChar + aString
    }else{
      "String cannot be empty"
    }

  }
  println(stringFunction("T"))
  println(stringFunction("Hello"))
  println(stringFunction(""))

  //3. Write a Scala program to get the absolute difference between n and 51. If n is greater than 51 return triple the absolute difference.
  println("--3")
  def theFiftyOne(n:Int):Int = {
    val absDiff = Math.abs(n - 51)
    if(n > 51) {3*absDiff} else {absDiff}
  }
  println(theFiftyOne(52))
  println(theFiftyOne(50))

  //4. Write a Scala program to check two given integers, and return true if one of them is 30 or if their sum is 30.
  println("--4")
  def thirtyCheck(a:Int,b:Int):Boolean = {
    if (a+b == 30 || a == 30 || b == 30 ) true else false
  }
  println(thirtyCheck(30,4))
  println(thirtyCheck(4,30))
  println(thirtyCheck(15,15))
  println(thirtyCheck(15,20))

  //5. Write a Scala program to check a given integer and return true if it is within 20 of 100 or 300.
  println("--5")
  def closeEnough(a:Int = 290):Boolean ={
    val oneHundred = Math.abs(a - 100)
    val threeHundred = Math.abs(a - 300)
    if ( oneHundred <= 20 || threeHundred <= 20) true else false
  }
  println(closeEnough(110))
  println(closeEnough(130))
  println(closeEnough(290))
  println(closeEnough(330))

  //6. Write a Scala program to create a new string where 'if' is added to the front of a given string. If the string already begins with 'if', return the string unchanged
  println("--6")
  def theIf(aString:String):String = {
    if (aString.charAt(0).toString + aString.charAt(1).toString == "if") aString else "if " + aString
  }
  println(theIf("if not"))
  println(theIf("only"))

  //7. Write a Scala program to remove the character in a given position of a given string.The given position will be in the range 0...string length -1 inclusive.
  println("--7")
  def removeCharAt(aString:String, a:Int): String = {
    if(a < 0 || a >= aString.length) "Out of Range" else aString.take(a) + aString.drop(a+1)
  }
  println(removeCharAt("This is a String", 13))

  //8. Write a Scala program to exchange the first and last characters in a given string and return the new string.
  println("--8")
  def headsTails(aString:String):String = {
    val a = aString.charAt(0).toString
    val b = aString.charAt(aString.length-1).toString
    var remainder = aString
    remainder = remainder.drop(1)
    remainder = remainder.take(aString.length-2)
    b + remainder + a

  }
  println(headsTails("This is a String"))


}



