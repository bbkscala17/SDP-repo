#Week 8 - Design Patterns II

##Q1 - Strategy Pattern
This pattern defines a set of encapsulated algos that are interchangeable and so can be swapped.  They can vary independently of the clients that use them.

In scala you can achieve the same thing more simply by having methods that accept functions as params, and changing the function
 you pass in based on runtime decisions.

It is appropriate to use the stategy design pattern when you want many different versions of an algorithm, and you want to define the behaviour at runtime, while avoiding complex conditionals

We saw this in coursework two where we had a series of instruction objects with algorithms built into their execute() methods (iadd, iconst etc)



