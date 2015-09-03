package com.kylehodgson

import scala.util.Random


class Board(pSize: Int) {
  def size: Int = pSize

  def NeighborsFor(targetRow: Int, targetCol: Int) = cells.filter(
    c =>
      c.row <= targetRow + 1 && c.row >= targetRow - 1 &&
        c.col <= targetCol + 1 && c.col >= targetCol - 1 &&
        (c.col != targetCol && c.row != targetRow))

  def LiveNeighborsFor(targetRow: Int, targetCol: Int) =
    NeighborsFor(targetRow, targetCol).filter(c => c.alive)

  val cells = {
    for (row <- 1 to size; col <- 1 to size)
      yield Cell(row, col, alive = new Random().nextBoolean())
  }

  def Next = {
    for (cursorRow <- 1 to size; cursorCol <- 1 to size) {
      if (LiveNeighborsFor(cursorRow, cursorCol).length < 2 || LiveNeighborsFor(cursorRow, cursorCol).length > 3)
        new Cell(row = cursorRow, col = cursorCol, alive = false)
      if (LiveNeighborsFor(cursorRow, cursorCol).length >= 2 && LiveNeighborsFor(cursorRow, cursorCol).length <= 3)
        new Cell(row = cursorRow, col = cursorCol, alive = true)
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
