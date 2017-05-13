package observer

case class SMSUsers(s: Subject, msg: String) extends Observer {
  def update(desc: String): Unit = {
    println("notifying user " + s + "with message" + msg)
  }

  def subscribe() = ???

  def unSubscribe() = ???
}
