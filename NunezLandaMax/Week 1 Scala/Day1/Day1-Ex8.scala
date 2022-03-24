package example

object myFiles
{
    def main(args:Array[String])
    {
        val file = scala.io.Source.fromFile("kumar.txt").mkString
        val  m = { print ("foo "); 1}
        println(file);
    }

}