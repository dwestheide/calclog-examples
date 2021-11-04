package selfpub

import calclog.ValueFormatter

opaque type RoyaltyRate = Int
object RoyaltyRate:
  def apply(value: Int): RoyaltyRate =
    require(value >= 0 && value <= 100)
    value
  extension (x: RoyaltyRate)
    def toFraction: BigDecimal = BigDecimal(x) / 100
