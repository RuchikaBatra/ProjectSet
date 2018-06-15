
class MyTest(val name:String,val age:Int){//primary constructor
  
  println("my message")
  
  def test():Unit={
    println(name+ "     "+age)
  }
  
  //auxillary constructor
  def this(name:String)
  {
    this(name,100)
  }
}

object Test {
  def main (args:Array[String]):Unit={
   
    val m1= new MyTest("Test1",18)
    //println(m1.name+"  "+m1.age)
    m1.test()
    val m2 = new MyTest("Test2")
    m2.test()
  }
}