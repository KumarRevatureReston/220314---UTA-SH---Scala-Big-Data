package example

//2 Structure of classes

class Employee(empId: Int,name: String,salary : Double){
    def this(empId:Int,name:String)  //constructor two arguments
    {
        this(0,"",0.0)
        println("Two-argument auxiliary constructor")
    }
    def this(empId:Int)  //constructor one argument overloaded
    {
        this(0,"",0.0)
        println("One-argument auxiliary constructor")
    }
    def this()             //constructor no arguments overloaded
    {
        this(0)
        println("Zero-argument auxiliary consturctor")
    }
    println("Primary constructor")
}

object Classes_2
{
    def main(args:Array[String])
    {
        val emp = new Employee()
        val emp1 =  new Employee(2)
        val emp2 = new Employee(name="Smith", empId=9)

     
    }
    
}