package decorator

class SimplyNonVegPizza extends Pizza {

  def getDesc: String = {
    "SimplyNonVegPizza (" + this.getPrice + ")"
  }

  def getPrice: Double = {
    350.0
  }
}
