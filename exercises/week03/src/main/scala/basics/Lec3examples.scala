package basics

object Lec3examples {

  def countDown(n: Int): List[Int] = {
    if (n==0) {
      Nil
    } else {
      n :: countDown(n-1)
    }
  }

  def fromTo(lo : Int, hi: Int): List[Int] =  {
    if (lo == hi) {
      lo :: Nil
    } else {
      lo :: fromTo(lo + 1, hi)
    }
  }

    // counting ones using an if expression
  def countOnes(aList: List[Int]) : Int ={
    aList match {
      case Nil => 0
      case n :: tail =>
        if(n == 1){
          1 + countOnes(tail)
        } else {
          countOnes(tail)
        }
    }
  }

  // counting ones using an if expression
  def countOnesPatternMatch(aList: List[Int]) : Int = {
    aList match {
      case Nil => 0
      case 1 :: tail => 1 + countOnesPatternMatch(tail)
      case _ :: tail => countOnesPatternMatch(tail)
    }
  }
}