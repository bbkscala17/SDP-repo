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
}