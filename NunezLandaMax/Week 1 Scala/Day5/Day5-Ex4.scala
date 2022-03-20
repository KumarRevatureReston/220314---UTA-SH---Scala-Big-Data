package example
object Demo3{
    def main(args: Array[String]) {
    val colors = Map("red"->"#FF0000","azure"->"#F0FFFF","peru"->"#CD853F") //Creates a map of 3 keys and values

    colors.keys.foreach{ i =>   //function that creates a loop for each key of the map  
        print( "Key = " + i )       //print the key
        println(" Value = " + colors(i) )}  //print the key value
    }
}
