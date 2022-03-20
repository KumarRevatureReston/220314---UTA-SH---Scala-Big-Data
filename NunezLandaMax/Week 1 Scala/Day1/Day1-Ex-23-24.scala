package example

object Demo{
    //23
    def factorial(n:Int):Int=if(n==0)1 else n*factorial(n-1); //recursive fucntion calculates factorial
    def main(args:Array[String])
    {
        var result = functionExample(15,2)
        println(result);
        println(factorial(5));
        println(react_area(2,5)); 
    }
    def functionExample(a:Int,b:Int):Int={
        if(b==0)
            0
        else
            a+functionExample(a,b-1);  //recursive function sum a to itself b times 
    }

    //24
    def react_area(length:Float,breadth:Float) //Function calculates the area
    {
        val area = length*breadth;print(area)
    }
}

