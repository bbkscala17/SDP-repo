import scala.util.Random

class FireSensor extends Sensor {
  var battery: Int = 100;
  val drain: Int = 10

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

  def getBatteryPercentage: Int = {
    battery - drain
  }
}