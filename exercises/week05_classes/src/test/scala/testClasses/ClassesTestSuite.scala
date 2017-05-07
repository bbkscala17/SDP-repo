package testClasses
import testClasses.myClasses._
import org.scalatest.FunSuite

class ClassesTestSuite extends FunSuite {
  test("Test method") {
    assert(testMeth() == 10.5)
  }
}
