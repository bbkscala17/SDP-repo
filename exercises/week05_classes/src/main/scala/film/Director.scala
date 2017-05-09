package film

class Director(firstN: String, lastN: String, yearBirth: Int) {
  def yearOfBirth(): Int = yearBirth
  def name(): String = firstN + " " + lastN
}

