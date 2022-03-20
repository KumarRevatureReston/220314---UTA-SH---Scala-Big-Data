package example

object Curry
{
    def add2(a:Int)=(b:Int)=>a+b;
    def main(args:Array[String])
    {
        println(add2(20)(19));  //Function takes only one Argument two numbers
    }
}

