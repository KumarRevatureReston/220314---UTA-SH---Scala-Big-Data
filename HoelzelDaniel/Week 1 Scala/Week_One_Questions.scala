object Week_One_Questions {
    def main(args: Array[String]): Unit = {
        //Questions:
        
        //1)
        def sum(a:Int, b:Int): Unit ={
            if(a == b){
                println((a+b)*3)
                //return (a+b)*3
            }
            else{
                println(a+b)
                //return a+b
            }
        }
        
        sum(1,2) //1+2 = 3
        sum(2,2) //2+2 = 4 but are same so returns 4*3 = 12*/
        
        //2)
        def extendString(a:String): Unit ={
            val lastChar = a.takeRight(1)
            println(lastChar+a+lastChar)
            //return(lastChar+a+lastChar)
        }
        
        extendString("Hello World")//returns dHello Worldd
        
        //3)
        def absoluteDifference(n:Int): Unit ={
            val sum = (n-51).abs
            if(n>51){
                println(sum*3)
                //return(sum*3)
            }
            else{
                println(sum)
                //return(sum)
            }
        }
        
        absoluteDifference(42)//returns 9
        absoluteDifference(102)//returns 153
        
        //4)
        def thirty(a:Int, b:Int): Unit ={
            if(a == 30 || b == 30){
                println("true")
                //return(true)
            }
            else if(a + b == 30){
                println("true")
                //return(true)
            }
            else{
                println("false")
                //return(false)
            }
        }
        
        thirty(3,10)//returns false
        thirty(13,17)//returns true
        thirty(30,45)//returns true
        
        //5)
        def close(a:Int): Unit ={
            if((a>= 80&& a<=120) || a>= 280 && a<= 320){
                println("true")
                //return(true)
            }
            else{
                println("false")
                //return(false)
            }
        }
        
        close(80)//returns true
        close(160)//returns false
        close(320)//returns true
        
        //6)
        def addIf(s:String): Unit ={
            if(s.take(2) == "if"){
                println(s)
                //return s
            }
            else{
                println("if " + s)
            }
        }
        
        addIf("else if statement")//returns if else if statement
        addIf("if else statement")//returns if else statement
        
        //7)
        def removeIndex(s:String, n:Int): Unit ={
            println(s.take(n) + s.drop(n + 1))
        }
        
        removeIndex("String 1", 3)//prints Strng 1
        removeIndex("String 2", 0)//prints tring 2
        removeIndex("String 3", 6)//prints String3
        
        //8)
        def switchFL(s:String): Unit ={
            val first = s.take(1)
            val last = s.takeRight(1)
            val newString = s.drop(1)
            val newString1 = newString.dropRight(1)
            println(last + newString1 + first)
        }
        
        switchFL("Hello World")//returns dello WorlH
        switchFL("New Scala")//returns aew ScalN
    }
}