package Factory

class Creator {
  def factory(description: String): Product = {
    new ConcreteProduct(description) // use ConcreteProduct as Product trait is abstract
  }
}
