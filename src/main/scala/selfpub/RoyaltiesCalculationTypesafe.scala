package selfpub

import calclog.Defaults.{given, *}
import calclog.Calculation
import java.time.LocalDate
import java.time.YearMonth

import CustomTypes.given
import CustomOperators.{*, given}

object RoyaltiesCalculationTypesafe:

  def royaltiesForMonth(sales: List[Euros], month: YearMonth): Calculation[Euros] =
    val minimumSelfPubSharePerBook = Euros(0.8) ~ "minimum SelfPub share per book"
    val royaltyRate = RoyaltyRate(75) ~ "royalty rate"
    val numberOfSales = sales.size ~ "number of sales"
    val totalRevenue = sales.total ~ "total revenue"
    val minimumSelfPubShare = minimumSelfPubSharePerBook * numberOfSales <~ "minimum SelfPub share"
    val revenueShare = totalRevenue * royaltyRate <~ "revenue share"
    val maximumRoyalties = totalRevenue - minimumSelfPubShare <~ "maximum royalties"
    min(revenueShare, maximumRoyalties) <~ s"royalties for $month"
