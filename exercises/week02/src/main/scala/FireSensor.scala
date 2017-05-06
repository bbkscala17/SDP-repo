import scala.util.Random

class FireSensor extends Sensor {

  def isTriggered: Boolean = {
    if(Random.nextInt(100) <= 5) {
      //5% chance
      true
    } else {
      false
    }
  }

  def getLocation: String = "2nd floor"

  def getSensorType: String = "Fire Sensor"

  def getBatteryPercentage: Int = 0

}
