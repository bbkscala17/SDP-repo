package sml

import java.io._

import java.nio.charset.Charset;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

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
        val className = "sml." + fields(1)(0).toUpper  + fields(1).substring(1,3) + "Instruction"
//        val ai = new AddInstruction("S", "S", 1, 1, 1);
//        println(ai.getClass())
        println("classname " + className)
        println(Class.forName(className))
        try {
                val actualClass = Class.forName(className)
                println("actual class = "  + actualClass)

                try {
                  val constructors = actualClass.getDeclaredConstructors();
                  if(constructors.length >1) {
                    for (constructor <- constructors) {
                      println(constructor)
                    }
                  } else {
                    println("Execute insn.  must provide for where more thn one possible contructor")
                      println("param types")
                      val params = constructors(0).getGenericParameterTypes()
                      for(param <- params){
                        println(param)
                      }
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