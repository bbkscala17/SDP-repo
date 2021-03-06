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

def flattenThis[A](l: List[A]): List[Any] = {
  val output = l match{
    case Nil => Nil
    case (head: List[_]) :: tail => flattenThis(head) ::: flattenThis(tail)
    case head :: tail => head :: flattenThis(tail)
    case _ => throw new IllegalArgumentException()
    //TODO as for construct
  }
  output
}
val notFlat: List[List[Int]] = List(List(9,8,7),List(2,3), List(9), List(9))
flattenThis(notFlat)


//TREE TRAVERSAL EXAMPLE FROM
//http://www.scala-lang.org/old/node/7984

sealed abstract class Tree
case class Leaf(x: Int) extends Tree
case class Node(left: Tree, right: Tree) extends Tree

// Recursive but not tail recursive
def sum(t: Tree): Int = t match {
  case Leaf(x) => x
  case Node(l, r) => sum(l) + sum(r)
}
//A common trick is to use a continuation to make the function tail
//recursive. That works in Haskell or F# for instance but Scala is not
//able to optimize the following code. Probably because the recursive call
//is from lambda (it is not a self call).
def sum2(t: Tree) = {
  def sumRec(t: Tree, k: Int => Int): Int = t match {
    case Leaf(x) => k(x)
    case Node(l, r) =>
      sumRec(l, lsum => sumRec(r, rsum => k(lsum + rsum)))
  }
  sumRec(t, x => x)
}
def bigTree =
  (0 to 100).foldLeft(Leaf(1): Tree) { (t, i) => Node(Leaf(1), t) }
sum2(bigTree)
// StackOverflowError with 100000



