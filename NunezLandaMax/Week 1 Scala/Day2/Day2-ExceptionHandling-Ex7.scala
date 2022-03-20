package example

import java.io.IOException

object CFG
{
    def main(args:Array[String])
    {
        try 
        {
            var n=5/0   //Aritmetic exception number cannot be divide by 0
        }
        catch
        {
            case i: IOException=>
            {
                println("IOException occurred.")
            }
            case a: ArithmeticException=>  //program catch this exception and print Aritmetic exception
            {
                println("Aritmetic Exception")
            }
        }
        finally
        {
            println("This is final block") //Final block is always executed
        }

    }
}


