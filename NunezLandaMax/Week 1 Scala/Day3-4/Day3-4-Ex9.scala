package example

object Country
{
    def main(args:Array[String])
    {
        val country_1 =  List("States","Britain","New Zealand") //creates a list of 3 string elements
        val country_2 = List("Austria","Belgium","Canada")      //creates a list of 3 string elements
        val country = country_1 ::: country_2
        println("country_1 ::: country2 : " + country)  //concatenates the elements of country_1 and next elements of country_2
        val cont = country_1.:::(country_2)
        println("country_1.:::(country_2) : "+cont )    // concatenates the elements of country_2 and next elements of country_1
        val con=List.concat(country_1,country_2) 
        println("List.concat(country_1,country_2)  : " +con) // concatenates the elements of country_1 and next elements of country_2

    }
}