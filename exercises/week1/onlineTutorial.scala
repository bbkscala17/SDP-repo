object onlineTutorial{

  def main(args: Array[String]) {
    var i=0

    while(i <=10) {
      println(i)
      i += 1
    }

    do {
      println(i)
      i += 2
    } while (i<=100)

    while(i<=150){
      println(i)
      i += 10
    }

    for (i <- 1000 to 1030)
      println(i)

    var aList = List(1,2,3,4,5)
    for(i <- aList){
      println(aList(i-1))
    }
    val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    for(i <- 0 until randLetters.length())
      println(randLetters(i))

    println("Even list")
    var evenList = for { i<- 1 to 20
      if(i % 2) ==0
    } yield i
//value of i after it cycles through the list is stored in evenList
    // so all even values get stored in i as a list

    for (x <- 0 to evenList.length-1)
      println(evenList(x))
    //or quicker
    println("Even list v2")
    for (y <- evenList)
      println(y)

  for ( i <- 1 to 5; j <- 6 to 10){
    println("=====i: " + i)
    println("j: " + j)
  }
// works like a nested loop of j within i

  def printPrimes(): Unit ={
    val primeList = List(1,2,3,5,7,11)
    for (i <- primeList){
      if(i==11){
        return
        // break and continue not in scala but can do this instead
      }
      if(i != 11) {
        println(i)
      }
      }
    }
    printPrimes()


//    var numberGuess = 0
//    do{
//      print("Guess a number ")
//      numberGuess = readLine.toInt
//      println("You entered " + numberGuess)
//    } while (numberGuess != 0)
//    println("Good guess the answer was 0")


    val name = "Bernard"
    val age = 33
    val weight = 88.345678

    println(s"Hello $name")
    println(f"I am ${age+1} and weigh $weight%.2f")
    //weight to 2 decimal places
    // in %.2f the f is a double
    // %c is a char %d is int %f is float %s is string

    printf("'%5d'\n", 5) // prints '    5' right justified 5 spaces
    printf("'%-5d'\n", 5) //'5    ' because -5 at start so left justify
    printf("'%05d'\n", 5) //'00005' with leading zeros
    printf("'%.5f'\n", 3.14159265) //'3.14159' because .5 is 5 decimal places and note changed to f for float

    // \b is backspace and \a is alert sound

    def funcName(param1:String, param2: Int) : String = {
      println("the second String in the above line is the return type")
      println("Supplied params were")
      println(param1)
      println(param2)
      "return value"
    }

    println(funcName("Hello", 99))




  }
}
