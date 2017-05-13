package builder

// Why have a director?  From http://stackoverflow.com/questions/4313172/builder-design-pattern-why-do-we-need-a-director
//If you separate into Director and Builder you have documented the different responsibility of assembling a product from a set of parts (director) and the responsibility of creating the part (builder).
//In the builder you can change how a part is build. In your case whether a AddLiquid() should add cream or milk.
//In the director you can change how to assemble the parts. In your case a by using AddChocolate() instead of AddFruits() you get a different cake.

// TODO

case class CarDirector(carBuilder: CarBuilder) {
  def build = {
    carBuilder.buildEngine
    carBuilder.buildBodyStyle
    carBuilder.buildBreaks
    carBuilder.buildFuelType
    carBuilder.buildPower
    carBuilder.buildSeats
    carBuilder.buildWindows
  }

}
