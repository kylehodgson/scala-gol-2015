package com.kylehodgson

case class Cell(row: Int, col: Int, alive: Boolean) {

  def Render() = if (alive) "." else " "

  override def toString = "Cell %d, %d is %s" format(row, col, if (alive) "Alive" else "Dead")

}