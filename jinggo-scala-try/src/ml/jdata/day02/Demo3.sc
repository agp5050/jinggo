//映射 Map： 不可变Map 可变的Map
//使用操作符号
val scores = Map("Tom"->80,"Mary"->90,"Mike"->75)

//可变的map
val chinese = scala.collection.mutable.Map("Tom"->80,"Mary"->90,"Mike"->75)

//常用的操作
//获取值
chinese("Tom")

//获取一个不存在的value
//chinese("Jone")
//可以这么写
if(chinese.contains("Jone")){
  chinese("Jone")
}else{
  -1
}


//简写方式
chinese.getOrElse("Jone",-1)

//更新
//chinese("Tom")->100

//添加新的元素
chinese += "Jone" -> 96
chinese

//移除元素
chinese -= "Mike"

//迭代映射
for (s <- chinese) println(s)

//说明：通过foreach 取出Chinese 中的每个元素，并把这个元素传递println
chinese.foreach(println)

