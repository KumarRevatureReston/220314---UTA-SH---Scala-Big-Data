//complete first 6 questions for assignment


//object one{                                                       //problem 1
    //def main(args: Array[String]){
        //val name = Map("abc" -> "author", "pqr" -> "coder")
        //val x = name.get("abc")
        //val y = name.get("xyz")

        //println(x)
        //println(y)
    //}
//}
//------output of Some(author) due to successful 'get' of "abc", 'none' return for "xyz" since not defined. (1)



//class ExceptionExample{                                           //problem 2
    //def divide(a:Int, b:Int)={
        //a/b
        //println("rest of the code is executing...")
    //}
//}
//object MainObject{
    //def main(args: Array[String]){
        //var e = new ExceptionExample()
        //e.divide(100,0)
    //}
//}
//------no output since exception 'divide by zero' is created. (2)


//class ExceptionExample{                                            //problem 3
    //def divide(a:Int, b:Int)={
            //try {
                //a/b
            //}
            //catch{
                //case e: ArithmeticException=> println(e)
            //}
        //println("Rest of the code is executing")
    //}
//}
//object MainObject{
    //def main(args: Array[String]){
        //var e = new ExceptionExample()
        //e.divide(100,0)
        //}
    //}
//------output of '/ by zero' exception, line of "rest of..." prints to indicate the code continues  (3)



//class ExceptionExample{                                         //problem 4
    //def divide(a:Int, b:Int) ={
        //try{
            //a/b                                                 //no issue since no div by zero
            //var arr = Array(1,2)                                //simple two element array defined
            //arr(10)                                             //index 10 of 2 element array is out of bounds
        //}
        //catch{
            //case e: ArithmeticException => println(e)
            //case ex: Exception => println(ex)
            //case th: Throwable=>println("found an unknown exception"+th)
        //}
        //finally{
            //println("Finally block always executes")
        //}
        //println("Rest of the code is executing...")
        //println(a/b)                                             //added to visualize output of (100,10)
    //}
//}
//object MainObject{
    //def main(args: Array[String]){
        //var e = new ExceptionExample()
        //e.divide(100,10)                                         //applies divide function to new variable 'e'
    //}
//}
//------output of out of bounds exception for arr(10), finally block executes as expected and rest of code runs. (4)


//object MainObject {                                                 //problem five
    //def main(args: Array[String]){
        //var result = search ("Hello")
        //print(result)
   // }
    //def search (a:Any):Any = a 
    //match{
        //case 1 => println("One")
        //case "Two" => println("Two")
        //case "Hello" => println("Hello")
        //case _ => println("No")
    //}
//}
//------output of Hello because search matches case "Hello" and follows the command to print. adds a () because of search structure. (5)


//object six{                                                            //problem 6 intro
    //def main(args: Array[String]){
        //val numbersList: List[Int] = List(1,2,3,4)
        //val emptyList: List[Int] = List()
        //val numbersList: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil           //cannot run same time as previous numbersList
        //println(numbersList)
        //println(emptyList)
    //}
//}
//------output of val exactly as shown in definition. second numbersList output is same as first, constructed differently
//object Student{                                                         //problem 6
    //def main(args: Array[String]){
        //val names = "Harry" :: ("Adam" :: ("Jill" :: Nil))              //assembled list of names
        //val age = Nil                                                   //empty placeholder for age value
        //println( "Head of names array : "+ names.head)                  //print function concatenating predefined value operators
        //println( "Tail of names array : "+names.tail)
        //println("Check if names is empty : "+names.isEmpty)
        //println("Check if age is empty : "+age.isEmpty)
    //}
//}
//------output of single lead element when using names.head of Harry. names.tail pulls list of nonlead elements. both checks
//------use boolean .isEmpty function to determine if the values are empty or populated and display accordingly. (6)


//object Student {                                                //problem seven
   //def main(args: Array[String]) {
        //val emptySet: Set[Int] = Set() 
        //val numbersSet: Set[Int] = Set(1, 2, 3, 4)
        //val name = Set("Smith", "Brown", "Allen")
        //val id: Set[Int] = Set()

        //println( "Head of name : " + name.head )                //will output Smith
        //println( "Tail of name : " + name.tail )                //will output all but Smith as Set
        //println( "Check if name is empty : " + name.isEmpty )   //will output false since name is not empty
        //println( "Check if id is empty : " + id.isEmpty )       //will output true since id is empty
   //}
//}
//------function gives multiple outputs with string increasing the readibility and format of output. (7)


//import scala.collection.immutable._           //eight
//object MainObject{  
    //def main(args:Array[String]){  
        //val games = Set("Cricket","Football","Hockey","Golf")  
        //val alphabet = Set("A","B","C","D","E")   
        //val mergeSet = games ++ alphabet                        // Merging two sets  
       //println("Elements in games set: "+games.size)           //prints the number of elements in games; 4 
        //println("Elements in alphabet set: "+alphabet.size)     //prints the number of elements in alpha; 5
        //println("Elements in mergeSet: "+mergeSet.size)         //prints out the new merged list
        //println(mergeSet)  
    //}  
//}  
//------function combines sets into a new, single set, seemingly of a middle-join type. (8)


//object Country {                        //nine
	//def main(args:Array[String]) {
	    //val country_1 = List("States","Britain","New Zealand")
	    //val country_2 = List("Austria","Belgium","Canada")

	    //val country = country_1 ::: country_2               //appends 2 to the end of 1
	    //println( "country_1 ::: country_2 : " + country )
	    //val cont = country_1.:::(country_2)                 //appends 1 to the end of 2
        //println( "country_1.:::(country_2) : " + cont )
	    //val con = List.concat(country_1, country_2)         //standard concat of 2 to end of 1
        //println( "List.concat(country_1, country_2) : " + con  )
   //}
//}
//------multple functions combine two seperate lists into single list and print output (9)