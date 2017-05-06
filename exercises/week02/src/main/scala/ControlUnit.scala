class ControlUnit {
  private val sensorManager: SensorManager = new SensorManager

  def pollSensors() {
    val sensors = sensorManager.getSensors
    for (sensor <- sensors) {
      if (sensor.isTriggered) {
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
      }
      else {
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
      }
    }
  }
  object ControlUnit
}