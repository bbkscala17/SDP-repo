def filter(func: (Int => Boolean), l: List[Int]): List[Int] = l match {
  case head :: tail if(isEven(head)) => head :: filter(func, tail)
  case head :: tail => filter(func, tail)
//  case int => l
  case _ => Nil
}

def isEven(i: Int) = i match{
  case int if(i % 2 == 0) => true
  case _ => false
}

val list:List[Int] = List(1,5,3,2,6,9,8,0,0,12)
filter(isEven, list)

val list2:List[Int] = List(12)
filter(isEven, list2)

