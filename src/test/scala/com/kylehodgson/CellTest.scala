package com.kylehodgson

import org.scalatest.FunSuite

class CellTest extends FunSuite {

  test("Cells can render themselves in a board") {
    assert(Cell(1, 1, alive = true).Render()==".")
    assert(Cell(1, 1, alive = false).Render()==" ")
  }
  test("Cells can print themselves") {
    assert(Cell(1,2,alive=true).toString=="Cell 1, 2 is Alive")
    assert(Cell(5,4,alive=false).toString=="Cell 5, 4 is Dead")
  }
}
