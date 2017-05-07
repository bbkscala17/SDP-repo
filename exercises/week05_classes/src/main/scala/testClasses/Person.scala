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
