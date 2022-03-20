package example
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer
object Demo{
    def main(args:Array[String])
    {
        //27 List
        val list =1::2::3::Nil; //creates a list of 3 elements 1,2,3
        val list1 = List(1,2,3);  //creates a list of 3 elements 1,2,3
        val x=List(1,2.0,33d,3000L);  // creates a list of different numbers
        val x1=List.range(1,10);   //creates a list from 1 to 10
        val x2=List.fill(3)("foo"); //creates a list of 3 elements "foo"
        val x3=List.tabulate(5)(n=>n*n);  //creates a list of elements numbers from 0 to 5 squares

        println(list)
        println(list1)
        println(x)
        println(x1)
        println(x2)
        println(x3)

        //Use listBuffer library
        var fruits=new ListBuffer[String]() //Creates a list
        fruits += "Apple"                   //Add Apple to the list
        fruits+= ("strawberry","kiwi")   //Adds 2 elements to the list
        fruits+=("Apple","kiwi")        //Adds 2 elements to the list
        val fruitlist=fruits.toList   //Adds all elemtents from fruits to fruitlist

        println(fruitlist);

        val a= List(3);  //creates a list of one element 3
        val b= 1 :: 2 :: a; //creates a list of 3 elements 1,2 and add list b 
        val z= -1 :: b;   // creates a list of elemnts -1, elements in b

        val originalList1 = List(7,8,4,3,2);  //creates a list of 5 elements
        val newList1 = originalList1.filter(_>3); //creates a new list with elements less thant 3 from original list

        println(newList1);

        val p=List(111,200,321); //Creates a list of 3 elements
        val q=List(4,-5,60);    //creates a list of 3 elements
        val r=p ++ q            //creates a list and concatenates list p an list q
        val r1 = p ::: q;       //creates a list and concatenates list p an list q
        val r2=List.concat(p,q) //creates a list and concatenates list p an list q

        println(r)
        println(r1)
        println(r2);

        val lst = List(1,2,3,4,5,6,7,8)  //Creates a list of 8 elements
        lst.head     //return the first element of the list lst
        lst.tail    //return all alaments of the list lst without the first element

        val y=sum(lst) // assign y wit the sum of all elements of list lst

        println(y)
  
    }
    //Recursive function sumss all alements from the list
    def sum(l: List[Int]):Int = 
        { 
            if(l == Nil) 
               0 
            else 
               l.head + sum(l.tail)
        }

}

