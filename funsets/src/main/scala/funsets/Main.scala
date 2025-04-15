package funsets

object Main extends App:
  import FunSets.*
  val s5 = Set(3, 5, 6, 7, 8)
  println(forall(s5, x => x > 0))
