import scala.annotation.tailrec

def factorials(inp: Int): BigInt = inp match{
  case 0 => 1
  case _ => inp * factorials(inp-1)
}

@tailrec
def factorialsTailRec(inp: Int, accum: Int = 1): Int = (inp, accum) match{
  case (0,a) => a
  case _ => factorialsTailRec(inp-1, accum * inp)
}

factorials(3)

factorialsTailRec(3)



def fib(inp: Int): Int = inp match{
  case 1 => 1
  case a if a <=0 => 0
  case _ => fib(inp-1) + fib(inp-2)
}


//def fibtail(inp: Int, accum: Int = 0): Int = (inp, accum) match{
//  case (1,acc) => acc + 1
//  case (_,acc) if inp <=0 => acc
//  case (value,accum) => {
//    fibtail(value, accum + value)
//  }
//}

def fibtail(x: Int): BigInt = {
  @tailrec def fibHelper(x: Int, prev: BigInt = 0, next: BigInt = 1): BigInt = x match {
    case 0 => prev
    case 1 => next
    case _ => fibHelper(x - 1, next, (next + prev))
  }
  fibHelper(x)
}

def maxInList(xs: List[Int], max: Int = -1): Int = xs match {
  case xs if xs.length == 1 && xs.head > max => xs.head
  case a :: tail if a > max => maxInList(tail,a)
  case tail => maxInList(tail, max)
}

def minInListTail(xs: List[Int], min: Int = 9999): Int = xs match{
  case List(element: Int) if element < min => element
  case head :: tail if head < min => minInListTail(tail, head)
  case head :: tail => minInListTail(tail, min)
  case _ => min
}

def minInList(xs: List[Int]): Int = xs match{
  case List(last) => last
  case head :: tail if head < minInList(tail) => head
  case head :: tail => minInList(tail)
}

//maxInList(List(4,8,3,2,8,9,12,2,9))
minInList(List(4,8,3,2,8,9,12,2,9))
//0,1,1,2,3,5,8,13,21,34

//fib(0)
//fib(1)
//fib(2)
//fib(3)
//fib(4)
//fib(5)
//fib(6)
//fib(7)
//fib(8)
//fib(9)

//fibtail(0)
//fibtail(1)
//fibtail(2)
//fibtail(3)
//fibtail(4)
//fibtail(5)
//fibtail(6)
//fibtail(7)
//fibtail(8)
//fibtail(9)

def myFoldLeft[A, B](ls: List[A])(z: B)(f: (B, A) => B): B = ls match {
//  case List(tail) => f(z, tail)
  case head :: tail => myFoldLeft(tail)(f(z, head))(f)
  case Nil => z
}

val func =  (a: Int, b: Int) => a * b

//val halfEmptyFunc = (a: Int, _) => (a * 2)
//halfEmptyFunc(6,_)


myFoldLeft(List(1,2,3))(1)(func)

val concatFunc = (a: String, b: String) => a + b
myFoldLeft(List("H", "e", "l", "l", "o"))("initial")(concatFunc)
myFoldLeft(List("H", "e", "l", "l", "o"))("another")(concatFunc)

//using List library fold
val list = List(1,2,3,4,5)
println("folding")
list.foldLeft(0)((b,a) => b+a)
list.foldLeft(1)((b,a) => b*a)
list.foldLeft(List[Int]())((b,a) => a :: b)
//def foldLeft[A,B](z: B)(f: (B, A) => B): B

val afunc = (a: Int, b: Int) => a - b

def foldRight[A, B](ls: List[A], z: B)(f: (B, A) => B): B = ls match {
  //  case List(tail) => f(z, tail)
  case ls if ls.length > 1 => foldRight(ls.take(ls.length-1),f(z, ls.last))(f)
  case List(item) => f(z, item)
  case Nil => z
}

println("fold right")
foldRight(List(1,2,3,4,5,6), 0)((b,a) => b+a)