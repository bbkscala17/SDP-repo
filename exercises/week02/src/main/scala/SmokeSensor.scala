import scala.util.Random

class SmokeSensor extends Sensor{
  var batteryLevel: Int = 0
  val drainFactor: Int = 20
  val triggerChance = 10

  def isTriggered: Boolean = {
    batteryLevel = drainBattery
    if(Random.nextInt(100) <= triggerChance) {
      true
    } else {
      false
    }
  }

  def getLocation: String = "1st floor"

  def getSensorType: String = "Smoke Sensor"

  def getBatteryPercentage: Int = {
    batteryLevel
  }
  def drainBattery: Int = {
    batteryLevel - drainFactor
  }
}
