package testClasses

case class CounterCase(counter: Int = 0) {
//  println("init case counter is " + counter)
  def inc(): CounterCase = {
    inc(1)
  }

  def inc(int: Int): CounterCase = {
    copy(counter=counter+int)
  }

  def dec(): CounterCase = {
    dec(1)
  }

  def dec(int: Int): CounterCase = {
    copy(counter= counter-int)
  }

  def count(): Int = counter

}
