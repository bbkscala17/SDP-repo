package bridge

case class Motoren(product: Product, s: String) extends Car(product, s) {
  override def assemble: Unit = println("Assembling " + product.productName + " for " + s)

  override def produceProduct: Unit = println("Modifying " + product.productName + " according to " + s)

  override def printDetails: Unit = println("Car: " + s + ", Product: " + product.productName)
}
