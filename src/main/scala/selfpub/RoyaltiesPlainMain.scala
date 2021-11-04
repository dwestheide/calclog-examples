package selfpub

import RoyaltiesWithLogging.*
import java.time.YearMonth

@main def royaltiesPlain: Unit =
  val sales = List(BigDecimal(5.99), BigDecimal(12.99), BigDecimal(1.49))
  val royalties = royaltiesForMonth(sales, YearMonth.of(2021, 10))
  println(royalties)