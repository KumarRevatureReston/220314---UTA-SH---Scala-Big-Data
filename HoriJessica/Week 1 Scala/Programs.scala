object Programs extends App {

  //1. Write a Scala program to compute the sum of the two given integer values. If the two values are the same, then return triples their sum.
  def add(a: Int, b: Int): Int = {
    if (a == b)
      (a + b) * 3
    else a + b
  }
  println("Result: " + add(10, 20))
  println("Result: " + add(2, 2))

  println("---------------------------")

  //2. Write a Scala program to create a new string with the last char added at the front and back of a given string of length 1 or more
  def stringHop(a : String):String = {
    var lastLetter = a.charAt(a.length - 1)
      if (a.length >= 1)
        lastLetter + a
      else
      "No input"
  }
  println(stringHop("hello"))
  println(stringHop("Z"))
 // println(stringHop(""))
  println("---------------------------")

  //3. Write a Scala program to get the absolute difference between n and 51. If n is greater than 51 return triple the absolute difference.
  def absoluteDif(n: Int): Int = {
    if (n > 51)
    (n - 51) * 3
    else
     n - 51
  }
  println(absoluteDif(89))
  println(absoluteDif(17))

  println("---------------------------")

  //4. Write a Scala program to check two given integers, and return true if one of them is 30 or if their sum is 30.

  def isThirty(a: Int, b: Int): Boolean = {
    var sum = a + b
    a == 30 || b == 30 || sum == 30
    }
  println(isThirty(14, 1))
  println(isThirty(30, 25))
  println(isThirty(15,15))

  println("---------------------------")


  //5. Write a Scala program to check a given integer and return true if it is within 20 of 100 or 300.
   def withinTwenty(n: Int): Boolean = {
     (n >= 80 && n < 121 || n >=280 && n < 321)
   }
  println(withinTwenty(118))
  println(withinTwenty(305))
  println(withinTwenty(12))

  println("---------------------------")

  //6. Write a Scala program to create a new string where 'if' is added to the front of a given string. If the string already begins with 'if', return the string unchanged

  def amIf(s: String):String = {
    var iffy = "if"
    if (s.charAt(0) == "i" && s.charAt(1) == "f")
    s
    else
      iffy + s
 // BROKEN
  }
  println(amIf("Hi"))
  println(amIf("iframe"))

  println("---------------------------")

  //7. Write a Scala program to remove the character in a given position of a given string.The given position will be in the range 0...string length -1 inclusive.

  def removeMe(s: String, n: Int): String = {
    s.take(n) + s.drop(n + 1)
  }
  println(removeMe("Hello", 4))
  println(removeMe("Hello", 2))

  println("---------------------------")
  //Try another way

  //8. Write a Scala program to exchange the first and last characters in a given string and return the new string.

//  def swapMe(a : String):String = {
//    var lastLetter = a.charAt(a.length - 1)
//    var firstLetter = a.charAt(0)
//
//  }

  // incomplete
}