package com.kylehodgson

object GameOfLife {

  def main(args: Array[String]) {
    println("Game of Life")

    val board = new Board(5)
    println(board)
    (1 to 10).foreach(x => println(board.Next))
  }

}
