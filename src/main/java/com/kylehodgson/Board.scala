package com.kylehodgson

import scala.util.Random


class Board(pSize:Int) {
  def size:Int = pSize

  def NeighborsFor(targetRow: Int, targetCol: Int) = {
    val rowUpperBounds = targetRow + 1
    val rowLowerBounds = targetRow - 1
    val columnUpperBounds = targetCol + 1
    val columnLowerBounds = targetCol - 1
    cells.filter(c =>
      c.row <= rowUpperBounds && c.row >= rowLowerBounds &&
      c.col <= columnUpperBounds && c.col >= columnLowerBounds
    )
  }

  def LiveNeighborsFor(targetRow: Int, targetCol: Int) = {
    NeighborsFor(targetRow, targetCol).filter(c=>c.alive)
  }

  val cells = {
    for (row <- 1 to size; col <- 1 to size)
      yield Cell(row, col, alive = new Random().nextBoolean())
  }

  def Next = {
    for (cursorRow <- 1 to size; cursorCol <- 1 to size) {
      val liveNeighbors = LiveNeighborsFor(cursorRow, cursorCol).length
      if (liveNeighbors <2 || liveNeighbors > 3) println("Cell %d %d is dead".format(cursorRow, cursorCol))
      if (liveNeighbors >=2 && liveNeighbors <= 3) println("Cell %d %d is alive".format(cursorRow, cursorCol))
    }
  }
  override def toString: String = {
    var board = " "
    for( i<- 1 to size) board += "---"
    board += "\n"
    for (row <- 1 to size) {
      board += "|"
      for ( col <- 1 to size) {
        cells.find(c=>c.row==row && c.col==col)
          .foreach ( c=> { board += " " + c.Render() + " " })
      }
      board += "|\n"
    }
    board += " "
    for( i<- 1 to size) board += "---"
    board
  }
}
