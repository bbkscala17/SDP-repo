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



