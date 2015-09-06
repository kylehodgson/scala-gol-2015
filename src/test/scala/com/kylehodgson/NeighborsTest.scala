package com.kylehodgson

import org.scalatest.FunSuite

class NeighborsTest extends FunSuite {
  test("NeighborsFrom can get neighbors from a named location within a sequence of cells ") {
    val board = new Board(5)
    val neighborList = Neighbors.From(3, 3, board.cells)
    for (cursorRow <- 2 to 4; cursorCol <- 2 to 4;if (!(cursorRow == 3 && cursorCol == 3))) {
        assert(neighborList.exists(c => c.row == cursorRow && c.col == cursorCol))
    }
  }
  
  test("When NeighborsFrom gets neighbors it doesn't return the center cell of the neighborhood") {
    val board = new Board(5)
    val neighborList = LiveNeighbors.From(3, 3, board.cells)
    assert(!neighborList.exists(c => c.row == 3 && c.col == 3))
  }

  test("When NeighborsFrom gets neighbors it handles edge cases correctly") {
    val board = new Board(5)
    val neighborList = Neighbors.From(1, 1, board.cells)
    for (cursorRow <- 1 to 2; cursorCol <- 1 to 2; if (!(cursorCol == 1 && cursorRow == 1))) {
      assert(neighborList.exists(c => c.row == cursorRow && c.col == cursorCol),
        "\nMissing neighbor: row " + cursorRow + " col " + cursorCol)
    }
  }
  
  test("LiveNeighborsFrom can get live neighbors for a cell") {
    val board = new Board(5)
    val neighbors = LiveNeighbors.From(3, 3, board.cells)
    val liveNeighbors = LiveNeighbors.From(3, 3, board.cells)
    if (neighbors.exists(c => c.alive)) {
      assert(liveNeighbors.nonEmpty, "\nLiveNeighborsFor missed a live neighbor.")
    }
    assert(!liveNeighbors.exists(c => !c.alive), "\nLive neighbors shouldn't include dead cells")
  }
}
