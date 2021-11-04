package selfpub

object RoyaltiesPlain:
  def royaltiesForMonth(sales: List[BigDecimal]): BigDecimal =
    val royaltyRate = BigDecimal(0.75)
    val totalRevenue = sales.sum
    totalRevenue * royaltyRate
