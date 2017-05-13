package observer
// this is the Concrete Subject class
// it maintains the list of observers (here the 'subsribers' var passed in constuctor

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String) extends Subject with Commentary {
  def subscribeObserver(observer: Observer) = subscribers += observer

  def unSubscribeObserver(observer: Observer) = subscribers -= observer

  def notifyObservers() = for(observer <- subscribers) observer.notify()

  def subjectDetails: String = title

  def setDesc(title: String): Unit = {
    for(observer <- subscribers) observer.update(title)
  }
}
