package observer

import scala.collection.mutable.ListBuffer

class ConcreteSubject extends Subject{

  var observers: ListBuffer[Observer] = new ListBuffer

  override def subscribeObserver(observer: Observer): Unit = observers += observer

  override def unSubscribeObserver(observer: Observer): Unit = observers -= observer

  override def notifyObservers(): Unit = for(observer <- observers) notify()

  override def subjectDetails: String = ???
}
