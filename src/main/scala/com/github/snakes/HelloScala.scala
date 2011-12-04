package com.github.snakes

import java.util.{TimerTask, Timer}


/**
 * @author: Stanislav Kurilin
 */

object HelloScala {
  def main(args: Array[String]) {
    val game: Game = new Game()
    game.init()
    val guiClient: GuiClient = new GuiClient(game)
    val timer = new Timer()
    val performTurn = new TimerTask() {
      override def run() {
        game.turn()
        guiClient.fireChange();
      }
    }
    timer.scheduleAtFixedRate(performTurn, 10, 200)
    guiClient.go()
  }
}