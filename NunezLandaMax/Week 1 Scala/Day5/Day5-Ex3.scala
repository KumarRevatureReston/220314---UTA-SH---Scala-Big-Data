package example

object Demo2{
    def main(args:Array[String])
    {
        val colors1= Map("red"->"#FF0000","azure"->"#F0FFFF","peru"->"#CD853F") //Creates a map of 3 keys with values
        val colors2 = Map("blue"->"#0033FF", "yellow"->"#FFFF00", "red"->"#FF0000") //Creates a map of 3 keys with values
        var colors=colors1++colors2
        println("colors1 ++ colors2 : "+colors)  //Retunrs concatenation Map colors1 and colors2

        colors=colors1.++(colors2)              //Retunrs concatenation Map colors1 and colors2
        println("colors1.++(colors2)) : "+colors)
    }
}