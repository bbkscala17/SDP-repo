package film

  class Director(firstName: String, lastName: String, yearBirth: Int){
    val yearOfBirth: Int = yearBirth
    // this is needed since if we just left yearOfBirth in the constructor but did not use it anywhere,
    // it would remains there, and no field would be generated, so we wouldnt be able to get its value
    // from Film.scala by director.yearOfBirth
    // we cant add a getter method called yearOfBirth() if the param in constructor has same name

    def name(): String = firstName + " " + lastName
}

object Director{
  def apply(firstName: String, lastName: String, yearBirth: Int): Director ={
    new Director(firstName: String, lastName: String, yearBirth: Int)
    // if omit the new from the second line it keeps calling itself
  }
  // apply used to make it nicer to construct objects than using 'new' e.g. the split string example in person
//  or if had arrays as params

  def older(director1: Director, director2: Director): Director = {
    if(director1.yearOfBirth < director2.yearOfBirth) director1
    else director2
  }
  //  called from test suite by Director.older(eastwood, mcTiernan)
}