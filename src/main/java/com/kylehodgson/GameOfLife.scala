package com.kylehodgson

object GameOfLife {

  def main(args: Array[String]) {
    println("Game of Life")

    val board = new Board(5)
    println(board)
    val iterations: Int = if(args(0).toInt > 0) args(0).toInt else 10
    (1 to iterations).foreach(x => {
      board.Next
      println(board)
    })
  }

}
