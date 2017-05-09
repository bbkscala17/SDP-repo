case class PersonCase(name: Array[String]) {
  println("Person created with name ...")
  for(word<-name) println(word)

  def getName(): Array[String] = name
}

case object PersonCase{
  def apply(name:String): PersonCase = {
    new PersonCase(name.split(" "))
  }
}
