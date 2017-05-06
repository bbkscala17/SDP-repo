import scala.util.Random

class FireSensor (loc: String) extends BatteryPoweredSensor {
  private var batteryLevel: Int = 0
  private val batteryDrainFactor: Int = 5
  private val triggerChance = 5
  private var location: String = loc
  private val sensorType: String = "Fire Sensor"


  def isTriggered: Boolean = {
    batteryLevel = drainBattery
    if(Random.nextInt(100) <= triggerChance) {
      true
    } else {
      false
    }
  }

  def getLocation: String = location

  def getSensorType: String = sensorType

  def getBatteryPercentage: Int = {
    batteryLevel
  }

  def drainBattery: Int = {
    batteryLevel - batteryDrainFactor
  }
}