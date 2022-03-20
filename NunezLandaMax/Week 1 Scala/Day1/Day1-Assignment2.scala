package example
//2. Write a Scala program to create a new string with the last char added at the front and back of a given string of length 1 or more
object LastString{
    def main(args:Array[String])
    {
        println(lastString("abcd"));
        println(lastString("vwxyz"));
    }

    def lastString(myString:String):String=
    {
        val lastStr=myString.charAt(myString.length()-1); //last string
        return lastStr+myString+lastStr;
    }
}