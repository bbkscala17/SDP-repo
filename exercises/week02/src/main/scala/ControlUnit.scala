


  import scala.collection.mutable.ListBuffer

  class ControlUnit {
    def pollSensors() {
      val sensors = new ListBuffer[Sensor]()
      sensors += new FireSensor()
      sensors += new SmokeSensor()
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


object main extends App{
  println("Control unit started")
  args foreach println
  val contUnit = new ControlUnit
  for(x <- 1 to 1000){
    println(x)
    contUnit.pollSensors()
  }
}