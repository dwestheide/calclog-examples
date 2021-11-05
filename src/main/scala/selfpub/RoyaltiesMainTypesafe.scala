package selfpub

import RoyaltiesCalculationTypesafe.*
import java.time.YearMonth
import calclog.Defaults.{given, *}
import calclog.CalculationDescriptionFormatter

@main def runTypesafeRoyaltiesCalculation: Unit =
  val sales = List(Euros(5.99), Euros(12.99), Euros(1.49))
  val royalties = royaltiesForMonth(sales, YearMonth.of(2021, 10)).run
  println(royalties.description.format(using CalculationDescriptionFormatter.flat))
