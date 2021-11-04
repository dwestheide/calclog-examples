package selfpub

object RoyaltiesTreeLog:

  import java.time.YearMonth
  import cats.implicits._
  import treelog.LogTreeSyntaxWithoutAnnotations._

  def royaltiesForMonth(
      sales: List[BigDecimal],
      month: YearMonth
  ): DescribedComputation[BigDecimal] =
    s"Revenue share for $month" ~< {
      for
        royaltyRate  <- BigDecimal(0.75) ~> (rate => s"Royalty rate = $rate")
        totalRevenue <- sales.sum ~> (revenue => s"Total revenue = $revenue")
        revenueShare <- (totalRevenue * royaltyRate) ~> (revShare =>
          s"revenue share = total revenue * royalty rate = $revShare"
        )
      yield revenueShare
    }

@main def royaltiesTreeLogMain: Unit =
  import java.time.YearMonth
  import cats.implicits._
  import treelog.LogTreeSyntaxWithoutAnnotations._
  import RoyaltiesTreeLog.*

  val sales     = List(BigDecimal(5.99), BigDecimal(12.99), BigDecimal(1.49))
  val royalties = royaltiesForMonth(sales, YearMonth.of(2021, 10))
  println(royalties.value.written.show)