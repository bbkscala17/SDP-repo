package xpay

class XpayToPayDAdpaterImpl extends XpayToPayDAdapter{

  val payD:PayD = new PayDImpl()

  def getCreditCardNo: String = payD.getCustCardNo

  def setCreditCardNo(creditCardNo: String): Unit = payD.setCustCardNo(creditCardNo)

  def getCustomerName: String = payD.getCardOwnerName

  def setCustomerName(customerName: String): Unit = payD.setCardOwnerName(customerName)

  def getCardExpMonth: String = (payD.getCardExpMonthDate).substring(0,2) //substring(int beginIndex, int endIndex) 0 is first char and 2 is end index

  def setCardExpMonth(cardExpMonth: String): Unit = {
      if(payD.getCardExpMonthDate == null){
        payD.setCardExpMonthDate(cardExpMonth.concat("XX"))
        println("h")
        println(payD.getCardExpMonthDate)
    } else {
        payD.setCardExpMonthDate(cardExpMonth + this.getCardExpYear)
        println("h1")
        println(payD.getCardExpMonthDate)
      }
  }

  def getCardExpYear: String = payD.getCardExpMonthDate.substring(2,4)
  //assumes payD date is stored as MMYY so substring 2,4 is the year part

  def setCardExpYear(cardExpYear: String): Unit = {
    if (payD.getCardExpMonthDate == null) {
      payD.setCardExpMonthDate("XX".concat(cardExpYear))
      println("h2")
      println(payD.getCardExpMonthDate)
    } else {
      payD.setCardExpMonthDate(this.getCardExpMonth + cardExpYear)
      println("h3")
      println(payD.getCardExpMonthDate)
    }
  }



  def getCardCVVNo: Short = payD.getCVVNo.toShort

  def setCardCVVNo(cardCVVNo: Short): Unit = payD.setCVVNo(cardCVVNo.toInt)

  def getAmount: Double = payD.getTotalAmount

  def setAmount(amount: Double): Unit = payD.setTotalAmount(amount)
}