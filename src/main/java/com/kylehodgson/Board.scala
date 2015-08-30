package com.kylehodgson


class Board(size:Int) {
  var cells = {
    for (row <- 1 to size; col <- 1 to size)
      yield Cell(row, col, alive = true)
  }

  def Size():Int = size

  def Display() {
    for (row <- 1 to size; col <- 1 to size)
      cells.find(c=>c.row==row && c.col==col)
        .foreach ( _.consolePrint())
  }


}
