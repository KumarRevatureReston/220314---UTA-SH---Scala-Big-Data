object Demo {
   def main(args: Array[String]) {
         //1. min and max of the elements
         //the num.min finds the minimum of the set while the num.max finds the maximum
      val num = Set(5,6,9,20,30,45)
      println( "Min element in Set(5,6,9,20,30,45) : " + num.min )
      println( "Max element in Set(5,6,9,20,30,45) : " + num.max )


         //2. common elements between two sets
         //the num1.&(num2) and num1.intersect(num2) both result in the values that the two sets share, which are 9 and 20
      val num1 = Set(5,6,9,20,30,45)
      val num2 = Set(50,60,9,20,35,55)
      println( "num1.&(num2) : " + num1.&(num2) )
      println( "num1.intersect(num2) : " + num1.intersect(num2) )


         //3. adding maps
         //these show the two different ways you can add two maps together
         //by (colors1 ++ colors 2) or colors1.++(colors2)
         //both ways, the second map gets prepended to the first since scala can't append
      val colors1 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
      val colors2 = Map("blue" -> "#0033FF", "yellow" -> "#FFFF00", "red" -> "#FF0000")
      var colors = colors1 ++ colors2
      println( "colors1 ++ colors2 : " + colors )
      colors = colors1.++(colors2)
      println( "colors1.++(colors2)) : " + colors )


         //4. Print Keys and Values
         //the colors3.keys.foreach causes each key in colors3 to be printed along with its value seperately
         //this shows that the key is whatever comes first and the value is what is followed by the arrow
      val colors3 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF","peru" -> "#CD853F")
      colors3.keys.foreach{ i =>  
         print( "Key = " + i )
         println(" Value = " + colors3(i) )}


         //5. Checkin for a key in Map
         //this shows using an if else to check if a key is inside of a map or not
         //if it is, the expression prints the value and if not it prints a specific line
      val colors4 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
      if( colors.contains( "red" )) {
         println("Red key exists with value :"  + colors("red"))
      } else {
           println("Red key does not exist")
      }
      if( colors.contains( "maroon" )) {
         println("Maroon key exists with value :"  + colors("maroon"))
      } else {
         println("Maroon key does not exist")
      }
   }
}

         //6. Scala program of flatMap
         //the flatmap below takes f(y) while y are values from "list" and flattens the results
object Revature {
	def main(args:Array[String]) {
		val list = List(2, 3, 4)
		def f(x:Int) = List(x-1, x, x+1)
		val result = list.flatMap(y => f(y))
		println(result)
	}
}