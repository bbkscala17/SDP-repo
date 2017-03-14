package vendor

import scala.collection.mutable.ListBuffer


/**
  * A program parser parses a file or string containing a sequence
  * of bytecode programs in textual format. The program parser
  * is used by many vendor libraries to manipulate programs (we do
  * not need the rest of the vendor library for our purposes here.
  *
  * However, we do need to parse in bytecode programs so we can
  * execute them on our virtual machine.
  *
  * The structure of a bytecode program is simple. Each line
  * is a single textual representation of a stack-based instruction
  * that may optionally be followed by an integer argument:
  *
  * instruction1 [arg]
  * instruction2 [arg]
  * ...
  * instructionk [arg]
  *
  * The allowable instructions in a bytecode program are:
  *
  *  iconst INT, where INT is an integer literal (e.g., 4)
  *  iadd
  *  isub
  *  imul
  *  idiv
  *  irem
  *  ineg
  *  iinc
  *  idec
  *  idup
  *  iswap
  *  print
  *
  * As you can see, there is only one bytecode instruction
  * `iconst` that takes an argument.
  */
class ProgramParserImpl extends ProgramParser {
  // a type alias to make it clear!
//  override type InstructionList = _

  /**
    * Parses a file representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */
  def parse(file: String): InstructionList = {
    import scala.io.Source
    val lines = Source.fromFile(file).getLines
    var instructionList = new ListBuffer[Instruction]
    for (line <- lines) {
      val fields = line.split(" ")
      val args = fields.filter(field => fields.indexOf(field) > 0).map(x => x.toInt).toVector
      instructionList += new Instruction(fields(0), args)
    instructionList.toVector
  }

  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  def parseString(string: String): InstructionList = ???
//    val vector: Vector[Int] = Vector(1, 2, 3)
//    val inst: Instruction = new Instruction("iconst", vector)
//    Vector(inst, inst)

}
