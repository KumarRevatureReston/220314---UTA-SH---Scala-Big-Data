package scala_fundamentals_questions

// This refers to the Scala_fundamentals.txt (the questions section) worksheet file handed posted
// to our Discord channel.

// 1. Write a Scala program to compute the sum of the two given integer values.
// If the two values are the same, then return triples their sum.
object Question1 {
  def sum(a:Int ,b: Int): Int = {
    if(a == b)
      return (a+b)*3
    return a+b
  }

  def main(args: Array[String]) = {
    var a: Int = 3
    var b: Int = 2
    print("The sum of a and b is: ")
    println(sum(a,b))
  }
}

// 2. Write a Scala program to create a new string with the last char added at the
// front and back of a given string of length 1 or more
object Question2 {
  def addLast(s:String): String = {
    var r: String = s.charAt(s.length-1) + s + s.charAt(s.length-1)
    return r
  }

  def main(args: Array[String]): Unit = {
    println(addLast("Wicky wild wild"))
  }
}

// 3. Write a Scala program to get the absolute difference between n and 51. If n is greater
// than 51 return triple the absolute difference.
object Question3 {
  def getAbsoluteDifference(n: Int): Int = {
    var r = Math.abs(n-51)
    if(r > 51)
      return r * 3
    return r
  }

  def main(args: Array[String]): Unit = {
    println(getAbsoluteDifference(151))
  }
}


// 4. Write a Scala program to check two given integers, and return true if one of them is 30
// or if their sum is 30.
object Question4 {
  def checkIntegers(a: Int, b: Int): Boolean = {
    if(a == 30 || b == 30 || (a + b) == 30)
      return true
    return false
  }

  def main(args: Array[String]): Unit = {
    println(checkIntegers(30,1))
    println(checkIntegers(1,30))
    println(checkIntegers(15,15))
    println(checkIntegers(2,2))
  }
}

// 5. Write a Scala program to check a given integer and return true if it is within 20 of 100 or 300.
object Question5 {
  def within20(n: Int): Boolean = {
    if((n >= 280 && n <= 320) || (n >= 80 && n <= 120))
      return true
    return false
  }
  def main(args: Array[String]): Unit = {
    println(within20(120))
    println(within20(80))
    println(within20(79))
    println(within20(320))
    println(within20(280))
    println(within20(321))
  }
}


// 6. Write a Scala program to create a new string where 'if' is added to the front of a given string.
// If the string already begins with 'if', return the string unchanged
object Question6 {
  def addIf(s: String): String = {
    if(s.charAt(0) == 'i' && s.charAt(1) == 'f')
      return s

    var r: String = "if" + s
    return r
  }

  def main(args: Array[String]): Unit = {
    println(addIf("Wicky wild wild"))
    println(addIf("ifWicky wild wild"))
    println(addIf("wild wild west"))
  }
}

// 7. Write a Scala program to remove the character in a given position of a given string.
// The given position will be in the range 0...string length -1 inclusive.
object Question7 {
  def removeChar(s: String, i: Int): String = {
    var r = s.substring(0, i) + s.substring(i+1)
    return r
  }
  def main(args: Array[String]): Unit = {
    println(removeChar("Rollin' with the homies",0))
    println(removeChar("Rollin' with the homies",1))
    println(removeChar("Rollin' with the homies",2))
    println(removeChar("Rollin' with the homies","Rollin' with the homies".length-1))
  }
}

// 8. Write a Scala program to exchange the first and last characters in a given string and
// return the new string.
object Question8 {
  def exchangeFirstAndLast(s: String): String = {
    var r = s.charAt(s.length-1) + s.substring(1,s.length-2) + s.charAt(0)
    return r
  }

  def main(args: Array[String]): Unit = {
    println(exchangeFirstAndLast("Continuing to roll with the homies..."))
  }
}