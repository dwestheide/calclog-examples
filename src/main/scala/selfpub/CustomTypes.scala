package selfpub

import calclog.*
import CustomOperators.Minimum

object CustomTypes:

  given ValueFormatter[Euros] with
    def format(euros: Euros): String = s"EUR ${euros.formatted("%2.2f")}"
  given ValueFormatter[RoyaltyRate] with
    def format(royaltyRate: RoyaltyRate): String = s"$royaltyRate %"

  given Plus[Euros] = Plus.safe((x, y) => Euros(x.value + y.value))
  given Minus[Euros] = Minus.safe((x, y) => Euros(x.value - y.value))
  given Times[Euros, Int, Euros] = Times.safe((x, y) => Euros(x.value * y))
  given Times[Euros, RoyaltyRate, Euros] = Times.safe((euros, rate) => Euros(euros.value * rate.toFraction))
  given Minimum[Euros] with
    def apply(x: Euros, y: Euros): Evaluated[Euros] = Evaluated(Euros(x.value.min(y.value))) 

