
//companion object
class TestComp{
  def test():Unit={
    TestComp.printmsg()
  }
}
object TestComp {
  
  def printmsg():Unit={
    println("hello comapnion")
  
  }
}

object Main{
  def main(args:Array[String]):Unit={
    val m = new TestComp()
    m.test()
  }
}