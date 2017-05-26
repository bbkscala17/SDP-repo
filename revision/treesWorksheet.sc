trait MyBinTree
case class Leaf(value: Int) extends MyBinTree
case class Node[A](lhs: A, rhs: A) extends MyBinTree

val tree1 = Node(Leaf(1), Leaf(2))

val tree2 = Node(
  Node(
    Leaf(1),
    Node(
      Leaf(2), Leaf(3)
    )
  ),
  Node(
    Node(
      Leaf(4), Leaf(5)
    ),
    Node(
      Leaf(6), Node(
        Leaf(7), Leaf(8)
      )
    )
  )
)

def traverse[A](item: A): Unit = item match {
  case Leaf(x) => "Leaf " + println(x)
  case Node(left, right) => {
    traverse(left)
    traverse(right)
  }
}

def find[A](searchValue: Int, searchSet: A): Option[Leaf] = searchSet match {
  case leaf: Leaf => {
    if(leaf.value == searchValue) Option(leaf) else None
  }
  case Node(left, right) => find(searchValue, left) match{
    case leaf: Some[Leaf] => leaf
    case None => find(searchValue, right)
  }
  case _ =>{
    None // in this case the whole sub-tree has now been searched
  }
}

def contains(searchValue: Int, tree: MyBinTree): Boolean = find(searchValue, tree) match {
  case Some(Leaf(searchvalue)) => true
  case _ => false
}

def toList[A](item: A, list: List[Int] = List()): List[Int] = item match {
  case leaf: Leaf => list ::: List(leaf.value)
  case Node(left, right) => {
    toList(left, list) ::: toList(right, list)
  }
}

//
traverse(tree1)
traverse(tree2)

println("Finding 2")
println(find(2, tree2))
println("Finding 6")
println(find(6, tree2))
println("Finding 12")
println(find(12, tree2))

println("Contains 3 " + contains(3, tree2))
println("Contains 8 " + contains(8, tree2))
println("Contains 10 " + contains(10, tree2))

println(toList(tree2))