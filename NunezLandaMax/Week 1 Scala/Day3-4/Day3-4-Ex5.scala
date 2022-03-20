package example

//Pattern Matching

object MainObject3
{
    def main(args:Array[String]){
        var result = search("Hello") //print "Hello"
        var result1 = search(1)      //print 1
        var result2 = search("Two")  //print "two"
        var result3 = search("abcd")  // print "No"
        print(result)
    }
    def search(a:Any):Any = a match {
        case 1 => println("one")        //matches 1 print "one"
        case "Two" => println("Two")     //matches "Two" print "Two" 
        case "Hello"=>println("Hello")   //matches "Hello" print "Hello"
        case _=>println("No")            //matches anything else print "No"  
    }
}