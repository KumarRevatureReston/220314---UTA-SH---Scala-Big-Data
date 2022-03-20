package example
//4. Write a Scala program to check two given integers, and return true if one of them is 30 or if their sum is 30.
object Check30
{
    def main(args:Array[String])
    {
        println(check30(30,5))
        println(check30(10,30))
        println(check30(15,15))
        println(check30(2,3))
    }

    def check30(a:Int,b:Int):Boolean=
    {
        if(a==30 || b==30 || (a+b)==30)  // conditional statement with OR
            return true
        else 
            return false
    }
}