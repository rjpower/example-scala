package example
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec
import scala.io.Source

class LongLinesSpec extends FunSpec with ShouldMatchers {

  describe("Long lines") {
    it("should return only lines longer than 5 characters") {
      val source = Source.fromString("line\nlong line")

      LongLines.processSource(source, 5) should be ("long line")
    }
  }
}