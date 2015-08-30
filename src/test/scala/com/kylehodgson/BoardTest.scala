package com.kylehodgson

import org.scalatest.FunSuite

class BoardTest extends FunSuite {
  test("Board accepts a size") {
    val testSize = 6
    val testBoard = new Board(testSize)
    assert(testBoard.Size() == testSize )
  }
}
