object Scala_Fundamentals{
    def main(args:Array[String]){
        
    println(10+2)   /* 1 */
        /*  simple computation of 10 + 2, the output here would be 12
      2  val msg = "Hello World"

      3  msg = "Hello!" */
        /* will run an error as a Val is immutable, can not be changed */
    var msg = "Hello World" /* 4 */
/* will be a mutable variable and will be changed to "Hello!" by the following line and then will run an error with 6, since there is a type difference, and variable types must remain the same */
    msg = "Hello!"  /* 5 */

        /*msg = 3      6 */

       /* val x = {val a=10;val b=100; b-a}    7 */
    /* the value of x will be 90 in this case */

    /*val file = scala.io.Source.fromFile("kumar").mkString     /* 8 */
     the value of file will be equivalent to a file named kumar and all elements of the file will be considered a string
    I do not have a file under this name so it will run a FileNotFoundexception */

        val  m = { print ("foo "); 1}   /* 9 */
    /* the value m is 1, when m is called it will invoke the print function that will print the string "Foo" */
        var x = 5  /* 10 */          
        /* This code will run an error with the prior code line with question 7, since x is double defined, type is infered as an integer and is set to 5 */
        val s = if (x> 0 && x<6) 1 else 0   /* 11 */
        // the s value will be the interger 1, as x is set in the prior line to be int 5
        

    /*vim Demo_1.scala         12 

Object Demo_1{
def main(args:Array[String]) {
var x=15;
if( x<20) {
println("This is if statement");
}
} } */
    // this object contains a main function that allows for variable x to be set as an integer data type and is equivalent to 15,
    // the if statement is be True as x is less than 20 which will have the statment print the string "this is if statment"

        var args = "hello"      /* 13 */
        // sets a variable named args with a string data type with hello being the string

        args.foreach(arg=>println(arg))     /* 14 */
        // variable args is called with foreach function, which calls back each element in the list, with arg variable denoting character data type within  variable args, which then calls a print function to print each character of args
        args.foreach(println)               /* 15 */
        val x15 = List(1,2,3)
        x15.foreach{println}               
        // similar to the line above in what the output is, however this is no variable asigned to the characters being outputed, 
        // there is no arg variable to hold onto the data of each character. there is also no variable associated with the individual integers that are printed, as x15 is a list data type, and is the entire list of (1,2,3)

        for(i<-1 to 5)      /* 16 */
        println(i)
        // this is a for loop for the variable i which will be an integer data type and will go up incrimentally from integer 1 to 5

        val in = "hello world"              /* 17 */
        var sum = 0
        for (i<-0 until in.length) sum+=i
        println(sum)
        // a for loop is being utilized for variable i with the array being from int 0 to the int equivalent to the length of the string associated with the in variable
        // the length of this string is 10 characters so i will go from a value of 0 to 10 within the loop, sum will be sum = sum + 1, so sum will grow for each loop that occurs for i
        // i will grow incrementally from 0 until 10, which is the length of variable in. As a result, sum will be equivalent to 10 factoral, 10! and the resulting print will be int 55

        for(i<-1 to 3;j<-1 to 3)            /* 18 */
        println(10*i+j)
        // variable i and variable j are both incrementally increasing from 1 to 3 within the loop, the print line is multiplying i's value by 10 then adding j's value
        // the result will be a display of numbers with the tens value increasing by 10 while the ones value goes from 1 to 2 to 3, then the 10 will increase and the process continues
        // until 33 where both i and j have reached to top of their incremental growth
        
        for(i<-1 to 3;j<-1 to 3 if i==j) println(10*i+j)        /* 19 */
        // similar to the above line, however the print function will only occur when i is equal to j, being when both are 1, 2, and 3, so the resulting output will be 11, 22, 33

        for(i<-1 to 3;x=4-i;j<- x to 3) println(10*i+j)        /* 20 */ 
        // for loop again where i starts at 1 and with each loop increases to 3 at max, while as j variable is dependent upon the i variable's change, there will only be one iteration
        //  when i is 1 for j, there will be 2 iterations when i is 2 for j, and there will be 3 iterations when i is 3 for j due to j's range changing from 3-3 to 2-3 then finally to 1-3

                             /* 21 */ 
        val x21 = for(i<-1 to 20)yield i*2.5
        for (i<-x21) println(i)
        // variable x21 contains a for loop, where variable i will grow incrementally from 1 to 20
        // for each iteration through the for loop, there will be a print output of i * 2.5, which will show
        // the first 20 multiples of 2.5

        var a=10;
        while( a<20) {
        println("value of a = " + a);
        a= a+1;
        }
        // this is a while lope, where the print occurs before a first iteration, so a will be printed out as 10 initially
        // and a will grow incrementally from each iteration until it is equivalent to 19

        var nodb = 2

        do {
        nodb +=1
        println(s"nodb = $nodb")
        }
        while(nodb < 10);

        // this is a do while loop which is similar to while loops however, do while loop checks condition at the bottom
        //  of a loop, which garuntees that a loop is executed at least once. Do to the execution of the condition at the
        // the bottom of the loop, we will never see the initial assigned value to nodb in the print output, rather we will only
        // our first output in the printline will have already added 1 to the value of nodb
        
       
        


        
        
        

        

    }
}