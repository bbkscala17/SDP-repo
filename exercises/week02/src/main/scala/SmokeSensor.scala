class SmokeSensor extends Sensor{

  def isTriggered: Boolean = false

  def getLocation: String = "1st floor"

  def getSensorType: String = "Smoke Sensor"

  def getBatteryPercentage: Int = 0
}
