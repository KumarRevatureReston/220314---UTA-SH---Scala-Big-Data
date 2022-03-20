package example

//Multilevel Inheritance
class A{
    println("A")
}


class B extends A{
    println("B")
}
                          //C inherits from B, B inherits from A
                          // C->B->A
class C extends B{
    println("C")
}

//Hierarchical Inheritance
class A1
{
    println("A1")
}
class B1 extends A1{   
    println("B1")
}
                    //class C1 and B1 inherits from A1 
                    //                              ^
                    //                           B1    C1
class C1 extends A1{
    println("C1")
}

object Inheritance{
    def main(args:Array[String])
    {
        var x=new C()
        var x1=new C1()
        println(x);
        println(x1);
    }
}

object Multiple{
    def main(args: Array[String]):Unit={
        trait A{                
            var length:Int= _      
            def action={
                length=length+5
            }
        }
        trait B{
            var height:Int = _
            def action={
                height = height + 1
            }
        }
        class C extends A with B{  //class C extends traits A and B
            length=3;
            height+=6;
            override def action={
                super[A].action
                super[B].action
            }
        }
        var c=new C
        c.action      //When call action, action A and B are executed
        println(c.height)    //height 6+1=7
        println(c.length)    //length 3+5=8
    }
}