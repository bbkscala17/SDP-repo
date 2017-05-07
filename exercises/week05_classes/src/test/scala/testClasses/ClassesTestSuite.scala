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

}
