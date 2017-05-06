import scala.collection.mutable.ListBuffer

class SensorManager {
  private val sensors: ListBuffer[Sensor] = initialiseSensors


  // scan for all sensors and add to list buffer
  // to be implemented - hard coded for now
  def initialiseSensors(): ListBuffer[Sensor] = {
    var scannedSensors = new ListBuffer[Sensor]
    scannedSensors.append(new FireSensor)
    scannedSensors.append(new SmokeSensor("1st Floor"))
  }

}
