package NotePad1.SCALAFundamentalsAssignment

object scala extends App {

  //(1)
  //println(10+2) //2 Int values are being added.
                //println is used here to print the string, move cursor, and add new line.

  //(2)
  //val msg = "Hello World" //immutable value (val) and a string/value type.
  //println(msg)            //println is also used here to print the string, move cursor, and adds a new line.

  //(3)
  //var msg = "Hello!" //Question 3 (msg="Hello!") will result in an error as it stands, as there is no
  //println(msg)       //variable (or var) assigned to the value ("Hello!"). By changing this, and adding
                       //println(msg), "Hello!" will be printed. This will not work with val, as val is
                       //immutable, and thus, is unchangeable. Trying to change a value will result in an error.

  //(4), 5, 6
  //var msg = "Hello World" //Is by default, any integer type. This means that this is mutable, allowing the variable to be changed.
  //println(msg)            //Variable is indicated by the var keyword. Println is used here again to print the string, move
                            //the cursor, and adds a new line. This will print: Hello World.

  //4, (5)
  //var msg="Hello"  //Question 5, (msg="hello!") will not run without error as the Question stands on it's own. It needs to
  //println(msg)     //have the variable attached to the message in order for the code to be executed properly. Question 5 will
                     //also not run if it continues from Question 4, as assigning a var as both "Hello World" and "Hello" will
                     //result in a double definition error.

  //4, 5, (6)              //msg = 3 will need a variable attached to it in order for the code to run. Because variables are, by
  //var msg = 3      //by default, an integer type, the variable must be defined in the statement. The same issue will occur
  //println(msg)     //as Question 5 if you try to redefine the variable after having previously defining it, once again,
                     //resulting in a double definition error.

  //(7)                       //A mathematical expression, which subtracts two values. The answer (90) is then returned using
  //val x = 100 - 10          //the println function.
  //println(x)

  //(8)
  //val  m = { print ("foo "); 1} //This question exclusively uses the (print) function, rather than the (println) function.
                                  //The (print) function does NOT move the cursor, NOR does it move it to a new line. This
                                  //means that when the code is executed, the result "foo" will appear in the compiler.

  //(9) //Missing Question 9 in ScalaFundamentals

  //(10)
  //var x = 5   //We can use (print) instead of (println) here again to print variable x. When this code is executed,
  //print(x)    //variable (x) will be printed. Since var x = 5, "5" will appear in the compiler when ran.

  //(11)                                    //an IF expression. The Code as it is in Question 11 will not run on it's own.
  //val x = 2                               //Since this is a Boolean (True/False) expression, a value must be given first
  //val s = if (x> 0 && x<6) 1 else 0       //so that the if statement has a value to compare it to. This is why we define
  //println(s)                              //val x here as 2. After we add the line of code provided by the ScalaFundamentals
                                            //doc, we can println(s) to perform the expression and determine the value of s.
                                            //Since x = 2, which is greater 0 and less than 6, the compiler will print 1 as
                                            //2 is still greater than 0, but is still less than 6, meaning the condition is true.
                                            //The condition will be false if x is lower than 0 or greater than 6. If the condition
                                            //is false, then result of the expression will be 0 (if else 0)

  //(DEMO)          //Another example of an IF expression. In the ScalaFundamentals text document,
  //val x = 15;     //var is given. This is not correct - since 15 is a value. Thus, var must be
  //if (x < 20)     //changed to val. Since val x is 15, and x is lower than 20, the condition is true -
  //println(x)      //val is lower than 20, and the compiler will print 15. However, if x is greater
                    //than 20, the condition is now false, and will not run in the compiler. x MUST be
                    //lower than 20, unless an ELSE statement is added, which can return a different value,
                    //based on the condition.

  //(12)
  //val x = 3                                               //Another example of an IF expression. In the ScalaFundamentals text document,
  //val t = if (x>0 && x<6) "positive" else "negative"      //x is not defined - we need to define x in order to have a value for (t) to
  //println(t)                                              //compare against. Because I have defined val x as 3, and 3 is greater than 0,
                                                            //but smaller than 6, the line will print as "positive". However, if I define
                                                            //val x to be less than 0, or, greater than 6, the line will print as "negative".

  //(13)
  //var thisArgs = "hello"    //This statement will result in an error for one of two reasons. In example 1,
  //OR var args = "hello"     //you need to define the Arg as this Args, however, it will result in an error
                              //as no main class will be detected. Example 2 will also result in an error as the code
                              //as it stands is attempting to redefine an argument that is already defined as
                              //type Array[String]

  //(14)
  //thisArgs.foreach(x=>println(x))   //This statement essentially prints out an instance of an argument in
                                      //thisArgs (x) for each instance of (x). The => (syntactic sugar)
                                      //function will pass each argument to args array (in the case that x is
                                      //passed.

  //(15)-1
  //args.foreach(println)     //Will result in an error on it's own, but the idea here is that each
                              //argument in the array will be printed to a new line.

  //(15)-2
  //val x = List(1,2,3)   //Here, val x is a list which includes 3 elements (1,2,3). x.foreach(println)
  //  x.foreach(println)  //will print each instance of each element once. The result should be: 1, 2, 3.

  //(16)
  //for(i<- 1 to 5)   //The value of i SHOULD only be between 1 and 5 (otherwise, an exception is thrown)
  //println(i)        //the values 1-5 will be printed as is, based on the condition, and can be called on
                      //by any other expression or function that calls on it (and by it, I mean by calling on
                      //(i))

  //(17)
  //val in = "hello world"              //This code should work on it's own! However, because we are printing
  //var sum = 0                         //the sum, val n String "hello world" (line 1) is irrelevant, as we
  //for (i<-0 until in.length) sum+=i   //are printing the sum, of i, not the val. Because var sum starts at 0
  //print(sum)                          //our sum, or in other words, "starting number" starts at 0. Line 3
                                        //essentially creates a loop, which will run 11 times, adding one to
                                        //our starting sum (0), and adding 1 to i each time, 11 times. This will
                                        //look like: (0+1+2+3+4+5+6+7+8+9+10). The result should be int = 55.

  //(18)
  //for(i<-1 to 3;j<-1 to 3)    //Here, we have 2 expressions: for(i<-1 to 3), and for(j<-1 to 3), of which
  //println(10*i+j)             //i will be multiplied by 10, then have j added to (10*i). For each instance
                                //of i (which can be 1, 2 or 3) and each instance of j (which can be 1, 2, or 3)
                                //the compiler will multiply by 10, and then add j. For example, if i=1 and j=2,
                                //the compiler will print 12 because (10*1(i))+2(j)) = 12.

  //(19)
  //for(i<-1 to 3; j<-1 to 3 if i==j)   //Here, we have 2 expressions similar to Question 18, however we are integrating
  //println(10*i+j)                     //a new syntactic sugar, the == with an if expression. In this case, the int
                                        //i MUST be equal to int j in order to get a result, otherwise, the result will
                                        //be false. For example, when i=1 and j=1, we get ((10*1)+1) which equals 11. However,
                                        //if we assign i=1 and j=2, the compiler will return the result false in the terminal.

  //(20)
  //for(i<-1 to 3; x=4-i; j<- x to 3)   //Here, i can, once again, be ints 1, 2 or 3. x will equal 4 minus the value
  //println(10*i+j)                     //of i, and j will be an int between the value of 1, 2, and 3. This is because:
                                        //i can only be 1, 2, or 3, thus, j can only be: 4-1 (3), 4-2 (2), or 4-3 (1).
                                        //An example of this would be: if i=3, then x=1, then (10*1+j) will be printed as
                                        //println(10*i(3) = 30+1, which equals: 31.

  //(21)
  //val x = for(i<-1 to 20)yield i*2.5   //In this expression, i can be any number between 1 and 20. If I select, for example
  //for (i<-x) println(i)                //i=5, then i (which is 5) will be multiplied by 2.5. This integer is 12.5, AND 12.5
                                         //will be the value of x. This will print the int i=5 12.5, which IS between 1 to 20, as
                                         //well as x, which is 12.5, therefore, meeting the condition. Thus, i can be printed.

  //(22)                          //In this code example, we use a number of FUNCTIONS, which are defined in the code
  //def sayhello() {              //as def. Here we are performing an addition method (represented by the sum) of a+b
  //println("Hello")              //where a=2 and b=5. This will return the int 7, and will print the line "hello".
  //}                             //Therefore, this code should read in the compiler as 7 and beneath that, "hello".
  //
  //def sum(a:Int,b:Int) {
  //println(a+b)
  //}
  //
  //sum(2,5)
  //
  //def func():Int={
  //return 7
  //}
  //
  //def sum(a:Int,b:Any):Any= {
  //println("hello")
  //}

  //(23)
  //def factorial(n:Int):Int=if(n==0)1 else n*factorial(n-1)    //This code example uses a factorial multiplication method
                                                                //in order to define the function of value n. However, if n
                                                                //is 0, the compiler will return 1 when the code is executed.
                                                                //But, let's say that n=4. Then, this function would read as:
                                                                //4*(4-1) which equals 12. However, this is only the first step
                                                                //of the function. 1 will be subtracted from n over each iteration
                                                                //of the factorial so the function would perform like this:
                                                                //4*(4-1)*3*(3-1)*2(2-1)*1 then n=0. The result of the int would
                                                                //thus be, 12*6*2*1.

  //(24)
  //def rect_area(length:Float,breadth:Float)   //In Code Sample 24, we are using a function to define both the length
  //{ val area = length*breadth; print(area)}   //and breadth, both of which are using Floating point, or decimal numbers.
                                                //An example of such would be: length = 5.6 and breadth = 3.2. This code
                                                //should execute, then print out: 5.6*3.2, and that int will be the value of
                                                //the area of rect.

  //(25) - 1 Arrays with values
  //var a = Array(1,2,3)    //This Code sample uses Arrays, which unlike tuples in SCALA, start at 0. This array has 3 indexes,
  //a(4)                    //as seen in the Array (1,2,3). This code should print out: (4,1), (4,2), and (4,3) BUT ONLY IF the Array int was
  //a(0)                    //4, however, it only goes up to 3, and does not have the memory space reserved. Therefore, a must be an int between 1 and 3. NOT 4.
                            //However, because array indices start at 0, a=0 should work just fine. We should see (0,1), (0,2) and (0,3).
                            //in the compiler.



  //(25) - 2 Arrays without values    //Arrays without values can be tricky, but it is possible to assign a string
  //var a = new Array[Int](3)         //to an array, as seen here. If we start from top to bottom, our new Array will
  //var a(1)                          //have 3 indices, indicated by the (3) following [Int]. We then assign our first
  //var a(1)=2                        //array var a(1) with an int value equal to 2. When the code is executed, we should
  //var a                             //have var a = 2.
  //
  //val a = new Array[Int](10)        //Our first thing to take note of here is that we have created a new Array with 10 indices,
  //val s = new Array[String](10)     //indicated by the (10) following the int, each of which are int values. Because Array indices
  //val st = Array("Hello,"world")(2) //start at 0 (unlike tuples in Scala), we will create 10 indices as such: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9.
                                      //Val s also creates 10 indices, starting at 0 BUT they are a STRING TYPE. So, we have created here
                                      //a total of 10 indices, val a which creates 10 INT arrays, and val s which creates 10 STRING arrays.
                                      //Our last string will require 2 more indices, represented by the (2) at the end of the statement.
                                      //Thus, val st will need to have 2 arrays as a result.

  //(26)
  //import scala.collection.mutable.ArrayBuffer   //Here, we are working with ArrayBuffers, which are not the same as Arrays.
  //val a = ArrayBuffer[Int]()                    //The difference is that while Arrays cannot grow in size (memory bytes specifically)
  //a +=1                                         //ArrayBuffers CAN GROW in MEMORY SIZE. This code block is an example of such.
  //a +=(2,3,5)                                   //We can see that in the expression a+=1 we are growing. and therefore ADDING 1 to the
  //a ++=Array(6,7,8)                             //array. We can add multiple elements as seen in a+=(2,3,5). In the last line,
                                                  //we are able to add elements of type array to another instance of another type of type array.

  //(27) - 1
  //val list = 1 :: 2 :: 3 :: Nil   //
  //val list = List(1,2,3)
  //val x = List(1,2.0,33D,4000L)
  //val x = List.range(1,10)
  //val x = List.fill(3)("foo")
  //val x = List.tabulate(5)(n=>n*n)




