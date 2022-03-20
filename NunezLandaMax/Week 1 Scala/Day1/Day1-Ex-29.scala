package example
object Demo{
    def main(args:Array[String])
    {
        //29 Set
        var s : Set[Int] = Set(1,3,5,7) //creates a Set of 4 elements
        var s1=Set(7,9,8,9)          //Creates a set of 3 elements no repetitions
        var s2=Set(10,11,12,13)       //creates a set of 4 elements
        println(s1++s2)                 // shows the concatenation of two sets without repetitions
        var x1=Set(7,9,8,9)        
        var x2=Set(10,11,12,13)
        println(x1.++(x2))           //Shows the concatenation of two sets no repetitions

        var a1=Set(11,44,33,22)     //creates a set of 4 elements
        var b1=Set(77,99,22,88)      //creates a set of 4 elements
        println(a1.&(b1))           //shows the intersection common elements in tw sets 22

        var a2=Set(11,44,33,22)
        var b2=Set(77,99,22,88)
        println(a2.intersect(b2))   //shows the intersection common elements in this two sets 22

    }

}

