package example

//7. Write a Scala program to remove the character in a given position of a given string.The given position will be in the range 0...string length -1 inclusive. 

object RemoveCharacter
{
    def main(args:Array[String])
    {
        println(removeCharacter("This is my String",5))
    }

    def removeCharacter(myString:String,pos:Int):String=
    {
        if(pos>=0 && pos<=(myString.length()-1))
        {
            return myString.take(pos)+myString.drop(pos+1)  //take the first characters and concatenate it with the last characters one position after the pos position
        }
        else
        {
            println("Wrong position")
            return myString
        }
    }
}