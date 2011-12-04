package com.github.snakes

/**
 * @author: Stanislav Kurilin
 */

object HelloScala {
  def main(args: Array[String]) {
    val game : Game = new Game()
    game.init()
    game.print()
    game.turn()
    game.print()
    game.changeDirection(Down)
    game.turn()
    game.print()
    game.turn()
    game.print()
  }
}