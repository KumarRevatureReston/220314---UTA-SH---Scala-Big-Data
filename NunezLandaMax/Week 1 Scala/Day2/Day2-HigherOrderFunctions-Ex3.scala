package example

//3 Higher Orgder functions

object HigherOrderFunctions{
    def main(args:Array[String])
    {
        val salaries = Seq(20000,70000,40000)
        val doubleSalary = (x: Int) => x*2  //define a function to return number multiply by 2
        val newSalaries = salaries.map(doubleSalary) //uses method map with function double salary to return
                                                        //all elements of the sequence multiplied by 2

        val salaries1 = Seq(20000,70000,40000)
        val newsalaries1 = salaries1.map(x=>x*2)   //call method map and return all elements of the sequence multiplied by 2
        
        println(newSalaries)
        println(newsalaries1)
    }
}