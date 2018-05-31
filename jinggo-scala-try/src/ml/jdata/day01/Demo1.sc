//定义一个函数，求和
def sum(x:Int,y:Int):Int = x + y

//调用
var total = sum(1,10)

//定义函数：求阶乘  5!
//使用递归：必须有退出条件
//注意：scala中函数的最后一句话，就是函数分返回值
//不写reture
//如果x的类型是一个函数，就是Scala高阶函数 ----> 函数式编程
//也就是说：x的值是另一个函数
def myFactory(x:Int):Int = {
  if(x <= 1){
    1
  }else{
    x * myFactory(x-1)
  }
}

//调用
myFactory(5)
