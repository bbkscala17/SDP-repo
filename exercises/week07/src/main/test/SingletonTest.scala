package Factory
import org.scalatest.FunSuite
import singleton.SingletonLazyDoubleCheck

class SingletonTest extends FunSuite {


  test("Exercise 2 - Singleton Pattern") {
    assert(singleton.Singleton.getInstance() == singleton.Singleton.getInstance())
  }

  test("Exercise 2 - matching hashcodes") {
    assert(System.identityHashCode(singleton.Singleton.getInstance()) == System.identityHashCode(singleton.Singleton.getInstance()))
  }

  test("Exercise 2 - LazySingleton ") {
    assert(System.identityHashCode(singleton.LazySingleton.getInstance()) == System.identityHashCode(singleton.LazySingleton.getInstance()))
  }

  test("Exercise 2 - Singleton protected") {
    assert(System.identityHashCode(singleton.SingletonProtected.getInstance()) == System.identityHashCode(singleton.SingletonProtected.getInstance()))
  }

  var sdc: SingletonLazyDoubleCheck = SingletonLazyDoubleCheck.getInstance()
  var sdc2: SingletonLazyDoubleCheck = SingletonLazyDoubleCheck.getInstance()
  test("Exercise 2 - SingletonLazyDoubelCheck protected") {
    assert(System.identityHashCode(sdc) == System.identityHashCode(sdc2))
  }
}
