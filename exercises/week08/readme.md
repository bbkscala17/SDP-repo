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
of the complexity in order to do what they need to do.  e.g. if you have a complex existing system which you cannot rewrite
from scratch, and the client only needs to actually use a limited number of functions of that system, you could make a facade

In a way it is like the adaptor in that it changes one thing to another, but by wrapping the original object it can be simpler

#Q9 - Bridge pattern

The Bridge pattern decouples an abstraction from its implementation so that the two can very independently.

Derek Banas explains it as "Progressively adding functionality while separating out major differences using absract classes"

e.g. if designing remote controls for lots of different TVs, all will have a volumne control.  But TV2 may have a DVD player so that button 6 on TV2 relates to that and not to change channel like on TV1.  So this method (button 6) differs betweeen the two
Our abstract remote control classes sit between the remotes and the TVs and hold a reference to the TV (e.g. TV1 and TV2) and define the abstract methods that differ between the two

Banas on when to use it:
- When you want to be able to change both the abstractions (abstract classes) and concrete classes independently
- when you want the first abstract class to define rules (Abstract TV)
- The concrete class adds additional rules (Concrete TV)
- An abstract class has a reference to the device and it defines abstract methods that will be defined (Abstract remote)
- The Concrete Remote defines the abstract methods required

It is useful to avoid a proliferation of classes / sub classes whcih would make maintenance and readability difficult

Again this is similar to adaptor except that we use adaptor in 3rd party or legacy code, but we use the Bridge pattern when we
design from the outset

#Q11 - Composite Design Pattern

This pattern is for composing objects into tree structures (nodes, leafs) to represent whole-part hierarchies.
Each object can be treated independently or they can be treated as a nested set using the same interface

e.g. if you have a shopping cart and want the total cost, you could call the cost() method on the whole cart or one item, or perhaps just those items in the 'books' catergory

When to use it?  Anywhere that a tree structure makes sense.  e.g. file systems are a good candidate as they are pure tree structures with directories as nodes and files as leafs

The four participants are:
- composite - this is like the node in the tree or the directory in the file structure.  Can contain other composites or leafs.  Contains its own name and methods to describe its contents
- leaf - final elements e.g. items in shopping cart.  Contains its own name and method to get it
- component - the interface for both the composite and the leaf.
- tree object which implements component interface so contains methods for adding and removing units and has a list of its childen


