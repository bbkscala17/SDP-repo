package decorator

class Spinach(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    pizza.getDesc + ", Spinach (" + -(pizza.getPrice - this.getPrice) + ")"
  }

  def getPrice: Double = {
    pizza.getPrice + 7.92
  }
}
