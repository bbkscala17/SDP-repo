class SensorManager {
  private val allSensors: List[Sensor] = initialiseSensors

  def initialiseSensors(): List[Sensor] = {
    // scans for all sensors on setup and returns a list of them
    // list is hard coded for now - to be implemented properly later
    List(new FireSensor("2nd floor"), new SmokeSensor("1st Floor"))
  }

  def getSensors(): List[Sensor] = {
    allSensors
  }

}
