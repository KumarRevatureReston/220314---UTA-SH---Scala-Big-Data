package example

object Demo{
    def main(args:Array[String])
    {
        val num = Set(5,6,9,20,30,45)      
        println("Min element in Set(5,6,9,20,30,45) : "+ num.min) //Returns the smallest number in the Set
        println("Max element ins Set(5,6,9,20,30,45) : "+num.max) //Returns the largest number in the set
    }
}