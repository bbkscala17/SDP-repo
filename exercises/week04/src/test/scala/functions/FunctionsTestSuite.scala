package functions

import functions.Funcs._
import org.scalatest.FunSuite

class FunctionsTestSuite extends FunSuite {
  // Basics
  test("Tail removes the first element") {
    assert(tail(List(1, 2, 3, 4)) == List(2, 3, 4))
  }

  test("setHead changes the first element of the list") {
    assert(setHead(List("A", "B", "C"), "0") == List("0", "B", "C"))
  }

  test("drop removes N elements from the front of the list") {
    assert(drop(List(1, 2, 3), 2) == List(3))
  }

  test("init removes the last element") {
    println(init(List("A", "B", "Z")))
    assert(init(List("A", "B", "C", "D")) == List("A", "B", "C"))
  }

  // Folding
  test("foldLeft computes the correct value") {
    assert(foldLeft(List("H", "e", "l", "l", "o"), "")(_ + _) == "Hello")
  }

  test("sum produces the correct sum") {
    assert(sum(List(1.0, 2.0, 3.0, -3.0, -2.0, -1.0)) == 0.0)
  }

  test("product produces the correct product 1*2") {
    assert(product(List(1.0, 2.0)) == 2.0)
  }

  test("product produces the correct product 0*8*9") {
    assert(product(List(0.0, 8.0, 9.0)) == 0.0)
  }

  test("product produces the correct product") {
    assert(product(List(1.0, 2.0, 3.0, 4.0, 5.0)) == 120.0)
  }

  test("length calculates the length") {
    assert(length("Hello".toList) == 5)
  }

  test("length calculates the length empty") {
    assert(length("".toList) == 0)
  }

  test("length calculates the length  longer") {
    assert(length("This is a longer string to test".toList) == 31)
  }

  test("reverse reverses the list") {
    assert(reverse("Hello".toList) == "olleH".toList)
  }

  test("flatten flattens the nested list") {
    println(flatten(List(List(1, 2, 3), List(4, 5, 6))))
    assert(flatten(List(List(1, 2, 3), List(4, 5, 6))) == List(1, 2, 3, 4, 5, 6))
  }
  test("flatten flattens the nested list 3 items inc one non list") {
    println(flatten(List(List(1, 2, 3), 5, List(7, 8, 9 ))))
    assert(flatten(List(List(1, 2, 3), 5, List(7, 8, 9 ))) == List(1, 2, 3, 5, 7, 8, 9))
  }

  // Map and Filter
  test("map creates a new list of the correct values") {
    assert(map((1 to 10).toList)(_ + 1) == (2 to 11).toList)
  }

  test("filter filters the list") {
    assert(myFilter((_ > 0), (-5 to 5).toList) == (1 to 5).toList)
  }


  val list:List[Int] = List(1,5,3,2,6,9,8,0,0,12)
  val list2:List[Int] = List(12)
  val list3:List[Int] = List()
  val list4:List[Int] = List(0,-1,3,2,10,11,9)

  test("More checks on myFilter method") {
    assert(myFilter(isEven, list4) == List(0,2,10))
      assert(myFilter(isEven, list3) == List())
      assert(myFilter(isEven, list2) == List(12))
      assert(myFilter(isEven, list) == List(2,6,8,0,0,12))
    //now as anon function
      assert(myFilter(x => x % 2 == 0, list) == List(2,6,8,0,0,12))
      assert(myFilter(x => x % 3 == 0, list4) == List(0,3,9))
  }

  test("flatMap maps and flattens") {
    assert(flatMap((1 to 5).toList)(x => (x to 5).toList) ==
      List(1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5))
  }

  // Combined

  test("maxAverage calculates the max average") {
    val list = List(1.0, 2.0, 3.0, 4.0, 5.0).map(x => (x, x + 10))
    assert(maxAverage(list) == 13.0)
  }

  test("variance calculates the correct variance") {
    val v = variance(List(1.0, 2.0, 3.0, 4.0, 5.0))
    assert(v == 2.0, "If you got 2.5, you divided by the wrong thing, probably.")
  }
}
