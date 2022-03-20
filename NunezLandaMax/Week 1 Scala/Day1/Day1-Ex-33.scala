package example
object Demo{
    def main(args:Array[String])
    {
        //33 Filtering and transformation
        val m1=List(5,12,3,13) //creates a list
        val result = m1.filter(_ <10) //filter, return elements < 10 from the list
        println(result)

        val m2=Map(3->"geeks",4->"for",2->"cs") //Creates mapping
        val result1=m2.transform((key,value)=>value.toUpperCase) //Change to uppercaser elements
        println(result1)
    }
}

