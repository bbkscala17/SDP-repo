package abstractfactory

class NYCConcreteFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = ???
}
