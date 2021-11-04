package selfpub

import RoyaltiesCalculation.*
import java.time.YearMonth
import calclog.Defaults.{given, *}

@main def runRoyaltiesCalculation: Unit =
  val sales = List(BigDecimal(5.99), BigDecimal(12.99), BigDecimal(1.49))
  val royalties = royaltiesForMonth(sales, YearMonth.of(2021, 10)).run
  println(royalties.description.format)
