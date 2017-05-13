package decorator

class Cheese(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    pizza.getDesc + ", Cheese (" + -(pizza.getPrice - this.getPrice) + ")"
  }

  def getPrice: Double = {
    pizza.getPrice + 20.72
  }
}
