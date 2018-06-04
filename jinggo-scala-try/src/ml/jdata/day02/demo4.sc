//元祖Tuple:是不同类型的值的聚集
//指定类型：Tuple3[Int,Double,String]
val t1 = (1,3.14,"Hello")
val t2 = new Tuple3("Mary",100,"Hello")

//取出每个元素：第二个元素
t2._2
//t2._4  没有的错误

//遍历
t2.productIterator.foreach(println)