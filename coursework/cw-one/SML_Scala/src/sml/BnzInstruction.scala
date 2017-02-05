package sml

class BnzInstruction(label: String, op: String, val s1: Int, nextLabel : String)
  extends Instruction(label, op) {

  override def execute(m: Machine) {
    println("Starting BNZ - programme counter is " + m.pc.toString)
    val contentas1 = s1
    val labelsArray = m.labels.toString().split(" : ")
    m.pc = labelsArray.indexOf(nextLabel); // do not add 1 because, although PC starts at 1 and labelsArray starts at 0, counter incremented at end of this bnz instruction anyway
    println("Ending BNZ - programme counter is now " + m.pc.toString)
  }

  override def toString(): String = {
    super.toString + " " + s1 + " next to execute is " + nextLabel
  }
}

object BnzInstruction {
  def apply(label: String, s1: Int, nextStmt: String) =
    new BnzInstruction(label, "bnz", s1, nextStmt)
}