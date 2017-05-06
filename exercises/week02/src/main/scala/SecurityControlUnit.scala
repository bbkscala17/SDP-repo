import java.util.Calendar

class SecurityControlUnit extends ControlUnit {

  override def pollSensors(): Unit = {
    val now = Calendar.getInstance()
    val currentMinute = now.get(Calendar.HOUR)
    println(currentMinute);
  }

  //  private def timecheck(): Boolean ={
//}
}
