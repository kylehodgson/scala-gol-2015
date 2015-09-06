package com

package object kylehodgson {
  def NeighborsFrom(row: Int, col: Int, cells: IndexedSeq[Cell]) =
    cells.filter(
      c =>
        c.row <= row + 1 &&
          c.row >= row - 1 &&
          c.col <= col + 1 &&
          c.col >= col - 1 &&
          !(c.col == col && c.row == row))

  def LiveNeighborsFrom(row: Int, col: Int, cells: IndexedSeq[Cell]) =
    NeighborsFrom(row, col, cells).filter(c => c.alive)
}
