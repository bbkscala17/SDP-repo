package film

  class Director(firstName: String, lastName: String, yearBirth: Int){
    val yearOfBirth: Int = yearBirth
    // this is needed since if we just left yearOfBirth in the constructor but did not use it anywhere,
    // it would remains there, and no field would be generated, so we wouldnt be able to get its value
    // from Film.scala by director.yearOfBirth
    // we cant add a getter method called yearOfBirth() if the param in constructor has same name

  def name(): String = firstName + " " + lastName

}