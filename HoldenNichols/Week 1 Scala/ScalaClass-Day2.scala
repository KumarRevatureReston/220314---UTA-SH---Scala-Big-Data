object Scala_Class_Day2{
    def main(args:Array[String]){

        //  Problem 1
    class Ctr {
    private var value = 6
    def incr() {value +=1}
    def curr() = value
    }

    val ctr1 = new Ctr 
    ctr1.incr()
    println(ctr1.curr)

    class Duck {
    var size = 1
    }

    var f = new Duck
    f.size =10
    println(f.size)

// There are 2 super classes above, and 2 subclasses above. There are 2 hierarchies present.
// The first hierarchy contains the super class Ctr and its subclass ctr1, the second heirarchy being the super class Duck, and sub class f.
// the method incr and curr are defined in Ctr and can be called in ctr1 do to inheritance.
// ctr1 can print the value of curr due to the value being defined in the super class and the method that alters the value is also inherited.

// within the 2nd heirarchy, parent Duck and child f, there is an override of the size method within f.


    // Problem 2

    class Employee(empId: Int, name: String, salary: Double) {
    def this(empId: Int, name: String)= {
    this(0, "", 0.0) // here it invokes primary constructor.
    println("Two-argument auxiliary constructor")
  }
    def this(empId: Int) = {
    this(0, "", 0.0) // here it invokes primary constructor.
    println("One-argument auxiliary constructor")
  }
    def this() = {
    this(0) // here it invokes one-argument auxiliary constructor.
    println("Zero-argument auxiliary constructor")
  }
    println("Primary construtor")
  }

    val emp = new Employee()

    class Employeez(empId: Int = 0, name: String = "" , salary :Double =0.0){
        println(s"empId = $empId, empName = $name , salary = $salary")
    }
    val empz = new Employeez()
    println(empz)

    val emp1 = new Employeez(name = "Smith")
    println(emp1)

    val emp2 = new Employeez(name = "Smith", empId = 9)
     println(emp2)



    //  Problem 3

    val salaries = Seq(20000, 70000, 40000)
    val doubleSalary = (x: Int) => x * 2
    val newSalaries = salaries.map(doubleSalary) // out put for newSalaries will be  List(40000, 140000, 80000). This is due to the function newSalaries taking in the sequence from salaries
    // and runs the sequence through doubleSalary to find its output, the values of the integers in the original list are all multiplied by 2. newSalaries is a higher order function in this case
    // taking in salaries and doubleSalary as its parameters. It is not worthy that the output is a Boolian data type. 

    val salaries2 = Seq(20000, 70000, 40000)
    val newSalaries2 = salaries2.map(x => x * 2)    
//    practically identical to the above higher function example, however instead of designating a doubleSalary variable, newSalries2 specifies the computation itself instead of ustilizing another function.



    
    }
}