package observer

class ConcreteSubject extends Subject{
  override def subscribeObserver(observer: Observer): Unit = ???

  override def unSubscribeObserver(observer: Observer): Unit = ???

  override def notifyObservers(): Unit = ???

  override def subjectDetails: String = ???
}
