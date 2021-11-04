package integration.squants

import calclog.Dsl.{*, given}
import calclog.DefaultOperatorSyntax.{*, given}
import calclog.ValueFormatter.Defaults.given
import squants.space.*
import squants.space.LengthConversions.*
import calclog.Calculation
import SquantsIntegration.{given, *}

@main def runSquantsDemo: Unit =
  println(dailySealedArea.run.description.format)

def dailySealedArea: Calculation[Area] =
  val length = 105.meters ~ "length"
  val width = 68.meters ~ "width"
  val soccerFieldArea = length * width <~ "soccer field area"
  val dailySealedArea = soccerFieldArea * 100d.literal <~ "daily sealed area"
  dailySealedArea.in(Hectares)
