package scala_codes_example


// This refers to the scala_codes_example.txt worksheet file handed posted to our Discord channel.

// Scala Example 1: Hello Scala
// the following example is a simple Scala program

object ScalaExample {
  def main(args:Array[String]): Unit = {
    println("Hello Scala")
  }

  // In the above code we have created an object ScalaExample/
  // 2. Below is an example using a functional approach
  def scalaExample {
    println("Hello Scala")
  }
  scalaExample            // Calling of function

  // 3 Scala Example (If statement)
  var age:Int = 20
  if(age > 18) {
    println("Age is greater than 18")
  }

  // 4 Scala If-Else Statement
  val condition = true
  if(condition) {
    // statements executed if condition is true
  }
  else {
    // statements executed if condition is false
  }
}



