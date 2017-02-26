package Factory

class AppleCreator extends Creator {
  override def factory(description: String = ""): Product = {
    new AppleProduct(description)
  }
}