package assignmentthree

val a=10;val b=100; b-a}

//x has assigned a to equal 10 and b to equal 100 while also wanting a to be subtracted from b. //There will be no out as println has not been. used to reference.

//8
val file = scala.io.Source.fromFile("kumar").mkString  val  m = { print ("foo "); 1}

//This code is retrieving a file from file of kumar and using 'm' to output foo and 1. There is an exception because the code// can't retrieve kumar. It will not be able to run m because the println has to be produce "foo" + 1 instead to get the //necessary output.




//9
val s = if (x> 0 && x<6) 1 else 0

//The value of s is creating a conditional statement is x is greater 0 and less than 6 then it will produce 1 if not it will use
//else to produce 0.

//10
vim Demo_1.scala

//This section is used to reference Demo_1. from scala

Object Demo_1{ // Object needs to be lowercase to object.
def main(args:Array[String]) { //defining the method and creating arguements for String.
var x=15; // assigning x to have the value of 15
if( x<20) { // creating a condition if value is less then 20
println("This is if statement"); //then produce "this is if statement."
}
} }



//11)
val t = if (x> 0 && x<6) "positive" else "negative"
  // value of t is imuttable. It is trying a condition statement where if x is greater than 0
  //and less 6 then it would come out positive then uses an 'else' statement to say negative if otherwise.
  //There are no println references as well no curly brackets to create the block for the condition.

//12)
var args = "hello"
// This mutable and assigns 'arg' with the value of "hello". There will be no output with no println references.

//13)
args.foreach(arg=>println(arg))

  //This is trying to refer each arg within an structure to have the output using println of arg.
  //The println needs to be separate in this expression to complete the output and run.

//14)
args.foreach(println)
  // This is trying to println reference for each variable inside of the "args"


//15
val x = List(1,2,3) // This is trying to create a list that is immutable. //There will be an error due to
  //the wrong positions of list in the expression.
x.foreach{println} //this code is attempting to assign a printlin for each variable inside of the list.


//16)
for(i<-1 to 5)
println(i)
//this statement creates a range between 1 to 5 and wants and output of 'i' being able to output each number
  //between 1 to 5

//17)
val in  = "hello world" //immutable 'in' value of 'hello world'
var sum = 0 //mutable 'sum' has been given the value of 0
for (i<-0 until in.length) sum+=i  // this statements wants to create a range between 0 and length of 'in'
  //then assigning the value of i with the sum.
print(sum) // at the end of the code it will output each number in the length and let you know how far the range
  //actually is.



//18)
for(i<-1 to 3;j<-1 to 3) // this mutable expression will create the range for 'i' and 'j' between 1 to 3
println(10*i+j) //for each variable in the expression it will create an output of 10 times 'i' plus 'j;'

//19)
for(i<-1 to 3;j<-1 to 3 if i==j) println(10*i+j)
//this mutable expression is attempting to create  a range of elements for 'i' and 'j' from 1 to 3 AND
  //the conditional statements creates an output of 10 times i plus j whenever i is equal to j



//20)
for(i<-1 to 3;x=4-i;j<- x to 3) println(10*i+j)
//this mutable expression creates a range of elements of 'i' from 1 to 4, 'x' will change range based on the range of i minus 4.
  // the value of 'i' and 'j' will have a list range of the value of  'x' to 3
  // the output will multiply 10 by 'i' and 'j'




//21)
val x = for(i<-1 to 20)yield i*2.5 //immutable value of x creates for statement that creates a range for 'i'
  //of elements between 1 to 20' that yeilds, which returns an each element of 'i' multiplied by 2.5
for (i<-x) println(i) // this expression creates a range of 'i' of x and creates the outputs of the range of elements
// in 'i'

while loop // the while loop creates a function during the duration of the for statements created a above
vim Demo_4.scala //pulling this specific function for the object demonstrated before.
Object Demo_4{ //creating an instance of the class of demo_4
def main(args:Array[String]) { //creating a declaration for a constructors
var a=10; //immutable value of a being 10
while( a<20) { // because 'a' is 10 which is less than 20 then it will create a new loop
println("value of a = " + a); // that creates an output that lets the users know the what the value of 'a' is
a= a+1; //because a is mutable it can be changed by adding one to the value of what a is.
}
} }

dowhile loop //this creates loop that while the above loop is continuing to work
var nodb = 2 //creating the mutable value of nodb to equal 2

do { //activating the do loop
nodb +=1 // that adds 1 to the value of 'nodb'
println(s"nodb = $nodb") //creating the output using println of the string 'nobd = $nodb'
}while(nodb < 10) // this loop can only be activated while the value of 'nodb" is less than 10



//22)

def sayhello() { //this defining a method of hello to return an output
println("Hello") // an output of the method defined as sayhello
}

def sum(a:Int,b:Int) { //defining that a sum has two integers value inside of it which are 'a' and 'b'
println(a+b) //creating an output of  adding the two ints together
}

sum(2,5)// the output of this will be 2+5 which will equal to 7 due to the method above.

def func():Int={ //defining the function that "func()" will create an integer that
return 7 //when "func()" is being used it will output the int '7'
}


def sum(a:Int,b:Any):Any= { //this defines the function of 'sum' being an int 'a' and  being inferred to be 'any'
println("hello") //Any will equal to the output of "hello".... When sum is used it will create an int, along with 'hello'
}



23)
def factorial(n:Int):Int=if(n==0)1 else n*factorial(n-1)
  //declaring the function of factorial as n being an int during the if else loop.
  // the conditions will be true when n is equal to 0 and if not n will by multiplied by n subtracted by 1

Object Demo{ //creating the instance of a class called Demo
def main(args:Array[String]) = { //defines a function of the main method
var result= functionExamp(15,2) //mutable value of result that is equal to function of functionExamp of the ins, '15 and 2'
println(result) // the output will be 'results' which will come from the functionExamp(15,2)
}
def functionExamp(a:Int,b:Int):Int={ //defining a function for functionExamp which has two ints for 'a' and 'b' during a condition
if(b == 0) //the condition is if 'b' is equal to 0"
0
else // when 'b' is not equal to 0 then it will lead to else statement leading to another loop
a+functionExamp(a,b-1) //this loop when b is not equal to 0 will add a to the functionExamp which consist of 'a' and 'b' minus 1
} }


24)
def rect_area(length:Float,breadth:Float) //defining a function for rect_area that creates the value of the length and breadth
  // using float which takes the space of a number
{ val area = length*breadth; print(area)} // the immutable value of area will be the length multiplied by breadth
  //print has been illegally used in the expression to provide what the int of 'area'

25)

Arrays with values

var a = Array(1,2,3) // mutable value of 'a' creates an array with three elements, '1,2,3'
a(4) //this int does not exist in the array so it will not be retrieved
a(0)// this array also does not exist so it can not be pulled from the array.

Arrays without values
var a = new Array[Int](3) //mutable value of a which creates a new array with three undefined int elements inside of it
a(1) //this will retrieve the second element from the array
a(1)= 2 // this changes the value of the fist element in the array and changes it to the int '2'
a //this will have the array where the elements do not have values except for the second element in the array which is '2'

val a = new Array[Int](10) // value of 'a' which creates a new array with 10 int elements that are undefined
val s = new Array[String](10) // this is an immutable value of 's' which creates an array of strings of 10 elements that are undefined
val st = Array("Hello","world") //this is an immutable value of 'st' where the array has two values of "hello", and "world"

26) //creating an instance of the arraybuffer
val a = ArrayBuffer[Int]() //this creates a value for 'a' where an arraybuffer for integers can change the size of array
a +=(1) // creating an element of the int '1' and adding it to the array
a +=(2,3,5) //creating a new element of ints '2,3,5'
a +=Array(6,7,8) //creating a new elements of ints '2,3,5' to be apart of the array

practice for Array
-----------------------------------------------------------------
https://www.geeksforgeeks.org/scala-arrays/
----------------------------------------------------------------

27) List
val list = 1 :: 2 :: 3 : Nil  //using cons to create new elements which can be implemented into a list with
  //which has the tail nil that has no value to close the list.
val list = List(1,2,3) // this now has been implemented in a list that is immutable with elements "1,2,3"
val x = List(1,2.0,33D,4000L) //Gives 'x' the value of The list which contains three elements that are of different datatypes
val x = List.range(1,10) // this creates a list with a range of elements from 1 to 9 and discounts 10 because it is the tail of the list
val x = List.fill(3)("foo") // this will fill the list with three 'foo'. example is 'foo','foo','foo'
val x = List.tabulate(5)(n=>n*n) //this creates a list of 5 elements where it creates an instance of a function where the
  //elements are basically added by odd numbers, ex; 0,1,4,9,16 because there are only 5 elements.
var fruits = new ListBuffer[String]() //creates a mutable new listbuffer, which will open the list to allow insertion
fruits += "Apple" // one of the elements that will be apart of the list
fruits += ("strawberry","kiwi") // two elements that have been created apart of the fruits list
fruits -= ("Apple","kiwi") // two more elements that can be implemented to the list
val fruitslists = fruits.toList //creates immutable fruitlists which will create a list of the elements using .toList


val x = List(3) //immutable value of three elements inside of a list that are not defined
val y = 1 :: 2 :: x //immutable elements '1' '2'  that connected by cons that sets them up to be used in a list alongside the three
  // elements in x
val z = -1 :: y //immutable z which has a negative element alongside the y which contains elements '1' '2' and elements in 'x'

val originalList1 = List(7,8,4,3,2) //immutable list for 'originallist1'which contains the elements of '7','8','4''3''2'
val newList1 = originalList1.filter(_>3) // this limits the output of the list to only numbers that are less than 3

val p = List(111,200,321) //immutable value for 'p' which creates a list with elements '111' '200' and '321'
val q = List(4,-5,60) //immutable value for 'q' which is contains a list of '4''-5''60'
val r =  p ++ q //immutable value r which adds the list of 'p' and 'q'
val r = p ::: q // will bring both list of 'p' and 'q' and bring them together
val r = List.concat(p,q) //another way of being able to bring the list together.


val lst = List(1,2,3,4,5,6,7,8) //creates immutable value for 'lst' and creates a list for 1,2,3,4,5,6,7,8
lst.head //will be used to retrieve the first element in the list '1'
lst.tail //will be used to retrieve the last element in the list '8'

def sum(l: List[Int]):Int = { if(l == Nil) 0 else l.head + sum(l.tail)}
  //defining a function for sum which contains a list of int that will activate through a condition if  'l' equals nil, which nothing
  //if the condition is false it will lead to an else that statement that will add the first element of the list to the last element
  //of the list.
val y = sum(lst) // the immutable value of y will result in the function above to see if the list is null and if not it will
  //activate the else statement and add '1' (the head) to '8' the tail.

practice for Array
--------------------------------------------------------------------------
https://www.geeksforgeeks.org/scala-lists/
--------------------------------------------------------------------------

28)Tuples

A tuple is immutable, unlike an array in scala which is mutable. An example of a tuple storing an integer, a string, and boolean value. Type of tuple is defined by, the number of the element it contains and datatype of those elements

val a = (1,4, "Bob", "Jack") //immutuable value of 'a' which creates a tuple of 4 elements, which include two ints and two strings
a._2 //this will retrieve the second element in the list
a _2 // represents the second field of the tuple which is 4

val ab = (4,3,2,1) //immutable value of "ab' which creates a tuple of 4 elements of the similar data type.
ab.productIterator.foreach{ i => println("value ="+i)} //generating a method for productIterator where each element in the tuple
  // now has 'i' which has the output of value of 'i'
val t =("exam","test") // the immutable value of t which is a tuple containing two strings, exam and test.
println(("swapped Tuple: " + t.swap) //this will create an output to swap one of the elements in the tuple.
val mn = (1,"wonderful",20.2356) // immutable vale of mn which creates a tuple with following three elements of different data types.
println("concatenated String: " + mn.toString()) //bring two list together. one of them being mn and to.string

practice for Tuple
--------------------------------------------------------------
"https://www.geeksforgeeks.org/scala-tuple/"
--------------------------------------------------------------

29) set
var s : Set[Int] = Set(1,3,5,7) //creates a mutable vale of 's' which is a set of unique ints 1,3,5,7
var s1 = Set(7,9,8,9) // creates a unique mutable value for 's1' with ints being inferred for 7,9,8,9
var s2 = Set(10,11,12,13) //creates a unique mutable value for 's2' with ints being inferred for 10,11,12,13
s1++s2 //adding both sets from s1 and s2
var x1 = Set(7,9,8,9) // creating mutable value for x1 that creates a set of 4 unique int 7,9,8,9
var x2 = Set(10,11,12,13) //creating a mutable value for x2 that creates set ofr unique int 10,11,12,13
x1.++(x2) //combines both sets of x1 and x2

var a1 = Set(11,44,33,22) //creating a mutable value for a1 that creates set ofr unique int 11,44,33,22
var b1 = Set(77,99,22,88) //creating a mutable value for b1 that creates set ofr unique int 77,99,22,88
a1.&(b1) // brings both sets a1 and b1

var a1 = Set(11,44,33,22)
var b1 = Set(77,99,22,88)
a1.intersect(b1) //there are no matching integers on each section so it will not able to intersect
  //and bring out the matching int from each set.

practice for sets
-------------------------------------------------------------
https://www.geeksforgeeks.org/set-in-scala-set-1/
-------------------------------------------------------------


30)
val mapping = Map("Vishal"-> "Kumar","Vijay" -> "verma")  // creating keys to connect 'vishal' to 'kumar' and 'vijay' to 'verma'
mapping.keys.foreach{i=>println(i+" "+mapping(i))}  //for each of the keys in the map there is a output to so that 'i' will be presented with
  // where 'i' is located in th map
mapping.contains("Vishal") //this will return as true and deliver 'vishal' because it is in the map

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

val m1 = List(5, 12, 3, 13) //immutable value of m1 that creates a list.

//Applying filter method
val result = m1.filter(_ < 10) //using filter it will output numbers that are less than 10

// Displays output
println(result) //the output should come out as 5 and 3 as they are both less than 10.
---------------------------------------------
val m1 = Map(3 -> "geeks", 4 -> "for", 2 -> "cs") // creating keys for "geeks" and "4" to match "for",2,"cs"

// Applying transform method
val result = m1.transform((key,value) => value.toUpperCase)// the transform method allows us to change keys into becoming mutable
  // and in this example it will make sure all the elements are changed to uppercase instead of lowercase.

// Displays output
println(result)
-----------------------------------------------

34)FlatMap
val name = Seq("Nidhi", "Singh") //Defining the sequence of how the names will be produced in output
val result1 = name.map(_.toLowerCase) //this will change the all the letters in the names to lowercase

val result2 = result1.flatten //flatten is able to take each individual data and put them in to a list that connects them through
  // a sequence
List(n, i, d, h, i, s, i, n, g, h) //

name.flatMap(_.toLowerCase) //this will connect all the individual data types in each element and sequence them in lower case
List(n, i, d, h, i, s, i, n, g, h) //This will create a new list out of all the elements that have been connected through flattening

---------------------------------------------------------------------

1. Write a Scala program to compute the sum of the two given integer values. If the two values are the same, then return triples their sum.
  object deems {

    def main (args: Array([String])
    {
      var x = 20;
      var b = 10;

      if (x==b)
      {
        println(x+b)*3)
      }
    }
  }

2. Write a Scala program to create a new string with the last char added at the front and back of a given string of length 1 or more

object examps {
  def test(mk2: String): String =
  {
    val len = mk2.length
    val last = mk2.charAt(len - 1)
    last + mk2 + last
  }

  def main(args: Array[String]): Unit = {
    println("Result: " + test("Javier"));
    println("Result: " + test("Cabral"));
    println("Result: " + test("mk"));

  }
}

3. Write a Scala program to get the absolute difference between n and 51. If n is greater than 51 return triple the absolute difference.
object turning {
  def test(x:Int) : Int =
  {
    val mk_subtract = Math.abs(x - 51)
    if (x > 51) 3 * mk_subtract else mk_subtract
  }

  def main(args: Array[String]): Unit = {
    println("Result: " + test(15));
    println("Result: " + test(30));
  }
}
4. Write a Scala program to check two given integers, and return true if one of them is 30 or if their sum is 30.
object checkers {
  def test(x:Int),(y:Int) : Boolean =
  {
    Math.abs(x) ==30 || Math.abs(y) ==30 || Math.abs(x+y) <=30
  }
  def main(args: Array[String]): Unit = {
    println("Result: " + test(10));
    println("Result: " + test(15))
  }
}
5. Write a Scala program to check a given integer and return true if it is within 20 of 100 or 300.
object givenint {
  def test(x:Int) : Boolean  =
  {
    Math.abs(100 - x) <= 20 || Math.abs(300 - x) <= 20
  }

  def main(args: Array[String]): Unit = {
    println("Result: " + test(135));

  }
}

6. Write a Scala program to create a new string where 'if' is added to the front of a given string. If the string already begins with 'if', return the string unchanged
object mems {
  def test(mark: String): String =
  {
    if (mark.startsWith("if")) mark else "if " + str
  }

  def main(args: Array[String]): Unit = {
    println("Result: " + test("if else"));
    println("Result: " + test("else"));
  }
}


7. Write a Scala program to remove the character in a given position of a given string.The given position will be in the range 0...string length -1 inclusive.
object moveover {
  def test(another: String, n: Int): String =
  {
    another.take(n) + another.drop(n + 1)
  }
  def main(args: Array[String]): Unit = {
    println("Result: " + test("Scala", 3));
    println("Result: " + test("Scala", 2));
    println("Result: " + test("Scala", 1));
  }
}

8. Write a Scala program to exchange the first and last characters in a given string and return the new string.

object almade {
  def test(almade: String): String =
  {
    val mke = almade.length
    if (mke <= 1) almade
    else mke.charAt(mke - 1) + almade.substring(1, mke - 1) + mke.charAt(0)
  }
  def main(args: Array[String]): Unit = {
    println("Result: " + test("Scala"));
    println("Result: " + test("abcd"));
    println("Result: " + test("ab"));
    println("Result: " + test("a"));
  }
}
Source----
"https://www.w3resource.com/scala-exercises/basic/index.php"