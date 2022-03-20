package example

//4 Functional Programming

object FunctionalProgramming{
    
    def sum(f:Int=>Int,a:Int,b:Int):Int=
    {   
        if(a>b)
            0 
        else 
            f(a) + sum(f, a + 1, b)   //recursive function return the sum of thenumbers between a and b

    }
    def sumInts(a: Int, b: Int): Int = 
    {   
        sum(id, a, b)   //pass  function is to sum
    }
    def sumSquares(a: Int, b: Int): Int = 
    {
        sum(square, a, b)  //pass function square to sum
    }
    def sumPowersOfTwo(a: Int, b: Int): Int =
    { 
        sum(powerOfTwo, a, b)  //pass function powerOfTwo to sum
    }
    
    def id(x: Int): Int = x    //function return x
    def square(x: Int): Int = x * x  //function return x*x
    def powerOfTwo(x: Int): Int =    
    {
        if (x == 0) 1 else 2 * powerOfTwo(x - 1)  //recursive function return 2 multiplied by itself x times
    }
    
    def main(args:Array[String])
    {
        println(sumInts(2,7))
        println(sumPowersOfTwo(4,5))
        println(sumSquares(6,7))
        println("sum ints 1 to 4 = " + sumInts(1,4))
    }
}