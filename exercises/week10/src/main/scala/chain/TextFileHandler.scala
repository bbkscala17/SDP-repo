package chain

case class TextFileHandler(s: String) extends Handler {
  var nextHandler: Option[Handler] = None

  override def setHandler(handler: Handler): Unit = nextHandler = Some(handler)

  override def process(file: File): Unit = file.fileType match {
    case "text" => println("Process and saving text file by " + s)
    case _ => nextHandler.isEmpty match {
      case false => nextHandler.get match {
        case h: Handler => {
          println(s + " forwards request to " + h.getHandlerName())
          h.process(file)
        }
      }
      case true => println("File not supported type " + file.fileType)
    }
  }

  override def getHandlerName(): String = s
}
