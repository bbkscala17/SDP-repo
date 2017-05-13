package abstractfactory

class LondonConcreteFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = parserType match {
    case "LondonORDER" => new LondonOrderXMLParser()
    case "LondonFEEDBACK" => new LondonFeedbackXMLParser()
    case "LondonERROR" => new LondonErrorXMLParser()
    case "LondonRESPONSE" => new LondonResponseXMLParser()
  }
}
