package abstractfactory
// This is the 'factory of factories'
// it is called by ParserFactoryProducer.getFactory("NYCFactory")

object ParserFactoryProducer {
  def getFactory(s: String): AbstractParserFactory = s match{
    case "NYCFactory" => new NYCConcreteFactory()
  }

  // TODO

}
