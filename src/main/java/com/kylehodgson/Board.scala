package com.kylehodgson

import scala.util.Random


class Board(size:Int) {
  def NeighborsFor(targetRow: Int, targetCol: Int) = {
    for (row <- 1 to size; col <- 1 to size)
      yield cells.filter(
        c =>
          c.row - targetRow <= 1 &&
            c.col - targetCol <= 1 &&
            c.row != targetRow && c.col != targetCol)
  }.flatMap(c => c)

  var cells = {
    for (row <- 1 to size; col <- 1 to size)
      yield Cell(row, col, alive = new Random().nextBoolean())
  }

  def Size():Int = size

  def ConsolePrint() {
    for (row <- 1 to size; col <- 1 to size)
      cells.find(c=>c.row==row && c.col==col)
        .foreach ( _.ConsolePrint())
  }

  def Render(): String = {
    var board = "\n"
    for (row <- 1 to size) {
      board += "|"
      for ( col <- 1 to size) {
        cells.find(c=>c.row==row && c.col==col)
          .foreach ( c=> { board += " " + c.Render() + " " })
      }
      board += "|\n"
    }
    board
  }
}
