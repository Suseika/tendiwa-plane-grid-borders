package org.tendiwa.plane.grid.borders

import org.tendiwa.plane.directions.CardinalDirection
import org.tendiwa.plane.directions.CardinalDirection.*
import org.tendiwa.plane.directions.OrdinalDirection.*
import org.tendiwa.plane.grid.rectangles.GridRectangle
import org.tendiwa.plane.grid.rectangles.corner
import org.tendiwa.plane.grid.rectangles.sides.side
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

/**
 * Returns the border of the [GridRectangle] composed of [TileBorder] elements.
 */
val GridRectangle.tileBorder: List<TileBorder>
    get() =
    bordersAtCorners().plus(
        listOf(N, E, S, W).flatMap { bordersFromSideExceptCorners(it) }
    )

private fun GridRectangle.bordersFromSideExceptCorners(
    side: CardinalDirection
): List<TileBorder> =
    this.side(side)
        .tilesList
        .map { it.border(side) }
        .let { it.subList(1, it.size - 1) }

private fun GridRectangle.bordersAtCorners(): List<TileBorder> =
    listOf(
        corner(NE).border(N),
        corner(NE).border(E),
        corner(NW).border(N),
        corner(NW).border(W),
        corner(SE).border(S),
        corner(SE).border(E),
        corner(SW).border(S),
        corner(SW).border(W)
    )
