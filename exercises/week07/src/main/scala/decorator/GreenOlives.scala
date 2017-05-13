package decorator

class GreenOlives(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    pizza.getDesc + ", Green Olives (" + -(pizza.getPrice - this.getPrice) + ")"
  }

  def getPrice: Double = {
    pizza.getPrice + 5.47
  }
}
