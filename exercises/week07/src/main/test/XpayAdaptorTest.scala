package xpay
import org.scalatest.FunSuite

class XpayAdaptorTest extends FunSuite {

  val xpayObj: Xpay = new XpayToPayDAdpaterImpl()
  xpayObj.setCreditCardNo("123456")
  xpayObj.setCustomerName("John Smith")
  xpayObj.setCardExpMonth("12")
  xpayObj.setCardExpYear("17")
  xpayObj.setCardCVVNo(123)
  xpayObj.setAmount(10.99)

  val payD = new PayDImpl
  payD.setCustCardNo("123456")
  payD.setCardOwnerName("John Smith")
  payD.setCardExpMonthDate("1217")
  payD.setCVVNo(123)
  payD.setTotalAmount(10.99)

  test("Exercise 3 - Adaptor") {
    assert(xpayObj.getAmount == payD.getTotalAmount)
    assert(xpayObj.getCustomerName == payD.getCardOwnerName)
    assert(xpayObj.getCardCVVNo == payD.getCVVNo)
  }
  test("Exercise 3 - Adaptor cust card no") {
    assert(xpayObj.getCreditCardNo == payD.getCustCardNo)
  }
  test("Exercise 3 - Adaptor date") {
    assert(xpayObj.getCardExpMonth + xpayObj.getCardExpYear == payD.getCardExpMonthDate)
  }
}
