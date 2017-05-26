// Q6

def flatten[A](as: List[List[A]]): List[Any] = as match{
  case (head: List[A]) :: tail => head ::: flatten(tail)
  case head :: tail => head :: tail
  case value: A => value
}

val list1 = List(List(1,2,3),List(4,5,6),List(7),List(8,9))
println(flatten(list1))


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