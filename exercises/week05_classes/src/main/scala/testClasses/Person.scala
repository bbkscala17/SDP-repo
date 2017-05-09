package testClasses

class Person(name: Array[String]) {
  println("Person created with name ...")
  for(word<-name) println(word)

  def getName(): Array[String] = name
}

object Person{
  def apply(name:String): Person = {
    new Person(name.split(" "))
  }
}


//In Scala, there is a language feature generally referred to as "The Apply Method" that has the following rules:
//Any object that has an apply method can be called with the .apply omitted. Functions are no more than objects.
//http://jackcoughonsoftware.blogspot.co.uk/2009/01/deeper-look-at-apply-method-in-scala.html