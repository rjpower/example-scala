package s99

object P02 {
  def lastButOneBuiltIn[A](list: List[A]): A =
    if (list.isEmpty) throw new NoSuchElementException
    else list.init.last

  def lastButOneRecursive[A](list: List[A]): A = list match {
    case element :: _ :: Nil => element
    case _ :: tail => lastButOneRecursive(tail)
    case _ => throw new NoSuchElementException
  }
}