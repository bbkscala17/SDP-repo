package strategy

// this class is a concrete strategy class and
// here the 'format' method is the 'execute' method of that concrete strategy

case class CapTextFormatter() extends TextFormatter {
  override def format(text: String): Unit = text.toUpperCase
}
