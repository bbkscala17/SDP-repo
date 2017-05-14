package chain

case class VideoFileHandler(s: String) extends Handler {
  var nextHandler: Option[Handler] = None

  override def setHandler(handler: Handler): Unit = nextHandler = Some(handler)

  override def process(file: File): Unit = file.fileType match {
    case "text" => println("Process and saving video file by " + s)
    case _ => nextHandler.get match {
      case h: Handler => h .process(file)
    }
  }

  override def getHandlerName(): String = s
}
