# Revature Training 3/18/2022

## Collection - Sets

A collection of elements which only allows one instance of a given value (consists of only unique elements)

Sets can be Immutable and Mutable

- Immutable `scala.collection.immutable` - set can't be changed
- Mutable - `scala.collection.mutable` - set can be changed

```
object Automobile {
  def main(args: Array[String]): Unit = {
    val car = Set("Ford", "GMC", "Tesla", "GMC")
    val nums: Set[Int] = Set()

    println( "Head of car : " + car.head)
    println( "Tail of car : " + car.tail)
    println( "Check if car is empty : " + car.isEmpty)
    println( "Check if nums is empty : " + nums.isEmpty)
  }
}
```

Strings are immutable in Java, once created they remain the same

Note `set.tail` contains all the entries except for the first entry


## Collection - Maps

A map is a collection set of elements where each element contains a key and a value, and the key is used to access the value

Also called HashMaps or Associative Arrays in other languages

map can be Mutible and Immutible

```
object Revature {
  def main(args: Array[String]) = {
    val candies = Map("Hershey" -> "#FF0000", "Twix" -> "#F0FFFF", "MGM" -> "#CD853F")
    val nums: Map[Int,Int] = Map()

    println("Keys in Candies: " + candies.keys)
    println("Values in Candies: " + candies.values)
    println("Check if Candies is empty: " + candies.isEmpty)
    println("Check if nums is empty: " + nums.isEmpty)
  }
}
```

**Note:** HashMap is **O(n)** in the worst case and big **O(1)** in the average case time complexity for insertion and lookup so it is very efficient for storing and accessing elements fast

Reference: https://www.bigocheatsheet.com/

Map is a key value pair - the key *accesses* the value using `mapname(key)`

```
// e.g. 
candies("Hershey") // "#FF0000"
```

"Hershey" is the key and "#FF0000" is the value

**Question from Max**
What to do with the assignments?

Everything is an assignment in the file, not just the questions, we can either create a folder or do it in a zip file, turn them into the Github repo

Max(?) offered to create an example file

**Question from Nick**
We will be getting feedback from the assignments regarding how well we did

**Question from Andrew**
The quiz will be populated in Revature pro, we will receive an invite

**Question from Melissa**
The training was better without remote work for various reasons including social interaction

Quiz, QC, Assignment, 1-on1 need to be done every week

## flatMap()

`flatMap()` method is identical to the `map()` method, but the inner grouping of an item is removed and a sequence is generated (i.e. it gets rid of the nesting below the main level of the object or collection it's declared on)

- `map()` then `flatten()` is the same as `flatMap()`

- Flat Map is good for Parallel processing with Parallel collections
- Applies the Map method then the flatten method sequentially rather than parallel, then processes the collections themselves parallelly

```
object Rev {
  def main(args:Array[String]) = {
    val portal = Seq("Revature", "Big", "Data")
    val result = portal.flatMap(_.toUpperCase)
    println(result)
  }
}
```

Package or a library


## filter()

The `filter()` method is utilized to select all elements of the list that satisfy a condition (predicate)

```
def filter (p: (A) => Boolean): List[A]
```

Return type - returns a new list consisting of all the elements that satisfied the condition (predicate)

Filter method helps us get more specific results from the big data by narrowing things down with conditions

```
// example
object Demo {
  def main(args:Array[String]): Unit = {
    val list = List(5,20,10,1)
    println(list)
    val result = list.filter(x=>{x % 5 == 0})
    println(result)
  }
}
```

## transform()

`transform()` - performs an operation to transform the elements of a map according to a given condition then returns another mutable map with the transformed elements

```
// transforms all values to uppercase
object RevTransform {
  def main(args:Array[String]): Unit = {
    val m1 = Map(3 -> "Rev", 4 -> "Big", 2 -> "Data")
    val result = m1.transform((key, value) => value.toUpperCase())
    println(result)
  }
}
```

e.g. It is good to use for data munging (cleanup of data from the initial state)

1-on-1s continued

**Timesheets link**
https://rev2.force.com/revature/s/login/
