###Why lazy initialise?
If the singleton is going to be costly to inialise and you might not need it, then lazy initialise to potentially save the cost / wasted resource if unused
See LazySingelton.scala based on code from https://dzone.com/articles/singleton-implementation-in-scala

The potential problem though it in a multi threaded environment if one thread calls getInstance() and, after that has happened but before the instance
actually exists, another thread calls it again

If a val is used then this should be avoided as vals are immutable and therefore should be created only once.
See http://docs.scala-lang.org/sips/pending/improved-lazy-val-initialization.html
"The current lazy val initialization scheme uses double-checked locking to initialize the lazy val only once"


If you mention objects in the constructor then they are initialised when the constructor is called (see EagerSingleton class)