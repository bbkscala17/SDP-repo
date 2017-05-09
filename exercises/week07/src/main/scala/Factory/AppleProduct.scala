package Factory

class AppleProduct(description: String) extends Product {
  // do not need to specify constructor as Scala will take it from the line above - see Alvin Alexander
  println("Apple product created descr '" + description +"'")

  def fallFromTree(): Unit ={
    println("Apple falls from tree")
  }

  def ripen(): Unit ={
    println("Apple is ripe")
  }
}