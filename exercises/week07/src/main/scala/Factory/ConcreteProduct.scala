package Factory

class ConcreteProduct (description: String) extends Product {
  println("Creating ConcreteProduct object (fallback when class does not appear in switch statement)")
  // do not need to specify constructor as Scala will take it from the line above - see Alvin Alexander

  }
