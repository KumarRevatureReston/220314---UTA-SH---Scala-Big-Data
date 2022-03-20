object AssignmentDay3Day4{
  def main(args: Array[String]): Unit = {
    //1.Try/Catch
    object Maps {

      def main(args: Array[String]) {
        val name = Map("abc" -> "author", "pqr" -> "coder")


        val x = name.get("abc")
        val y = name.get("xyz")


        println(x)
        println(y)
      }
    }
    // Added object Maps

    //2. without Exception Handling
    class ExceptionExample {
      def divide(a: Int, b: Int) = {
        a / b // Exception occurred here
        println("Rest of the code is executing...")
      }
    }
    object MainObject {
      def main(args: Array[String]) {
        var e = new ExceptionExample()
        e.divide(100, 0)

      }
    }
    // Throws an exception at a/b.

    //3.
    class ExceptionExample1 {
      def divide(a: Int, b: Int) = {
        try {
          a / b
        } catch {
          case e: ArithmeticException => println(e)
        }
        println("Rest of the code is executing...")
      }
    }
    object MainObject1 {
      def main(args: Array[String]) {
        var e = new ExceptionExample()
        e.divide(100, 0)

      }
    }
    // Runs properly.

    //4. Finally
    class ExceptionExample2 {
      def divide(a: Int, b: Int) = {
        try {
          a / b
          var arr = Array(1, 2)
          arr(10)
        } catch {
          case e: ArithmeticException => println(e)
          case ex: Exception => println(ex)
          case th: Throwable => println("found a unknown exception" + th)
        }
        finally {
          println("Finaly block always executes")
        }
        println("Rest of the code is executing...")
      }
    }


    object MainObject2 {
      def main(args: Array[String]) {
        var e = new ExceptionExample()
        e.divide(100, 10)

      }
    }
    // Runs properly.

    //5.Pattern Matching
    object MainObject3 {
      def main(args: Array[String]) {
        var result = search("Hello")
        print(result)
      }

      def search(a: Any): Any = a match {
        case 1 => println("One")
        case "Two" => println("Two")
        case "Hello" => println("Hello")
        case _ => println("No")

      }
    }

    // Runs properly.

    //6. list
    val numbersList: List[Int] = List(1, 2, 3, 4)
    val emptyList: List[Int] = List()

    val numbersList1: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil


    object Student1 {
      def main(args: Array[String]) {
        val names = "Harry" :: ("Adam" :: ("Jill" :: Nil))
        val age = Nil
        println("Head of names array : " + names.head)
        println("Tail of names array : " + names.tail)
        println("Check if names is empty : " + names.isEmpty)
        println("Check if age is empty : " + age.isEmpty)
      }
    }
    // Had to change the name for numbersList since it is immutable. I added 1 to the second numbersList.

    //7.set
    val emptySet: Set[Int] = Set()

    val numbersSet: Set[Int] = Set(1, 2, 3, 4)

    object Student {
      def main(args: Array[String]) {
        val name = Set("Smith", "Brown", "Allen")
        val id: Set[Int] = Set()

        println("Head of name : " + name.head)
        println("Tail of name : " + name.tail)
        println("Check if name is empty : " + name.isEmpty)
        println("Check if id is empty : " + id.isEmpty)
      }
    }
    // Runs properly.

    //8. Merge two Set
    import scala.collection.immutable._
    object MainObject4 {
      def main(args: Array[String]) {
        val games = Set("Cricket", "Football", "Hocky", "Golf")
        val alphabet = Set("A", "B", "C", "D", "E")
        val mergeSet = games ++ alphabet // Merging two sets
        println("Elements in games set: " + games.size) // Return size of collection
        println("Elements in alphabet set: " + alphabet.size)
        println("Elements in mergeSet: " + mergeSet.size)
        println(mergeSet)
      }
    }
    // Runs properly.

    //9. Concatenating lists
    object Country {
      def main(args: Array[String]): Unit = {
        val country_1 = List("States", "Britain", "New Zealand")
        val country_2 = List("Austria", "Belgium", "Canada")

        val country = country_1 ::: country_2
        println("country_1 ::: country_2 : " + country)

        val cont = country_1.:::(country_2)
        println("country_1.:::(country_2) : " + cont)
        val con = List.concat(country_1, country_2)
        println("List.concat(country_1, country_2) : " + con)

        // Indentation issue. Reformated made the program work.
      }
    }
    // 10)
    trait GroceryItem

    case class Fruit(name: String) extends GroceryItem

    case class Vegetable(name: String) extends GroceryItem

    def classifyGroceryItem(item: GroceryItem): Unit = {
      item match {
        case _: Fruit => println("label item as fruit.")
        case _: Vegetable => println("label item as vegetable.")
        case _ => println("unable to label the item. this seems to be an item for other department.")

      }
    }

    val inventory: Map[String, Int] = Map(
      "apple" -> 10,
      "banana" -> 15,
      "strawberry" -> 10,
      "spinach" -> 30,
      "capsicum" -> 25
    )

    def findItemAndReturnQuantity(itemName: String): Option[Int] = {
      inventory.get(itemName)
    }

    findItemAndReturnQuantity("sugar") // res1: Option[Int] = None
    findItemAndReturnQuantity("spinach") // res2: Option[Int] = Some(30)

    def handleOptionItemQuantity(quantity: Option[Int]): Unit = {
      quantity match {
        case Some(value) => println(s"quantity is $value.")
        case None => println("item is not available.")
      }
    }

    handleOptionItemQuantity(findItemAndReturnQuantity("strawberry"))
  }
}