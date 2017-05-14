package command

class SmsJob extends Job {
  var sms: Sms = null

  def setSms(sms: Sms): Unit = sms

  override def run(): Unit = sms.sendSms
}