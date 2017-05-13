package abstractfactory
// this is one of the objects created by the concrete factory
// (which factory is in turn is created by the abstract factory)

class NYCErrorXMLParser extends XMLParser{
  override def parse(): Unit = ???
}
