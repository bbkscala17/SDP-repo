package chain

case class TextFileHandler(s: String) extends Handler {
  override def setHandler(handler: Handler): Unit = println()

  override def process(file: File): Unit = ???

  override def getHandlerName(): String = ???
}
