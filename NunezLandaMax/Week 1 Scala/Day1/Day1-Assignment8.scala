package example
//8. Write a Scala program to exchange the first and last characters in a given string and return the new string. 
object SwitchCharacters
{
    def main(args:Array[String])
    {
        println(switchCharacters("12"))
    }

    def switchCharacters(myString:String):String=
    {
        val middleString=myString.take(myString.length-1).drop(1); //takes middle of the string
        return myString.charAt(myString.length-1) + middleString + myString.charAt(0); //return the last character concatenated with teh middle of the string and the first letter
    }
}