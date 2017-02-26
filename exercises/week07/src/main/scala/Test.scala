import Factory.{AppleProduct, ConcreteCreator, OnionProduct}

object Test extends App {
  val onionProd = new ConcreteCreator().factory("onion")
  println("trying to create onion.  product is created of class " + onionProd.getClass)

  val fruitProd = new ConcreteCreator().factory("apple")
  println("trying to create apple.  product is created of class " + fruitProd.getClass)

  while(true) {
    var typ = readLine("enter item to create as apple or onion")
    val prod = new ConcreteCreator().factory(typ)
    println("Resulting object class: " + prod.getClass)
    prod match {
      case prod: AppleProduct => prod.fallFromTree(); prod.ripen()
      case prod: OnionProduct => prod.chop(); prod.cook()
      case _ => throw new ClassCastException
    }
    }
}
