package com.kylehodgson

import scala.collection.immutable.IndexedSeq

case class Cell(row: Int, col: Int, alive: Boolean) {
  def neighborsFrom(cells: IndexedSeq[Cell]) = cells.filter(
    c =>
      c.row <= row + 1 &&
        c.row >= row - 1 &&
        c.col <= col + 1 &&
        c.col >= col - 1 &&
        !(c.col == col && c.row == row))

  def Render() = if (alive) "." else " "

  override def toString = "Cell %d, %d is %s" format(row, col, if (alive) "Alive" else "Dead")

}