package selfpub

import calclog.Defaults.{given, *}
import calclog.Calculation

object RoyaltiesCalculationSimple:
  
  def royaltiesForMonth(sales: List[BigDecimal]): Calculation[BigDecimal] =
    val royaltyRate = BigDecimal(0.75) ~ "royalty rate"
    val totalRevenue = sales.sum ~ "total revenue"
    totalRevenue * royaltyRate <~ "revenue share in EUR"
