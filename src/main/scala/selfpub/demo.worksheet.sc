import calclog.Calculation.Variable
import calclog.Defaults.{given, *}

val pi = Math.PI ~ "pi"
val radius = 15d ~ "radius"
val perimeter = 2d * pi * radius <~ "perimeter"
perimeter.run.description.format