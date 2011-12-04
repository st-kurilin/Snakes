package com.github.snakes

/**
 * @author: Stanislav Kurilin
 */


abstract class Direction(val opposite: Direction) {
  def isOpposite(other: Direction) = other == opposite
}

case object Up extends Direction(Down)

case object Down extends Direction(Up)

case object Left extends Direction(Right)

case object Right extends Direction(Left)
