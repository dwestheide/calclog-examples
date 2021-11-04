package selfpub

import calclog.ValueFormatter

opaque type Euros = BigDecimal
object Euros:
  def apply(value: BigDecimal): Euros = value
  extension (x: Euros)
    def value: BigDecimal = x
  extension (xs: List[Euros])
    def total: Euros = xs.foldLeft(Euros(0))((x, y) => Euros(x.value + y.value))

