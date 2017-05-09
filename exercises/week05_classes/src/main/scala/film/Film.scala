package film

class Film (name: String, yearOfRelease: Int, imdbRating: Double, dir: Director){

  def director(): Director = dir
  def directorsAge(): Int = yearOfRelease - dir.yearOfBirth
  def isDirectedBy(queryDirector: Director): Boolean = {
    if(queryDirector.name  == dir.name && queryDirector.yearOfBirth() == dir.yearOfBirth()) true
    else false
  }

  def print(): Unit ={
    println(name)
    println(yearOfRelease)
    println(imdbRating)
    println(dir)
    println(dir.name)
  }

  }
