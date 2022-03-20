object Assignment1{
  def main(args: Array[String]): Unit = {
    // Make comments for the code and explain what is going on if an error occurs.
    // This must be put into a .scala file.
    //1)
    10+2
    // Runs properly.
    //2)
    val msg = "Hello World"
    // Runs properly.
    //3)
    val msg1 = "Hello!"
    // The error stats: "Not found: msg", this is because msg has not been declared with val or var before
    // assignment.
    //4)
    var msg2 = "Hello World"
    // Runs properly.
    //5)
    val msg3 = "Hello!"
    // The error stats: "Not found: msg", this is because msg has not been declared with val or var before
    // assignment.
    //6)
    val msg4 = 3
    // The error stats: "Not found: msg", this is because msg has not been declared with val or var before
    // assignment.
    //7)
    val x = {val a=10;val b=100; b-a}
    // Runs properly.
    //8)
    val file = scala.io.Source.fromFile("C:\\Users\\bjgod\\IdeaProjects\\TestProject2\\src\\main\\scala\\kumar.txt").mkString

    val  m = { print ("foo "); 1}
    // The error stats: "java.lang.ExceptionInInitializerError ... ", this is because I do not have the
    // file named "kumar". This is fixed by putting in the absolute path to the kumar file.

    //10)
    var x1 = 5
    // Runs properly.

    //11)
    val x2 = 0
    val s = if (x> 0 && x<6) 1 else 0

    //vim Demo_1.scala

    object Demo_1{
      def main(args:Array[String]): Unit = {
        var x3=15;
        if( x3<20) {
          println("This is if statement");
        }
      } }
    // There was an error because x was not defined yet, vim is not a command in the IDE, and
    // ": Unit =" needed to be added to the main method.

    //12)
    val x4 = 0
    val t = if (x4> 0 && x4<6) "positive" else "negative"
    // There was an error because x was not defined yet.

    //13)
    var args1 = "hello"
    // The error states: "Found: ("hello" : String)
    //                    Required: Array[String]" This is because the name should be
    // changed from the argument in the main method. Thus, we change args to args1.
    //14)
    var args2 = new Array[String](3)
    args2.foreach(arg=>println(arg))
    // The error states: "java.lang.ExceptionInInitializerError ...", this is because we trying to
    // index through args which is defined in the main method. We can fix this by defining an Array
    // and indexing that instead.
    //15)
    var args3 = new Array[String](3)
    args3.foreach(println)

    val x5 = List(1,2,3)
    x5.foreach{println}
    // The error states: "java.lang.ExceptionInInitializerError ...", this is because we trying to
    // index through args which is defined in the main method. We can fix this by simply
    // defining an array as args1 and changing args to args1.

    //16)
    for(i<-1 to 5)
      println(i)
    // Runs properly.
    //17)
    val in  = "hello world"
    var sum = 0
    for (i<-0 until in.length) sum+=i
    print(sum)
    // Runs properly.
    //18)
    for(i<-1 to 3;j<-1 to 3)
      println(10*i+j)
    // Runs properly.
    //19)
    for(i<-1 to 3;j<-1 to 3 if i==j) println(10*i+j)
    // Runs properly.
    //20)
    for(i<-1 to 3;x=4-i;j<- x to 3) println(10*i+j)
    // Runs properly.
    //21)
    object Demo_4{
      def main(args:Array[String]): Unit = {
        val x6 = for(i<-1 to 20)yield i*2.5
        for (i<-x6) println(i)
        var a=10;
        while( a<20) {
          println("value of a = " + a);
          a = a+1;
        }
      }
    }
    // The ": Unit = " needed to be added, "val x = ..." and "for (i<-x)..." was moved
    // to the inside of the main method.

    //dowhile loop
    var nodb = 2

    do {
      nodb +=1
      println(s"nodb = $nodb")
    }while(nodb < 10)
    // Runs properly.


    //22)

    def sayhello(): Unit = {
      println("Hello")
    }

    def sum1(a:Int,b:Int): Unit = {
      println(a+b)
    }

    sum1(2,5)

    def func():Int={
      return 7
    }


    def sum2(a:Int,b:Any):Any= {
      println("hello")
    }
    // Just needed to add ": Unit =" to sayhello and sum.


    //23)
    def factorial(n:Int):Int=if(n==0)1 else n*factorial(n-1)

    object Demo{
      def main(args:Array[String]) = {
        var result= functionExamp(15,2)
        println(result)
      }
      def functionExamp(a:Int,b:Int):Int={
        if(b == 0)
          0
        else
          a+functionExamp(a,b-1)
      } }
    // Object had to change it to object.

    //24)
    def rect_area(length:Float,breadth:Float): Unit =
    { val area = length*breadth; print(area)}
    // Just needed to add ": Unit ="
    //25)

    //Arrays with values

    var a = Array(1,2,3)
    a(2)
    a(0)
    // a(4) is indexing too far. There are only 3 items and it starts at 0. The highest
    // it can go is 2.
    // Arrays without values
    var a1 = new Array[Int](3)
    a1(1)
    a1(1)= 2
    a1

    a = new Array[Int](10)
    val s5 = new Array[String](10)
    val st = Array("Hello","world")
    // Had to remove val because a has already been declared with var as an Int array.
    //26)
    import scala.collection.mutable.ArrayBuffer
    val a2 = ArrayBuffer[Int]()
    a2 +=1
    a2 +=(2,3,5)
    a2 ++=Array(6,7,8)
    // Runs properly.
    //practice for Array
    //-----------------------------------------------------------------
    //https://www.geeksforgeeks.org/scala-arrays/
     // ----------------------------------------------------------------

    //27) List
    val list = 1 :: 2 :: 3 :: Nil
    val list1 = List(1,2,3)
    val x7 = List(1,2.0,33D,4000L)
    val x8 = List.range(1,10)
    val x9 = List.fill(3)("foo")
    val x10 = List.tabulate(5)(n=>n*n)

    import scala.collection.mutable.ListBuffer
    var fruits = new ListBuffer[String]()
    fruits += "Apple"
    fruits += ("strawberry","kiwi")
    fruits -= ("Apple","kiwi")
    val fruitslists = fruits.toList


    val x14 = List(3)
    val y = 1 :: 2 :: x14
    val z = -1 :: y

    val originalList1 = List(7,8,4,3,2)
    val newList1 = originalList1.filter(_>3)

    val p = List(111,200,321)
    val q = List(4,-5,60)
    val r =  p ++ q
    val r1 = p ::: q
    val r2 = List.concat(p,q)


    val lst = List(1,2,3,4,5,6,7,8)
    lst.head
    lst.tail

    def sum3(l: List[Int]):Int = { if(l == Nil) 0 else l.head + sum3(l.tail)}
    val y1 = sum3(lst)

    //practice for Array
    //--------------------------------------------------------------------------
    //https://www.geeksforgeeks.org/scala-lists/
      //--------------------------------------------------------------------------

    //28)Tuples

    //A tuple is immutable, unlike an array in scala which is mutable. An example of a tuple storing an integer, a string, and boolean value. Type of tuple is defined by, the number of the element it contains and datatype of those elements

    import scala.language.postfixOps
    val a4 = (1,4, "Bob", "Jack")
    a4._2
    a4 _2

    val ab = (4,3,2,1)
    ab.productIterator.foreach{ i => println("value ="+i)}
    val t1 =("exam","test")
    println("swapped Tuple: " + t1.swap)
    val mn = (1,"wonderful",20.2356)
    println("concatenated String: " + mn.toString())
    // Need to import scala.language.postfixOps. The extra beginning paraenthesis had to be removed.
    //practice for Tuple
    //--------------------------------------------------------------
    //"https://www.geeksforgeeks.org/scala-tuple/"
    //--------------------------------------------------------------

    //29) set
    var s3 : Set[Int] = Set(1,3,5,7)
    var s1 = Set(7,9,8,9)
    var s2 = Set(10,11,12,13)
    s1++s2
    var x11 = Set(7,9,8,9)
    var x12 = Set(10,11,12,13)
    x11.++(x12)

    var a6 = Set(11,44,33,22)
    var b1 = Set(77,99,22,88)
    a6.&(b1)

    var a3 = Set(11,44,33,22)
    var b2 = Set(77,99,22,88)
    a3.intersect(b2)
    // The second a1 had to be changed to a2 and b1 had to be changed to b2.
    //practice for sets
    //-------------------------------------------------------------
    //https://www.geeksforgeeks.org/set-in-scala-set-1/
      //-------------------------------------------------------------


    //30)
    val mapping = Map("Vishal"-> "Kumar","Vijay" -> "verma")
    mapping.keys.foreach{i=>println(i+" "+mapping(i))}
    mapping.contains("Vishal")
    // Runs properly.
    //------------------------------------------------------------
    //https://www.geeksforgeeks.org/scala-map/
      //-----------------------------------------------------------

    //31)What is the difference between Expressions and Statements in Scala?

    //A statement
      //-----------------
    println("hello")

    //An expression --> something that returns.
    //-------------------
    val x13 = println("hello")

    //-------------------------------------------------------------
    //32) Pure functions.

    //The function’s output depends only on its input variables
      //It doesn’t mutate any hidden state
    //It doesn’t have any “back doors”: It doesn’t read data from the outside world (including the console, web services, databases, files, etc.), or write data to the outside world

    //Impure functions.

    //Read hidden inputs, i.e., they access variables and data not explicitly passed into the function as input parameters
     // Write hidden outputs
    //Mutate the parameters they are given
      //Perform some sort of I/O with the outside world

    //Example is an assignment.............

    //--------------------------------------------------------------
    //33)Filtering and transformation

    val m1 = List(5, 12, 3, 13)

    //Applying filter method
    val result = m1.filter(_ < 10)

    // Displays output
    println(result)
    //---------------------------------------------
    val m2 = Map(3 -> "geeks", 4 -> "for", 2 -> "cs")

    // Applying transform method
    val result1 = m2.transform((key,value) => value.toUpperCase)

    // Displays output
    println(result)
    //-----------------------------------------------

    //34)FlatMap
    val name = Seq("Nidhi", "Singh")
    val result3 = name.map(_.toLowerCase)

    val result2 = result3.flatten
    List('n', 'i', 'd', 'h', 'i', 's', 'i', 'n', 'g', 'h')

    name.flatMap(_.toLowerCase)
    List('n', 'i', 'd', 'h', 'i', 's', 'i', 'n', 'g', 'h')
    // I had to change all letters to have single quotes for it to run.
    //---------------------------------------------------------------------

    //1. Write a Scala program to compute the sum of the two given integer values. If the two values are the same, then return triples their sum.
    object SumObject{
      def main(args: Array[String]): Unit = {
        def SumFunction(x: Int, y: Int): Int = {
          if (x == y){
            return (x + y)*3
          }else{
            return x + y
          }
        }
      }
    }
    //2. Write a Scala program to create a new string with the last char added at the front and back of a given string of length 1 or more
    object ConcatObject{
      def main(args: Array[String]): Unit = {
        def AddLastFront(x: String): String = {
          return x.substring(0,1) + x + x.substring(0,1)
        }
      }
    }
    //3. Write a Scala program to get the absolute difference between n and 51. If n is greater than 51 return triple the absolute difference.
    object AbsoluteDiffObject{
      def main(args: Array[String]): Unit = {
        def AbsoluteDiffFunction(n: Int): Int = {
          if (n > 51){
            return (n-51).abs*3
          }else{
            return (n-51).abs
          }
        }
      }
    }
    //4. Write a Scala program to check two given integers, and return true if one of them is 30 or if their sum is 30.
    object CheckIntsObject{
      def main(args: Array[String]): Unit = {
        def CheckIntsFunction(x: Int, y: Int): Boolean = {
          return (x == 30) || ((x+y) == 30) || (y == 30)
        }
      }
    }
    //5. Write a Scala program to check a given integer and return true if it is within 20 of 100 or 300.
    object Within20Object{
      def main(args: Array[String]): Unit = {
        def Within20Function(x: Int): Boolean = {
          return ((80 to 100) contains x)||((280 to 300) contains x)
        }
      }
    }
    //6. Write a Scala program to create a new string where 'if' is added to the front of a given string. If the string already begins with 'if', return the string unchanged
    object AddingIfObject{
      def main(args: Array[String]): Unit = {
        def AddingIfFunction(x: String): String = {
          if (x.substring(0,2).toLowerCase() == "if"){
            return x
          }else{
            return "if" + x
          }
        }
      }
    }
    //7. Write a Scala program to remove the character in a given position of a given string.The given position will be in the range 0...string length -1 inclusive.
    object RemoveCharacterObject{
      def main(args: Array[String]): Unit = {
        def RemoveCharacterFunction(x: Int, y: String): String = {
          val a = x + 1
          return y.substring(0, a-1) + y.substring(a, y.length())
        }
      }
    }
    //8. Write a Scala program to exchange the first and last characters in a given string and return the new string.
    object ExchangeFirstLastObject{
      def main(args: Array[String]): Unit = {
        def ExchangeFirstLastFunction(x: String): String = {
          return x.substring(x.length() - 1) + x.substring(1, x.length - 1) + x.substring(0,1)
        }
      }
    }
  }
}