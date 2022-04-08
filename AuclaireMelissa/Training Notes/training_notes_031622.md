# Revature Training 3/16/2022

## Review
* Pillars of OOPS
* We are a day behind
* QC is next week

Might have to share assignments OneDrive


## Git vs OneDrive

* We are using Git as opposed to OneDrive becuase it needs to be a part of our portfolio
* Make private repositories (not visible to the public)
* After the 10th week we can make the repos public
* Mr Kumar will create a Github repo
  
  
  
> Scala follows all the oops concepts by default

> A Scala class is a template for Scala objects

> Subclasses are inherited from a superclass

> Interfaces are implemented by a subclass

```
class MyClass {

}
```

- The first letter of the class needs to be capitalized
- All constructors execpt the noarg must call another constructor
- primary and auxillary constructors

## if statements

```
if(condition) {
	// code if condition is true
} else {
	// code if condition is false
}
```


Mr. Kumar's note: Big data is hardly that much code, 10 lines of code max

## OOP Concepts
- Class
- Objects
- Methods
- Fields
- Variables

```
class Myclass {
  var myField=0;
  
  
  def MyField() : Int = {
    return this.myField;  
  }
  
  def addToMyField(value : Int)={
    this.myField+=value;
  }
  
  // def this(value: Int) = {
  //   this();
  //   this.myField = value;
  // }
  
  var age : Int = 78
  if(age>58) {
    println("age is greater than 58")
  }
}
```

**Closure** - function returns values depending on input, has access to the outside scope
**Traits** - encapsulation

## Data type vs Data structures
There terms are interchangably used
Types tend to be more primitive than structures (usually)

## Primitive data type vs non-primitive data types

**Primitive types**
int, char, bool

**Non-primitive types**
- Linear and non-linear
	* Array, Stack, Queue, List
- Non-linear - data structure
	* Trees, Graphs, Tries
- Non-linear is always/most probably immutable


## Tuples

```
val cook = ("chocl", 25, false)
```

You can have different types of items in a tuple

Tuples are 1 indexed as opposed to 0 index

**Use cases:**
Pattern Matching, Iterate, Change or modify (swap) elements of tuple
Scala 3 increased the limitation of elements in a tuple
22 elements
Using nested tuples can overcome this but it's not suggested


```
Object rev {
	def main(args: Array[string])
}

val cook = ("chocl",25,false)

// false - a primitive type
// False - an ok class name

val name = ("chocl", 25, false)
print(name._1)
print(name._2)
print(name._3)
```

51 keywords in Java (I thought 52)

Python
27 - version 2.7
37 - versopm 3.~

Scala
was 32 keywords, 39 now

Scastie IDE issues...

-- 79 characters should be the maximum for a line

Melissa - What are the quizzes (.NET/Java etc)? / What is QC?

The quizzes are for extra things we might want to learn

## What is QC?

**QC**
- not exactly part of Revature
- external industry consultants
- They are asses how much are we aware of functions and other concepts in Scala

**QC team**
- Reston office
- Techy guys
- Big data
- Team forms a special group

Assigned a particular date, at maybed 1-2 EST, there will be a coordinator to split the batch into multiple breakout rooms, scenario based questions

Share screen, type code, answer various questions to assess our understanding

Spark, Kafka (Streaming), Hive, Avro, HDFS (Hadoop)


**Project Types**
1 Batch projects
2 Group projects
3 Individual Projects

4 Real-time projects
Take a real-time dataset and turn it into an insight to benefit the business

Bird's Eye view of curriculum (schedule in Revature Pro)

Lunch break

**Questions**

Gulbaniz - Email issues with Microsoft Authenticator
Max - HR - 1-9 form issue

Contact Shelby
shelby.lloyd@revature.com 

HR Issues go to
hr@revature.com
(there is no phone as far as Brandon is aware)

Brandon sent an email to them on Monday and they have not gotten back, they are busy, email early

Ticket #
Assigned to Executive


**Scala supports...**
Built-in functions - included with Scala
User-defined functions (UDFs) - creating our own functions per our own requirements


## println vs return

**println** - prints the value out (the contents go to the i/o (in this case the terminal))
**return** - the value goes back to where you called the function in the code

A function that does not return anything can return a Unit in Scala (akin to void in Java)

A Unit is implicitly returned when there is no return

A function that does not return anything is called a procedure in Scala

## Pure functions and Impure Functions

**Pure function** - does not change the parameters it has been passed (e.g a+1)

**Impure function** - it can change or mutate the paramaters it's been passed (e.g a = a+1)

// Copy pasted code from Zoom chat
1.Pure object rev { def main(args: Array[String]) { def square(a:Int) = { var b:Int = a * a; println("Square of the number is " + b); println("Number is " + a); } square(4); } } 2.Impure object FunctionsInScala { var someValue = 10 def myImpureSum(a: Int, b: Int) = { someValue = 20 println("Doing some sum work") a+b+someValue } }

Syntax Highlighting:

```
// Pure Function Example
object rev {
  def main(args: Array[String]) = {
    def square(a:Int) = {
      var b:Int = a * a;
      println("Square of the number is " + b)
      println("Number is " + a)
    }
    square(4);
  }
}

// Impure Function Example
object FunctionsInScala {
  var someValue = 10
  def myImpureSum(a: Int, b: Int) = {
    someValue = 20;
    println("Doing some sum work")
    a+b+someValue
  }
}
```

The difference is that in an impure function you are *altering the value of the variable*


We need to do 1-on-1's every week
1 Quiz per week
1 QC per week

QC Orientation will be from 2-3PM, or 3-4PM (we have an option to select)

## Higher-order functions

A higher-order function is a function that takes another function as an input paramter and return a function as a result

e.g. Maps

Collections in Java - ArrayList, Map, Set...

```
object Demo {
	def main(args: Array[String]) = {
		println(apply(layout, 10))
	}
	
	def apply(f: Int => String, v: Int) = f(v)
	
	
	def layout[A](x: A) = "[" + x.toString() + "]"
}
```

## Upcoming

- Mr. Kumar will create the Github repo today or tomorrow
- 1-on-1s will happen on Friday
- Assignment and Quiz sometime this week
- QC will happen on Tuesday of next week, the email will come out

