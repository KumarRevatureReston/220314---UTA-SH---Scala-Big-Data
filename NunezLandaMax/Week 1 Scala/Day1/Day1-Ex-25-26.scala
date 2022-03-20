package example
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer
object Demo{
    def main(args:Array[String])
    {
        //25
        var a = Array(1,2,3)
        println(a(2))  //a(4) and a(3) are out of range the array elements index are 0,1,2
        println(a(0))

        var b = new Array[Int](10);  //defines an array of size 10 type integer
        val s= new Array[String](10); // defines an array of size 10 type String
        val st = Array("Hello","world");  //creates an array of 2 elements

        println(st(0)+" "+st(1));

        //26
        val c=ArrayBuffer[Int]() //creates an array buffer
        c+=1            //add new element
        c+=(2,3,5)      //add 3 new elements
        c++=Array(6,7,8); // add 3 new elements

        println(c);

  
    }

}

