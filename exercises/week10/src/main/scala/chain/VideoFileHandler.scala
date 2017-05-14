package chain

case class VideoFileHandler(s: String) extends Handler {
  var nextHandler: Option[Handler] = None

  override def setHandler(handler: Handler): Unit = nextHandler = Some(handler)

  override def process(file: File): Unit = println("Process and saving text file by " + s)

  override def getHandlerName(): String = s
}
