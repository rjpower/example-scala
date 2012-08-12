package example

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec

import example.Element.element

class ElementSpec extends FunSpec with ShouldMatchers {

  describe("An array element 'hello', 'world!'") {
    val contents = Array("hello", "world!")
    val el = element(contents)

    it("should have width 5") {
      el.width should be (5)
    }

    it("should have height 2") {
      el.height should be (2)
    }

    it("should override toString") {
      el.toString should be ("hello\nworld!")
    }

  }

}