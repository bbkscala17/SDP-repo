package interpreter

object ExpressionUtils {

  def isOperator(s: String): Boolean = s match{
    case "*" => true
    case "+" => true
    case "-" => true
    case "/" => true
    case _ => false

  }

  def getOperator(s: String, left: Expression, right: Expression): Expression = s match{
    case "+" => new Add(left, right)
    case "-" => new Sub(left, right)
    case "*" => new Product(left, right)
    case "/" => new Div(left, right)
  }
}