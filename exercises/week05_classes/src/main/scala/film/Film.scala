package film

class Film (name: String, yearOfRelease: Int, imdbRasting: Double, director: Director){

  def directorsAge(): Int = yearOfRelease - director.yearOfBirth
  def director(): String = director
}
