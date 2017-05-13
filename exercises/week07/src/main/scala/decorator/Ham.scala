package decorator

class Ham(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    pizza.getDesc + ", Ham (" + -(pizza.getPrice - this.getPrice) + ")"
  }

  def getPrice: Double = {
    pizza.getPrice + 18.12
  }
}
