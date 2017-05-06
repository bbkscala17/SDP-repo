class ControlUnit (sensorMan: SensorManager){
  private val sensorManager: SensorManager = sensorMan

  def pollSensors() {
    val sensors = sensorManager.getSensors
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