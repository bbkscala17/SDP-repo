import scala.collection.mutable.ListBuffer

class ControlUnit (sensorList: ListBuffer[Sensor]){
  private val sensors: ListBuffer[Sensor] = sensorList

  def pollSensors() {
    for (sensor <- sensors) {
      if (sensor.isTriggered) {
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
        System.out.println("Battery " + sensor.getBatteryPercentage)
      }
      else {
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
        System.out.println("Battery " + sensor.getBatteryPercentage)
      }
    }
  }
  object ControlUnit
}