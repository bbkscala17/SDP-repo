import singleton.Singleton

import scala.math.Ordering

implicit val ordering = Ordering.fromLessThan[Int](_ < _ )
List(1,5,6,9,4,2,1,3,1).sorted
// in this case when we call 'sorted' the compiler finds the implcit
// type and because there is only one ordering it can use, it knows it
// must use this one.  However if two existed in same scope there would be an error.


//implicit val maxordering = Ordering.fromLessThan[Int](_ > _ ) // sign is flipped
//List(1,5,6,9,4,2,1,3,1).sorted // throws error

val minordering = Ordering.fromLessThan[Int](_ < _ );
List(1,5,6,9,4,2,1,3,1).sorted(minordering)

//can also use Ordering.by and Ordering.on
final case class Rational(numerator: Int, denominator: Int)
  implicit val ratordering = Ordering.fromLessThan[Rational] {
    (x,y) =>
      (x.numerator.toDouble / x.denominator.toDouble) <
      (y.numerator.toDouble / y.denominator.toDouble)
  }

  val ls = List(Rational(1,2), Rational(3,4), Rational(1,3))

  println(ls.sorted)



// 7 March 2016
//Singleton pattern

object Singleton

//class Singleton
class Singleton private () // constructor now private

object test extends App{

//  println(new Singleton)
  println(Singleton)
//  println(new Singleton)
  println(Singleton)

}

//when have case class, are getting the to string method
//but still when you do new Singleton, you have a problem
// key point with a Singleton pattern is a private constructor
// so you cannot call "new Singleton()"
// so comment out the two "new Singleton" lines above and add "pruvate () after class Singleton
// and scala does the rest, because Object Singleton gives you a unique instance

// in exam need the design patterns embedded in mind and can recite them
