package testClasses

class Counter(counter: Int) {
//  private var counter: Int = initialCounter

  def inc(): Counter = {
    inc(1)
  }

  def inc(int: Int): Counter = {
    new Counter(counter + int)
  }

  def dec(): Counter = {
    dec(1)
  }

  def dec(int: Int): Counter = {
    new Counter(counter-int)
  }

  def count(): Int = counter

}
