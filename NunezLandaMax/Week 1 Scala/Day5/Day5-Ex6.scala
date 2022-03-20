package example

object Revature
{
	def main(args:Array[String])
	{
		val list = List(2, 3, 4)  //Creates a List of 3 Integer elements
		def f(x:Int) = List(x-1,x,x+1)  // Function that return a list of three list elements 
		val result = list.flatMap(y => f(y))  //return list of elements-1 concatenated wit list elements concatenated with list elements +1
		println(result)
	}
}