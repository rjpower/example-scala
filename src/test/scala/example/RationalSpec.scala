package example
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.path.FunSpec
import org.scalatest.prop.TableDrivenPropertyChecks

class RationalSpec extends FunSpec with ShouldMatchers with TableDrivenPropertyChecks {

  describe("A Rational constructor") {
    val validRationals =
      Table (
        ("numerator", "denominator"),
        (1, 2),
        (-1, 2),
        (0, 2)
      )

    forAll(validRationals) { (numerator: Int, denominator: Int) =>
      it("should create Rational for " + numerator + "/" + denominator) {
        val rational = new Rational(numerator, denominator)
        rational.numerator should be (numerator)
        rational.denominator should be (denominator)
      }
    }

    forAll(validRationals) { (numerator: Int, denominator: Int) =>
      it("should create Rational for " + numerator + "/1") {
        val rational = new Rational(numerator)
        rational.numerator should be (numerator)
        rational.denominator should be (1)
      }
    }

    it("should not create Rational when denominator is equal 0") {
      val thrown = evaluating { new Rational(1, 0) } should produce[IllegalArgumentException]
      thrown.getMessage should include ("Denominator can not be 0")
    }
  }

  describe("A Rational") {
    it("should override toString") {
      val rational = new Rational(1, 2)
      rational.toString should be ("1/2")
    }

    it("should add 1/2 and 1/3") {
      val half = new Rational(1, 2)
      val third = new Rational(1, 3)

      val result = half + third
      result.numerator should be (5)
      result.denominator should be (6)
    }

    it("should multiply 1/2 and 1/3") {
      val half = new Rational(1, 2)
      val third = new Rational(1, 3)

      val result = half * third
      result.numerator should be (1)
      result.denominator should be (6)
    }

    it("should keep operators precedence for 1/2 + 1/3 * 1/3") {
      val half = new Rational(1, 2)
      val third = new Rational(1, 3)

      val result = half + third * third
      result.numerator should be (11)
      result.denominator should be (18)
    }

    it("should keep operators precedence for (1/2 + 1/3) * 1/3") {
      val half = new Rational(1, 2)
      val third = new Rational(1, 3)

      val result = (half + third) * third
      result.numerator should be (5)
      result.denominator should be (18)
    }
  }
}