1) 
10+2 //prints 12

2)
val msg = "Hello World" // assigns "Hello World" to the val msg

3)
msg="Hello!" // Throws an error for trying to reassign a val (immutable)

4)
var msg = "Hello World" // assigns "Hello World" to the var msg

5)
msg="Hello!" // Compiles correctly, reassigns the var (mutable)

6)
msg = 3 // Error, expects a string instead of an int

7)
val x = {val a=10;val b=100; b-a} // Assigns vals a, b, and c to x

8)
val file = scala.io.Source.fromFile("kumar").mkString  // Prints out string from the file "kumar"

val  m = { print ("foo "); 1} // prints out "foo"


10)
var x = 5 // Assigns Int 5 to var x

11)
val s = if (x> 0 && x<6) 1 else 0 // conditionally assigns to val s dependant on var x

vim Demo_1.scala

Object Demo_1{
def main(args:Array[String]) {
var x=15;
if( x<20) {
println("This is if statement");
}
} }


12)
val t = if (x> 0 && x<6) "positive" else "negative" // conditionally assigns val t based on var x
// if you added println(t), it would then print out "positive"

13)
var args = "hello" // Assigns "hello" to the string array in main

14)
args.foreach(arg=>println(arg)) // prints out each letter in args

15)
args.foreach(println) // alternative way of using println on each var in args

val x = List(1,2,3) // Assigns a list of ints to val x
x.foreach{println} // prints each individual value in x


16)
for(i<-1 to 5) // creates for loop from 1 to 5
println(i) // prints out i each step of loop

17)
val in  = "hello world" // assigns a string to val in
var sum = 0 // assigns int 0 to var sum
for (i<-0 until in.length) sum+=i // creates loop from 0 to the length of val in, then adds iterator to the var sum
print(sum) // prints out the sum after the loop (55)

18)
for(i<-1 to 3;j<-1 to 3) // creates a nested for loop for i from 1 to 3 and for j from 1 to 3
println(10*i+j) // prints out 10*i+j for each step of the nested loop (11,12,13,21,22,23,31,32,33)

19)
for(i<-1 to 3;j<-1 to 3 if i==j) println(10*i+j) // Only prints out the step of the nested loop when i is equal to j (11, 22, 33)

20)
for(i<-1 to 3;x=4-i;j<- x to 3) println(10*i+j) // Prints out the values of the loop, only the the j loop is dependant on x which is dependant on i (13,22,23,31,32,33)

21)
val x = for(i<-1 to 20)yield i*2.5 // assigns a loop to val x which yields a value
for (i<-x) println(i) // then prints each value of loop

//while loop
vim Demo_4.scala
Object Demo_4{
def main(args:Array[String]) {
var a=10; // creates var a and assigns Int 10
while( a<20) {  // create while loop while a < 20
println("value of a = " + a); // print a
a= a+1; // add 1 to a, then continue loop
}
} } 


//dowhile loop
var nodb = 2

do {
nodb +=1 // adds 1 to var nodb
println(s"nodb = $nodb") // print to new line
}while(nodb < 10)  // executes the loop while var nodb is less than 10



22)

def sayhello() { //method to print out "Hello"
println("Hello")
}

def sum(a:Int,b:Int) { // creates a sum method to print the sum of a and b
println(a+b)
}

sum(2,5) // executes the method sum

def func():Int={ 
return 7
}


def sum(a:Int,b:Any):Any= { // Creates an overloaded method for sum, which will print out hello
println("hello")
}



23)
def factorial(n:Int):Int=if(n==0)1 else n*factorial(n-1)

Object Demo{
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


24)
def rect_area(length:Float,breadth:Float) // creates a method to get the area of a rect, given two floats, and prints the area
{ val area = length*breadth; print(area)}

25)

Arrays with values

var a = Array(1,2,3) // creates an array a with ints
a(4) // throws index 4 out of bounds, the length is 3
a(0) // prints 1

Arrays without values
var a = new Array[Int](3) // creates array of ints length 3
a(1) // index 1 of a is 0
a(1)= 2 // assigns 2 to index 1 of a
a
 
val a = new Array[Int](10) // creates array of Ints, all are 0
val s = new Array[String](10) // creates array of strings, all are null
val st = Array("Hello","world") // creates array with two strings

26)
import scala.collection.mutable.ArrayBuffer
val a = ArrayBuffer[Int]()
a +=1 // adds 1 to the end of a
a +=(2,3,5) // adds 2, 3, and 5 to the end of a
a ++=Array(6,7,8) //adds an array with 6, 7, and 8 to the end of a

practice for Array
-----------------------------------------------------------------
https://www.geeksforgeeks.org/scala-arrays/
----------------------------------------------------------------

27) List
val list = 1 :: 2 :: 3 :: Nil
val list = List(1,2,3)
val x = List(1,2.0,33D,4000L)
val x = List.range(1,10)
val x = List.fill(3)("foo")
val x = List.tabulate(5)(n=>n*n)

import scala.collection.mutable.ListBuffer
var fruits = new ListBuffer[String]()
fruits += "Apple"
fruits += ("strawberry","kiwi")
fruits -= ("Apple","kiwi")
val fruitslists = fruits.toList


val x = List(3)
val y = 1 :: 2 :: x
val z = -1 :: y

val originalList1 = List(7,8,4,3,2)
val newList1 = originalList1.filter(_>3)

val p = List(111,200,321)
val q = List(4,-5,60)
val r =  p ++ q
val r = p ::: q
val r = List.concat(p,q)


val lst = List(1,2,3,4,5,6,7,8)
lst.head
lst.tail

def sum(l: List[Int]):Int = { if(l == Nil) 0 else l.head + sum(l.tail)}
val y = sum(lst)

practice for Array
--------------------------------------------------------------------------
https://www.geeksforgeeks.org/scala-lists/
--------------------------------------------------------------------------

28)Tuples

A tuple is immutable, unlike an array in scala which is mutable. An example of a tuple storing an integer, a string, and boolean value. Type of tuple is defined by, the number of the element it contains and datatype of those elements

val a = (1,4, "Bob", "Jack")
a._2
a _2

val ab = (4,3,2,1)
ab.productIterator.foreach{ i => println("value ="+i)}
val t =("exam","test")
println(("swapped Tuple: " + t.swap)
val mn = (1,"wonderful",20.2356)
println("concatenated String: " + mn.toString())

practice for Tuple
--------------------------------------------------------------
"https://www.geeksforgeeks.org/scala-tuple/"
--------------------------------------------------------------

29) set
var s : Set[Int] = Set(1,3,5,7)
var s1 = Set(7,9,8,9)
var s2 = Set(10,11,12,13)
s1++s2
var x1 = Set(7,9,8,9)
var x2 = Set(10,11,12,13)
x1.++(x2)

var a1 = Set(11,44,33,22)
var b1 = Set(77,99,22,88)
a1.&(b1)

var a1 = Set(11,44,33,22)
var b1 = Set(77,99,22,88)
a1.intersect(b1)

practice for sets
-------------------------------------------------------------
https://www.geeksforgeeks.org/set-in-scala-set-1/
-------------------------------------------------------------


30)
val mapping = Map("Vishal"-> "Kumar","Vijay" -> "verma")
mapping.keys.foreach{i=>println(i+" "+mapping(i))}
mapping.contains("Vishal")

------------------------------------------------------------
https://www.geeksforgeeks.org/scala-map/
-----------------------------------------------------------

31)What is the difference between Expressions and Statements in Scala?

A statement
-----------------
println("hello")

An expression --> something that returns.
-------------------
val x = println("hello")

-------------------------------------------------------------
32) Pure functions.

The function’s output depends only on its input variables
It doesn’t mutate any hidden state
It doesn’t have any “back doors”: It doesn’t read data from the outside world (including the console, web services, databases, files, etc.), or write data to the outside world

Impure functions.

Read hidden inputs, i.e., they access variables and data not explicitly passed into the function as input parameters
Write hidden outputs
Mutate the parameters they are given
Perform some sort of I/O with the outside world

Example is an assignment.............

--------------------------------------------------------------
33)Filtering and transformation

val m1 = List(5, 12, 3, 13)
          
//Applying filter method
val result = m1.filter(_ < 10)
          
// Displays output
println(result)
---------------------------------------------
val m1 = Map(3 -> "geeks", 4 -> "for", 2 -> "cs")
          
// Applying transform method
val result = m1.transform((key,value) => value.toUpperCase)
          
// Displays output
println(result)
-----------------------------------------------

34)FlatMap
val name = Seq("Nidhi", "Singh")
val result1 = name.map(_.toLowerCase)

val result2 = result1.flatten
List(n, i, d, h, i, s, i, n, g, h)

name.flatMap(_.toLowerCase)
List(n, i, d, h, i, s, i, n, g, h)
---------------------------------------------------------------------

1. Write a Scala program to compute the sum of the two given integer values. If the two values are the same, then return triples their sum. 
def sum(a:Int,b:Int):Int = { if(a == b) 3*(a+b) else a+b}
sum(4,5) //9
sum(5,5) //30

2. Write a Scala program to create a new string with the last char added at the front and back of a given string of length 1 or more
def newS(s:String):String = { if(s.length > 0) s(s.length - 1) + s + s(s.length - 1) else s }
newS("hello") //ohelloo

3. Write a Scala program to get the absolute difference between n and 51. If n is greater than 51 return triple the absolute difference.
def adiff(n:Int):Int = { if (n > 51) 3*(n - 51) else 51 - n }
adiff(30) //21
adiff(80) //87

4. Write a Scala program to check two given integers, and return true if one of them is 30 or if their sum is 30.
def test(a:Int,b:Int):Boolean = { if (a == 30 || b == 30 || a+b == 30) true else false }
test(4,5)//false
test(14,16) //true
test(30,45) //true
test(15,30) //true

5. Write a Scala program to check a given integer and return true if it is within 20 of 100 or 300.
def test(a:Int):Boolean = { if ( a > 79 && a < 121 ) true else if( a > 279 && a < 321 ) true else false }
test(5) //false
test(88) //true
test(155) //false
test(299) //true

6. Write a Scala program to create a new string where 'if' is added to the front of a given string. If the string already begins with 'if', return the string unchanged
def iftest(a:String):String = { if (a(0) == 'i' && a(1) == 'f') a else "if" + a }
iftest("test") //iftest
iftest("infinite") //ifinfinite
iftest("offer") //ifoffer
iftest("iffy") //iffy

7. Write a Scala program to remove the character in a given position of a given string.The given position will be in the range 0...string length -1 inclusive. 
def removechar(s:String,i:Int):String = 
{
    if (i > -1 && i < s.length) // Does the index fall within the string size
        var snew = ""
        for(j <- 0 until (s.length - 1)) // iterate thru snew
            if (j > i-1) 
                snew += s(j+1) // shift chars after index
            else
                snew += s(j) // copy chars before index
        return snew
    else 
        return s // return if index outside of length
}

removechar("abcde", 2) // returns abde
removechar("abcde", 50) // returns abcde

8. Write a Scala program to exchange the first and last characters in a given string and return the new string. 
def swap(s:String):String =
{
    var snew = ""
    if (s.length > 1)
        snew += s.charAt(s.length-1)
        if (s.length > 2)
            for (i<-1 until s.length-1)
                snew += s.charAt(i)
        snew += s.charAt(0)
        return snew
    else
        return s
}
swap("lollipops") // returns sollipopl

Source----
"https://www.w3resource.com/scala-exercises/basic/index.php"



