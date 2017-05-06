import java.util.Calendar

class SecurityControlUnit extends ControlUnit {
  override def pollSensors(): Unit = {
    val now = Calendar.getInstance()
    val currentHour = now.get(Calendar.HOUR)
//    currentHour match{
//      case <6 =>
//    }
//    println(currentMinute);
//  }

  //  private def timecheck(): Boolean ={
}
}
