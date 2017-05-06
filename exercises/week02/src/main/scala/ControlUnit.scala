class ControlUnit {
  private val sensorManager: SensorManager = new SensorManager
  private val hazardSensors = sensorManager.getHazardSensors()
  protected val securitySensors = sensorManager.getSecuritySensors()
  private val notificationServiceFire = new NotificationServiceFire()
  private val notificationServiceBurglary = new NotificationServiceBurglary()

  def pollSensors(sensors: List[Sensor]): Unit = {
    for (sensor <- sensors) {
      if (sensor.isTriggered) {
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
        sensor.getSensorType match {
          case "Motion" => notificationServiceFire.issueNotification(sensor.getSensorType, sensor.getLocation)
          case "Fire" => notificationServiceFire.issueNotification(sensor.getSensorType, sensor.getLocation)
          case "Smoke" => notificationServiceFire.issueNotification(sensor.getSensorType, sensor.getLocation)
          case _ => throw new IllegalArgumentException("Unknown sensor type " + sensor.getSensorType)
        }

      }
      else {
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
      }
    }
  }

//  if no sensors supplied, use hazard sensors (if sensors are supplied, they will be non hazard sensors
  def pollSensors(): Unit ={
    pollSensors(hazardSensors)
  }
  object ControlUnit
}