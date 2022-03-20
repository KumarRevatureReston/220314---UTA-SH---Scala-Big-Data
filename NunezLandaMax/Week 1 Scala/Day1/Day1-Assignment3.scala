package example
//3. Write a Scala program to get the absolute difference between n and 51. If n is greater than 51 return triple the absolute difference.
object Difference
{
    def main(args:Array[String])
    {
        println(absoluteDifference(6))
        println(absoluteDifference(56))
    }
    
    def absoluteDifference(n:Int):Int=
    {
        val absDifference=Math.abs(n-51)  //Call Math library function abs
        if(n<=51)
            return(absDifference)
        else
            return(absDifference*3)
    }
}