var lines = Array("this", "is", "a", "string", "string")
def countFunc(word: String, lines: Array[String]): Int = {
  lines.count(_ == word)
}
println(countFunc("this", lines))

var wordSet = lines.toSet
var wordMap = wordSet.map(word => (word, countFunc(word, lines)))
println(wordMap.toString)
