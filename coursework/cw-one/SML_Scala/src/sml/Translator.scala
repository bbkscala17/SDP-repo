package sml

import java.io._

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val DIV = "div"
  private final val LIN = "lin"
  private final val BNZ = "bnz"
  private final val MUL = "mul"
  private final val SUB = "sub"
  private final val OUT = "out"

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
//    println(AddInstruction.getInterfaces().getClass())
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.length > 0) {
        labels.add(fields(0))
        println("classname " + fields(1))
        val className = fields(1)(0).toUpper  + fields(1).substring(1,3) + "Instruction"
//        + fields(1)(1) + fields(1)(2)

        println("classname " + className)
        try {
                val actualClass = Class.forName(className)
                try {
                  val instance = actualClass.newInstance("label", 1, "test")
                  println("instance is "  + instance)
                  val args = "args"
  //                program = program :+ instance(args)

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


        fields(1) match {
          case ADD =>
            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case SUB =>
            program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case MUL =>
            program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case DIV =>
            program = program :+ DivInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case OUT =>
            program = program :+ OutInstruction(fields(0), fields(2).toInt)
          case LIN =>
            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
          case BNZ =>
            program = program :+ BnzInstruction(fields(0), fields(2).toInt, fields(3))
          case x =>
            println(s"Unknown instruction $x")
        }
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

//import scala.io.StdIn._
//
//trait Instruction {
//  def action(name: String*) : String
//}
//
//trait Add extends Instruction
//trait Sub extends Instruction
//
//class AddImpl extends Instruction {
//  def action(name: String*): String = s"Executing an instruction $name"
//}
//
//object FooMain extends App {
//  print("Enter a class name: ")
//  val name = readLine
//  try {
//    Class.forName(name)
//    val className = name + "Impl"
//    try {
//      val actualClass = Class.forName(className)
//      val foo = actualClass.newInstance.asInstanceOf[Instruction]
//      println("foo is "  + foo)
//      println(foo.action("Crash the machine"))
//    }
//    catch {
//      case ex: ClassNotFoundException =>
//        println(s"No implementation for [$name] found")
//    }
//  }
//  catch {
//    case ex: ClassNotFoundException =>
//      println(s"No class of instruction [$name]")
//  }
//}
