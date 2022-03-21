//1. min and max of the elements
object Demo {
  def main(args: Array[String]) {
    val num = Set(5,6,9,20,30,45)                                 //This is a val 'num' that's assigned to a set with 6 integer elements


    println( "Min element in Set(5,6,9,20,30,45) : " + num.min )  //This returns the element with the minimum value in the set
    println( "Max element in Set(5,6,9,20,30,45) : " + num.max )  //This returns the element with the maximum value in the set
  }                                                               //The output will be:
}                                                                 //5
                                                                  //45

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//2. common elements between two sets
object Demo {
  def main(args: Array[String]) {
    val num1 = Set(5,6,9,20,30,45)                               //This block of code applies other methods to sets
    val num2 = Set(50,60,9,20,35,55)

    println( "num1.&(num2) : " + num1.&(num2) )                  //This returns matching numbers in both sets
    println( "num1.intersect(num2) : " + num1.intersect(num2) )  //This is another way of doing the same thing as the line above
  }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//3.
object Demo {
  def main(args: Array[String]) {
    val colors1 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")   //These two lines create maps which are a series
    val colors2 = Map("blue" -> "#0033FF", "yellow" -> "#FFFF00", "red" -> "#FF0000")  //of key-value pairs

    // use two or more Maps with ++ as operator
    var colors = colors1 ++ colors2                  //using the ++ operator combines the two maps together, and doesn't preserve any
    println( "colors1 ++ colors2 : " + colors )      //duplicate key-value pairs.

    // use two maps with ++ as method
    colors = colors1.++(colors2)                     //This block of code does the same as the block above. It is just a different way
    println( "colors1.++(colors2)) : " + colors )    //of combining the two maps.
  }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//4. Print Keys and Values
object Demo {
  def main(args: Array[String]) {
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF","peru" -> "#CD853F")

    colors.keys.foreach{ i =>                                   //This block of code uses a for loop to print out each key
      print( "Key = " + i )                                     //followed by each value in the 'colors' map
      println(" Value = " + colors(i) )}
  }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//5. Checking for a key in Map
object Demo {
  def main(args: Array[String]) {
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")

    if( colors.contains( "red" )) {
      println("Red key exists with value :"  + colors("red"))          //This is an if statement that has a condition that checks to see if there
    } else {                                                           //is a key, "red", and prints its corresponding value if it exists. If the
      println("Red key does not exist")                                //map doesn't contain the key "red" then it prints that it doesn't exist
    }

    if( colors.contains( "maroon" )) {                                 //This if statement does the exact same as the one above, but it checks for
      println("Maroon key exists with value :"  + colors("maroon"))    //the existence of the the key "maroon"
    } else {
      println("Maroon key does not exist")                             //the output will be:
    }                                                                  //Red key exists with value :#FF0000
  }                                                                    //Maroon key does not exist
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//6. Scala program of flatMap
// Creating object
object Revature
{

  def main(args:Array[String])
  {

    val list = List(2, 3, 4)                //this creates a list of 3 integer elements called 'list'

    def f(x:Int) = List(x-1, x, x+1)        //this is a function that takes in an int and creates a list of elements that are one less than,
                                            //one equal to, and one greater than the int value

    val result = list.flatMap(y => f(y))    //this creates a flatmap of 'list' and passes the values of list into the function f above
                                            //it also stores this new flat map in a val 'result'
    println(result)                         //this line prints out the new flat map

  }
}
