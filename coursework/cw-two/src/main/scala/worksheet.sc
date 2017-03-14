//val array = Array("1", "2", "3")
//
//val shortarray = array.drop(0)
//
//println(shortarray)
//
//shortarray.map(_.drop(1))
//println(shortarray.toString)
//
//val i = 3
//
//i.getClass

val str = "iconst 4\niconst 5\niadd\nprint"
val arr = str.replace("\n", " ").split(" ")
for(str <- arr)
  println(str)
