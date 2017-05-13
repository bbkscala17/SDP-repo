package decorator

class RomaTomatoes(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    pizza.getDesc + ", Roma Tomatoes (" + (this.getPrice - pizza.getPrice) + ")"
  }

  def getPrice: Double = {
    pizza.getPrice + 5.20
  }
}
