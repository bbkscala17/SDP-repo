import java.util.Calendar

class SecurityControlUnit extends ControlUnit {
  override def pollSensors(): Unit = {
    val now = Calendar.getInstance()
    val currentHour = now.get(Calendar.HOUR_OF_DAY)
    if(currentHour < 6 || currentHour >= 22 ){
      println("night")
  } else {
      println("day")
    }

  //  private def timecheck(): Boolean ={
}
}
