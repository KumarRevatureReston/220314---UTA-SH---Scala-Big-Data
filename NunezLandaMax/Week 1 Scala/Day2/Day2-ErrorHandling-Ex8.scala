package example
import java.io.IOException
object ErrorHandling
{
    //throw a java exception
    def failingFn(i:Int):Int={
        val y:Int = throw new Exception("fail!")
        try{
            val x=42+5
            x+y
        }
        catch
        {
            case e:Exception=>43
        }
    }
    
    
    def failingFn2(i:Int):Int={
        try{
            val x=42+5
            x+((throw new Exception("fail!")):Int)
        }
        catch
        {
            case e: Exception=>43
        }
    }

    
    def mean1(xs: IndexedSeq[Double],onEmpty:Double):Double=
    {
        if(xs.isEmpty) onEmpty
        else xs.sum / xs.length
    }
    def main(args:Array[String])
    {
        println(failingFn2(5))    //throws the number of the exception 43
        println(mean1(IndexedSeq(2.3,2.5),2.5))   //sum numbers if the sequence and divide them by the lenght
        println(failingFn(2))  //throws a java exception "fail!"
    }
}