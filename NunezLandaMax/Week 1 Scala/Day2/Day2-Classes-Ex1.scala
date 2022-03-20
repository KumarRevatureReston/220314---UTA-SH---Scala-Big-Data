package example
//1 Classes and objects
class Ctr{   //class Ctr
    private var value = 6  //variable private
    def incr() {value+=1}  //method incr, increase vairable value in 1
    def curr() = value      //method curr to access the value of the variable value
}

class Duck{        //class Duck
    var size=1    //variable size public
}

object Classes_1
{
    def main(args:Array[String])
    {
        val ctr1 = new Ctr
        ctr1.incr()
        println(ctr1.curr())

        var f=new Duck
        f.size=10
        println(f.size)
    }
}



