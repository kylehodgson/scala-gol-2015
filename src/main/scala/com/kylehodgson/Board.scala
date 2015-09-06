package com.kylehodgson

import scala.util.Random


class Board(pSize: Int) {
  def size: Int = pSize

  var cells = {
    for (row <- 1 to size; col <- 1 to size)
      yield Cell(row, col, alive = new Random().nextBoolean())
  }

  def Next = {
    cells = for (cursorRow <- 1 to size; cursorCol <- 1 to size) yield {
      new Cell(row = cursorRow, col = cursorCol,
        alive = if (LiveNeighborsFrom(cursorRow, cursorCol, cells).length >= 2 &&
          LiveNeighborsFrom(cursorRow, cursorCol, cells).length <= 3) true
        else false
      )
    }
  }

  override def toString: String = {
    var board = " "
    for (i <- 1 to size) board += "---"
    board += "\n"
    for (row <- 1 to size) {
      board += "|"
      for (col <- 1 to size) {
        cells.find(c => c.row == row && c.col == col)
          .foreach(c => {
          board += " " + c.Render() + " "
        })
      }
      board += "|\n"
    }
    board += " "
    for (i <- 1 to size) board += "---"
    board
  }
}
