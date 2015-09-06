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

  test("Board can get next generation") {
    val board = new Board(5)
    val initialCells = board.cells
    board.Next
    val nextGenerationCells = board.cells
    assert(initialCells != nextGenerationCells,
      "\nNext generation should never be identical to current generation.")
  }

}
