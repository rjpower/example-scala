package s99

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

class P0102Spec extends FlatSpec with ShouldMatchers with P01Behaviours {
  "Built-in last" should behave like last(P01.lastBuiltIn)
  "Recursive last" should behave like last(P01.lastRecursive)
  "Built-in last but one" should behave like lastButOne(P02.lastButOneBuiltIn)
  "Recursive last but one" should behave like lastButOne(P02.lastButOneRecursive)
}

trait P01Behaviours { this: FlatSpec =>
  val max = 50000
  val list = 1 to max

  def last(fn: List[Int] => Int) {
    it should "find the last element of a list" in {
      assert(fn(list.toList) === max)
    }

    it should "complain if the list is empty " in {
      intercept[NoSuchElementException] {
        fn(List())
      }
    }
  }

  def lastButOne(fn: List[Int] => Int) {
    it should "find the last but one element of a list" in {
      assert(fn(list.toList) === max - 1)
    }

    it should "complain for one element list" in {
      intercept[NoSuchElementException] {
        fn(List(1))
      }
    }

    it should "complain if the list is empty " in {
      intercept[NoSuchElementException] {
        fn(List())
      }
    }
  }
}