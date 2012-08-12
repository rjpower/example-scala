package example
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec

class BasicIntQueueSpec extends FunSpec with ShouldMatchers {

  describe("A basic int queue") {
    it("should act as FIFO") {
      val queue = IntQueue.basicIntQueue
      queue.put(-1)
      queue.put(0)
      queue.put(1)

      queue.get() should be (-1)
      queue.get() should be (0)
      queue.get() should be (1)
    }
  }

  describe("A super int queue") {
    it("should act as super FIFO") {
      val queue = IntQueue.superIntQueue
      queue.put(-1)
      queue.put(0)
      queue.put(1)

      queue.get() should be (-2)
      queue.get() should be (0)
      queue.get() should be (2)
    }
  }

  describe("A super int queue") {
    it("should act as duper FIFO") {
      val queue = IntQueue.duperIntQueue
      queue.put(-1)
      queue.put(0)
      queue.put(1)

      queue.get() should be (1)
    }
  }

}