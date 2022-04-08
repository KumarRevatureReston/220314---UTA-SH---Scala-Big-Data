# Revature Training 3/21/2022

QC doesn't ask us to open our editor 
5 minutes, 3-4 questions per associate OR
If there are 2 QC they can create a breakout room 10/10 each

## Inheritance

When a class inherits another it `extends` another, in order to achieve reusability of the code. With inheritence one class acquires the data and methods (features) of another class

If B extends A then B gets all the properties and methods of A

We use the keyword `extends`

The class that extends is the *subclass* (also called child class or derives class)

The extended class is the *superclass* (also called parent class or base class)

* Single and Multiple Inheritence
* Heirarchical inheritance
* Hybrid Inheritence

**Heirarchical Inheritence Example**
B & C & D, expand to the class E

```
class Big {
  var Name: String = "Revature"
}
class Data extends Big {
  var License_no: Int = 700

  def details(): Unit =  {
    println("Another name" + Name);
    println("Total number of plates: " + License_no)
  }
}

// object extends class (blueprint)
object Main {
  def main(args: Array[String]) = {
    val ob = new Data()
    ob.details()
  }
}
```

**Quiz** 
* Wednesday or Thursday?
* No time limit on the quiz
* Everyone must take the quiz at the same time
* It will be through Rev Pro on Thursday this week


## Parallel, Distributed and Concurrent Computing

### Parallel Computing
Multi core or multi processor, multiple tasks assinged simultaneously at the same point in time

### Distributed Computing
Multiple individual CPUs or computers working together as a single system, Single core machines come together

The CPUs can communicate with each other with messages (e.g. using SOAP)

### Concurrent Computing

Processing with threads

We don't have multiple cores but we have multiple jobs

**Thread** - process running in Software, JVM allows a number of multiple threads.

Concurrency in Scala is built on top of concurrency in Java

Scheduler - responsible to schedule the threads in the CPU

The scheduler takes care of the job scheduling, switching between threads per ms (called context switching)

Concurrency is about dealing with a lot of things at once

Concurrency occurs with a single core processor (important)

## Futures

A way to reason about performing operations in parallel in an efficient and nonblocking manner in concurrent programming

An asynchronous transformation of an immutable(?) state

Future module - we always import `scala.concurrent.Future`

When you want to write parallel and concurrent applications in Scala, you could use a native Java Thread but Scala Future makes parallel/concurrent programming much simpler

Scaladoc

Implemented internally with promise

Futures and Promises - Modules - will support you in multithreading and multiprocessing (asynchronous programming)

`import scala.concurrent.Future`
`import scala.concurrent.Promise`


A future/promise represents a value which may or may not currently be available but will be available at some point

Future - read-only
Promise - writable

**Notes from Mr. Kumar in the Discord**

> *Wk 1 QC w/ Bharath N - Auditors (JS)
Mon 3/21/2022, 2 PM to 4pm Eastern
https://revature.zoom.us/j/91719400058


> Scala Quiz been assigned for March 24th Thursday btw 5 to 6 eastern.

> Pls check your Revpro
You might have received an invite to join Revature connect.please activate your account
They usually create a group for each training batch and add all the associates so that you can use it as a platform to communicate with the associates. You might find some important documents and polices in there too. Thanks!*


Lunch break

Working until QC

## QC

We are graded on the content of our answers and our presentation (body language, dress and eye contact)

Practice quiz coming via email

**QC Study notes:**
Overriding methods have the same signature i.e. same name and method arguments. Overloaded method names are the same but the parameters are different.

Overloading is multiple implementations of a method via inherited classes. Overriding is multiple implementations of a method in the same class.

**Pillars of OOPS Acronym : (from Jessica)** 
APIE (A pie!)
Abstraction, Polymorphism, Inheritence, Encapsulation


**Link from Alex about Lambda Expressions in Scala:**
https://www.geeksforgeeks.org/lambda-expression-in-scala/ 

## Handling Failures

### Option vs try vs Either

**Option** 

A special type of error which refers to the absence or presence of a value in the code

Often denoted with `!variablename` in some languages

Option has either the some or none type depending on whether something is found or not

(e.g. the `Map()` constructor here returns some or none depending on whether the element is found, the some and none are the options in this case)

```
// Option (Map returns some or none)
object option {
  def main(args: Array[String]): Unit = {
    val name = Map("abc" -> "Revature", "pqr" -> "coder")
    val x = name.get("abc")
    val y = name.get("xyz")
    println(x)
    println(y)
  }
}
```

**Try** 
achieves functional purity by returning success (a value) or failure (an exception)

**Either**
handles mutually exclusive values represented by left and right, handles both cases

*Left* - contains the error message
*Right* - contains the value itself


```
// Either example
object EitherExample extends App {
  def Name(name: String): Either[String, String] = {
    if(name.isEmpty)
      Left("No Name")
    else
      Right(name)
  }
  println(Name("Kumar"))
  println(Name(""))
}
```

Usually we use option and either (these collectively are called exceptionless handling)

There are also various third party libraries for error handling

1-on-1s / Assignment work

**Tomorrow**
RDBMS, MySQL, CRUD, Aggregate Functions


Data Engineer Job Description
https://walmart.wd5.myworkdayjobs.com/WalmartExternal/job/US-TX-DALLAS-Home-Office-Bonobos-Knox-Henderson-Dallas/Data-Engineer-III_R-985776-1?source=Advertising_Indeed_Organic&_ccid=16477965036007a4gryc68&ittk=SWWEIBIVIC





