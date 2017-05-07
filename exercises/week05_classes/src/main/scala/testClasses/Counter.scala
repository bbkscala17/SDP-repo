package testClasses

class Counter(counter: Int) {

  def inc(): Counter = {
    new Counter(counter+1)
  }

  def dec(): Counter = {
    new Counter(counter-1)
  }

  def count(): Int = counter

}
