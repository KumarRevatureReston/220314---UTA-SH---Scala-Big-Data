//remove slashes in front of code to run it. End of code segments will be seperated by ------

//class Ctr {
    //private var value = 6
    //def incr() = {value +=1}
    //def curr() = value
//}
//object incre{
    //def main(args: Array[String]){
    //val ctr1 = new Ctr 
    //ctr1.incr                         //applies the incr function to ctr1
    //println(ctr1.curr)
    //}
//}
//------output of 7 since the initial value of var is defined as 6, and the incr function adds one to it. 
//class Duck {
    //var size = 1
//}
//object one{
    //def main(args: Array[String]){
    //var f = new Duck
    //f.size = 10
    //println(f.size)
    //}
//}
//------output is 10 because a new instance of class Duck is invoked by variable f, and given a value of 10. (1)


//class Employee(empId: Int,name: String,salary :Double){
    //def this(empId:Int,name:String){
        //this(0,"",0.0) 
        //println("Two-argument auxiliary constructor")                     //not called since no two arg
    //}
    //def this(empId:Int){  
        //this(0,"",0.0)                                                    //third to print since this is invoked by by the zero arg constructor
        //println("One-argument auxiliary constructor")
    //}
    //def this(){
        //this(0)                                                           //second to print since empty emp invokes this
        //println("Zero-argument auxiliary constructor")
    //}
    //println("Primary construtor")                                         //first to print since this is called when the object is initialized
//}
//object empl{
    //def main(args: Array[String]){
        //val emp = new Employee()
    //}
//}
//------output of "Primary constructor", "Zero arg...", and "One arg..." for reasons explained above
//class Employee(empId: Int = 0,name: String = "",salary :Double = 0.0){
    //println(s"empId = $empId , empName = $name , salary = $salary")
//}
//object empl{
    //def main(args: Array[String]){ 
        //val emp = new Employee()                                //output of empId = 0 , empName =  , salary = 0.0
        //val emp1 = new Employee(name = "Smith")                 //output of empId = 0 , empName = Smith , salary = 0.0
        //val emp2 = new Employee(name = "Smith", empId = 9)      //output of empId = 9 , empName = Smith , salary = 0.0
    //}
//}
//------values of emp(s) will be defined by the inputs, blank fields will be treated as zero or empty


//object three{
    //def main(args: Array[String]){
        //val salaries = Seq(20000, 70000, 40000)
        //val doubleSalary = (x: Int) => x * 2
        //val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000) as output for newSalaries
        //println(newSalaries)
        //val newSalaries2 = salaries.map(x => x * 2) 
        //println(newSalaries2)                       //gave a new name since cant overwrite vals
    //}
//}
//This will create two identical lists since essentially the same function is being performed twice. (3)


//object four{
    //def main(args: Array[String]){
        //def sum(f: Int => Int, a: Int, b: Int): Int = if (a > b) 0 else f(a) + sum(f, a + 1, b)  //=> takes and returns int
        //def sumInts(a: Int, b: Int): Int = sum(id, a, b)                //make use of sum function
        //def sumSquares(a: Int, b: Int): Int = sum(square, a, b)
        //def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b)
                                                                        // three functions that are passed into the sum() function
        //def id(x: Int): Int = x
        //def square(x: Int): Int = x * x
        //def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)
        //println("sum ints 1 to 4 = " + sumInts(1,4))
    //}
//}
//------output of 10 since 1+2+3+4 is equal to 10. sumSquares will print the sum of all squares within given range, etc


//class A{
    //println("A") 
//}
//class B extends A{
    //println("B") 
//}
//class C extends B{
    //println("C") 
//}
//object five{
    //def main(args: Array[String]){
        //new (C)                          
    //}
//}
//------output of strings, A, B, C because subclass C inherited println's from parent classes. (5)
//class A{
    //println("A")
//}
//class B extends A{
    //println("B")
//}
//class C extends A{
    //println("C")
//}
//object fivestill{
    //def main(args: Array[String]){
        //new B()                         //this will give A,B since it extends println from A
        //new C()                         //this will give A,C since it extends println from A
    //}
//}
//------output of branching classes since B and C share a parent, but have no dependencies on another
//object Multiple{
        //def main(args: Array[String]):Unit={
           //trait A{
                   //var length:Int= _
                   //def action={
                     //length=length+5
                  //}
             //}
           //trait B{
                   //var height:Int = _
                   //def action={
                     //height = height + 1
                  //}
             //}
           //class C extends A with B{
                   //length=3;
                   //height+=6;
                   //override def action={
                            //super[A].action
                            //super[B].action
                   //}
              //}
                //var c=new C
                //c.action
                //println(c.height)
                //println(c.length)
             //}
//}
//------new class C takes the parent methods of both A and B and applies the action function to them. 
//The new height and length are then displayed. (5_end)


//object ReservationsSix {
    //def main(args: Array[String]){
        //var lastNum = 0;
        //val num2 = 2;
        //def newReservationNum() = { lastNum +=1; lastNum }
        //println(newReservationNum())
    //}
//}
//------creates an empty function that adds a value to an existing variable. (6)


//import java.io.IOException
//object GFGseven{
	//def main(args:Array[String]){
		//try{
			//var N = 5/0	
		//}
		//catch{
			//case i: IOException =>{
				//println("IOException occurred.")
			//}
			//case a : ArithmeticException =>{
				//println("Arithmetic Exception occurred.")
			//}
		//}
	//}
//}
//------output of arithmetic exception because dividing by zero will create an exception but it was caught by try-catch. (7)
//object GFG{
	//def main(args: Array[String]){
		//try{
			//var N = 5/0
		//}
		//catch{
			//case ex: ArithmeticException =>{
				//println("Arithmetic Exception occurred.")
			//}
		//}
		//finally{
			//println("This is final block.")
		//}
	//}
//}
//------output of arithmetic exception as before, with the finally statement executing because it always will regardless. (7)


//class eight{
    //def failingFn(i: Int): Int = {
        //val y: Int = throw new Exception("fail!")	
        //try {
            //val x = 42 + 5
            //x + y
        //}
    //catch { case e: Exception => 43 }	
    //}
    //def failingFn2(i: Int): Int = {
        //try {
        //val x = 42 + 5
        //x + ((throw new Exception("fail!")): Int)	
        //}
    //catch { case e: Exception => 43 }
    //}
    //def mean_1(xs: IndexedSeq[Double], onEmpty: Double): Double =
        //if (xs.isEmpty) onEmpty
        //else xs.sum / xs.length 
//}
//object help{                                    //created to help me evaluate the expressions
	//def main(args: Array[String]){
          //var test1 = new eight()
          //println(test1.failingFn2(1))
          //println(test1.failingFn2(44))         //both of these give 43
    //}
//}
//------this does not create any errors or exceptions, so no output is created. (8)
//********** If you are seeing this then I never had enough time in the curriculum to go back and figure this one out


//nine seems to be describing features of Scala.(9)


//object Curry{
    //def add2(a: Int) = (b: Int) => a + b;
    //def main(args: Array[String]){
        //println(add2(20)(19));
    //}
//}
//------output will give sum of the two input numbers as one integer. (10)

//object eleven{
    //def main(args: Array[String]){
        //def matchTest(x: Int): String = x match {
            //case 1 => "one"
            //case 2 => "two"
            //case _ => "other"
        //}
        //println(matchTest(3))  // prints other
        //println(matchTest(1))  // prints one
    //}
//}
//------ simple matching function using cases to search for matching inputs and outputting assigned string
//import scala.util.matching.Regex
//object elevenCont{
    //def main(args: Array[String]){
        //val numberPattern: Regex = "[0-9]".r
        //numberPattern.findFirstMatchIn("awesomepassword") match {      //adding anumber here will make "password ok"
            //case Some(_) => println("Password OK")
            //case None => println("Password must contain a number")
        //}
    //}
//}
//------output of case None because no numbers were found in the password string
//import scala.util.matching.Regex
//object elevenEvenMoreCont{
    //def main(args: Array[String]){
        //val keyValPattern: Regex = "([0-9a-zA-Z- ]+): ([0-9a-zA-Z-#()/. ]+)".r

        //val input: String =
        //"""background-color: #A03300;
        //|background-image: url(img/header100.png);
        //|background-position: top center;
        //|background-repeat: repeat-x;
        //|background-size: 2160px 108px;
        //|margin: 0;
        //|height: 108px;
        //|width: 100%;""".stripMargin

        //for (patternMatch <- keyValPattern.findAllMatchIn(input))
        //println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")
    //}
//}
//------output of the enture input string. seems to be indicating that there is a match (11)