package film

 class Film (filmName: String, year: Int, imdbRating: Double, dir: Director) {
  val name: String = filmName
   val director: Director = dir
   val yearOfRelease: Int = year
   // as in film, these is needed to ensure we can call film.director etc from other class
   // and we need to rename to 'dir' in constructor so it does not conflict

   def directorsAge(): Int = yearOfRelease - director.yearOfBirth

   def isDirectedBy(queryDirector: Director): Boolean = {
     if (queryDirector.name == director.name && queryDirector.yearOfBirth == director.yearOfBirth) true
     else false
   }


   def copy(name: String = name, yearOfRelease: Int = yearOfRelease, imdbRating: Double = imdbRating, director: Director = director): Film = {
     new Film(name, yearOfRelease, imdbRating, director)
     // previously had lots of case statements to work out if each value had changed or was still default
     // but it looks like Scala handles this so I removed them
     //  note that field names match the class level
     // seems Scala is clever enough to know that when I say name: String = name I am referring to
     // the existing instance variable as the default with the second 'name'
   }

   def copyYearZero(name: String = name, yearOfRelease: Int = 0, imdbRating: Double = imdbRating, director: Director = director): Film = {
     new Film(name, yearOfRelease, imdbRating, director)
     }

   def print(): Unit = {
     println(name)
     println(yearOfRelease)
     println(imdbRating)
     println(director)
     println(director.name)
   }
 }


