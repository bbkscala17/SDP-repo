import scala.util.Random

class SmokeSensor extends Sensor{
  var battery: Int = 100;
  val drain: Int = 20

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

  def getBatteryPercentage: Int = {
    battery - drain
  }
}
