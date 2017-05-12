import scala.List._

def myFilter(func: (Int => Boolean), l: List[Int]): List[Int] = l match {
  case head :: tail if(func(head)) => head :: myFilter(func, tail)
  case head :: tail => myFilter(func, tail)
  case _ => l
}

def isEven(i: Int) = i match{
  case int if(i % 2 == 0) => true
  case _ => false
}

val list:List[Int] = List(1,5,3,2,6,9,8,0,0,12)
myFilter(isEven, list)

val list2:List[Int] = List(12)
myFilter(isEven, list2)

val list3:List[Int] = List()
myFilter(isEven, list3)

val list4:List[Int] = List(0,-1,3,2,10,11,9)
myFilter(isEven, list4)

//now using Scala list function
list4.filter(isEven)

//now as anon function
list.filter(x => x % 2 == 0)
myFilter(x => x % 2 == 0, list)
myFilter(x => x % 3 == 0, list4)
list4.filter(x => x % 3 == 0)
