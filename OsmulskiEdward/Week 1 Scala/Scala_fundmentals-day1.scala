class MyClass{
  def main(args: Array[String]) = {
    //fundamentals.txt assignment

    //1)
    10+2
    //This statement does nothing and will not do anything unless you assign the result of the expression to a var or val.
    //Such as writing the statement var x = 10+2. The value 12 would then be assigned to the variable x. which you could then manipulate or print

    //2)
    val msg = "Hello World"
    //this expression assigns the immutable value of "Hello World" to the val msg. It also implicitly understands that the datatype is a string.

    //3)
    msg="Hello!"
    //this will throw a 'reassignment to val' exception because the val variable type is immutable and cannot be changed once it has been initialized.

    //4)
    var msg = "Hello World"
    //this will throw a 'double definition' exception since msg has already been defined as a val.
    //To fix this you would have to change the name of the var or val to something other than msg.

    //5)
    msg="Hello!"
    //This would throw the same exception as prompt 3. However assuming the val name has been changed, this will just change the value of the var msg to "Hello!"
    //rather than what it was. This is because var variables are mutable which means that their values are able to be changed.

    //6)
    msg = 3
    //This would throw a type mismatch exception. Since the original var msg was implicitly defined as a string datatype the value 3 would either
    //have to be cast to a string type or would have be edited to say "3".

    //7)
    val x = {val a=10;val b=100; b-a}
    //This expression defines the val x and sets it equal to a field where the val a and the val b are initialized to be 10 and 100 respectively.
    //Then defines x as the difference between b and a. another way this could be written is:
    /*val a=10
     *val b=100
     *val x = b-a
     */

    //8)
    val file = scala.io.Source.fromFile("kumar").mkString
    /* This expression uses the fromfile() to read a file called "kumar" and uses the mkString method to transfer the content to a string stored in the val 'file'.
     * From what I've read about scala.io.Source the file name would also require a file name extension such as .txt and reading the file using this method would
     * the file open as long as the JVM is running. A better way of doing this would be:
     * val file = scala.io.Source.fromFile("kumar.txt")
     * val content = file.mkString
     * file.close()
     * Additionally the fromFile method can use an absolute path such as C:/users/... or a relative path to accesst the fill in question.
     */


    //9)
    val m = { print ("foo "); 1}
    //This line of code creates a val variable called 'm' and assigns it to a block of code that will print the statement "foo " to the terminal and assign the value
    //1 to the variable 'm'

    //10)
    var x = 5
    //This would throw the same 'double definition' exception as prompt 4 since x is already defined as a value. Otherwise it would assign the integer 5 to the var x

    //11)
    val s = if (x>0 && x<6) 1 else 0
    //assuming you are using the value of x from prompt 10. This would assign the integer value of 1 to the val s because the var x from (10) is 5 which is greater than 0
    //and less than 6

    //12)
    val t = if (x>0 && x<6) "positive" else "negative"
    //assuming the same as above. This would assign the string value of "positive" to the val t. if x had been greater than 6 or less than 0 than the string value
    //would be "negative"

    //13)
    var args = "hello"
    //This would throw an exception because args is reserved for the main method parameter. assigning args to "hello" would throw an excption because the main method
    //would be expecting a string array from the console.

    //14)
    args.foreach(arg=>println(arg))
    //This line of code will take in and loop through the args array using .foreach and then print each arg to a new line in the terminal.

    //15)
    args.foreach(println)
    //This code does the same as question 14, it's just shorter.

    //15.5)
    val x = List (1,2,3)
    x.foreach{println}
    //This creates a list and assigns it to the val x. Then uses the foreach command to iterate over it and print each value in the list on a separate line

    //16)
    for(i<-1 to 5)
      println(i)
    //this will print out the values from 1 to 5 on separate lines

    //17)
    val in = "hello world"
    var sum = 0
    for (i<-0 until in.length) sum+=i
    print(sum)
    //this creates a val in assigned a string "hello world", a var sum assigned an integer 0, then uses a for loop to iterate over an integer startig at 0 and
    //ending at the value just before the length of the string "hello world". The for loop adds that integer to the var sum until the for loop ends. Then it
    //prints out the sum, which happens to be 55, which is the sum of the number 1 to 10.

    //18)
    for(i<-1 to 3;j<-1 to 3)
      println(10*i+j)
    //this will print out 9 numbers on different lines iterating through both i and j. importantly the line within the println statement follows order of operations.
    //the values printed will be 11, 12, 13, 21, 22, 23, 31, 32, 33.

    //19)
    for(i<-1 to 3;j<-1 to 3 if i==j) println(10*i+j)
    //This is the same as above except the if statement where i=j means that it will only proceed to print if i=j.
    //the values printed will be 11, 22, 33.

    //20)
    for(i<-1 to 3;x=4-i;j<- x to 3) println(10*i+j)
    //This is the same as above except the range of j changes with each iteration of the integer for i. for i=1 there is only one value of j possible, for i=2 there is 2,
    //and for i=3 there is 3. Which is why there is 6 values printed instead of the 9 for problem 18.
    //the values printed will be 13, 22, 23, 31, 32, 33.

    //21)
    val x = for(i<-1 to 20)yield i*2.5
    for (i<-x) println(i)
    //The first line of code here creates a val variable called 'x' and assigns it an Double array that is comprised of the numbers 1-20 each multiplied by 2.5.
    //The second line iterates through the Double array 'x' and prints out the prints out each value on its own line.
    //The output for question 21 is 2.5, 5.0, 7.5, 10.0, . . ., 42.5, 45.0, 47.5, & 50.0.

    while loop
    vim Demo_4.scala
    Object Demo_4{
      def main(args:Array[String]) {
        var a=10;
        while( a<20) {
          println("value of a = " + a);
          a= a+1;
        }
      }
    }
    //Disregarding the first two lines of this block of code the only thing that will stop this code from working as it should is the declaration of the object.
    //The object keyword must be written in all lowercase letters to work properly. The body of the main method here declares a var 'a' and assigns it a value of 10,
    //then a while loop checks to see if the 'a' is less than 20, if it is, then the value of a is printed to the terminal via the println function. Lastly the value
    //of 'a' is incremented by 1 and the while loop continues until the condition is no longer satisfied. The output is the numbers 10 through 19 printed out on different lines


    dowhile loop
    var nodb = 2

    do {
      nodb +=1
      println(s"nodb = $nodb")
    }while(nodb < 10)
    //This block of code doesn't work unless it is within a method and currently throws an illegal top level definition error. The do-while loop will always complete the contents
    //of the do-while loop at least once regardless of the condition set in the while statement. This block of code set the var 'nodb' to the value of 2, then conducts a do-while
    //loop where 'nodb' is incremented by 1 then printed to the terminal using the println function. Within the println statement is the the string interpolator 's' before the string
    //that allows the variable nodb to be inserted into the string literal. This is done by using the '$' symbol before declaring the variable name. The end of the while loop uses the
    //where nodb is less than 10. The output for this code is the numbers 3 through 10.


    //22)

    def sayhello() {
      println("Hello")
    }

    def sum(a:Int,b:Int) {
      println(a+b)
    }

    sum(2,5)

    def func():Int={
      return 7
    }


    def sum(a:Int,b:Any):Any= {
      println("hello")
    }
    //To have this code work properly as is, all of it would need to be wrapped in an object and the call to the method sum should be placed within the main method.
    //The function sayhello() takes in no args and simply prints "Hello" to the terminal when called.
    //The first definition of function sum(a:Int,b:Int) takes two Int parameters and prints their sum to the terminal.
    //The function func() takes in no args and just returns the value 7 when called.
    //The second definition of the function sum(a:Int,b:Any) is an overloaded function that takes in variables with different dataTypes than the first definition of
    //the sum function. The second sum function takes an Int and a data type of Any. All scala data types are instances of Any, so the Any datatype will take in any
    //data type to pass into the function. The second sum function also has different implementation in that it just prints "hello" to the terminal.


    //23)
    def factorial(n:Int):Int=if(n==0)1 else n*factorial(n-1)
    //This is the commonly used example of recursion, this method called factorial takes in an int parameter. An if else statement then determines if the int value is 0,
    //and if not then the the function will output the number multiplied the result of the function being called again with the int now decremented by 1.
    //for example:
    //factorial(3), this means n=3, n!=0 so factorial(3)=3*factorial(3-1)
    //factorial(2)=2*factorial(2-1)
    //factorial(1)=1*factorial(1-1)
    //factorial(0)=1
    //factorial(3)=3*2*1*1 or 6

    Object Demo{
      def main(args:Array[String]) = {
        var result= functionExamp(15,2)
        println(result)
      }
      def functionExamp(a:Int,b:Int):Int={
        if(b == 0)
          0
        else
          a+functionExamp(a,b-1)
      }
    }
    //This is another example of a recursive function. The function functionExamp does the same thing as multiplying two number together.
    //A var 'result' is set equal to the output of the function functionExamp passing in the int values 15 and 2. If the value of the the
    //second number is not 0 then the function adds the value of a back to the function called again with second number being decremented by 1.
    //The function operates as follows:
    //functionExamp(15, 2), where a=15 and b=2, b!=0 therefore return a+functionExamp(15,2-1)
    //functionExamp(15, 1), where a=15 and b=1, b!=0 therefore return a+functionExamp(15,1-1)
    //functionExamp(15, 0), where a=15 and b=0, b==0 therefore return 0
    //working backwards we get result = 0 + a + a or result = 15 + 15 = 30, which also happens to be the product of the two original parameters 15 * 2 = 30
    //finally the program prints result to the terminal

    //24)
    def rect_area(length:Float,breadth:Float)
    { val area = length*breadth; print(area)}
    //This function takes in two Float parameters multiplies them together, assigns them to the val 'area' and then prints that value to the terminal.
    //This function would need to be called using from the main method using rect_area(0.0f, 0.0f).

    //25)

    //Arrays with values

    var a = Array(1,2,3)
    a(4)
    a(0)

    //Arrays without values
    var a = new Array[Int](3)
    a(1)
    a(1)= 2
    a

    val a = new Array[Int](10)    //this creates an Int array with 10 empty elements
    val s = new Array[String](10)  //this creates a string array with 10 empty elements
    val st = Array("Hello","world")     //this creates a string array called 'st' with two elements, "Hello" and "world"

    //26)
    import scala.collection.mutable.ArrayBuffer
    val a = ArrayBuffer[Int]()                 //declaration of an Int ArrayBuffer
    a +=1              //This adds another element with a value of 1 to the ArrayBuffer
    a +=(2,3,5)        //This will add the three elements listed to the next available spots in the ArrayBuffer
    a ++=Array(6,7,8)  //This add the Array(6,7,8) to the ArrayBuffer, note the ++= is used to add another collection to the ArrayBuffer
  }
}
