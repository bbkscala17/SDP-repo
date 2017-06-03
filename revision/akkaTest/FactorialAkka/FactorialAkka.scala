import scala.annotation.tailrec

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

object FactorialAkka extends App{
  val factorials = List(20,18,32,28,22,42,55,48)

  val actorSystem = ActorSystem("factorial")

  val collector = system.actorOf(Props(new FactorialCollector(factorials)), "collector")
}

class FactorialCollector(factorials: List[Int]) extends Actor with ActorLogging {
  var list: List[BigInt] = Nil
  var size = factorials.size

  for (num <- factorials.size){
    context.actorOf(Props(new FactorialCalculator("ActorNum" + num)) ! num
  }

  def receive = {
    case (num: Int, fac: BigInt) => {
      log.info(s"factorial for $num is $fac")

      list = num :: list
      size -= 1

      if(size == 0){
        context.system.shutdown()
      }
    }
  }
}

class FactorialCalculator(name: String) extends Actor {
  def receive = {
    log.info(s"Fac calc actor received num. Returning result to sender")
    case num : Int => {
//      sender ! (num(factor(num)))
    }
  }

  private def factor(num: Int) = factorTail(num,1)

  @tailrec private def factorTail(num: Int, acc: BigInt): BigInt = {
    (num, acc) match {
      case (0,a) => a
      case (n,a) => factorTail(n-1, n*a)
    }
  }
}