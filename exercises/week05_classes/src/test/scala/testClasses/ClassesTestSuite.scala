package testClasses
import film.{Director, Film}
import testClasses.myClasses._
import org.scalatest.FunSuite

class ClassesTestSuite extends FunSuite {
  test("Initialise and return count") {
    assert(new Counter(10).inc.dec.inc.inc.count == 12)
  }
  test("user can use value for inc or dec") {
    assert(new Counter(10).inc(3).dec(1).inc.inc.count == 14)
  }

  test("Case class initialise and return count") {
    assert(CounterCase(10).inc.dec.inc.inc.count == 12)
  }
  test("Case class user can use value for inc or dec") {
    assert(CounterCase(10).inc(3).dec(1).inc.inc.count == 14)
  }

  test("Case class with default init counter value") {
    assert(CounterCase().inc(3).dec(1).inc.inc.count == 4)
  }

  test("Case class with default init counter value but not mentioning the word 'new' because we have apply automatically generated") {
    assert(new CounterCase(3) == CounterCase(3))
    assert(CounterCase().inc(3).dec(1).inc.inc.count == 4)
    assert(CounterCase(7).inc(3).dec(6).inc.inc.count == 6)
  }

  test("Initialise adder") {
    assert(new Adder(5).add(6) == 11)
  }

  test("Counter adjust"){
    assert(new Counter(new Adder(5).add(6)).count() == 11)
  }

  test("Person class apply method"){
    val name1 = Person("John Smith").getName()
    val name2 = new Person(Array("John", "Smith")).getName()
    for(x <- 0 to name1.length-1){
      assert(name1(x) == name2(x))
      //cannot compare object or arrays as they will not be 'equal'
      // could not get .equals to work either
    }
  }

//  test("PersonCase class apply method") {
//    PersonCase("John Smith").getName()
//    Error: Cannot resolve method PersonCase.apply
//  }


// F I L M   T E S T S

  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  val nolan = new Director("Christopher", "Nolan", 1970)
  val someGuy = new Director("Just", "Some Guy", 1990)

  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)

  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)

  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

  test("Eastwood year of birth") {
    assert(eastwood.yearOfBirth == 1930)
  }

  test("Diehard director") {
    assert(dieHard.director.name == "John McTiernan")
  }

  test("invictus director false") {
    assert(invictus.isDirectedBy(nolan) == false)
  }

  test("invictus director true") {
    assert(invictus.isDirectedBy(eastwood) == true)
  }

}
