package example
object Demo{
    def main(args:Array[String])
    {
        //34 FlatMap
        val name = Seq("Nidhi","Singh")
        val result1=name.map(_.toLowerCase())

        println(result1) //print a list in lower case List(nidhi, singh)

        val result2 = result1.flatten
        println(result2)  //print a flatten list in lower case List(n, i, d, h, i, s, i, n, g, h)

        //print a flatten list in lowercase List(n, i, d, h, i, s, i, n, g, h)
        println(name.flatMap(_.toLowerCase()))
        
    
    }
}

