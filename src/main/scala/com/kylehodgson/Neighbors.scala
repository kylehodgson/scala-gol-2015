package com.kylehodgson

object Neighbors {
  def From(row: Int, col: Int, cells: IndexedSeq[Cell]) = cells.filter(
    c =>
      c.row <= row + 1 &&
        c.row >= row - 1 &&
        c.col <= col + 1 &&
        c.col >= col - 1 &&
        !(c.col == col && c.row == row)
  )
}

object LiveNeighbors {
  def From(row: Int, col: Int, cells: IndexedSeq[Cell]) =
    Neighbors.From(row, col, cells).filter(c => c.alive)
}
