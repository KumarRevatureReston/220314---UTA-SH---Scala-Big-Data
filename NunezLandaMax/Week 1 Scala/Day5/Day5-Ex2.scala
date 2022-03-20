package example

object Demo1
{
    def main(args:Array[String])
    {
        val num1 = Set(5,6,9,20,30)  //Creates a set of 5 elements
        val num2 = Set(50,60,9,20,35,55) //Creates a set of 6 elements
        println("num1.&(num2) : "+num1.&(num2))  //Returns the common numbers between two sets num1,num2
        println("num1.intersect(num2) : "+num1.intersect(num2)) //Returns common numbers between two sets num1,num2
    }
}
