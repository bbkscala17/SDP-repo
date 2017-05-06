import scala.util.Random

class FireSensor extends Sensor {
  var batteryLevel: Int = 0
  val drainFactor: Int = 5
  val triggerChance = 5

  def isTriggered: Boolean = {
    batteryLevel = drainBattery
    if(Random.nextInt(100) <= triggerChance) {
      true
    } else {
      false
    }
  }

  def getLocation: String = "2nd floor"

  def getSensorType: String = "Fire Sensor"

  def getBatteryPercentage: Int = {
    batteryLevel
  }

  def drainBattery: Int = {
    batteryLevel - drainFactor
  }
}