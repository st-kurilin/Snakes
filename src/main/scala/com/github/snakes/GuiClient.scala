package com.github.snakes

import java.awt.{Color, Graphics}
import javax.swing.{JFrame, JPanel}
import java.awt.event.{KeyAdapter, KeyEvent}

/**
 * @author: Stanislav Kurilin
 */

class GuiClient(game: Game) {
  val area = new Area(game)

  def go() {
    val frame: JFrame = new JFrame("Snake")
    frame.add(area)
    frame.setSize(300, 300)
    frame.addKeyListener(new KeyAdapter {
      override def keyPressed(e: KeyEvent) {
        e.getKeyCode match {
          case KeyEvent.VK_DOWN => game.changeDirection(Down)
          case KeyEvent.VK_UP => game.changeDirection(Up)
          case KeyEvent.VK_LEFT => game.changeDirection(Left)
          case KeyEvent.VK_RIGHT => game.changeDirection(Right)
        }
      }
    })
    frame.setVisible(true)
  }

  def fireChange() {
    area.repaint()
  }
}

class Area(game: Game) extends JPanel {
  override def paint(graphics: Graphics) {

    for (y <- 0 until game.height) {
      for (x <- 0 until game.width) {
        if (game.snake.contains((x, y))) {
          graphics.setColor(Color.DARK_GRAY)
        } else {
          graphics.setColor(Color.WHITE)
        }
        graphics.drawRect(x * 30, y * 30, 29, 28)
      }
    }
  }
}