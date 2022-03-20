package example

object rev
{
    def main(args:Array[String])=
    {
        //32
        //Pure function
        def square(a:Int)=
        {
            var b:Int=a*a;
            println("Square of the number is "+b);
            println("Number is "+a);
        }
        square(2);
        var b=FunctionsInScala;
        b.myImpureSum(2,3);
    }
}

object FunctionsInScala 
{
    var someValue = 10
    //Impure function
    def myImpureSum(a: Int, b: Int) =
    {
        someValue = 20 //change value of variable
        println("Doing some sum work")
        println(a+b+someValue);
    }
}



