package example

object Demo4{

    def main(args: Array[String]) {
        val colors = Map("red"->"#FF0000","azure"->"#F0FFFF","peru"->"#CD853F")//Creates a map of 3 keys and values

        if(colors.contains("red")){  //checks if the key red exists in the map
            println("Red key exists with value :"+colors("red")) //returns the value of key red 
        } 
        else 
        {
           println("Red key does not exist")     
        }
      
        if( colors.contains("maroon")) {  //checks if the key maroon exists in the map
            println("Maroon key exists with value :"+colors("maroon")) //returns the value of the key marrons
        } 
        else 
        {
             println("Maroon key does not exist")
        }
   }
}
