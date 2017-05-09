package film

class Film (filmName: String, year: Int, imdbRating: Double, dir: Director){

  def name() = filmName
  def yearOfRelease() = year
  def director(): Director = dir
  def directorsAge(): Int = year - dir.yearOfBirth
  def isDirectedBy(queryDirector: Director): Boolean = {
    if(queryDirector.name  == dir.name && queryDirector.yearOfBirth() == dir.yearOfBirth()) true
    else false
  }

  def copy(newName: String = "", newYearOfRelease: Int = -1, newImdbRating: Double = -1, newDir: Director = new Director("", "", -1)): Film ={
    val finalName = newName match{
      case "" => filmName
      case _ => newName
    }
    val finalYear = newYearOfRelease match{
      case -1 => year
      case _ => newYearOfRelease
    }
    val finalImdb = newImdbRating match{
      case -1 => imdbRating
      case _ => newImdbRating
    }
    val finalDirector = newDir.yearOfBirth() match{
      case -1 => dir
      case _ => newDir
    }
    new Film(finalName, finalYear, finalImdb, finalDirector)
  }

  def print(): Unit ={
    println(name)
    println(yearOfRelease)
    println(imdbRating)
    println(dir)
    println(dir.name)
  }

  }
