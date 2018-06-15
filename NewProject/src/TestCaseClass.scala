case class MyCaseClass(empId:Int,empName:String,empAddr:String)
{
  
}

object TestCaseClass {
    def main(args:Array[String]):Unit={
      val s= new MyCaseClass(12,"navi","delhi")
      val s1 = new MyCaseClass(13,"navi1","mumbai")
      println(s==s1)
      val s2 = s1.copy()  // val s2 = s1.copy(empId=14)
      println( s1== s2)
      println(s)
    }
}