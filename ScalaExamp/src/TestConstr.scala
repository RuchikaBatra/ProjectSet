

class TestConstr(val name:String,val age:Int){//primary Constructor
  
  def this(name:String){//Auxillary constructor)
    this(name,100)
  }
  def test():Unit={
    println(name + "  " +age)
  }
}

object TestMyClass{
  def main(args:Array[String]):Unit={
    val m = new TestConstr("Test",18)
   val m1 = new TestConstr("Test1")
   m1.test()
   
  }
}