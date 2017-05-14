package composite
import scala.collection.mutable.ListBuffer

case class HtmlParentElement(s: String) extends HtmlTag(s) {
  var startTag: String = null
  var endTag: String = null
  var children: ListBuffer[HtmlTag] = new ListBuffer[HtmlTag]

  override def setStartTag(tag: String): Unit = startTag = tag

  override def setEndTag(tag: String): Unit = endTag = tag

  override def generateHtml: Unit = {
    println(startTag)
    children.map(child => child.generateHtml)
    println(endTag)
  }
}
