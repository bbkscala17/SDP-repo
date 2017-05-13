package decorator

class Meat(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    pizza.getDesc + ", Meat (" + -(pizza.getPrice - this.getPrice) + ")"
  }

  def getPrice: Double = {
    pizza.getPrice + 14.25
  }
}
