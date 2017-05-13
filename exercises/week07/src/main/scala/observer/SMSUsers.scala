package observer
// this is the concrete observer class.  It needs to hold a reference to concrete subject
// whcih here it gets in the constructor as s
// Each observer registers with a concrete subject to receive updates

case class SMSUsers(s: Subject, msg: String) extends Observer {
  def update(desc: String): Unit = {
    println("===============")
    println("notifying user " + msg)
    println(s.subjectDetails)
    println(desc)
  }

  def subscribe() = s.subscribeObserver(this)

  def unSubscribe() = s.subscribeObserver(this)
}
