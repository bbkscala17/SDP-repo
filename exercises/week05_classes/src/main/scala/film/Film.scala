package film

class Film (name: String, yearOfRelease: Int, imdbRasting: Double, director: Director){

  def directorsAge(): Int = yearOfRelease - director.yearOfBirth
//  def director(): String = director.name
  def isDirectedBy(): Boolean = director match {
    case director => true
    case _ => false
  }
}
