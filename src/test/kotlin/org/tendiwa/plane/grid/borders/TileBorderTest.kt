package org.tendiwa.plane.grid.borders

import org.junit.Test
import org.tendiwa.plane.directions.CardinalDirection.*
import org.tendiwa.plane.grid.rectangles.GridRectangle
import org.tendiwa.plane.grid.tiles.AnyTile
import org.tendiwa.plane.grid.tiles.move
import kotlin.test.assertEquals

class TileBorderTest {
    @Test
    fun `neighbor tiles share a side`() {
        val tile = AnyTile()
        assertEquals(
            tile.border(E),
            tile.move(E).border(W)
        )
        assertEquals(
            tile.border(W),
            tile.move(W).border(E)
        )
        assertEquals(
            tile.border(N),
            tile.move(N).border(S)
        )
        assertEquals(
            tile.border(S),
            tile.move(S).border(N)
        )
    }

    @Test
    fun `creates border of GridRectangle out of TileBorders`() {
        val width = 3
        val height = 4
        GridRectangle(1, 2, width, height)
            .tileBorder
            .distinct()
            .apply {
                assertEquals((width + height) * 2, size)
            }
    }
}
