package abstractfactory

// this is one of the objects created by the concrete factory
// (which factory is in turn is created by the abstract factory)

class NYCOrderXMLParser extends XMLParser{
  override def parse(): String = {
    println("NYC Parsing order XML....")
    "NYC Order XML Message"
  }
}
