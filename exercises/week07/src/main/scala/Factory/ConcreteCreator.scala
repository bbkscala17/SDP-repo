package Factory

class ConcreteCreator extends Creator {
  override def factory(description: String): Product = description match {
    case "Apple" => new AppleProduct (description)
    case "apple" => new AppleProduct (description)
    case "onion" => new OnionProduct (description)
    case "Onion" => new OnionProduct (description)
    case "Spring onion" => new OnionProduct (description)
    case _ => new ConcreteProduct(description) //fallback
  }


//  override def factory(customerId: Int, description: String): Product = {
//    new AppleProduct(description: String)
//  }
}
