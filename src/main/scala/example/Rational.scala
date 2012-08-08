package example

class Rational(val numerator: Int, val denominator: Int) {

  require(denominator != 0, "Denominator can not be 0")

  def this(numerator: Int) = this(numerator, 1)

  override def toString = numerator + "/" + denominator

  def +(that: Rational): Rational = {
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )
  }

  def *(that: Rational): Rational = {
    new Rational(numerator * that.numerator, denominator * that.denominator)
  }
}