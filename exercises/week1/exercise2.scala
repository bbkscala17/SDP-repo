import scala.util.Random

object Hammurabi {

	println("================\nStart of object")

	var starved = 0            // how many people starved
	var immigrants = 5         // how many people came to the city
	var population = 100
	var harvest = 3000          // total bushels harvested
	var bushelsPerAcre = 3      // amount harvested for each acre planted
	var rats_ate = 200          // bushels destroyed by rats
	var bushelsInStorage = 2800
	var acresOwned = 1000
	var pricePerAcre = 19       // each acre costs this many bushels
	var plagueDeaths = 0

	//the object assigned to a val cannot be replaced, and the object assigned to a var can

	val a:String = ("""
	Congratulations, you are the newest ruler of ancient Samaria, elected for a ten year term of office. Your duties are to dispense food, direct farming, and buy and sell land as needed to support your people. Watch out for rat infestations and the plague! Grain is the general currency, measured in bushels. The following will help you in your decisions:
	* Each person needs at least 20 bushels of grain per year to survive.
	* Each person can farm at most 10 acres of land.
	* It takes 2 bushels of grain to farm an acre of land.
	* The market price for land fluctuates yearly.
	Rule wisely and you will be showered with appreciation at the end of your term. Rule poorly and you will be kicked out of office!
	""")

	println("Printing string")
	println(a)

	println("Printing from fn")

	def printIntroductoryMessage(a: String) : String = {
		println("================\nPrinting from fn")
		println(a)
		a // returns a as well as printing it
	}

	def hammurabi () : String = {
		println("================\nhammurabi")
		var year:Int = 1
		var impeached = false
		while(year <=10 && population > 0 && impeached == false) {
			printAnnualMessage(year, starved, immigrants, population, harvest, bushelsPerAcre, rats_ate, bushelsInStorage, acresOwned, pricePerAcre, plagueDeaths, impeached)
			var landBought = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
			acresOwned += landBought
			bushelsInStorage -= landBought * pricePerAcre

			if(landBought <=0){
				var landSold = askHowMuchLandToSell(acresOwned)
				acresOwned -= landSold
				bushelsInStorage += landSold * pricePerAcre
			}

			var grainFed = askHowMuchGrainFeed(bushelsInStorage)
			bushelsInStorage -=grainFed

			var acresPlanted = askHowManyAcresPlant(acresOwned, bushelsInStorage, population)

			// done getting input now do calcs

			plagueDeaths = visitPlague(population)
			population -= plagueDeaths
			
			rats_ate = ratsEat(bushelsInStorage)
			bushelsInStorage -= rats_ate

			harvest = harvest(acresPlanted)
			bushelsInStorage += harvest

			pricePerAcre = Random.nextInt(6)+17

			if(population * 20 > grainFed) {// each person needs 20 bushels annually to survive
				starved = population - (grainFed / 20)
				if(starved > population * 0.45){
					impeached = true
				}
			}
			population += immigrants
			year += 1

		}

		//final message
		printAnnualMessage(year, starved, immigrants, population, harvest, bushelsPerAcre, rats_ate, bushelsInStorage, acresOwned, pricePerAcre, plagueDeaths, impeached)

		
		// println(readInt("enter int"))
		// testReadInt(10)
				"end"
	}


def harvest(acresPlanted : Int) = {
	acresPlanted * Random.nextInt(8) 
}

def ratsEat(bushelsInStorage : Int) : Int = {
	if(Random.nextInt(100) <= 40) { //40% chance
		var fractionEaten : Int = Random.nextInt(2)+1;
		println("Fraction eaten: " + fractionEaten)
		var eaten: Int =  (bushelsInStorage / 100 * fractionEaten).toInt
		if(eaten>bushelsInStorage){
			bushelsInStorage
		} else {
			eaten
		}
	}
	0 //40% chance did not occur so rats eat nothing
}

def visitPlague(population: Int) : Int = {
	if(Random.nextInt(100) <= 15){ //15% chance
		plagueDeaths = population / 2
		population / 2
	} else {
		population
	}
}

def printAnnualMessage(year : Int, starved : Int, immigrants : Int, population : Int, harvest : Int, bushelsPerAcre : Int, rats_ate : Int, bushelsInStorage : Int, acresOwned : Int, pricePerAcre : Int, plagueDeaths : Int, impeached : Boolean) = {
	println("\n\n================\n")
	println("O great Hammurabi!")
	if(year <=10 && population > 0 && impeached == false)
		println("You are in year " + year.toString + " of your ten year rule.")
	else
		println("Your swamp has been drained.")
		if(impeached)
			println("You were impeached because " + starved + " people starved to death")
	println("In the previous year " + starved + " people starved to death.")
	println("In the previous year " + immigrants + " people entered the kingdom.")
	println("The population is now " + population + ".")
	println("We harvested " + harvest + " bushels at " + bushelsPerAcre + " bushels per acre.")
	println("Rats destroyed " + rats_ate + " bushels, leaving " + bushelsInStorage + " bushels in storage.")
	println("The city owns " + acresOwned + " acres of land.")
	println("Land is currently worth " + pricePerAcre + " bushels per acre.")
	println("There were " + plagueDeaths + " deaths from the plague.")
}

def askHowMuchLandToBuy(bushels: Int, price: Int) = {
	var acresToBuy = readInt("How many acres will you buy? ")
	while (acresToBuy < 0 || acresToBuy * price > bushels) {
		println("O Great Hammurabi, we have but " + bushels + " bushels of grain! " + acresToBuy + " The price is " + price + " and " + acresToBuy + " acres would cost " + acresToBuy * price)
		acresToBuy = readInt("How many acres will you buy? ")
		}
		acresToBuy
	}

	def askHowMuchLandToSell(acresOwned: Int) : Int = {
		var response = readInt("How many acres of land to sell? ")
		while (response < 0 || response > acresOwned) {
			println("O Great Hammurabi, we have but " + acresOwned + " acres owned!")
			response = readInt("How many acres will you sell? ")
		}
		response
	}

	def askHowMuchGrainFeed(bushels: Int) = {
		var response: Int = readInt("How much grain to feed? ")
		while (response < 0 || response > bushels) {
			println("O Great Hammurabi, we have but " + bushels + " bushels in storage!")
			response = readInt("How much grain to feed? ")
		}
		response
	}

	def askHowManyAcresPlant(acresOwned: Int, bushelsInStorage: Int, population: Int) = {
		var response: Int = readInt("How many acres of land to plant? ")
		var maxAcres = bushelsInStorage / 2
		if(acresOwned < maxAcres){
			maxAcres = acresOwned
		}
		if(population * 10 > maxAcres){ //each person can farm 10 acres max
			maxAcres = population * 10
		}
		while (response < 0 || response > maxAcres) {
			println("O Great Hammurabi, we have but " + acresOwned + " acres owned, " + bushelsInStorage + " bushels in storage and a population of " + population + " so can only plant up to " + maxAcres + " acres!")
			response = readInt("How many acres will you plant? ")
		}
		response
	}
	
	def readInt(message: String): Int = {
		try {
			readLine(message).toInt
		} catch {
			case _ : Throwable =>
			println("That's not an integer. Please enter an integer.")
			readInt(message)
		}
	}
	def testReadInt(howMany : Int) = {
		var x : Int = 1
		while( x <= howMany ){
			val randomInt = Random.nextInt(1000000)
			println(x + " simulating reading Int " + randomInt)
			try {
				println(randomInt.toInt)
				println("success")
				x += 1
			} catch {
				case _ : Throwable =>
				println("That's not an integer. Please enter an integer.")
				x = howMany

			}
		}
	}
	

}

println("================\nHammurabi.hammurabi\n================")
Hammurabi.hammurabi
