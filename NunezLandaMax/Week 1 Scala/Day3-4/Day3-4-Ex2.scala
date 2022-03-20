package example

class ExceptionExample{
    def divide(a:Int,b:Int)={
            a/b //catch an exception the rest of the code is not executed
            println("Rest of the code is executing...")
    }
}

object MainObject{
    def main(args:Array[String])
    {
        var e=new ExceptionExample()
        e.divide(100,0)  //Exception divide by 0
    }
}