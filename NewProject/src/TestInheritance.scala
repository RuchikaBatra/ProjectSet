
abstract class MyAbstractFile{
  def open(filename:String):Unit
  def save(filename:String):Unit
}
 class MyFile extends MyAbstractFile{
  override def open(filename:String):Unit={
    println("myfile open method..")
    
  }
  override def save(filename:String):Unit={
    println("myfile close method called..")
  }
}

class MyCompressedFile extends MyFile{
  override def save(filename:String):Unit={
    println("mycompressed file save method called..")
    println(">>>>implementing compression logic")
    super.save(filename)
  }
}

object TestInheritance {
  def main(args:Array[String])
  {
    var f:MyAbstractFile = new MyFile()//run-time polymporphism
    f.open(null)
    f.save(null)
    f = new MyCompressedFile()
    f.open(null)
    f.save(null)
  }
}