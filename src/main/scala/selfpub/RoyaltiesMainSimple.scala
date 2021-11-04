package selfpub

import RoyaltiesCalculationSimple.*
import calclog.Defaults.{given, *}

@main def runSimpleRoyaltiesCalculation: Unit =
  val sales = List(BigDecimal(5.99), BigDecimal(12.99), BigDecimal(1.49))
  val royalties = royaltiesForMonth(sales).run
  println(royalties.description.format)
