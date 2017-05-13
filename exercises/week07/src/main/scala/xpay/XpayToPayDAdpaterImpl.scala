package xpay

trait XpayToPayDAdpaterImpl extends XpayToPayDAdapter{

  val payD:PayD = new PayDImpl()

  def getCreditCardNo: String = payD.getCustCardNo

  def setCreditCardNo(creditCardNo: String): Unit = payD.setCustCardNo(creditCardNo)

  def getCustomerName: String = payD.getCardOwnerName()

  def setCustomerName(customerName: String): Unit = payD.setCardOwnerName(customerName)

  def getCardExpMonth: String = (payD.getCardExpMonthDate).substring(0,1)

  def setCardExpMonth(cardExpMonth: String): Unit = payD.setCardExpMonthDate(cardExpMonth + this.getCardExpYear)

  def getCardExpYear: String = payD.getCardExpMonthDate.substring(2,3)
  //assumes payD date is stored as MMYY so substring 2,3 is the year part

  def setCardExpYear(cardExpYear: String): Unit = payD.setCardExpMonthDate(this.getCardExpMonth + cardExpYear)

  def getCardCVVNo: Short = payD.getCVVNo.toShort

  def setCardCVVNo(cardCVVNo: Short): Unit = payD.setCVVNo(cardCVVNo.toInt)

  def getAmount: Double = payD.getTotalAmount

  def setAmount(amount: Double): Unit = payD.setTotalAmount(amount)
}