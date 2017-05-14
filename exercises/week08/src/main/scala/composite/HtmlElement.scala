package composite


case class HtmlElement(s: String) extends HtmlTag(s) {
  var startTag: String = null
  var endTag: String = null
  var body: String = null

  override def setStartTag(tag: String): Unit = startTag = tag

  override def setEndTag(tag: String): Unit = endTag = tag

  override def setTagBody(tagBody: String): Unit = body = tagBody

  override def generateHtml: Unit = println(startTag + body + endTag)

  override def addChildTag(htmlTag: HtmlTag):Unit = throw new IllegalArgumentException ("cannot add child to leaf")
  //FIXME do this without throwing exceptions e.g. convert child to parent?

  override def removeChildTag(htmlTag: HtmlTag): Unit = throw new IllegalArgumentException ("cannot remove child from leaf")

  override def getChildren: List[HtmlTag] = Nil
}