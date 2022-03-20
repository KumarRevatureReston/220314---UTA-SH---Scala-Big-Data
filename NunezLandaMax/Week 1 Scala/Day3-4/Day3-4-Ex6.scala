package example

object Student {
def main(args:Array[String]) {
    val numberList: List[Int] = List(1,2,3,4)  //creates a list of 4 elements
    val emptyList: List[Int]=List()             //creates an empty list of Integer elements
    val numbersList1: List[Int] = 1::2::3::4::5::Nil   //Creates and adds 5 elements to de list
    val names= "Harry" :: ("Adam" :: ("Jill" :: Nil))  //Creates and adds 3 elements to the list
    val age = Nil  //Creates an empty list
    println( "numberList :" + numbersList1 )   //Show elements of numberList
    println( "numberList1 : " + numbersList1 )  //Shows elements of numberList1
    println( "Head of names array : " + names.head ) //Retunrs the first element of the List
    println( "Tail of names array : " + names.tail ) //Returns all elements of the list without the first
    println( "Check if names is empty : " + names.isEmpty ) //Check if List names is empty
    println( "Check if age is empty : " + age.isEmpty )    //Check if list age is empty
   }
}
