package s99

object P01 {
  def lastBuiltIn[A](list: List[A]): A = list.last

  def lastRecursive[A](list: List[A]): A = list match {
    case element :: Nil => element
    case _ :: tail => lastRecursive(tail)
    case _ => throw new NoSuchElementException
  }
}