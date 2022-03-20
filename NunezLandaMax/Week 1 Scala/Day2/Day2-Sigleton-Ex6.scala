package example
//Creates an object that generates reservation numbers
object Reservations{
    var lastNum=0;
    val num2=2;
    def newReservationNum() ={
        lastNum+=1;
        lastNum
    }
}

object Singleton
{
    def main(args:Array[String])
    {
        val a=Reservations;
        for(x<-0 to 10) //Call and print every new reservation number
            println("New reservation :"+ a.newReservationNum());
    }
}

