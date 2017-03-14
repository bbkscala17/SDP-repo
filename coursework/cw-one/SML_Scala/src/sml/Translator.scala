package sml

import java.io._

import java.nio.charset.Charset;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type

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
        val label = fields(0)
        labels.add(label)
        val opcode = fields(1)(0).toUpper  + fields(1).substring(1,3) // capitalise first letter: add -> Add
        val className = "sml." + opcode + "Instruction"
        println()

        try {
                val actualClass = Class.forName(className)
                println("actual class = "  + actualClass)
//                val inst: Instruction = actualClass.newInstance.asInstanceOf[Instruction]
//                println(inst.getClass)
                try {
                  val constructors = actualClass.getDeclaredConstructors()
                  if(constructors.nonEmpty) {
                    for (constructor <- constructors) {
                      println("Constructor")
                      println(constructor)
                      val params = constructor.getParameters()
                      println("Count" + params.length)
                      if(params.length==5){
                        val obj = constructor.newInstance("test", "test2",new Integer(1),new Integer(2), new Integer(3))
                        println("Got object " + obj.getClass)
                      }
                    }
                  } else {
                    println("Execute insn.  must provide for where more than one possible contructor")
                      println("param types")
                      val params = constructors(0).getParameters()
                      for(param <- params){
                        println("param")
                        println(param)
                      }
//                    (actualClass.toString).substring(0,2)
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