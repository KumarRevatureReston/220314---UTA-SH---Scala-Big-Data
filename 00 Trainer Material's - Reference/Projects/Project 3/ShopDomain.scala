// ShopDomain.scala
package example

object Domain {
  case class SalesRecord(transactionTimestamp: String, shopId: Int, productId: Int, amount: Int, totalCost: Double)
}
