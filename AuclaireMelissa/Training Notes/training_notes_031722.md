# Revature Training 3/17/2022

## Exception Handling

**Exception** - an event that changes the normal flow of a program (a form of error handling)

e.g. 25/0 - Division by 0 results in a Mathematical error

**Checked vs Unchecked Exceptions**
* Checked - exceptions that are checked at compile time
* Unchecked - not checked at compile time

(Scala supports only unchecked exceptions)

**Throwable** -  Error and Exception are throwable types in Java
At compile time we won't actually know if a method is throwing an exception we are not handling

**Assert method** - a special built in testing method for evaluating the truthiness of unit tests

Garrett - question about overloading inner methods

```
object Arithmetic {
  def main(args: Array[String])= {
    try {
      val z = 4/0
    } catch {
      case ex: ArithmeticException => println("Cannot divide number by zero")
    }
  }
}
```


*try* *catch* and *throw* are keywords in Scala

You can use finally without catch

## Pattern Matching 

Mechanism for checking a value against a pattern (designed for big data)
Like a more powerful switch statement

```
object MainObject {
  def main(args: Array[String])= {
    var a = 1
    a match{
      case 1 => println("One")
      case 2 => println("Two")
      case _ => println()
    }
  }
}
```


```
// example with or bars
val a=5
a match {
  case 1|2|3|4 => println("even")
  case 5|7|9|4 => println("odd")
}
```

## Attendance and Breaks
Attendance is taken very seriously and is recorded in Salesforce and added to our portfolio along with QC and tests as a percentage using internal calculations developed by Revature.

<span style="background-color:  #5cb85cdd; color: white; font-size: 12; font-weight: 800;">Green</span> - Excellent (>95%)
<span style="background-color:  #f0ad4edd; color: white; font-size: 12; font-weight: 800;">Yellow</span> - Good (90-95%)
<span style="background-color:  #d9534fdd; color: white; font-size: 12; font-weight: 800;">Red</span> - Not good (80-89% or below)

**Informed absence** - affects attendance a *little*
**Uninformed absence** - affects attendance a **lot**


- Attending some days is more important in terms of attendance score than others depending on the subject
- It's okay to take a 45 minute break during training but it's important to inform Mr. Kumar first
- Inform Revature if we have a Doctor's appointment or we need 3-4 days leave requires documentation

We have a strong relationship with the University of South Florida (Teaching Assistants and Secrataries)
Online Training - the responsibility falls on the trainer

**1-on-1s** - 
10 today, 11 tomorrow

Monday - If we have any files or folders in your C drive, please move them to make sufficient space for the big data stuff

Laptop - (you can maybe get a laptop for work use (I wasn't sure about this))
itsupport@revature.com
2 days response time

Our batch is probably for Walmart
Walmart will send people to everywhere in the US (there are probably data centers in all the states)


## Collections

**Slide Notes**
Collections are containers of things, linear sets like List, Tuple, Option, Map etc.
Scala has a rich collections library.
Scala can use Java libraries, a Java API can support Scala (e.g. PySpark) Pickle/Flask
Java provides open source APIs but not true all the time, there are API limits and restrictions
Can have an arbitrary number of elements or be bounded by zero or one element
Collections can be strict or lazy. Lazy collections have elements that may not consume memory until they are accessed (e.g. ranges)

Question from Brandon about tuples
Having 1-indexed Tuples is mathematically/programmatically more efficient (45 page research paper, lots of Calculus)

## Lists

A linear collection of items of a given type

List operator
:: prepends the first item (single item) to a list
::: prepends the first complete list to a list

```
  val i = 1
  println(i::List(2,3)) // List(1,2,3)
  println(List(1,2):::List(3,4)) // List(1,2,3,4)

```

### Merging vs Concatenation
Concatenating two lists adds one list to the end of the other

Merging the two lists can have different rules, like merging them in sorted order

```
object Associates {
  def main(args:Array[String]) = {
    val names = "Noah" ::("Ben" ::("Brandon"::Nil))
    val designation = Nil
    println("Head on names array: " + names.head)
    println("Tail on names array: " + names.tail)
    println("check if a designation is empty: " + designation.isEmpty)
  }
}
```

39 reserved Scala keywords

Types of nothingness

Lunch Break

### *Bonus Stuff we didn't cover in class but I researched it*

**Traits vs Abstract Classes**

Traits are akin to interfaces in Java but can also have implemented methods

Abstract classes are the same as abstract classes in Java

- Traits support multiple inheritence and abstract class doesn't
- We can add a trait to an object instance but not an abstract class
- Traits don't contain constructor parameters but abstract classes do
- Traits are completely interoperable only when they don't contain implementation code (they then become interfactes in Java)
- Traits are stackable and super calls are dynamically bound, but abstract classes are not stackable and statically bound

1-on-1s


<h1 style="background-color:crimson; color:white; font-size: 22;">IMPORTANT</h1>
<i>Training Week 1 Wrap Up Session#
Fri 3/18/2022 12 PM - 1 PM Eastern
https://revature.zoom.us/j/92456091980
</i>
</span>

> Description
Come join our Senior Director of Employee Experience, Kyle Taylor, to welcome our new Associates into the Revature network of tech professionals with a motivational presentation where Kyle will talk about the benefits of starting a career in tech and share some keys to success.

> Join Details
Topic: Training Week 1 Wrap Up Session with Kyle Taylor

Join Zoom Meeting
https://revature.zoom.us/j/92456091980
Meeting ID: 924 5609 1980

Most Github repository members added

File path issue on #8 can be resolved using the absolute path of the file instead of the relative path
e.g. "C:\this\is\the\file.txt"
instead of "file.txt"

### Upcoming

Files will be created in the repository for tomorrow
