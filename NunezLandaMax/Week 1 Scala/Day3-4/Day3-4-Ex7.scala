package example



object Student1 {
    def main(args: Array[String]) {
        val emptySet: Set[Int]=Set()  //creates an empty set of elements
        val numbersSet: Set[Int]=Set(1,2,3,4)    //creates a set of 4 Integer non repeated elements
        val name = Set("Smith", "Brown", "Allen")  //creates a set of 3 String non repated elements
        val id: Set[Int] = Set()                  //creates a set of empty Integer elements

        println( "Head of name : " + name.head )     //return the first elemetn of the set
        println( "Tail of name : " + name.tail )     //return all elements of the se without the first
        println( "Check if name is empty : " + name.isEmpty )  //check if name set is empty
        println( "Check if id is empty : " + id.isEmpty )    //check if id set is empty
   }
}