package strategy

// this trait is the Strategy interface and the concrete strategies LowerTextF and CapTextF inherit from it
trait TextFormatter {
  def format(text: String)
}