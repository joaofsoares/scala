package exercism

class Strain

object Strain {
  def keep[A](xs: Iterable[A], f: A => Boolean): List[A] = xs.toList.filter(f)

  def discard[A](xs: Iterable[A], f: A => Boolean): List[A] =
    xs.toList.filterNot(f)
}
