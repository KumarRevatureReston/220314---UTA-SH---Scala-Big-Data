package scala_flatmaps

// This refers to the sets__mapsFlatmaps.txt (the questions section) worksheet file handed posted
// to our Discord channel.

// 1. min and max of the elements
object Demo1 {
  def main(args: Array[String]): Unit = {
    val num = Set(5,6,9,20,30,45)
    println("Min element in Set(5,6,9,20,30,45) : " + num.min)
    println("Max element in Set(5,6,9,20,30,45) : " + num.max)
  }
}

// 2 . Common elements between two sets
object Demo2 {
  def main(args: Array[String]): Unit = {
    val num1 = Set(5,6,9,20,30,45)
    val num2 = Set(50,60,9,20,35,55)

    println("num1.&(num2) : " + num1.&(num2))
    println("num1.intersect(num2) : " + num1.intersect(num2))
  }
}

// 3.
object Demo3 {
  def main(args: Array[String]): Unit = {
    val colors1 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    val colors2 = Map("blue" -> "#0033FF", "yellow" -> "#FFFF00", "red" -> "#FF0000")

    // use two or more Maps with ++ as operator
    var colors = colors1 ++ colors2
    println("colors1 ++ colors2 : " + colors)

    // use two maps with ++ as method
    colors = colors1.++(colors2)
    println("colors1.++(colors2) : " + colors)
  }
}

// 4. Print Keys and Values
object Demo4 {
  def main(args: Array[String]): Unit = {
    val colors =  Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")

    colors.keys.foreach { i =>
      print("Key = " + i)
      println("Value = " + colors(i))
    }
  }
}


// 5. Checkin' for a key in Map
object Demo {
  def main(args: Array[String]): Unit = {
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")

    if(colors.contains("red")) {
      println("Red key exists with value : " + colors("red"))
    } else {
      println("Red key does not exist")
    }
    if(colors.contains("maroon")) {
      println("Maroon key exists with value : " + colors("maroon"))
    } else {
      println("Maroon key does not exist")
    }
  }
}


// 6. Scala program of flatMap
object Revature {
  def main(args: Array[String]): Unit = {
    val list = List(2,3,4)
    def f(x:Int) = List(x-1, x, x+1)

    val result = list.flatMap(y => f(y))
    println(result)
  }
}