package example

object Maps
{
    def main(args:Array[String])
    {
        val name=Map("abc"->"author","pqr"->"coder") //defines a map
        val x=name.get("abc") //get the value from the map according to the key (abc) 
        val y=name.get("xyz") //search for the key xyz in the map and return nothing
        val z=name.get("pqr")

        println(x)
        println(y)
        println(z)

    }
}