class ControlUnit {
  private val sensorManager: SensorManager = new SensorManager
  private val hazardSensors = sensorManager.getHazardSensors()
  private val securitySensors = sensorManager.getSecuritySensors()

  def pollSensors(sensors: List[Sensor]): Unit = {
    for (sensor <- sensors) {
      if (sensor.isTriggered) {
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
      }
      else {
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
      }
    }
  }

  //if no sensors supplied, use hazard sensors
  def pollSensors(): Unit ={
    pollSensors(hazardSensors)
  }
  object ControlUnit
}