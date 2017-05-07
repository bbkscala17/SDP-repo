package testClasses
import testClasses.myClasses._
import org.scalatest.FunSuite

class ClassesTestSuite extends FunSuite {
  test("Initialise and return count") {
    assert(new Counter(10).inc.dec.inc.inc.count == 12)
  }
}
