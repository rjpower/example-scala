package example

import scala.Array.canBuildFrom
import example.Element.element

object Element {

  def element(contents: Array[String]): Element = new ArrayElement(contents)
  def element(line: String): Element = new LineElement(line)
  def element(c: Char, height: Int, width: Int): Element = new UniformElement(c, height, width)

  private class ArrayElement(val contents: Array[String]) extends Element {
  }

  private class LineElement(line: String) extends Element {
    val contents = Array(line)
    override def height: Int = 1
    override def width: Int = line.length
  }

  private class UniformElement(c: Char, override val height: Int, override val width: Int) extends Element {
    private val line = c.toString * width
    val contents = Array.fill(height)(line)
  }
}

abstract class Element {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = contents(0).length

  def above(that: Element): Element = {
    val widenThis = this widen that.width
    val widenThat = that widen this.width
    element(widenThis.contents ++ widenThat.contents)
  }

  def beside(that: Element): Element = {
    val heightenThis = this heighten that.height
    val heightenThat = that heighten this.height
    element(
      for (
        (thisLine, thatLine) <- heightenThis.contents zip heightenThat.contents
      ) yield thisLine + thatLine
    )
  }

  def widen(w: Int): Element = {
    if (w <= width) this
    else {
      val left = element(' ', (w - width) / 2, height)
      val right = element(' ', w - width - left.width, height)
      left beside this beside right
    }
  }

  def heighten(h: Int): Element = {
    if (h <= height) this
    else {
      val top = element(' ', width, h - height)
      val bottom = element(' ', width, h - height - top.height)
      top above this above bottom
    }
  }

  override def toString: String = contents.mkString("\n")

}