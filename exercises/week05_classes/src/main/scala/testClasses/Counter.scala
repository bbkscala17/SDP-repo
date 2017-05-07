package testClasses

class Counter(intialCounter: Int) {
  private var counter: Int = intialCounter

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
