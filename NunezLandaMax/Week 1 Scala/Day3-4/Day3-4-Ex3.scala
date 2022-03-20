package example

class ExceptionExample1
{
    def divide(a:Int,b:Int)={
        try{
            a/b   
        }
        catch{
            case e:ArithmeticException=>println(e) //if exception is found print a message
        }
        println("Rest of the code is executing")  //The rest of the code is executed
    }
}

object MainObject1
{
    def main(args:Array[String]){
        var e=new ExceptionExample1()
        e.divide(100,0)  //send a division by 0 
    }
}