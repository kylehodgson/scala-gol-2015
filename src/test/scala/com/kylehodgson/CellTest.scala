package com.kylehodgson

import org.scalatest.FunSuite

class CellTest extends FunSuite {

  test("Cells can render themselves") {
    val liveCell = Cell(1, 1, true)
    assert(liveCell.Render()==".")
    val deadCell =  Cell(1, 1, false)
    assert(deadCell.Render()==" ")
  }

}
