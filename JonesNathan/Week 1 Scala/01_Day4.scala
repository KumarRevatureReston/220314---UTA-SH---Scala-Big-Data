//remove comments to activate code if needed. End of question or code segment will be given by ------.


//object one{
   //def main(args: Array[String]) {
      //val num = Set(5,6,9,20,30,45)
      //println( "Min element in Set(5,6,9,20,30,45) : " + num.min )  //.min function will look for lowest value in set
      //println( "Max element in Set(5,6,9,20,30,45) : " + num.max )  //.max function will look for highest value in set
   //}
//}
//------output of given strings with associated max and min elements. (1)


//object Demo {
    //def main(args: Array[String]) {
        //val num1 = Set(5,6,9,20,30,45)
        //val num2 = Set(50,60,9,20,35,55)
        //println( "num1.&(num2) : " + num1.&(num2) )
        //println( "num1.intersect(num2) : " + num1.intersect(num2) )
   //}
//}
//------output of the matching numbers between the two sets. "intersect" and "&" operator both do the same thing here. (2)


//object three{
    //def main(args: Array[String]) {
        //val colors1 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
        //val colors2 = Map("blue" -> "#0033FF", "yellow" -> "#FFFF00", "red" -> "#FF0000")

        //var colors = colors1 ++ colors2                 //combine operator of two maps
        //println( "colors1 ++ colors2 : " + colors )

        //colors = colors1.++(colors2)                    //same process, different syntax
        //println( "colors1.++(colors2)) : " + colors )
    //}
//}
//------output of set of all unique keys and values in both 1 & 2 as single map, repeats are not shown. (3)


//object four{
    //def main(args: Array[String]) {
        //val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF","peru" -> "#CD853F")

        //colors.keys.foreach{ i =>  
        //print( "Key = " + i + " : ")            //added additional " : " to help readability
        //println(" Value = " + colors(i) )}
    //}
//}
//------output of keys and associated values in easy to parse lines. (4)


//object five {
    //def main(args: Array[String]) {
        //val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")

        //if(colors.contains( "red" )) {                          //searches for a certain key and outputs value
            //println("Red key exists with value :"  + colors("red"))
        //} else {
            //println("Red key does not exist")
        //}
        //if(colors.contains( "maroon" )) {
            //println("Maroon key exists with value :"  + colors("maroon"))
        //} else {
            //println("Maroon key does not exist")
        //}
    //}
//}
//------output of red key exists along with its value since it was found. output of no maroon key since not in map set. (5)


//object six{
	//def main(args:Array[String]){
		//val list = List(2, 3, 4)
		//def f(x:Int) = List(x-1, x, x+1)        //creates a list for each element of original list based on function
		//val result = list.flatMap(y => f(y))    //defines result value as applies flatmap of function
		//println(result)
	//}
//}
//------ output of a list(1, 2, 3, 2, 3, 4, 3, 4, 5) because the f(x) function gives 3 values for each element and flatmap compresses them into a single list. (6)