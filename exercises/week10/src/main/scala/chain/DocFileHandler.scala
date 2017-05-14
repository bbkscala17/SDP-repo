package chain

case class DocFileHandler(s: String) extends Handler {
  var nextHandler: Option[Handler] = None

  override def setHandler(handler: Handler): Unit = nextHandler = Some(handler)

  override def process(file: File): Unit = file.fileType match {
    case "text" => println("Process and saving text file by " + s)
    case _ => nextHandler.get match {
      case h: Handler => {
        println(s + " forwards request to " + h.getHandlerName())
        h.process(file)
      }
    }
  }

  override def getHandlerName(): String = s
}
