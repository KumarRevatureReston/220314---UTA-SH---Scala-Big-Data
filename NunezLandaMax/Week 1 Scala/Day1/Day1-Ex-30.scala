package example
object Demo{
    def main(args:Array[String])
    {
        //30 Mapping
        val mapping=Map("Vishal"->"Kumar","Vijay"->"Verma") //Creates a mapping
        mapping.keys.foreach{          //loop shows all elements of mapping 
            i=>println(i+" "+mapping(i))
        }
        println(mapping("Vishal"));  //Shows element of mapping "Kumar"
        println(mapping.contains("Vishal"))  //Show true if element exist in mapping
    }

}

