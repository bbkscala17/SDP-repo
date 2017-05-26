import scala.annotation.tailrec

// Q6

def myFlatten[A](as: List[List[A]]): List[Any] = as match{
  case (head: List[A]) :: tail => head ::: myFlatten(tail)
  case head :: tail => head :: tail
  case Nil => Nil
}

val list1 = List(List(1,2,3),List(4,5,6),List(7),List(8,9))
println(myFlatten(list1))


// Q8

def allExceptOption(str: String, xs: List[String]): Option[List[String]] = {
  val helperResult = helper(str, xs)
  if (helperResult.length != xs.length) Option(helper(str, xs)) // string was found
  else None
}


def helper(searchStr: String, xs: List[String], accum: List[String] = List()): List[String] = xs match {
  case head :: tail if head != searchStr => helper(searchStr, tail, accum ::: List(head)) // include head
  case head :: tail => helper(searchStr, tail, accum) // miss off head
  case tail => accum ::: tail
}

println(allExceptOption("item", List("fred", "knife", "butter")))

println(allExceptOption("knife", List("fred", "knife", "butter")))

def getSubstitutions1(s: String, xs: List[List[String]]): List[String] = xs match {
  case head :: tail if head.contains(s) => head.filter(x => x!=s) ::: getSubstitutions1(s, tail)
  case head :: tail => getSubstitutions1(s, tail) // drop head as doesnt contain
  case _ => List[String]()
  }

getSubstitutions1("Jeff", List(List("Fred", "Frederick"), List("Jeff", "Jeffrey"), List("Geoff", "Jeff","Jeffrey")))


def getSubstitutions2(s: String, xs: List[List[String]]): List[String] = {
  tailRecHelper(s, xs, List[String]())
}

@tailrec
def tailRecHelper(s: String, xs: List[List[String]], accum: List[String]): List[String] = xs match {
  case head :: tail if head.contains(s) => tailRecHelper(s, tail, accum ::: head.filter(x => x != s))
  case head :: tail => tailRecHelper(s, tail, accum) // drop head as doesnt contain
  case _ => accum
}

getSubstitutions2("Jeff", List(List("Fred", "Frederick"), List("Jeff", "Jeffrey"), List("Geoff", "Jeff", "Jeffrey")))

def similarNames(name: Tuple3[String, String, String], xs: List[List[String]]): List[Tuple3[String, String, String]] = {
  val subsnames = getSubstitutions2(name._1, xs)
    getSubsNames(name, subsnames)
}
def getSubsNames(name: (String, String, String), xs: List[String]): List[Tuple3[String, String, String]] = xs match{
    case head :: tail => (head, name._2, name._3) :: getSubsNames(name, tail)
    case _ => List[Tuple3[String, String, String]](Tuple3(name._1, name._2, name._3))
}
println("Similar names")
similarNames(("Fred", "W", "Smith"), List(List("Fred", "Frederick", "Frank"), List("Jeff", "Jeffrey"), List("Geoff", "Jeff", "Jeffrey")))

similarNames(("Bernard", "J", "Jones"), List(List("Fred", "Frederick", "Frank"), List("Jeff", "Jeffrey"), List("Bernie", "Bern", "Bernard", "Bez", "B"), List("Geoff", "Jeff", "Jeffrey")))


