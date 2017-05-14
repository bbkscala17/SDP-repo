#Week 8 - Design Patterns II

##Q1 - Strategy Pattern
This pattern defines a set of encapsulated algos that are interchangeable and so can be swapped.  They can vary independently of the clients that use them.

In scala you can achieve the same thing more simply by having methods that accept functions as params, and changing the function
 you pass in based on runtime decisions.

It is appropriate to use the stategy design pattern when you want many different versions of an algorithm, and you want to define the behaviour at runtime, while avoiding complex conditionals

We saw this in coursework two where we had a series of instruction objects with algorithms built into their execute() methods (iadd, iconst etc)


##Q3 - Abstract Factory Pattern

This can be described as a 'factory of factories'.  I.e. an abstract factory may create factories which themselves will create the objects required by the application

Refcardz explains that it is appropriate to use this when (their words):
 - creation of concrete objects should be independent of the system usign them
 - system needs to use multiple families of objects, which must be used together
 - Libraries must be used without exposing implementation details
 - Concrete classes should be decoupled from clients

#Q5 - Construction Bloat and Modularity

"In general, the details of object construction, such as instantiating and initialising the components that comprise the object,
are kept within the object, often as part of its constructor"

This may be fine for simple objects but when you get complexity and potentially lots of different kinds of objects needed by the object
then the constructor may become too unwieldy.  e.g. it may be necessary to have numerous different constructors, or it might be very difficult
to work out exactly whcih constructors would be required in advance.

This approach also also leads to close coupling (i.e. the opposite of a modular approach) making it harder to add new things,
take redundant things away, or swap things around as requirements change and the business needs evolve.

The Builder design pattern helps with this as it helps to create instances of classes without using the class constructors.
It does so by having a 'builder' object, which handles/sets initialisation parameters as required when building the new object

#Q7 - Facade Pattern
The facade pattern "supplies a single interface to a set of interfaces within a system" (refcardz)

The idea is to wrap a complex system into something simpler, to make it easier for those who need to use it to do so
 without understanding all of the complexity of the real system - i.e. to present them with a facade.

You would use this when you need to simplify a complex system and the client does not need to be able to see all
of the complexity in order to do what they need to do
