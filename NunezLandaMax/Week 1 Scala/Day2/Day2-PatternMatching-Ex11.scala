package example
import scala.util.matching.Regex
object Pattern
{
    def matchTest(x:Int): String = x match{
        case 1=>"one"
        case 2=>"two"
        case _=>"other"
    }

    def main(args:Array[String])=
    {
        println(matchTest(3))  //no matches print "other"
        println(matchTest(1))  //matches number 1 and print "one"

        val keyValPattern: Regex = "([0-9a-zA-Z- ]+): ([0-9a-zA-Z-#()/. ]+)".r
        //regular expression contain key before : and value after 
        val input:String=
            """background-color: #A03300;
              |background-image: url(img/header100.png);
              |background-position: top center;
              |background-repeat: repeat-x;
              |background-size: 2160px 108px;
              |margin: 0;
              |height: 108px;
              |width: 100%;""".stripMargin
        for(patternMatch<-keyValPattern.findAllMatchIn(input)) //print values and key that match regular expression
            println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")
    }
}