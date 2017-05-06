class SensorManager {
  private val HAZARD: String = "hazard"
  private val SECURITY: String = "security"
  private val hazardSensors: List[Sensor] = initialiseSensors(HAZARD)
  private val securitySensors: List[Sensor] = initialiseSensors(SECURITY)

  def initialiseSensors(sensorType: String): List[Sensor] = sensorType match {
    // scans for all sensors on setup and returns a list of them
    // list is hard coded for now - to be implemented properly later
    case HAZARD => List[Sensor](new FireSensor("2nd floor"), new SmokeSensor("1st Floor"))
    case SECURITY => List[Sensor](new MotionSensor("Lobby"))
  }

  def getAllSensors(): List[Sensor] = {
    hazardSensors ::: securitySensors
  }

  def getSecuritySensors(): List[Sensor] = {
    securitySensors
  }

  def getHazardSensors(): List[Sensor] = {
    hazardSensors
  }

}
