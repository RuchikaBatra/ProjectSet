//singleton object
object MyObject{
  def test():Unit={
    print("in test")
  }
}

object TestStatic {
  
  def main(args:Array[String]):Unit={
  MyObject.test()
    
  }
}