import scala.io.Source

object scala_examples {
    def main(args:Array[String]): Unit = {

        println("Question 1")
            //10+2
            //alternatively, to literally print the question it would be: println("10+2")
        println(10+2)
            

        println("Question 2")
            //val msg = "Hello World"
            //val is immutable, making msg unusable in the future
        val msg = "Hello World"
        println(msg)

        println("Question 3")
            //msg="Hello!"
            //there are many ways to print "Hello!", but this is the easiest
            //attempted to use "msg" as a var but error due to "msg" already defined as val
        println("Hello!")
            

        println("Question 4")
            //var msg = "Hello World"
            //val "msg" is immutable and also can't change the val to a var
            //changed string name to msg1
        var msg1 = "Hello World"
        println(msg1)

        println("Question 5")
            //msg="Hello!"
            //since variables are mutable, I changed the value of msg1 from question 4
        msg1 = "Hello"
        println(msg1)

        println("Question 6")
            //msg = 3
        println(3)

        println("Question 7")
            //val x = {val a=10;val b=100; b-a}
            //causes the result of 90 because 100-10 is b-a
            //printed the value for x
        val x = {
            val a = 10
            val b = 100
            b-a
        }
        println(x)

        println("Question 8")
            //val file = scala.io.Source.fromFile("kumar").mkString
            //runs an error because it can't find "kumar.txt" even though I made such a file
            //I imported scala.io.Source at the top and as a part of the question but neither worked
            //my attempt is as follows:
                //val file = Source.fromFile("kumar.txt").mkString
                //println(file)


        println("Question 9")
            //val  m = { print ("foo "); 1}
            //print as opposed to println won't drop next line of text to a new line
            //this causes the title for question 10 to be added to the end of the result for question 9
            //I'm unsure what the 1 is for in this problem
        val m = {
            print("foo")
            1
        }

        println("Question 10")
            //var x = 5
            //tried to change the value of x to 5 but val is immutable
            //created a new string name of x2
        var x2 = 5
        println(x2)

        println("Question 11")
            //val s = if (x> 0 && x<6) 1 else 0
            //pulls the value of x from question 7 which makes x = 90 -> 0
        val s = {
            if(x > 0 && x < 6) {
                println("1")
            }
            else {
                println("0")
            }
        }

        println("Question 12")
            //val t = if (x> 0 && x<6) "positive" else "negative"
            //pulls the value of x from question 7 just like question 11, meaning x = 90 -> negative
        val t = {
            if(x > 0 && x < 6) {
                println("positive")
            }
            else {
                println("negative")
            }
        }

        println("Question 13")
            //var args = "hello"
            //used an argument to allow someone to enter their name and be greeted with a "hello, "their name""
        def printGreeting(name: String): Unit = {
            println("Hello," + " " + name)
        }
        printGreeting("Jessica")

        println("Question 14")
            //args.foreach(arg=>println(arg))
            //used a vector to list dogs, then used .foreach to print each dog name
        val dogs = Vector("Spot", "Bingo", "Clifford", "Dogzilla")
        dogs.foreach {
            println
        }

        println("Question 15")
            //args.foreach(println); val x = List(1,2,3); x.foreach{println}
            //changed the val since "x" has already been used and val is immutable
            //the same process as question 14 but using a numbered list rather than a string vector
        val z = List(1,2,3)
        z.foreach {
            println
        }

        println("Question 16")
            //for(i<-1 to 5); println(i)
            //causes i to print the results 1, 2, 3, 4, 5
        for(i <- 1 to 5) {
            println(i)
        }

        println("Question 17")
            //val in  = "hello world"; var sum = 0; for (i<-0 until in.length) sum+=i; print(sum)
            //the for loop creates 11 0s because sum=o and there are 11 chacters in "in"
            //since 0-11 is 12, there is one less 0 because the "until" causes the loop to stop one before a "to" would
            //replacing the "until" with a "to" would cause another 0 to be added
            //print() instead of println() doesn't drop the next result to drop to a new line, so question 18's title is added to the end without a break
        val in = "hello world"
        var sum = 0
        for(i <- 0 until in.length)
        print(sum)

        println("Question 18")
            //for(i<-1 to 3;j<-1 to 3); println(10*i+j)
            //the result is (11,12,13,21,22,23,31,32,33)
            //this prints the values for the math: (10 * 1 + (1 -> 3)), then (10 * 2 + (1 -> 3)), and last (10 * 3 + (1 -> 3))
        for(i <- 1 to 3; j <- 1 to 3)
        println{10 * i + j}

        println("Question 19")
            //for(i<-1 to 3;j<-1 to 3 if i==j); println(10*i+j)
            //the result is (11,22,33)
            //only the results of (10 * 1 + 1), (10 * 2 + 2), and (10 * 3 + 3) are printed because i and j share the same value at these points
        for(i <- 1 to 3;j <- 1 to 3 if i == j)
        println(10 * i + j)

        println("Question 20")
            //for(i<-1 to 3;x=4-i;j<- x to 3) println(10*i+j)
            //the result is (13,22,23,31,32,33)
            //since x is 4 - 1 and j is now the value of x to 3,
            //when i is 1, x would be 3[4-1] 
            //since j stops after 3 this would cause only one result: (10 * 1 + 3)
            //when i is 2, x would be 2[4-2], causing j to be 2 and 3
            //the results for the following equations would be printed when x = 2: (10 * 2 + 2) and (10 * 2 + 3)
            //when i is 3, x would be 1[3-2] causing j to be 1 to 3
            //prints results for: (10 * 3 + 1), (10 * 3 + 2), and (10 * 3 + 3)
        for(i <- 1 to 3;x = 4 - i;j <- x to 3)
        println(10 * i + j)

        println("Question 21")
            //val x = for(i<-1 to 20)yield i*2.5; for (i<-x) println(i)
            //x has already been defined above, so I used b
            //results: (1 * 2.5 = 2.5), (2 * 2.5 = 5.0), and so on until the original i = 20 and (i <- b) = 50; [20 * 2.5]
            //yield causes for to be used as an expression instead of a statement and returns the results of the for loop
            //println() then prints the results of a for loop, unlike yield
        val b = for(i <- 1 to 20)
        yield i * 2.5
        for(i <- b)
        println(i)
            //while loop (part 2?)
            //Object Demo_4{def main(args:Array[String]) {var a=10; while( a<20) {println("value of a = " + a); a= a+1}}}
            //since a is redefined after the println(), the first result of the expression uses the original value of a (10)
            //after a is redefined, the loop continues running the code until a = 20
        var a = 10
        while(a < 20) {
            println("value of a = " + a)
            a = a + 1
        }
            //dowhile loop (part 3?)
            //var nodb = 2; do {nodb +=1; println(s"nodb = $nodb")}; while(nodb < 10)
            //basically does the same thing as the while loop but tests the condition at the end
            //since do while loop is used, the original value of nodb (2) is never returned and the first result is 3
            //this is the first time I've seen "s" in println; it seems like this causes a string to be identified
            //also the $ symbol allows you to call an expression inside of quotes
        var nodb = 2
        do {
            nodb += 1
            println(s"nodb = $nodb")
        }
        while(nodb < 10)

        println("Question 22")
            //def sayhello(); {println("Hello"); def sum(a:Int,b:Int) {println(a+b)}; sum(2,5); def func():Int={return 7}; def sum(a:Int,b:Any):Any= {println("hello")}
            //this is simiar to my greeting in question 13, but their is no print feature provided, so there is no output
            //called expression to return "Hello"
        def sayhello() {
            println("Hello")
        }
        sayhello()
            //sum was previously declared a variable so I changed to sum2
            //this declares that a and b are integers and then prints the result of adding the two numbers provided in sum2() at the bottom
        def sum2(a:Int,b:Int) {
            println(a+b)
        }
        sum2(2,5)
            //this function returns the value 7 to func() expression; I printed the expression to show the value of func()
        def func():Int = {
            return 7
        }
        println(func())
            //assuming that the question wants to use the same expression name (sum2 in this case), it causes a conflicting symbols since sum2 is defined twice
            //changed to sum3
            //called expression sum3 while making a = 2 and b = "hi", which causes "hello" to be printed
            //as long as an integer is used for a and any value is used for b, "hello" will be printed
        def sum3(a:Int,b:Any): Any = {
            println("hello")
        }
        sum3(2, "hi")
        
        println("Question 23")
            //def factorial(n:Int):Int=if(n==0)1 else n*factorial(n-1)
            //this uses the value of the expression inside of the expression itself
        def factorial(n: Int): Int = if(n == 0) 1 else n * factorial(n - 1)
        println(factorial(2))
        
        println("Question 24")
            //def rect_area(length:Float,breadth:Float); { val area = length*breadth; print(area)}
            //calculates the area of a rectangle with given length and breadth
            //I gave values for length and breadth so that there would be a result
        def rect_area(length:Float, breadth:Float) {
            val area = length * breadth
            print(area)
        }
        rect_area(3, 6)
        println("Question 25")
            //Arrays with values: var a = Array(1,2,3); a(4); a(0)
            //previously declared a, so changed name to d
            //since there is no 4th index of the array, there is an error saying Array index out of range
            //either the array needs more numbers, or change the inputted value for d() to a number between 0 and 2
            //I changed d(4) to d(2) to fix the error
            //d(0) works because indexes start at 0, not 1
        var d = Array(1,2,3)
        println(d(2))
        println(d(0))

        println("Question 26")
            //import scala.collection.mutable.ArrayBuffer; val a = ArrayBuffer[Int](); a +=1; a +=(2,3,5); a ++=Array(6,7,8)
            //the "+=" appends the given value(s) to the end of the desirec array
            //++=Array appends a newly created array to the end of the desired array
        import scala.collection.mutable.ArrayBuffer
        val h = ArrayBuffer[Int]()
        h +=1
        h +=(2,3,5)
        h ++=Array(6,7,8)
        println(h)
    }
}