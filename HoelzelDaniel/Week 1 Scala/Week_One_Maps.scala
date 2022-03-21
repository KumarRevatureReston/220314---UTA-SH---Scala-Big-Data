object Week_One_Maps {
    def main(args: Array[String]): Unit = {
        
        //1) min and max of the elements
        val num = Set(5, 6, 9, 20, 30, 45)
        
        //println("Min element in Set(5,6,9,20,30,45) : " + num.min)//prints the lowest element 5
        //println("Max element in Set(5,6,9,20,30,45) : " + num.max)//prints the highest element 45
        
        //2) common elements between two sets
        val num1 = Set(5,6,9,20,30,45)
        val num2 = Set(50,60,9,20,35,55)
    
        //println( "num1.&(num2) : " + num1.&(num2) ) //prints HashSet(20,9) Checks which elements exist in both sets
        //println( "num1.intersect(num2) : " + num1.intersect(num2) ) //prints same thing as last line. Prints elements that are contained in both sets
        
        //3)
        val colors1 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
        val colors2 = Map("blue" -> "#0033FF", "yellow" -> "#FFFF00", "red" -> "#FF0000")
    
        // use two or more Maps with ++ as operator
        //var colors = colors1 ++ colors2
        //println( "colors1 ++ colors2 : " + colors ) //combines both maps and prints the combined map. Only prints 5 elements as red is in both
    
        // use two maps with ++ as method
        //colors = colors1.++(colors2)
        //println( "colors1.++(colors2)) : " + colors )//does the same thing as the last code
        
        //4) Print Keys and Values
        /*val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF","peru" -> "#CD853F")
    
        colors.keys.foreach{ i =>
            print( "Key = " + i ) //prints a line with each of the keys
            println(" Value = " + colors(i) )} //prints the relevant value for each key*/
        
        //5) Checking for a key in Map
        /*val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    
        if( colors.contains( "red" )) {
            println("Red key exists with value :"  + colors("red")) //checks if red is a key in the colors map. Since it is, it prints the value
        } else {
            println("Red key does not exist")//would print does not exist if it weren't there
        }
    
        if( colors.contains( "maroon" )) {
            println("Maroon key exists with value :"  + colors("maroon"))//checks if maroon is a key in the color map
        } else {
            println("Maroon key does not exist")//maroon does not exist in the map, so it prints that key does not exist
        }*/
        
        //6) Scala program of flatMap
        val list = List(2, 3, 4) //creates a list of 3 values
    
        def f(x:Int) = List(x-1, x, x+1) //creates a function that transforms list
    
        val result = list.flatMap(y => f(y))//runs the function on each value in the list
    
        println(result)//prints the result of the function (1, 2, 3, 2, 3, 4, 3, 4, 5)
        
        
    }
}
