import java.util.Calendar

class SecurityControlUnit extends ControlUnit {

  override def pollSensors(): Unit = {
      if(timecheck()){
        super.pollSensors(securitySensors)
      }
  }

    private def timecheck(): Boolean ={
      val now = Calendar.getInstance()
      val currentHour = now.get(Calendar.HOUR_OF_DAY)
      currentHour match {
        case x if x < 6 => true
        case y if y >= 22 => true
        case _ => false
      }
  }
}
