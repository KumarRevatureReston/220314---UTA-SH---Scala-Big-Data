package example

object Demo_4{
  def main(args:Array[String])={
    var a=10
    var nodb=2
    //22
    //while loop
    while(a<20){
      println("value of a = "+a); //print value of a
      a=a+1;                      //adds 1 to a
    }
    //do while loop
    do{
        nodb +=1              //adds1 do nodb
        println(s"nodb = $nodb")       //prin using string interpolation
    }while(nodb<10);            //execute loo until nodb is bigger than 9

    sayhello();  //calls function 
    println(sum(2,3));
  }
  
  //22
  def sayhello()   //function print "Hello"
  {
      println("Hello");
  }
  def sum(a:Int,b:Int):Int={    //function sum a+b
      return a+b;
  }

}