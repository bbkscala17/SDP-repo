package testClasses
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
  test("Person class"){
    val name1 = Person("John Smith").getName()
    val name2 = new Person(Array("John", "Smith")).getName()
    for(x <- 0 to name1.length-1){
      assert(name1(x) == name2(x))
      //cannot compare object or arrays as they will not be 'equal'
      // could not get .equals to work either
    }
  }


}
