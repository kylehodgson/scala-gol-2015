package com.kylehodgson

import scala.util.Random


class Board(pSize:Int) {
  def size:Int = pSize

  def NeighborsFor(targetRow: Int, targetCol: Int) = {
    for (row <- 1 to size; col <- 1 to size)
      yield cells.filter(
        c =>
          c.row - targetRow <= 1 &&
            c.col - targetCol <= 1 &&
            c.row != targetRow && c.col != targetCol)
  }.flatMap(c => c)

  val cells = {
    for (row <- 1 to size; col <- 1 to size)
      yield Cell(row, col, alive = new Random().nextBoolean())
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
