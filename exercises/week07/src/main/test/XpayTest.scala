package xpay
import org.scalatest.FunSuite

class XpayTest extends FunSuite {

  val xpayObj: Xpay = new XpayImpl()
  xpayObj.setCreditCardNo("123456")
  xpayObj.setCustomerName("John Smith")
  xpayObj.setCardExpMonth("12")
  xpayObj.setCardExpYear("2017")
  xpayObj.setCardCVVNo(123)
  xpayObj.setAmount(10.99)

  test("Exercise 3 - Adaptor") {

  }
}
