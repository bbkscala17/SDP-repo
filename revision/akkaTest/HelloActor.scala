// to run this navigate to the correct directory then from console do sbt run

//import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
//
//import scala.annotation.tailrec

//class HelloActor extends Actor{
//
//  def receive = {
//    case "Hello" => println("Hello back")
//    case  "hello" => println("hello back")
//    case _ => println("Eh?")
//  }
//}
//
//object HelloActor extends App{
//  println("Running")
//  val system = ActorSystem("Hellosystem")
//  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor") // collector
//  helloActor ! "hello"
//  helloActor ! "buenos dias"
//  system.shutdown()
//
//  val factorials = List(20,18,32,28,22,42,55,48)
//
//  val actorSystem = ActorSystem("factorial")
//
//  val collector = system.actorOf(Props(new FactorialCollector(factorials)), "collector")
//}

import scala.annotation.tailrec

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

object HelloActor extends App {
  val factorials = List(20, 18, 32, 28, 22, 42)
  //  val factorials = List(200000, 180000, 320000, 280000, 220000, 420000, 550000, 480000)
  val system = ActorSystem("factorial")
  val collector = system.actorOf(Props(new FactorialCollector(factorials)), "collector")

  val squares = List(1,2,3,4,5,6,7,8)
  val squaresCollector = system.actorOf(Props(new squaresCollector(squares)), "squaresCollector")

}

class FactorialCollector(factorials: List[Int]) extends Actor with ActorLogging {
  println("Create instance factorial collector")
  var list: List[BigInt] = Nil
  var size = factorials.size

  for (num <- factorials) {
    context.actorOf(Props(new FactorialCalculator("Actor Named " + num))) ! num
  }

  def receive = {
    case (num: Int, fac: BigInt) => {
      log.info(s"factorial for $num is $fac")

      list = num :: list
      size -= 1

      if (size == 0) {
        context.system.shutdown()
      }
    }
  }
}

class FactorialCalculator(name: String) extends Actor with ActorLogging {
  println("Create instance factorial calc")
  def receive = {
    case num: Int => {
      log.info(s"Fac calc actor '$name' received $num. Returning result to sender")
      sender ! (num, factor(num))
    }
  }

  private def factor(num: Int) = factorTail(num, 1)

  @tailrec private def factorTail(num: Int, acc: BigInt): BigInt = {
    (num, acc) match {
      case (0, a) => a
      case (n, a) => factorTail(n - 1, n * a)
    }
  }
}


class squaresCollector(inputs: List[Int]) extends Actor with ActorLogging{
  println("Create instance sq collector")
  for(inp <- inputs){
    context.actorOf(Props[SquaresCalculator]) ! inp
  }

  def receive = {
    case result: Int => log.info(s"Squares collector received a result $result")
    case string: String => log.info("Squares collector received: " + string)
    case _ => log.info("Squares collector received unexpeced thing")
  }
}

class SquaresCalculator extends Actor with ActorLogging{
  println("Create instance sq calc")
  def receive = {
    case num: Int =>{
      log.info(s"squares calc received number $num")
      sender ! (s"Square of $num is " + (num * num))
    }
    case _ => log.info(s"squares calc received unexpected item")
  }
}
