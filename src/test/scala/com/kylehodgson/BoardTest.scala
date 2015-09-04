package com.kylehodgson

import org.scalatest.FunSuite

class BoardTest extends FunSuite {
  test("Board has a size") {
    val testSize = 6
    val testBoard = new Board(testSize)
    assert(testBoard.size == testSize)
  }
  test("Board can initialize with random patterns") {
    val target = new Board(5)
    assert(target.cells.exists(c => c.alive))
    assert(target.cells.exists(c => !c.alive))
  }
  test("Board renders to console") {
    val target = new Board(5)
    val currentState = target.toString()
    val firstHyphen = 1
    val lastHyphen = currentState.length - 2
    assert(currentState(firstHyphen) == '-')
    assert(currentState(lastHyphen) == '-')
  }
  test("Board can get the neighbors for a specific, central cell") {
    val board = new Board(5)
    val neighborList = board.NeighborsFor(3, 3)
    for (cursorRow <- 2 to 4; cursorCol <- 2 to 4; if cursorRow != 3 && cursorCol != 3) {
      assert(neighborList.find(c => c.row == cursorRow && c.col == cursorCol).size == 1,
        "Missing neighbor: row " + cursorRow + " col " + cursorCol)
    }
  }
  test("When board gets neighbors it doesn't accidentally get the cell itself") {
    val board = new Board(5)
    val neighborList = board.NeighborsFor(3, 3)
    assert(!neighborList.exists(c => c.row == 3 && c.col == 3))
  }
  test("When a board gets neighbors it handles edge cases correctly") {
    val board = new Board(5)
    val neighborList = board.NeighborsFor(1, 1)
    assert(!neighborList.exists(c => c.row == 3 && c.col == 3))
    for (cursorRow <- 1 to 2; cursorCol <- 1 to 2; if cursorRow != 1 && cursorCol != 1) {
      assert(neighborList.find(c => c.row == cursorRow && c.col == cursorCol).size == 1,
        "Missing neighbor: row " + cursorRow + " col " + cursorCol)
    }
  }
  test("Board can get live neighbors for a cell") {
    val board = new Board(5)
    val neighbors = board.NeighborsFor(3,3)
    val liveNeighbors = board.LiveNeighborsFor(3, 3)
    if (neighbors.exists(c => c.alive)) {
      assert(liveNeighbors.nonEmpty, "\nLiveNeighborsFor missed a live neighbor.")
    }
    assert(!liveNeighbors.exists(c => !c.alive), "\nLive neighbors shouldn't include dead cells")
  }
  test("Board can get next generation") {
    val board = new Board(5)
    val initialCells = board.cells
    board.Next
    val nextGenerationCells = board.cells
    assert(initialCells != nextGenerationCells,
      "\nNext generation should never be identical to current generation.")
  }

}
