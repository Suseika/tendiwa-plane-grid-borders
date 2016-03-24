package org.tendiwa.plane.grid.borders

import org.tendiwa.plane.directions.CardinalDirection
import org.tendiwa.plane.directions.CardinalDirection.*
import org.tendiwa.plane.grid.tiles.Tile

/**
 * Represents a 1-tile long border on a side of a [Tile].
 * @param borderX X coordinate of the border in border coordinates.
 * @param borderY Y coordinate of the border in border coordinates.
 */
data class TileBorder(val borderX: Int, val borderY: Int)

fun Tile.border(side: CardinalDirection): TileBorder =
    when (side) {
        N -> TileBorder(x * 2 + 1, y + 1)
        E -> TileBorder(x * 2 + 2, y)
        S -> TileBorder(x * 2 + 1, y)
        W -> TileBorder(x * 2, y)
    }


