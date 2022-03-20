package example
object Demo{
    def main(args:Array[String])
    {
        //28 Tuples
        val a=(1,4,"Bob","Jack")  //Creates a tuple of 4 elements
        println(a._2);    //gets the second element of the tuple

    
        val ab=(4,3,2,1)  //creates an array of 4 elements
        ab.productIterator.foreach{
            i=>println("value ="+i)    //loop that print all elements of the array
        }
        val mn=(1,"wonderful",20.2356) //creates a tuple of 4 elements
        println("concatenated String: "+mn.toString()); //show all elements of the tuple
    }

}

