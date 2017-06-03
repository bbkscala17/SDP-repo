def combine(str: String, int: Int): String = str * int

println(combine("test", 3))
println(combine2("test", 3))

def combine2(str: String, int: Int): String = int match{
  case 1 => str
  case _ => str + combine2(str, int-1)
}

class SimpleTime(val hours: Int, val minutes: Int)
// could do as case class but only do that if want the companion object
// if put val in constructor as class then get getters
// if put var in constructor as class then get getters and setters


val t = new SimpleTime(hours=5, minutes=30)
t.hours
t.minutes

class Item(name: String, price: Double) {
  def cost(grocery:Boolean = false, medication: Boolean = false, rate: Double = 0.1) =
    (grocery, medication) match {
      case (true, _) => price
      case (_, true) => price
      case _ => price * (1 + rate)
  }
}

val flour = new Item(name="flour", 4)
flour.cost(grocery = true)
val sunscreen = new Item(name="sunscreen", 3)
sunscreen.cost()

val tv = new Item(name="television", 500)
tv.cost(rate = 0.06)

class ClothesWasher(val modelName: String, val capacity: Double) {
  def this(modelName: String) = {
    this(modelName, 0)
  }
  def this(capacity: Double) = {
    this("", capacity)
  }
}

println(new ClothesWasher(3).modelName)
println(new ClothesWasher(3).capacity)

println(new ClothesWasher("test").modelName)
println(new ClothesWasher("test").capacity)

println(new ClothesWasher("test2", 2).modelName)
println(new ClothesWasher("test2", 2).capacity)


val func = (temperate: Int, low: Int, high: Int) => (temperate, low, high) match {
  case (t,l,h) if t > l && t < h => true
  case _ => false
}

def between(t: Int, l: Int, h: Int): Boolean = func(t,l,h)

def between2(t: Int, l: Int, h: Int): Boolean = !(t > h || t < l)

println(between2(70,80,90))
println(between2(70,60,90))

def sumIt(y: Int*): Int = y.reduce(_+_)

sumIt(1,2,3)
sumIt(45,45,45,60)


def map[A,B] (f: A=>B)(l:List[A]): List[B] = {
  for(e <- l) yield f(e)
}

def mapped2[A,B](f: A => B)(l: List[A]): List[B] = l match{
  case Nil => Nil
  case head :: tail => f(head) :: mapped2(f)(tail)
}

val mapped = map((a: Int) => a * 2)(List(1,2,3))
println(mapped)

val mapped2: List[Int] = mapped2((a: Int) => a * 2)(List(1,2,3))
println(mapped2)

val notFlat = List(List(1,2,3), List(4,5,6), List(7))

def myFlatten(xs: List[List[Int]]): List[Int] = xs match {
  case Nil => Nil
  case head :: tail => head ++ myFlatten(tail)
  case tail => myFlatten(tail)
}

println("flatten")
println(myFlatten(notFlat))

def myMap(xs: List[Int], f: (Int => Int)): List[Int] = xs match{
  case Nil => Nil
  case head :: tail => f(head) :: myMap(tail, f)
  case tail => myMap(tail, f)
}

println(myMap(List(3,6,9), (a: Int) => a * 2))

//def reverse(xs: List[Int]): List[Int] = xs match{
//  case Nil => Nil
//  case head :: tail => reverse(tail)  head
//}
//
//println(reverse(List(1,2,3,4,5)))

val aList = List (1,2,3,4,5,6)

def myFoldLeft[A,B](xs: List[A], z: B, f: ((B,A) => B)): B = xs match{
  case Nil => z
  case head :: tail => myFoldLeft(tail, f(z, head), f)
}

println(myFoldLeft(aList, 0, (a:Int, b: Int) => a+b))

def myReverse[A](xs: List[A]) = xs match{
  case Nil => Nil
  case head :: tail => myFoldLeft(tail, List[A](head), (z: List[A], head: A) => head :: z)
}

//aList

println("reverse")
println(myReverse(aList))


def myFilter[A](xs: List[A], filterFunc: (A => Boolean)): List[A] = xs match{
  case Nil => Nil
  case head :: tail if filterFunc(head) => head :: myFilter(tail, filterFunc)
  case head :: tail => myFilter(tail, filterFunc)
}

println("Filtering")
val filterFunc = (a:Int) => a % 3 match {
  case 0 => true
  case _ => false
}

println(myFilter(aList, filterFunc))

def myFoldRight[A, B](xs: List[A], accum: B, f: ((B, A) => B)): B = {
  val reversed  = myReverse(xs)
  myFoldLeft(reversed, accum, f)
}

val strList = List("A", "B", "C", "D")

println("foldright")
println(myFoldRight(strList, "", (a:String, b: String) => a+b))

//  // if list contains head and tail, apply the function to (z and the head) (e.g add head to z) and then recursively call func again
//  // with the result of that as a new z, and the tail
//  // dont need an extra case for head :: Nil as we are using two items together for the function (e.g. to add them)


def myZip[A,B](a: List[A], b: List[B]): List[(A,B)] = (a,b) match {
  case (Nil, Nil) => Nil
  case (h1 :: t1, h2 :: t2) => (h1, h2) :: myZip(t1,t2)
}

def getElement[A](xs: List[A], position: Int): A = xs match{
  case Nil => throw new IllegalArgumentException
  case _ :: tail if position != 1 => getElement(tail, position-1)
  case head :: _ => head
}

println("getting element")
println(getElement(strList,3))

println("My zip")
println(myZip(List(1,2,3), List(4,5,6)))
//foldright
// zip
