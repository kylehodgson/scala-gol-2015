package com.kylehodgson

import org.scalatest.FunSuite

class BoardTest extends FunSuite {
  test("Board has a size") {
    val testSize = 6
    val testBoard = new Board(testSize)
    assert(testBoard.Size() == testSize )
  }
  test("Board can initialize with random patterns") {
    val target = new Board(5)
    assert(target.cells.exists(c => c.alive))
    assert(target.cells.exists(c => !c.alive))
  }
  test("Board can render") {
    val target = new Board(5)
    val currentState = target.Render()
    assert(currentState.apply(1)=='|')
  }
  test("Board can get the neighbors for a specific, central cell that don't include that cell") {
    val board = new Board(5)
    val neighborList = board.NeighborsFor(3,3)
    assert(!neighborList.exists(c => c.row == 3 && c.col == 3))
    for( cursorRow <- 2 to 4; cursorCol <- 2 to 4; if cursorRow != 3 && cursorCol != 3 ) {
      assert(neighborList.find(c=>c.row==cursorRow && c.col==cursorCol).size==1,
        "Missing neighbor: row " + cursorRow + " col " + cursorCol)
    }
  }
  test("When a board gets neighbors it handles edge cases correctly") {
    val board = new Board(5)
    val neighborList = board.NeighborsFor(1, 1)
    assert(!neighborList.exists(c => c.row == 3 && c.col == 3))
    for( cursorRow <- 1 to 2; cursorCol <- 1 to 2; if cursorRow != 1 && cursorCol != 1 ) {
      assert(neighborList.find(c=>c.row==cursorRow && c.col==cursorCol).size==1,
        "Missing neighbor: row " + cursorRow + " col " + cursorCol)
    }
  }
}
