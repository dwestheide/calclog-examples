package integration.squants

import squants.Quantity
import calclog.*
import squants.space.*
import squants.UnitOfMeasure

object SquantsIntegration:
  
  given [A <: Quantity[A]]: Plus[A] with
    def apply(x: A, y: A): Evaluated[A] = Evaluated(x + y)
  given [A <: Quantity[A]]: Minus[A] with
    def apply(x: A, y: A): Evaluated[A] = Evaluated(x - y)
  given [A <: Quantity[A]]: Times[A, Double, A] with
    def apply(x: A, y: Double): Evaluated[A] = Evaluated(x * y)
  given [A <: Quantity[A]]: Divide[A, Double, A] with
    def apply(x: A, y: Double): Evaluated[A] = Evaluated(x / y)
  given [A <: Quantity[A]]: UnaryMinus[A] with
    def apply(x: A): Evaluated[A] = Evaluated(x.negate)
  
  given Times[Length, Length, Area] with
    def apply(x: Length, y: Length): Evaluated[Area] = Evaluated(x * y)

  def unitOfMeasureFormatter[A <: Quantity[A]]: ValueFormatter[UnitOfMeasure[A]] = _.symbol

  extension [A <: Quantity[A]](x: Calculation[A])
    def in(unitOfMeasure: UnitOfMeasure[A])(using format: ValueFormatter[A]): Calculation.Expression[A] = 
      Calculation.Expression(
      Op.Infix(x, 
      Calculation.Expression(Op.Literal(unitOfMeasure, unitOfMeasureFormatter), unitOfMeasureFormatter), 
      (quantity, unitOfMeasure) => Evaluated(quantity.in(unitOfMeasure)), 
      "in"), format)