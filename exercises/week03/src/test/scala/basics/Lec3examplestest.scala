package basics

import org.scalatest.FunSuite
import basics.Lec3examples._

class Lec3examplestest extends FunSuite {

  test("[1] Countdown from 10") {
    assert(countDown(10) ==10 :: 9 :: 8 :: 7 :: 6 :: 5 :: 4 :: 3 :: 2 :: 1 :: Nil)
    assert(countDown(10) ==List[Int](10, 9, 8, 7, 6, 5, 4, 3, 2, 1))
  }

  test("[2] Low to high 9 to 33") {
    assert(fromTo(9, 33) == List(9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33))
  }
  test("[3] 3 x ones") {
    assert(countOnes(List(1, 5, 6, 7, 8, 1, 4, 3, 2, 1)) ==3)
  }

  test("[4] 3 x ones using pattern matching") {
    assert(countOnes(List(1, 5, 6, 7, 8, 1, 4, 3, 2, 1)) ==3)
  }

  test("[5] 3 x tens using pattern matching") {
    assert(countOnes(List(10, 5, 6, 7, 8, 10, 4, 3, 2, 10)) ==3)
  }

}
