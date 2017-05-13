package abstractfactory

// this is one of the objects created by the concrete factory
// (which factory is in turn is created by the abstract factory)

class NYCResponseXMLParser extends XMLParser{
  override def parse(): String = {
    println("NYC Parsing response XML....")
    "NYC Response XML Message"
  }
}
