import scala.util.Random

class MotionSensor (loc: String) extends Sensor{
  private val triggerChance = 5

  def isTriggered: Boolean = {
    if(Random.nextInt(100) <= triggerChance) {
      true
    } else {
      false
    }
  }

  override def getLocation: String = loc

  override def getSensorType: String = "Motion"

  override def getCategory: String = "security"
}
