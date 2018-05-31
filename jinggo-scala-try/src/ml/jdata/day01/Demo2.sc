//循环
//for 循环
var nameList = List("a1","a2","a3")

println("==========第一种写法=========")
// <- 标示提取符
for (s <- nameList)
  println(s)

println("==========第二种写法=========")
//循环的时候加入判断条件
for{
  s <- nameList
  if(s.equals("a2"))
}println("result:" + s)

println("==========第三种写法=========")
for (s <- nameList if s.eq("a2")) println(s)

//使用操作符（关键字）yield 使用循环的每个元素创建一个新的集合
//创建一个新的集合，名字大写
var newNameList = for {
  s <- nameList
  s1 = s.toUpperCase
}yield (s1)

//使用while 循环
var i = 0
while (i < nameList.length){
  println(nameList(i))  //注意：小括号
  i += 1
}