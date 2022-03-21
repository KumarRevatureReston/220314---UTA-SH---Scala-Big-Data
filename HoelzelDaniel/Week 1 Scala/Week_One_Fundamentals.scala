object Week_One_Fundamentals {
    //Unit is same as void
    def main(args: Array[String]): Unit = {
        //println({
        //1)
        //10 + 2
        //prints 12
        
        //2)
        //val msg = "Hello World"
        //msg
        //prints Hello World
        
        //3)
        //msg = "Hello!"
        //Error: cannot change a val after initialization
        
        //4
        //var msg = "Hello World"
        //msg
        //prints Hello World
        
        //5)
        //msg = "Hello"
        //msg
        //prints Hello
        
        //6)
        //msg = 3
        //error type mismatch
        
        //7)
        //val x = {val a=10; val b=100; b-a}
        //x
        //prints out 90
        
        //8)
        //val file = scala.io.Source.fromFile("kumar").mkString
        //error cannot find specified file however it would load a file from source and take a string from the file
        
        //9)
        //val m = {print ("foo "); 1}
        //prints foo () may be because I have 2 nested print statements
        
        //10)
        //var x = 5
        //x
        //prints 5
        
        //11)
        //val s = if (x>0 && x<=6) 1 else 0
        //s
        //prints 1
        
        //var x = 15
        //if(x<20){println("This is if statement")
        //}
        //prints This is if statement, however if you adjust the value to 20 or higher, prints nothing
        
        //12)
        //val t = if (x>0 && x<=6) "positive" else "negative"
        //t
        //prints negative because x is 15 which is >6 but not between 0 and 6
        
        //13)
        //var args = "hello"
        //args
        //prints hello
        
        //14)
        //args.foreach(arg=>println(arg))
        //prints each letter on a new line
        
        //15)
        //args.foreach(println)
        
        //val x = List(1,2,3)
        //x.foreach{println}
        //prints 1, 2, and 3 each on separate lines
        
        //16)
        //for (i <- 1 to 5) {
        //println(i)
        //prints 1 - 5 on different lines
        //}
        
        //17)
        //val in = "hello world"
        //var sum = 0
        //for (i<-0 until in.length) sum +=i
        //print(sum)
        //prints 55
        
        //18)
        //for(i<-1 to 3;j<-1 to 3) {
            //println(10*i+j)
            //prints 11 12 13 21 22 23 31 32 33 all on separate lines
        //}
    
        //19)
        //for(i<-1 to 3;j<-1 to 3 if i==j) println(10*i+j)
        //prints 11 22 33 all on separate lines.
        
        //20)
        //for(i<-1 to 3;x=4-i;j<- x to 3) println(10*i+j)
        //prints 13 22 23 31 32 33 all on separate lines.
    
        //21)
        //val x = for(i<-1 to 20)yield i*2.5
        //for (i<-x) println(i)
        //prints 20 lines each adding 2.5 to the last value.
    
        /*while loop
        vim Demo_4.scala
        Object Demo_4{
            def main(args:Array[String]) {
                var a=10;
                while( a<20) {
                    println("value of a = " + a);
                    a= a+1;
                }
            } }
    
    
        dowhile loop
        var nodb = 2
    
        do {
            nodb +=1
            println(s"nodb = $nodb")
        }while(nodb < 10)*/
        //errors
    
        //22)
        //def sayhello() {
        //    println("Hello")
        //}
        //does nothing
    
        //def sum(a:Int,b:Int) {
            //println(a+b)
        //}
    
        //sum(2,5)
        //prints 7
    
        //def func():Int={
            //return 7
        //}
        //does nothing
    
    
        //def sum(a:Int,b:Any):Any= {
            //println("hello")
        //}
        //does nothing
        
        //23)
        //def factorial(n:Int):Int=if(n==0)1 else n*factorial(n-1)
        
        //object Demo{
        
        //}
        
        //24)
        //def rect_area(length:Float,breadth:Float)
        //{ val area = length*breadth; print(area)}
        
        //rect_area(12,13)//prints 156.0
        
        //25)
        //val a = Array(1,2,3)
        //a(4) out of bounds of array. would need 0-2 or create a larger array.
        //a(0)//accesses the first element in array which would be 1
        
        //var a = new Array[Int](3)
        //a(1)// cannot access array as there are no values set
        //a(1)= 2 //sets this value to array index 1
        //a//does nothing
    
        //val a = new Array[Int](10)//creates an empty Int array with 10 locations for values
        //val s = new Array[String](10)//creates an empty String array with 10 locations for values
        //val st = Array("Hello","world")//creates a String array with 2 values
    
        //26)
        //import scala.collection.mutable.ArrayBuffer
        //val a = ArrayBuffer[Int]()
        //a +=1//adds 1 to the array an array buffer is a mutable array that can increase size as needed
        //a +=(2,3,5)//adds each value sequentially to the array
        //a ++=Array(6,7,8)//adds each value 6, 7, 8 in order to the array
        
        //27)
        //val list = 1 :: 2 :: 3 :: Nil//creates a list with 4 values the final being a null value
        //val list = List(1,2,3)//creates a list with 3 values
        //val x = List(1,2.0,33D,4000L)//creates a list with 4 different values. lists do not need the same data type like arrays do.
        //val x = List.range(1,10)//creates a list of 1-9, does not include the value 10
        //val x = List.fill(3)("foo")//creates a list foo, foo, foo
        //val x = List.tabulate(5)(n=>n*n)//creates list with values 0, 1, 4, 9, 16 which is squares of 0-4
    
        /*import scala.collection.mutable.ListBuffer
        var fruits = new ListBuffer[String]()//creates an empty lustbuffer
        fruits += "Apple"//adds apple to the front of the list
        fruits += ("strawberry","kiwi")//adds strawberry and kiwi to the list
        fruits -= ("Apple","kiwi")//removes apple and kiwi from the list
        val fruitslists = fruits.toList//tries to create a new list from the fruits that are in the fruits list which at this point would only be strawberry*/
    
    
        /*val x = List(3)//creates an list holding the value 3
        val y = 1 :: 2 :: x//creates a list holding the value 1, 2, and the list x
        val z = -1 :: y//creates a list with the value -1 and the entire list y*/
    
        //val originalList1 = List(7,8,4,3,2)//creates a list of the specified values
        //val newList1 = originalList1.filter(_>3)//creates a new list excluding any value of 3 or less, 7, 8, 4
    
        /*val p = List(111,200,321)//creates a list with the specified values
        val q = List(4,-5,60)//creates a list with the specified values
        //val r =  p ++ q//creates a list of 6 values starting with list p then list q 111,200, 321, 4, -5, 60
        //val r = p ::: q//creates the same list as the last example
        //val r = List.concat(p,q)//again creates the same list*/
    
        //val lst = List(1,2,3,4,5,6,7,8)
        //lst.head//does nothing by itself but println would make it print the 1st element of the list, 1
        //lst.tail//does nothing by itself but println would make it print the last element of the list, 8
    
        //def sum(l: List[Int]):Int = { if(l == Nil) 0 else l.head + sum(l.tail)}//adds a list togeather any Nil value will add 0
        //val y = sum(lst)//uses the above function to add together all elements of lst which adds up to 36
    
        //28)Tuples
    
        //A tuple is immutable, unlike an array in scala which is mutable. An example of a tuple storing an integer, a string, and boolean value. Type of tuple is defined by, the number of the element it contains and datatype of those elements
    
        //val a = (1,4, "Bob", "Jack")
        //(a._2)//does nothing by itself but is the 2nd element of the tuple which is 4
        //a  _2 gives error int does not take parameters
    
        /*val ab = (4,3,2,1)//creates a tuple with 4 elements
        ab.productIterator.foreach{ i => println("value ="+i)}//prints each element in the tuple on a different line
        val t =("exam","test")//creates a tuple with 2 elements
        println("swapped Tuple: " + t.swap) //prints the previous tuple with their order swapped
        val mn = (1,"wonderful",20.2356) //creates a tuple with 3 elements
        println("concatenated String: " + mn.toString()) //concatenates the tuple to a single string*/
        
        //29) Set
        /*var s : Set[Int] = Set(1,3,5,7) //creates a set of the given values
        var s1 = Set(7,9,8,9) //creates a set of the given values but since each value is unique, there is only 1 value of 9 not 2
        var s2 = Set(10,11,12,13)//creates a set of the given values
        s1++s2//merges the sets but when printing, gives the values in a strange order 10, 9, 13, 12, 7, 11, 8
        
        var x1 = Set(7,9,8,9)
        var x2 = Set(10,11,12,13)
        x1.++(x2)
    
        var a1 = Set(11,44,33,22)//creates set with values
        var b1 = Set(77,99,22,88)//creates set with these values
        a1.&(b1) //& operator returns the value in the 2 sets that intersect or match. in these 2 sets, 22 is the only value that is in both
    
        var a1 = Set(11,44,33,22)
        var b1 = Set(77,99,22,88)
        a1.intersect(b1) // does the same as the & operator*/
        
        //30)
        //val mapping = Map("Vishal"-> "Kumar","Vijay" -> "verma") //Maps the 2nd value of each to the 1st
        //mapping.keys.foreach{i=>println(i+" "+mapping(i))} //prints 2 separate lines with the 2 value
        //mapping.contains("Vishal") //checks if the value is contained in the given map
        
        //31) statements/expressions
        //Statement
        //println("hello")
        
        //An expression is something that returns
        //val x = println("hello")
        
        //32) pure/impure functions
        //a pure function does not change any values
        /*def square(a: Int) = {
            var b: Int = a * a;
            println("Square of the number is " + b);
            println("Number is " + a);
        }
        square(4);
    
        //impure functions actually change the value of a var
        var someValue = 20
        def myImpureSum(a: Int, b: Int) = {
            println("Doing some sum work")
            someValue = a + b + someValue
            println(someValue)
        }
        myImpureSum(1, 2)*/
        
        //33)
        /*val m1 = List(5, 12, 3, 13)
    
        //Applying filter method
        val result = m1.filter(_ < 10)
    
        // Displays output
        println(result)
        //result is List(5, 3)*/
        //})
    }
}