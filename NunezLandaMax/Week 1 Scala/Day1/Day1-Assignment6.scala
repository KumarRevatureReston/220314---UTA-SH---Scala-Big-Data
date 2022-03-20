package example
//6. Write a Scala program to create a new string where 'if' is added to the front of a given string. If the string already begins with 'if', return the string unchanged

object ChangeString
{
    def main(args:Array[String])
    {
        println(checkIf("if this is my String"))
        println(checkIf(" this is my String"))
    }

    def checkIf(myString:String):String={
        if(myString.startsWith("if"))  //check if myString begins with if
        {
            return myString
        }
        else
        {
            return "if"+myString;
        }
    }
}
