package example
//1Write a Scala program to compute the sum of the two given integer values. If the two values are the same, then return triples their sum. 
object sum{
    def main(args:Array[String])
    {
        println(sum(5,6))
        println(sum(7,7))
    }

    def sum(a:Int,b:Int):Int=
    {
        if(a!=b)
            return(a+b)
        else
            return(a+b)*3;
    }
}