package sml

import scala.collection.mutable.ArrayBuffer

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
//  private final val ADD = "add"
//  private final val DIV = "div"
//  private final val LIN = "lin"
//  private final val BNZ = "bnz"
//  private final val MUL = "mul"
//  private final val SUB = "sub"
//  private final val OUT = "out"

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
        val opcode = fields(1)(0).toUpper + fields(1).substring(1,3) // capitalise first letter: add -> Add
        val className = "sml." + opcode + "Instruction"
//        val args = fields.filter(x => fields.indexOf(x)>1) // remove first two strings to leave only args at end
        try {
                var argsToUse: ArrayBuffer[Object] = new ArrayBuffer()
                val actualClass = Class.forName(className)
                try {
                  val constructors = actualClass.getDeclaredConstructors()
                  if(constructors.length ==1) {
                    val constructor = constructors(0)
//                      println("Constructor")
//                      println(constructor)
                      val paramTypes = constructor.getGenericParameterTypes
                      val startIndexForArgs = 2
                      for(index <- startIndexForArgs until paramTypes.length) {
                        val thisParam = paramTypes(index)
//                        println("param" + thisParam)
                        if (thisParam.toString == "class java.lang.String") {
//                          println("is string")
                          argsToUse += fields(index)
                        } else if (thisParam.toString == "int") {
                          argsToUse += new Integer(fields(index).toInt)    //must box int to Integer otherwise get error the result type of an implicit conversion must be more specific than AnyRef
                        }
                      }

                      val params = Seq(label, opcode) ++ argsToUse
//                      println("params")
//                      for(param <- params){
//                        println(param)
//                        println(param.getClass)
//                      }
//                      println("end params")
                      val obj = constructor.newInstance(params: _*).asInstanceOf[Instruction]
                      println("got new object: " + obj)
                      program = program :+ obj

                  } else {
                    println("Only objects with one constructor are supported")
                    }
                }
                catch {
                  case ex: ClassNotFoundException =>
                    println(s"No implementation for [$actualClass] found")
                }
              }
        catch {
          case ex: ClassNotFoundException =>
            println(s"No class of instruction [$className]")
        }

//        fields(1) match {
//          case ADD =>
//            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//          case SUB =>
//            program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//          case MUL =>
//            program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//          case DIV =>
//            program = program :+ DivInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//          case OUT =>
//            program = program :+ OutInstruction(fields(0), fields(2).toInt)
//          case LIN =>
//            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
//          case BNZ =>
//            program = program :+ BnzInstruction(fields(0), fields(2).toInt, fields(3))
//          case x =>
//            println(s"Unknown instruction $x")
//        }
      }
    }

//    :+ makes a new list with the old list as the first item and the element as the next item
//    So scala> List(b) :+ 5 produces
//    res14: List[Any] = List((1,2,3), 5)

    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}