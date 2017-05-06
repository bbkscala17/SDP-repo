class NotificationServiceFire extends NotificationService {
  override def issueNotification(sensorType: String, location: String): Boolean = {
    // TODO start telephone service

    // TODO call telephone of Fire service
    println("Calling fire service. " + sensorType + " sensor activation at location " + location)

    // TODO call building owner
    println("Calling building owner."  + sensorType + " sensor activation at location " + location)
  true
  }
}