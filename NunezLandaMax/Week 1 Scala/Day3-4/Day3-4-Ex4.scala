package example

class ExceptionExample2
{
    def divide(a:Int,b:Int)={
        try{
            a/b
        }
        catch
        {
            case e:ArithmeticException=>println(e)   //find arithmetic exception
            case ex:Exception=>println(ex)           //find the type of exception
            case th:Throwable=>println("Found an unknown exception"+th)  //find an unknown exception
        }
        finally
        {
            println("Finally block was executed")    //finally block always executed
        } 
        println("Rest of the code was executed ...")  //continue executing the rest of the program
    }
}

object MainObject2
{
    def main(args:Array[String])
    {
        var e= new ExceptionExample2
        e.divide(100,10)      //does not find any exception

        var m = new ExceptionExample2
        e.divide(100,0)        //find an Arithmetic exception
    }
}