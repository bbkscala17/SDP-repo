package film

class Director(firstN: String, lastN: String, yearBirth: Int) {
  def yearOfBirth(): Int = yearBirth
  def name(): String = firstN + " " + lastN
//  def firstName(): String = firstN
//  def lastName(): String = lastN

  // have given getters different names to the years of birth in constructor

//  def equals(director2: Director): Boolean = director2 match{
//    case this => true
//    case _ => false
//  }
}

