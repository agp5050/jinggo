//处理异常：使用关键字 case
try{
  val words1 = scala.io.Source.fromFile("d:\\ttt\\b.txt").mkString
}catch {
  case ex1:java.io.FileNotFoundException => {
    println("File Not Found Exception")
  }
  case ex2:IllegalArgumentException => {
    println("File Not Argumen Exception")
  }
  case _:Exception =>{
    println("Other Exception")
  }
}finally {
  println("*************finally*****************")
}