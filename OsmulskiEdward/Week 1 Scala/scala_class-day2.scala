//1)classes & Objects

class Ctr {                             //This is a class declaration of class Ctr. C is capitalized since the first letter of a class must be capitalized
  private var value = 6                 //This is an encapsulated var called 'value' which is assigned the value of the integer 6
  def incr() {value +=1}                //This is an impure no arg function that that adds 1 to the value of the variable 'value'. It is written incorrectly because there
                                        //must be an assignment operator between the parameter declaration and the body of the function.
  def curr() = value                    //This is a pure function that doesn't do anything. It just returns the 'value' variable when it is called, similar to a getter method.
}
                                        //These next 4 lines need a top level statement which means that they must be within an object declaration in order to be called.
                                        //Further, in order for this program to run, the commands must be within a main method.
val ctr1 = new Ctr // or                //val ctr1 = new Ctr and val ctr1 = new Ctr() are both acceptable ways to create a new object of class Ctr.
new Ctr()                               //Scala does not require parentheses when calling no arg constructors.
ctr1.incr()                             //This calls the incr() method and increments the var 'value' by 1 for the object ctr1.
print(ctr1.curr)                        //This line calls the curr() method to retrieve the value of 'value' for the object ctr1 and uses the print() function to print
                                        //to the terminal. This program will output 7 to the terminal.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Duck {                            //This is class declaration for class 'Duck'
  var size = 1                          //This sets an instance variable for the class Duck called 'size' with a value of 1
}
                                        //These next four lines outside of scastie online IDE would need to be within an object and within a main method
var f = new Duck                        //This line of code creates a new Duck object 'f' by using the keyword new and the
f.size =10                              //This line of code uses the dot operator to call the instance variable size for the object 'f' and reassigns its value to 10
println(f.size)                         //This line prints the value of the instance variable size for Duck object 'f' and then moves the cursor to the next line.
                                        //This program will output 10 to the terminal.

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//2)Structure of classes

/* the auxiliary constructor in Scala is
 * used for constructor overloading and
 * defined as a method using this  name.
 */

class Employee(empId: Int,name: String,salary :Double){              //This is the primary constructor for the class Employee, it takes in an Int empId, an Int name, and
                                                                     // a Double salary.
  def this(empId:Int,name:String)                                    //This is an auxiliary constructor for the class Employee it only takes in empId and name.
    {
      this(0,"",0.0) // here it invokes primary constructor.         //This invokes the primary constructor passing in the values of (0,"",0.0) for the primary constructors params.
      println("Two-argument auxiliary constructor")                  //This will print to the terminal the message within the print function.
    }
  def this(empId:Int)                                                //This is another auxiliary constructor for the class Employee that takes in only empId.
    {
      this(0,"",0.0) // here it invokes primary constructor.         //This invokes the primary constructor and passes in the same information as the previous auxiliary constructor.
      println("One-argument auxiliary constructor")                  //This will print to the terminal the message within the print function.
    }
  def this()                                                         //This is another auxiliary constructor, but it does not take in any parameters.
    {
      this(0) // here it invokes one-argument auxiliary constructor. //This line will invoke the one-argument auxiliary constructor and passes in (0) for the params.
      println("Zero-argument auxiliary constructor")                 //This will print the message within the print function.
    }
  println("Primary Constructor")                                     //This will print once the primary constructor has been invoked.
}

val emp = new Employee()                                             /* Here a new object of Employee class is being created with the name 'emp'. However, no values are being passed
                                                                      * into the constructor call so it will call the no-argument auxiliary constructor, which will in turn will call
                                                                      * the one-argument auxiliary constructor, which will finally call the primary constructor.
                                                                      * the output for this program will be:
                                                                      *
                                                                      * Zero-argument auxiliary constructor
                                                                      * One-argument auxiliary constructor
                                                                      * Primary Constructor
                                                                      */

/* In Scala, we can also create a primary constructor with a default value. If you don't
 * provide value, then it will take the default value, which is provided in the primary
 * constructor. Otherwise, the value we provide is from an instance created with the help
 * of a parameter name of the class. Here is an example:
 */

class Employee(empId: Int = 0, name: String = "", salary :Double = 0.0){    //Here the same primary constructor as above has been given default values so if incomplete-args are passed
  println(s"empId = $empId , empName = $name , salary = $salary")           //there will still be values passed in for the params. This is better alternative to having many different
}                                                                           //auxiliary constructors. The next line just prints the values that were passed in, or if they were not, the
                                                                            //default values.
scala> val emp = new Employee()
empId = 0 , empName = , salary = 0.0
                                                                            //These blocks of code to the left just show the different outputs for this program given different objects
scala> val emp1 = new Employee(name = "Smith")                              // created passing in different parameters
empId = 0 , empName = Smith , salary = 0.0

scala> val emp1 = new Employee(name = "Smith", empId = 9)
empId = 9 , empName = Smith , salary = 0.0

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//3)Higher order functions

//Higher order functions take other functions as parameters or return a function as a result
//This is possible because functions are first-class values in Scala.

val salaries = Seq(20000, 70000, 40000)      //This creates a val 'salaries' and assigns a sequence of ints to it
val doubleSalary = (x: Int) => x * 2         //This creates a val 'doubleSalary' assigned a function that takes is passed integers and multiplies them by 2
val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
                                             //newSalaries is a higher order function because it creates a list by calling the result of another function, that of doubleSalary.
val salaries = Seq(20000, 70000, 40000)
val newSalaries = salaries.map(x => x * 2)   //These lines of code do the same as above but it isn't a higher order function as the method of doubling the salaries is
                                             //in the in the newSalaries function
