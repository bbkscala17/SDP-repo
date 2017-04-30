trait Sensor {

  def isTriggered: Boolean

  def getLocation: String

  def getSensortype: String

  def getBatteryPercentage: Int
}
