1.//min and max of the elements
object Demo { //object Demo had been created
  def main(args: Array[String]) { //defining the methods for object Demo
    val num = Set(5,6,9,20,30,45)//immutable value for num is a Set with six Ints


    println( "Min element in Set(5,6,9,20,30,45) : " + num.min )
    //this output will show the smallest integer in the Set using '.min' for the elements in 'num'
    println( "Max element in Set(5,6,9,20,30,45) : " + num.max )
    //this output will show the biggest integer in the Set using '.max' for the elements in 'num'
  }
}

2.//common elements between two sets
object Demo { //object Demo had been created
  def main(args: Array[String]) { //defining the methods for object Demo
    val num1 = Set(5,6,9,20,30,45) //immutable value for num1 is a Set with six Ints
    val num2 = Set(50,60,9,20,35,55)//immutable value for num2 is a Set with six Ints

    println( "num1.&(num2) : " + num1.&(num2) ) //finding the Ints are each sets. HashSets are 20 and 9
    println( "num1.intersect(num2) : " + num1.intersect(num2) ) //finding the Ints are each sets. HashSets are 20 and 9
  }
}


//3.
object Demo { //object Demo had been created
  def main(args: Array[String]) { //defining the methods for object Demo
    val colors1 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    //immutable value for color1, which uses a Map to math elements within the list.
    val colors2 = Map("blue" -> "#0033FF", "yellow" -> "#FFFF00", "red" -> "#FF0000")
    //immutable value for color2, which uses a Map to math elements within the list.

    // use two or more Maps with ++ as operator
    var colors = colors1 ++ colors2
    println( "colors1 ++ colors2 : " + colors )
    //This output will have all the colors matched with their keys.

    // use two maps with ++ as method
    colors = colors1.++(colors2)
    println( "colors1.++(colors2)) : " + colors )
    //This output will have all the colors matched with their keys.
  }
}

//4./Print Keys and Values
object Demo { //object Demo had been created
  def main(args: Array[String]) { //defining the methods for object Demo
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF","peru" -> "#CD853F")
    //immutable value for colors, which uses a Map to match elements within the list.
    colors.keys.foreach{ i => //matching the keys with their values
      print( "Key = " + i )
      println(" Value = " + colors(i) )}
    //the output will have keys with matching values
  }
}

5.//Checkin for a key in Map
object Demo { //object Demo had been created
  def main(args: Array[String]) {//defining the methods for object Demo
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    //immutable value for colors, which uses a Map to match elements within the list.
    if( colors.contains( "red" )) {
      //conditional that uses '.contains' to see if 'red' exist within the variable 'colors'
      println("Red key exists with value :"  + colors("red"))
      //output that will show the value of "red" because red does exist within the element of colors
    } else {
      println("Red key does not exist")
      //the alternative for if condition that will not be activated
    }

    if( colors.contains( "maroon" )) {
      // //conditional that uses '.contains' to see if 'marron' exist within the variable 'colors'
      println("Maroon key exists with value :"  + colors("maroon"))
      //output that will not show the value of "maroon" because maroon does not exist within the element of colors
    } else {
      println("Maroon key does not exist")
      // this else condition will be true and activated because the if condition prior was false.
    }
  }
}

6. // Scala program of flatMap

// Creating object
object Revature //object Revature had been created
{

  def main(args:Array[String]) //defining the methods for object Revature
  {

    val list = List(2, 3, 4) //immutable value for list that contains three Ints

    def f(x:Int) = List(x-1, x, x+1) //defining a method for 'f' where the x Int is using subtraction,(the value itself), and addition
    // expressions based on the Int element inside of 'list'



    val result = list.flatMap(y => f(y))
    //immutable value for result that will take the elements in list and the function of y to create a flatmap
    // that output all the elements in each list in resulting in 1,2,3,2,3,4,3,4,

    println(result) // 1,2,3,2,3,4,3,4,

  }
}