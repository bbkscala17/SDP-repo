//package scala
import Factory.{AppleProduct, ConcreteCreator, OnionProduct}
import singleton._

object Test extends App {

  /**
    * Exercise 1 Factory Pattern
    * The key thing with the factory pattern is that the object's type is decided dynamically at run time
    */

  println("Exercise 1 - Factory Pattern")

  val onionProd = new ConcreteCreator().factory("onion")
  println("trying to create onion.  product is created of class " + onionProd.getClass)

  val fruitProd = new ConcreteCreator().factory("apple")
  println("trying to create apple.  product is created of class " + fruitProd.getClass)

  //  while (true) {
  //    var typ = readLine("enter item to create as apple or onion or end to end")
  //      val prod = new ConcreteCreator().factory(typ)
  //      println("Resulting object class: " + prod.getClass)
  //      prod match {
  //        case prod: AppleProduct => prod.fallFromTree(); prod.ripen()
  //        case prod: OnionProduct => prod.chop(); prod.cook()
  //        case _ => println("unrecognised type so using default object and not calling any methods")
  //      }
  //    }

  /**
    * Exercise 2 Singleton Pattern
    */

  println("Exercise 2 - Singleton Pattern")

  object MySingleton {
    def areYouThere() = {
      "Yes I am here.  My system hashcode is " + System.identityHashCode(this) + " and to string is " + this.toString()
    }
  }

  println("Are you there? " + MySingleton.areYouThere())
  println("Are you the same object? " + MySingleton.areYouThere())
  println("Are you still the same object? " + MySingleton.areYouThere())


  /**
    * from "Scala & Design Patterns" Lokke 2009 P43 "The presence of a singleton object allows to
    * implement a straightforward version of the pattern.  If the ability to extend the singleton is important,
    * an alternative solutio using companion object exists.  The example of the Singleton class
    * with a private constructor and companion object would be as in the Singleton class in this package
    */

  val s = Singleton.getInstance()
  println("Are you there? " + System.identityHashCode(s))
  println("Are you the same object? " + System.identityHashCode(s))
  println("Are you still the same object? " + System.identityHashCode(s))

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
  //    try{
  //      var sdc: SingletonLazyDoubleCheck = new SingletonLazyDoubleCheck()
  //      println(sdc.getClass)
  //    } catch {
  //      case e: Exception => println("exception caught: " + e);
  //    }

  var sdc: SingletonLazyDoubleCheck = SingletonLazyDoubleCheck.getInstance()
  var sdc2: SingletonLazyDoubleCheck = SingletonLazyDoubleCheck.getInstance()
  println("Got SingletonLazyDoubleCheck" + sdc.getClass)
  println("Got SingletonLazyDoubleCheck" + sdc2.getClass)
  sdc match {
    case sdc2 => println("sdc and sdc2 are the same - sdc " + System.identityHashCode(sdc) + " sdc2 " + System.identityHashCode(sdc2))
    case _ => println("sdc and sdc2 do not match")
  }


  // TODO explore breaking the Singleton pattern with multi thread


  /**
    * Exercise 3 Adaptor Pattern
    */

  println("Exercise 3 - Adaptor Pattern")








}
