package selfpub

import calclog.{Evaluated, Calculation, Op, ValueFormatter}
import CustomOperators.Minimum

trait CustomOperators:
  trait Minimum[A] extends ((A, A) => Evaluated[A])

  given [A](using Numeric[A]): Minimum[A] with
    def apply(x: A, y: A): Evaluated[A] = Evaluated(Numeric[A].min(x, y))

  def min[A](x: Calculation[A], y: Calculation[A])(using
      minimum: Minimum[A],
      valueFormatter: ValueFormatter[A]
  ): Calculation.Expression[A] =
    Calculation.Expression(Op.TwoArgsFunction(x, y, minimum, "min"), valueFormatter)

object CustomOperators extends CustomOperators
