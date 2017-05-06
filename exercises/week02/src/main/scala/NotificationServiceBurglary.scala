class NotificationServiceBurglary extends NotificationService {
    override def issueNotification(sensorType: String, location: String): Boolean = {
      // TODO start telephone service

      // TODO call Police
      println("Calling Police.  "  + sensorType + " sensor activated at " + location)

      // TODO call building owner
      println("Calling building owner. " + sensorType + " sensor activated at " + location)
      true
    }
}

