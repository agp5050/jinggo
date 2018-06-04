package ml.jdata.day02.clazz

/**
  * Created by gz12 on 2018-06-04.
  */
class Student1 {

  //定义属性
  private var stuIdD:Int = 0
  private var stuName:String = ""

  //成员方法
  def getStuID():Int = this.stuIdD
  def setStuID(newID:Int) = this.stuIdD = newID

  def getStuName():String = this.stuName
  def setStuName(newName:String) = this.stuName = newName

}

//写一个main 方法，是静态的
//如果object的名字跟类的名字一样，这时就把这个object对象叫做该类的伴生对象
object Student1{
  def main(args: Array[String]): Unit = {
    var s1 = new Student1

    //赋值
    s1.setStuID(1)
    s1.setStuName("Tom")

    //输出
    println(s1.getStuID() + " " + s1.getStuName())


  }
}
