package xpay

trait XpayToPayDAdpaterImpl extends XpayToPayDAdapter{

  val payd:PayD = new PayDImpl()

  }

  def getCreditCardNo: String

  def setCreditCardNo(creditCardNo: String)

  def getCustomerName: String

  def setCustomerName(customerName: String)

  def getCardExpMonth: String

  def setCardExpMonth(cardExpMonth: String)

  def getCardExpYear: String

  def setCardExpYear(cardExpYear: String)

  def getCardCVVNo: Short

  def setCardCVVNo(cardCVVNo: Short)

  def getAmount: Double

  def setAmount(amount: Double)
}

def getCustCardNo: String

def setCustCardNo(custCardNo: String)

def getCardOwnerName: String

def setCardOwnerName(cardOwnerName: String)

def getCardExpMonthDate: String

def setCardExpMonthDate(cardExpMonthDate: String)

def getCVVNo: Integer

def setCVVNo(cVVNo: Integer)

def getTotalAmount: Double

def setTotalAmount(totalAmount: Double)
