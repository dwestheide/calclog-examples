import calclog.*
import calclog.Defaults.{given, *}

final case class Parameters(a: Double, b: Double, c: Double)

@main def failingRoots: Unit =
  println(root(Parameters(2, 5, 10)).run.description.format)

  def root(parameters: Parameters): Calculation[Double] =
    val a = parameters.a ~ "a"
    val b = parameters.b ~ "b"
    val c = parameters.c ~ "c"

    val fourac = 4d.literal * a * c <~ "4ac"
    val determinant = b * b - fourac <~ "determinant"
    val numerator = -b + sqrt(determinant) <~ "numerator"
    val denominator = 2d.literal * a <~ "denominator"
    numerator / denominator <~ "root"