package strategy

object TestStrategyPattern extends App {
  var formatter: TextFormatter = CapTextFormatter() //concrete strategy for this publish
  var editor: TextEditor = TextEditor(formatter) //context for the strategy - passed the concrete strategy
  editor.publishText("Testing text in caps formatter") // this is the execute command for the strategyy

  formatter = LowerTextFormatter()
  editor = TextEditor(formatter)
  editor.publishText("Testing text in lower formatter")
}
