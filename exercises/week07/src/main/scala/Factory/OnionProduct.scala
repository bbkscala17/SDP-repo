package Factory

/**
  * Created by dev on 26/02/2017.
  */
class OnionProduct (description: String) extends Product {
  // do not need to specify constructor as Scala will take it from the line above - see Alvin Alexander
  println("Onion product created '" + description + "'")

  def cook(): Unit = {
    println("Onion is cooked")
  }

  def chop(): Unit = {
    println("Onion is chopped")
  }

}
