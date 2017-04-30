package sml

import scala.collection.mutable.ArrayBuffer

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.nonEmpty) {
        val label = fields(0)
        labels.add(label)
        val opcode = fields(1)(0).toUpper + fields(1).substring(1, 3) // capitalise first letter: add -> Add
        val className = "sml." + opcode + "Instruction"
        try {
          var argsToUse: ArrayBuffer[Object] = new ArrayBuffer()
          val actualClass = Class.forName(className)
          try {
            val constructors = actualClass.getDeclaredConstructors()
            if (constructors.length == 1) {
              val paramTypes = constructors(0).getGenericParameterTypes
              val startIndexForArgs = 2
              for (index <- startIndexForArgs until paramTypes.length) {
                val thisParam = paramTypes(index).toString
                if (thisParam == "class java.lang.String") {
                  argsToUse += fields(index)
                } else if (thisParam == "int") {
                  try {
                    argsToUse += new Integer(fields(index).toInt) //must box int to Integer otherwise get error the result type of an implicit conversion must be more specific than AnyRef
                  } catch {
                    case IllegalArgumentException => throw new IllegalArgumentException(s"Instruction type [$className] requires int not string for this arg - illegal text: " + fields(index))
                    case _ => throw new Exception(s"Exception with classname [$className]")
                  }
                }
              }
              val params = Seq(label, opcode) ++ argsToUse
              val obj = constructors(0).newInstance(params: _*).asInstanceOf[Instruction]
              program = program :+ obj
              println("got new object: " + obj)
            } else {
              throw new IllegalArgumentException("Only objects with one constructor are supported")
            }
          }
          catch {
            case ex: ClassNotFoundException =>
              throw new ClassNotFoundException(s"No implementation for [$actualClass] found")
          }
        }
        catch {
          case ex: ClassNotFoundException =>
            throw new ClassNotFoundException(s"No class of instruction [$className]")
        }
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}