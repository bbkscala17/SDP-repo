import scala.util.Random

class SmokeSensor (loc: String) extends Sensor {
  private var batteryLevel: Int = 0
  private val drainFactor: Int = 20
  private val triggerChance = 10
  private var location: String = loc
  private var sensorType: String = "Smoke Sensor"

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
