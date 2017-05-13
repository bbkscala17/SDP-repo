package abstractfactory

class NYCConcreteFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = parserType match {
    case "NYCORDER" => new NYCOrderXMLParser()
    case "NYCFEEDBACK" => new NYCFeedbackXMLParser()
    case "NYCERROR" => new NYCErrorXMLParser()
    case "NYCRESPONSE" => new NYCResponseXMLParser()
  }
}
