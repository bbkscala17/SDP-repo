package sml

class BnzInstruction(label: String, op: String, val s1: Int, val nextStmt: String)
  extends Instruction(label, op) {

  override def execute(m: Machine) {
    val contentss1 = s1

  }

  override def toString(): String = {
    super.toString + " " + s1 + " next to execute is " + nextStmt
  }
}

object BnzInstruction {
  def apply(label: String, s1: Int, nextStmt: String) =
    new BnzInstruction(label, "bnz", s1, nextStmt)
}
