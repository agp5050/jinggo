import  scala.collection.mutable.ArrayBuffer

//scala 数组
//数组 定长数组 Array
val a = new Array[Int](10)
val b = new Array[String](8)
val c = Array("Tom","Mary","Mike")

//边长数组
val d = ArrayBuffer[Int]()
//增加新的元素
d += 1
d += 2
d += 3
d += 4

//把边长数组转成一个定长数组
d.toArray

//遍历数组 for 循环
for(s <- c) println(s)

//使用foreach 方法（算子）
//注意：算子map 和foreach ：都是对集合中的每个元素进行操作
// 区别：foreach 没有返回值 map 有返回值
c.foreach(println)
