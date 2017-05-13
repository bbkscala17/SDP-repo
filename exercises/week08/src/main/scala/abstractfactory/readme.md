#ParserFactoryProducer
This is at the top and is the abstract factory
it has a method 'get factory' which returns the concrete factory
e.g. ParserFactoryProducer.getFactory("NYCFactory")
this returns the factory below, the AbstractParserFactory class

#AbstractParserFactory
This is the concrete factory
It has a method getParserInstance which returns the object to be used by the application
e.g. parserFactory.getParserInstance("NYCORDER")