package Factory
import org.scalatest.FunSuite

class SingletonTest extends FunSuite{


  test("Exercise 2 - Singleton Pattern"){
    assert(singleton.Singleton.getInstance() == singleton.Singleton.getInstance())
  }

  test("Exercise 2 - matching hashcodes"){
    assert(System.identityHashCode(singleton.Singleton.getInstance()) == System.identityHashCode(singleton.Singleton.getInstance()))
  }

  test("Exercise 2 - LazySingleton "){
    assert(System.identityHashCode(singleton.LazySingleton.getInstance()) == System.identityHashCode(singleton.LazySingleton.getInstance()))
  }

  test("Exercise 2 - Singleton protected"){
    assert(System.identityHashCode(singleton.SingletonProtected.getInstance()) == System.identityHashCode(singleton.SingletonProtected.getInstance()))
  }
}
