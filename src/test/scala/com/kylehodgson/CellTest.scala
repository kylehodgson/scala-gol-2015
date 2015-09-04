package com.kylehodgson

import org.scalatest.FunSuite

import scala.util.Random

class CellTest extends FunSuite {

  test("Cells can render themselves in a board") {
    assert(Cell(1, 1, alive = true).Render() == ".")
    assert(Cell(1, 1, alive = false).Render() == " ")
  }
  test("Cells can print themselves") {
    assert(Cell(1, 2, alive = true).toString == "Cell 1, 2 is Alive")
    assert(Cell(5, 4, alive = false).toString == "Cell 5, 4 is Dead")
  }
  test("Cells can get their own neighbors provided an indexedSequence of cells") {
    val boardLikeSequence = for (row <- 1 to 5; col <- 1 to 5)
      yield Cell(row, col, alive = new Random().nextBoolean())
    assert(boardLikeSequence.size == 25)
    assert(Cell(3, 3, alive = false).neighborsFrom(boardLikeSequence).size == 8)
  }
}
