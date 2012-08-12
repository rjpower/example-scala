package example
import scala.collection.mutable.ArrayBuffer

object IntQueue {

  def basicIntQueue: IntQueue = new BasicIntQueue
  def superIntQueue: IntQueue = new SuperIntQueue
  def duperIntQueue: IntQueue = new DuperIntQueue

  private class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]
    def put(x: Int) { buf += x }
    def get(): Int = buf.remove(0)
  }

  private class SuperIntQueue extends BasicIntQueue with Doubling

  private class DuperIntQueue extends BasicIntQueue with Incrementing with Filtering

}

abstract class IntQueue {
  def put(x: Int)
  def get(): Int
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(x * 2) }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x >= 0) super.put(x)
  }
}
