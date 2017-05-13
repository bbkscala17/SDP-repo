package observer

class ConcreteObserver(subject: ConcreteSubject) extends Observer{
  // concrete observer needs to hold a reference to concrete subject
  // each observer registers with a concrete subject to receive updates

  override def update(desc: String) = {
    // The Observers update method is called when the Subject's state changes
    println("notifying user " + desc)
  }

  override def subscribe(): Unit = subject.subscribeObserver(this)

  override def unSubscribe(): Unit = subject.unSubscribeObserver(this)

}
