import scala.util.Random

class SmokeSensor extends Sensor{

  def isTriggered: Boolean = {
    if(Random.nextInt(100) <= 10) {
      //10% chance
      true
    } else {
      false
    }
  }

  def getLocation: String = "1st floor"

  def getSensorType: String = "Smoke Sensor"

  def getBatteryPercentage: Int = 0
}
