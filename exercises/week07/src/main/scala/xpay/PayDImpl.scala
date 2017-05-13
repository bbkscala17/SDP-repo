package xpay

class PayDImpl {

  private var custCardNo: String = null
  private var cardOwnerName: String = null
  private var customerName: String = null
  private var cardExpMonthDate: String = null
  private var cardCVVNo: Int = 0
  private var totalAmount: Double = .0

  def getCustCardNo: String = getCustCardNo

  def setCustCardNo(custCardNo: String): Unit = {
    this.custCardNo = custCardNo
  }

  def getCardOwnerName: String = cardOwnerName

  def setCardOwnerName(cardOwnerName: String): Unit = {
    this.cardOwnerName = cardOwnerName
  }

  def getCardExpMonthDate: String = cardExpMonthDate

  def setCardExpMonthDate(cardExpMonthDate: String): Unit = {
    this.cardExpMonthDate = cardExpMonthDate
  }

  def getCVVNo: Integer = cardCVVNo

  def setCVVNo(cVVNo: Integer): Unit = {
    this.cardCVVNo = cVVNo
  }

  def getTotalAmount: Double = totalAmount

  def setTotalAmount(totalAmount: Double): Unit = {
    this.totalAmount = totalAmount
  }
}
