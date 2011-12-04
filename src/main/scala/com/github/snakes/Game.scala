package com.github.snakes


/**
 * @author: Stanislav Kurilin
 */


class Game {
  def width = 10

  def height = 10

  var snake: List[Tuple2[Int, Int]] = null

  var target: Tuple2[Int, Int] = null

  var direction : Direction= Right

  def init() {
    snake = List((4, 4), (3, 4), (2, 4))
  }

  def turn() {
    val newHead = next(snake.head, direction);
    snake = newHead :: snake.dropRight(1);
  }

  def changeDirection(newDirection: Direction) {
    if (!direction.isOpposite(newDirection)) direction = newDirection
  }

  def print() {
    for (y <- 0 until height) {
      for (x <- 0 until width) {
        if (snake.contains((x, y))) {
          System.out.print('*')
        } else {
          System.out.print('_')
        }
      }
      println()
    }
  }

  def next(current: Tuple2[Int, Int], direction: Any) =
    direction match {
      case Right => (current._1 + 1, current._2)
      case Left => (current._1 - 1, current._2)
      case Up => (current._1, current._2 - 1)
      case Down => (current._1, current._2 + 1)
    }
}

