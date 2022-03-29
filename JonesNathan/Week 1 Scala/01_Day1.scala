//Object names correspond to question numbers. Remove comments to enable code
//for each. //------ will indicate output after end of code. objects should not be
//run at the same time as other numbered objects


//object one{
  //def main(args: Array[String]): Unit = {

    //def add (x:Int, y:Int): Int=x+y
    //println(add(10,2))
  //}
//}
//------output of 12 for (1)


//object two{
  //def main(args: Array[String]): Unit = {
    //val msg = "Hello World"
    //println(msg)
  //}
//}
//------output of Hello World for (2)


//object three{
  //def main(args: Array[String]): Unit = {
    //val msg = "Hello World"
    //msg = "Hello"
    //println(msg)
  //}
//}
//------internal error due to reassignment of msg for (3)


//object four{
  //def main(args: Array[String]): Unit = {
    //var msg = "Hello World"
    //println(msg)
  //}
//}
//------output of Hello World for (4)


//object five{
  //def main(args: Array[String]): Unit = {
    //var msg = "Hello World"
    //msg = "Hello!"
    //println(msg)
  //}
//}
//------output of Hello! for (5)


//object six{
   //def main(args: Array[String]): Unit = {
    //var msg = "Hello World"
    //msg = "Hello!"
    //msg = 3
    //println(msg)
  //}
//}
//------ error due to mismatch of Int and String for (6)


//object seven{
   //def main(args: Array[String]): Unit = {
     //val x = {val a=10;val b=100; b-a}
     //println(x)
   //}
  //}
//------output of 90 for (7)


//object eight{
   //def main(args: Array[String]): Unit = {
      //val file = scala.io.Source.fromFile("kumar").mkString
   //}
  //}
//------no access to file so program does not run, could create file and would have output as string (8)


//object nine{
   //def main(args: Array[String]): Unit = {
     //val  m = { print ("foo "); 1}
   //}
  //}
//------output of foo for (9)


//object ten{
   //def main(args: Array[String]): Unit = {
     //var x = 5
     //println(x)
   //}
  //}
//------output of 5 at this time for (10)


//object eleven{
   //def main(args: Array[String]): Unit = {
     //var x = 5
     //val s = if (x> 0 && x<6) 1 else 0
     //println(s)
   //}
//------output of "s" is 1 because x (5) is between 0 and 6.
  //var age = 58
  //if (age>58){
    //println("age is greater than 58")
  //}
  //else if(age==58){
    //println("age is 58")
  //} 
  //else{
    //println("age is less than 58")
  //}
//}
//------output of "age is 58" 
//object Demo_1{
  //def main(args: Array[String]){
    //var x=15;
    //if (x<20) {
      //println("This is a statement");
    //}
  //}
//}
//------output of "This is a statement" because 15<20, for (11)


//object twelve{
  //def main(args: Array[String]){
    //var x = 15;                         //prev value of x used since none given
    //val t = if (x> 0 && x<6) {
      //println("positive")
    //}
    //else{
      //println("negative")
    //}
  //}
//}
//------output of "negative" because x is not between 0 and 6 for (12)


//object thirteen{
  //def main(args: Array[String]){
    //var args = "hello"
  //}
//}
//------no output, simply defining variable args as string "hello" for (13)


//object fourteen{
  //def main(args: Array[String]){
    //var args = "hello"                  //taken from object 13
    //args.foreach(arg=>println(arg))
  //}
//}
//------output of foreach breaks down string into elements and counts consecutive repeats as quantity for (14)


//object fifteen{
  //def main(args: Array[String]){
    //var args = "hello"
    //args.foreach(println)
  //}
//}
//------output seems identical to 14, both problems apply println to each element. (15)


//object sixteen{
  //def main(args: Array[String]){
    //for (i<-1 to 5)
    //println(i)
  //}
//}
//------output of 1-5 on individual lines, each increment of loop instances new println command. (16)


//object seventeen{
  //def main(args: Array[String]){
    //val in = "hello world"
    //var sum = 0
    //for (i<-0 until in.length) sum+=i
    //println(sum)                        //print not giving output, println used instead
  //}
//}
//------output of 55 because all integers until 11 (the length of in) are added to the sum. (17)


//object eighteen{
  //def main(args: Array[String]){
    //for(i<-1 to 3; j<-1 to 3)
    //println(10*i+j)
  //}
//}
//------output of all combinations of integer increments, with j incrementing first, 3 steps each. (18)
//------ 11, 21, 31, 12, 22, 32, 13, 23, 33


//object nineteen{
  //def main(args: Array[String]){
    //for(i<-1 to 3; j<-1 to 3 if i==j) 
    //println(10*i+j)
  //}
//}
//------output of only combinations where i=j, functionally making this = println(11*i) over 1 to 3. (19)


//object twenty{
  //def main(args: Array[String]){
    //for(i<-1 to 3;x=4-i;j<-x to 3)
    //println(10*i+j)
  //}
//}
//------ output of 13, 22, 23, 31, 32, 33 because x is only redefined when i iterates, so j can only 
//------update from its new value (given by x) up to 3. (20)


//object twentyone{
  //def main(args: Array[String]){
    //val x = for(i<-1 to 20)yield i*2.5
    //for (i<-x) println(i)
  //}
//}
//------output of 2.5 to 50 in multiples of 2.5 in individual lines due to 20 steps. Yield holds values 
//------as calculated and creates an array of values in x, which is used to print individual cells of the array. (21)
//object Demo_4{
  //def main(args: Array[String]){
    //var a=10; while(a<20) {
      //println("value of a = " +a)
      //a=a+1                              //originally forgot this line, very funny when it verified 10<20 thousands of times
    //}
  //}
//}
//------output of the value of a every time the loop was run. Since 20 does not satisfy the expression, the
//------last output of the program is the value of a that satisfies it: 19.
//object Dowhile{
  //def main(args: Array[String]){
    //var nodb = 2;
    //do { 
      //nodb +=1
      //println(s"nodb = $nodb")
    //} 
    //while(nodb <10)
  //}
//}
//------output of nodb from 3 to 10 because first implementation is 2+1, and the last accepted iteration of
//------the loop is 9, which has +1 applied to it and is printed before the loop evaluation becomes false


//********
//Expectation is that this is the end of the required questions. Additional are done for exercise or practice
//*********


//object twentytwo{
  //def main(args: Array[String]){
    //def sayhello() {
      //println("Hello")
    //}
    //def sum(a:Int,b:Int) {
      //println(a+b)
    //}
    //sum(2,5)
    //def func():Int={                      //past this point, nothing useful seems to happen; return discouraged
      //return 7
    //}
    ////def sum(a:Int,b:Any):Any = {        //this will fail because sum is already defined above
      ////println("hello")
    ////}
  //}
//}
//------output of 7 due to sum(2,5) being printed as 2+5; assume that failed portion is removed. (22)


//object twentythree{
  //def main(args: Array[String]){
    //def factorial(n:Int): Int=if(n==0) 1 else n*factorial(n-1)
    //var n = 5                             //added to prove functional
    //println(factorial(n))
  //}
//}
//------output will create the value of n! for any given positive integer. useful for comb and perm calcs (23)
//object Demo{
  //def main(args: Array[String]){
    //var result = functionExamp(15,2)
    //println(result)
  //}
  //def functionExamp(a: Int, b: Int):Int ={
    //if (b==0) 0
    //else
      //a+functionExamp(a,b-1)
  //}
//}
//------output of 30 because function updates until b=0. Can be expressed mathematically as result=15+15+functionExamp(15,2-2)
//------proof; 15+functionExamp(15,1) where functionExamp(15,1)= 15+functionExamp(15,0) and functionExamp(15,0)=0 


//object twentyfour{
  //def main(args: Array[String]){
    //def rect_area(length:Float, breadth:Float) ={
    //val area = length*breadth; 
    //println(area)
    //}     
  //}
//}      
//------ have not yet found a way to make use of this due to Float and best attempts are recursive, try to come back later
//************************************


//object twentyfive{
  //def main(args: Array[String]){
    //var a = Array(1,2,3)
    //a(4)
    //println(a(0))
  //}
//}
//------output of 1 when a(4) is removed since index starts at 0 and a(4) is out of bounds for array of 3. (25)
//object arraynoval{
  //def main(args: Array[String]){
    //var a = new Array[Int](3)
    //a(1)
    //a(1)=2
    //a
  //}
//}
//------a(1) will create an empty or zero element, a(1)=2 will set the value of the second element of the array to 2
//------a by itself will break everything
//object arraynovalcont{
  //def main(args: Array[String]){
    //val a = new Array[Int](10)
    //val s = new Array[String](10)
    //val st = Array("Hello", "world")
  //}
//}
//------stopped here, have not evaluated
