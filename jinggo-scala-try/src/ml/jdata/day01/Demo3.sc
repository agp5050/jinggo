//函数的参数：默认参数、代名参数、可变参数

//默认参数
def fun1(name:String=" Mary"):String = "Hello" + name

fun1(" Tom")
fun1()

//代名参数：如果一个函数具有多个默认参数，使用带名参数区别
def fun2(str:String="Good Morning ",name:String="Mary",age:Int=20)
=str + name + " the age of " + name + " is " + age
fun2()
fun2(name="Mike")

//可变参数 scala 使用 *
//求任意个数字的和
def sum(args:Int*) = {
    var result = 0
    for(arg <- args){
      result += arg
    }
  //最后一句就是返回值
  result
}

sum(1,2,3)
sum(1,2,3,4)

