package com.kylehodgson

case class Cell(row: Int, col: Int, alive: Boolean) {
  def consolePrint() {
    println( "Cell %d, %d is %s"
        .format(row, col, if (alive) "Alive" else "Dead"))
  }
}