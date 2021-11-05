package selfpub

import calclog.Defaults.{given, *}
import calclog.Calculation
import java.time.LocalDate
import java.time.YearMonth

object RoyaltiesCalculation:
  
  import CustomOperators.*

  def royaltiesForMonth(sales: List[BigDecimal], month: YearMonth): Calculation[BigDecimal] =
    val minimumSelfPubSharePerBook = BigDecimal(0.8) ~ "minimum SelfPub share per book in EUR"
    val royaltyRate = BigDecimal(0.75) ~ "royalty rate"
    val numberOfSales = sales.size ~ "number of sales"
    val totalRevenue = sales.sum ~ "total revenue"
    val minimumSelfPubShareInEUR = minimumSelfPubSharePerBook * numberOfSales <~ "minimum SelfPubShare in EUR"
    val revenueShare = totalRevenue * royaltyRate <~ "revenue share in EUR"
    val maximumRoyaltiesInEUR = totalRevenue - minimumSelfPubShareInEUR <~ "maximum royalties in EUR"
    min(revenueShare, maximumRoyaltiesInEUR) <~ s"royalties in EUR for $month"