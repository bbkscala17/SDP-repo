package Factory
import org.scalatest.FunSuite

class FactoryTest extends FunSuite {
  test("Exercise 1 - Factory Pattern - Onion"){
  val onionProd = new ConcreteCreator().factory("onion")
  println("trying to create onion.  product is created of class " + onionProd.getClass)
  assert(onionProd.isInstanceOf[OnionProduct])
}

  test("Exercise 1 - Factory Pattern - Apple"){
    val fruitProd = new ConcreteCreator().factory("apple")
    println("trying to create apple.  product is created of class " + fruitProd.getClass)
    assert(fruitProd.isInstanceOf[AppleProduct])
  }

  test("Exercise 1 - Factory Pattern - Spring onion"){
    val onionProd = new ConcreteCreator().factory("Spring onion")
    assert(onionProd.isInstanceOf[OnionProduct])
  }


  test("Exercise 1 - Factory Pattern - Unknown fruit to generate ConcreteProduct fallback"){
    val guavaProd = new ConcreteCreator().factory("Guava")
    assert(guavaProd.isInstanceOf[ConcreteProduct])
  }

}
