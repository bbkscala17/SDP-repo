###Why lazy initialise?
If the singleton is going to be costly to inialise and you might not need it, then lazy initialise to potentially save the cost / wasted resource if unused
See LazySingelton.scala based on code from https://dzone.com/articles/singleton-implementation-in-scala

The potential problem though it in a multi threaded environment if one thread calls getInstance() and, after that has happened but before the instance
actually exists, another thread calls it again

If a val is used then this should be avoided as vals are immutable and therefore should be created only once.
See http://docs.scala-lang.org/sips/pending/improved-lazy-val-initialization.html
"The current lazy val initialization scheme uses double-checked locking to initialize the lazy val only once"


If you mention objects in the constructor then they are initialised when the constructor is called (see EagerSingleton class)

  /**
    * from "Scala & Design Patterns" Lokke 2009 P43 "The presence of a singleton object allows to
    * implement a straightforward version of the pattern.  If the ability to extend the singleton is important,
    * an alternative solutio using companion object exists.  The example of the Singleton class
    * with a private constructor and companion object would be as in the Singleton class in this package
    */

  /**
    * Lazy initialisation
    * from https://pavelfatin.com/design-patterns-in-scala/#lazy-initialization
    * Lazy initialization is a special case of lazy evaluation strategy.
    * It’s a technique that initializes a value (or an object) on its first access.
    * Lazy initialization allows to defer (or avoid) some expensive computation.
    * A typical Java implementation uses null value to indicate uninitialized state.
    * However, if null is a valid final value, then a separate flag is needed to indicate
    * whether the initialization process has taken place.
    * In multi-threaded code, access to the flag must be synchronized to guard against a race condition.
    * Efficient synchronization may employ double-checked locking, which complicates code even further:
    *
    * In the example of SingletonLazyDoubleCheck, if you try to initialise it without using the
    * provided method of getInstance, you get an error that it "does not have a constructor"
    * However if you use the getInstance method then it works
    */


