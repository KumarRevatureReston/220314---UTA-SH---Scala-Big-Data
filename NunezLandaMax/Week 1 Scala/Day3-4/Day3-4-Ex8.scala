package example

import scala.collection.immutable._  
object MainObject4{  
    def main(args:Array[String]){  
        val games = Set("Cricket","Football","Hocky","Golf")   //creates a set of 4 String no repeated elements
        val alphabet = Set("A","B","C","D","E")   //Creates a set of 5 no repeated elements
        val mergeSet = games ++ alphabet            // Merge games elements with alphabet elements  
        println("Elements in games set: "+games.size)   // Returns size of games collection  
        println("Elements in alphabet set: "+alphabet.size)   //Retunrs size of alphabet collection
        println("Elements in mergeSet: "+mergeSet.size)   //Returns size of megeSet Collection
        println(mergeSet) 
    }  
}  
