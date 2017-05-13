package strategy

//this is the context for the Strategy

case class TextEditor(formatter: TextFormatter) {
  def publishText(s: String) = formatter.format(s)

}
