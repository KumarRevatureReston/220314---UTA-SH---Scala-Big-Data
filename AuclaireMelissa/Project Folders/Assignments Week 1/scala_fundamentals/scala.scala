package scala_fundamentals

import scala.collection.immutable.Seq
import scala.io.Source
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer

// This refers to the Scala_fundamentals.txt worksheet file handed posted to our Discord channel.

// Scala Example 1: Hello Scala
// the following example is a simple Scala program

object ScalaExample {
  def lb(x: Int): Unit = {
    println()
    println(x+1)
  }
  def main(args:Array[String]): Unit = {
    var argsa:Array[String] = new Array[String](3)
    var argsb = new Array[String](3)

    // 1
    println(10+2)
    lb(1)

    // 2
    //val msg = "Hello World"

    // 3
    //msg = "Hello"

    // 4
    var msg = "Hello World"

    // 5
    msg = "Hello"

    // 6
    //msg = 3

    // 7
    val x = {val a=10;val b=100; b-a}

    // 8
    //val file = scala.io.Source.fromFile("kumar").mkString
    val filename = "/home/charmi/Downloads/revature/scala/scalademo/src/kumar"
    for (line <- Source.fromFile(filename).getLines) { println(line) }
    lb(8)

    // 9
    val m = { print ("foo"); 1}
    lb(9)

    // 10
    var x2 = 5

    // 11
    val s = if(x > 0 && x < 6) 1 else 0

    object Demo_1 {
      def main(args:Array[String]): Unit = {
        var x = 15
        if(x < 20) {
          println("This is if statement")
        }
      }
    }
    lb(11)

    // 12
    val t = if(x > 0 && x < 6)  "positive" else "negative"

    // 13
    var args = "hello"

    //14
    args.foreach(arg=>println(arg))
    lb(14)

    // 15
    args.foreach(println)
    val x3 = List(1,2,3)
    x3.foreach{println}

    // 16
    for(i<-1 to 5)
      println(i)
    lb(16)


    // 17
    val in = "hello world"
    var sum = 0
    for(i<-0 until in.length)
      sum += i
    print(sum)
    lb(17)

    // 18
    for(i<-1 to 3;j<-1 to 3)
      println(10*i+j)
    lb(18)

    // 19
    for(i<-1 to 3;j<-1 to 3 if i==j)
      println(10*i+j)
    lb(19)

    // 20
    for(i<-1 to 3;x=4-i;j<- x to 3)
      println(10*i*j)
    lb(20)

    // 21
    val x4 = for(i4<-1 to 20)yield i4*2.5
    for(i5<-x4)
      println(i5)
    //while loop
    object Demo4 {
      def main(args:Array[String]): Unit = {
        var a = 10
        while(a < 20) {
          println("value of a = " + a)
          a = a+1
        }
      }
    }
    // dowhile loop
    var nodb = 2
    do {
      nodb += 1
      println(s"nodb = $nodb")
    } while(nodb < 10)
    lb(21)

    // 22
    def sayHello(): Unit = {
      println("Hello")
    }
    def sumf(a:Int, b:Int): Unit = {
      println(a+b)
    }
    sumf(2,5)
    def func():Int={
      return 7
    }
    // method overloading?
    def sumf2(a:Int,b:Any):Any = {
      println("hello")
    }
    lb(22)

    // 23
    def factorial(n:Int):Int=if(n == 0) 1 else  n*factorial(n-1)
    // Object
    object Demo {
      def main(args:Array[String]) = {
        var result = functionExamp(15,2)
        println(result)
      }
      def functionExamp(a:Int,b:Int):Int={
        if(b == 0)
          0
        else
          a + functionExamp(a, b-1)
      }
    }
    Demo.main(argsb)
    lb(23)

    // 24
    def rect_area(length:Float, breadth:Float): Unit = {
      val area = length*breadth
      print(area)
    }
    rect_area(3.0f,3.0f)
    lb(24)

    // 25
    // Arrays with values
    var arr = Array(1,2,3)
    //arr(4)
    arr(0)
    arr
    val array = new Array[Int](10)
    val srr = new Array[String](10)
    val st = Array("Hello", "World")

    // 26
    val array26 = ArrayBuffer[Int]()
    array26 += 1
    array26 += (2,3,5)
    array26 ++=Array(6,7,8)

    // 27
    val list = 1 :: 2 :: 3 :: Nil
    val x27 = List(1,2.0,33D,4000L)
    val x272 = List.range(1,10)
    val x273 = List.fill(3)("foo")
    val x274 = List.tabulate(5)(n=>n*n)
    var fruits = new ListBuffer[String]()
    fruits += "Apple"
    fruits += ("strawberry","kiwi")
    fruits -= ("Apple", "kiwi")
    val fruitslist = fruits.toList
    println(fruitslist)
    val x275 = List(3)
    val y27 = 1 :: 2 :: x275
    val z27 = -1 :: y27
    val originalList1 = List(7,8,4,3,2)
    val newList1 = originalList1.filter(_>3)
    val p27 = List(111,200,321)
    val q27 = List(4, -5, 60)
    val r27 = p27 ++ q27
    val r272 = p27 ::: q27
    val r273 = List.concat(p27,q27)
    val lst = List(1,2,3,4,5,6,7,8)
    println(lst.head)
    println(lst.tail)
    def sum27(l: List[Int]):Int = { if(l == Nil) 0 else l.head + sum27(l.tail)}
    val y272 = sum27(lst)
    lb(27)

    // 28
    val w  = (1,4,"Bob","Jack")
    w._2
    //w _2
    val ab = (4,3,2,1)
    ab.productIterator.foreach{ i => println("value ="+i)}
    val t28 = ("exam", "test")
    println("swapped Tuple: " + t28.swap)
    val mn = (1,"wonderful",20.2356)
    println("concantenated String: " + mn.toString())
    lb(28)

    // 29
    var s29 : Set[Int] = Set(1,3,5,7)
    var s291 = Set(7,9,8,9)
    var s292 = Set(10,11,12,13)
    s291++s292
    var x291 = Set(7,9,8,9)
    var x292 = Set(10,11,12,12)
    x291.++(x292)
    var a291 = Set(11,44,33,22)
    var b291 = Set(77,99,22,88)
    a291.&(b291)
    var a292 = Set(11,44,33,22)
    var b292 = Set(77,99,22,88)
    a292.intersect(b292)

    // 30
    val mapping = Map("Vishal" -> "Kumar", "Vijar" -> "verma")
    mapping.keys.foreach{i=>println(i+" "+mapping(i))}
    mapping.contains("Vishal")

    // 31
    println("hello")
    val x31 = println("hello")
    lb(31)

    // 32
    // The function’s output depends only on its input variables
    // It doesn’t mutate any hidden state
    // It doesn’t have any “back doors”:
    // It doesn’t read data from the outside world (including the console, web services, databases, files, etc.),
    // or write data to the outside world
    //
    // Impure functions.
    //
    // Read hidden inputs, i.e., they access variables and data not explicitly
    // passed into the function as input parameters
    // Write hidden outputs
    // Mutate the parameters they are given
    // Perform some sort of I/O with the outside world
    //
    // Example is an assignment.............

    // 33
    val m1 = List(5,12,3,13)
    val result = m1.filter(_ < 10)
    println(result)
    val m331 = Map(3 -> "geeks", 4-> "for", 2 -> "cs")
    val result33 = m331.transform((key,value) => value.toUpperCase)
    println(result33)
    lb(33)

    // 34
    val name = Seq("Nidhi","Singh")
    val result341 = name.map(_.toLowerCase)
    val result342 = result341.flatten
    name.flatMap(_.toLowerCase())
  }
}