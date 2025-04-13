package recfun

import scala.annotation.tailrec

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if c < 0 || c > r then 0
    else if r == 0 || c == 0 then 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean =
    @tailrec
    def balanceIter(open: Int, chars: List[Char]): Boolean =
      if open < 0 then false
      else if chars.isEmpty then open == 0
      else chars.head match
        case '(' => balanceIter(open+1, chars.tail)
        case ')' =>  balanceIter(open-1, chars.tail)
        case _ => balanceIter(open, chars.tail)

    balanceIter(0, chars)
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if money == 0 then 1
    else if money < 0 || coins.isEmpty then 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
