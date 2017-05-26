def flatten[A](as: List[List[A]]): List[Any] = as match{
  case (head: List[A]) :: tail => head ::: flatten(tail)
  case head :: tail => head :: tail
  case value: A => value
}

val list1 = List(List(1,2,3),List(4,5,6),List(7),List(8,9))
println(flatten(list1))
