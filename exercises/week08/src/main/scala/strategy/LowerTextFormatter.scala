package strategy

// this class is a concrete strategy class and
// here the 'format' method is the 'execute' method of that concrete strategy
// as this returns nothing it must have to print the text to screen too
case class LowerTextFormatter() extends TextFormatter {
  override def format(text: String): Unit = {
    println("[" + this.getClass + "] " + text.toLowerCase())
  }
}
