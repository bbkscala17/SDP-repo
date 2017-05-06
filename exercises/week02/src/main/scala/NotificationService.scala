trait NotificationService {

  def issueNotification(sensorType: String, location: String): Boolean

}