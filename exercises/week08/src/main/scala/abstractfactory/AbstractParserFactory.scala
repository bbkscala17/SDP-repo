package abstractfactory

// this is the interface which will be implemented by all the concrete factories
// (not the abstract one, which is what produces these factories)
// (those factories will then go on to provide the XML parser object to the client object

trait AbstractParserFactory {
  def getParserInstance(parserType: String): XMLParser
}