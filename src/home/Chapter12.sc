val fun: (Double) => Double = 3 * _
(1 to 9).map("*" * _).foreach(println _)
(1 to 9).filter(_ % 2 == 0)
(1 to 9).reduceLeft(_ * _)
"Mary had a little lamb".split(" ").sortWith(_.length < _.length).reverse
def mulBy(factor: Double) = (x: Double) => factor * x
def mul(x: Int, y: Int) = x * y
def mulOneAtATime(x: Int) = (y: Int) => x * y
mulOneAtATime(6)(7)
//task01
def values(fun: (Int) => Int, low: Int, high: Int) = (low to high).map { x => (x, fun(x)) }
//task02
(1 to 9).reduceLeft((x, y) => if (x > y) x else x)
//task03
(1 to 9).reduceLeft(_ * _)
//task04
(-2 to 9).foldLeft(1)(_ * _)
//task05
def largest(fun: (Int) => Int, inputs: Seq[Int]) = inputs.map(fun(_)).max
//task06
def largestAt(fun: (Int) => Int, inputs: Seq[Int]) = {
  inputs.map(x => (x, fun(x))).reduceLeft((x, y) => if (x._2 > y._2) x else y)._1
}
//task07
def adjustToPair(fun: (Int, Int) => Int) = (x: (Int, Int)) => fun(x._1, x._2)
val x = adjustToPair(_ * _)((6, 7))
println(x)
val pairs = (1 to 10) zip (11 to 20)
println(pairs)

val yx = pairs.map(adjustToPair(_ + _))
println(yx)
//task08
val a = Array("Hello", "beautiful", "world", "!")
val b = a.map(_.length)
println(a.mkString(", "))
println(b.mkString(", "))
val y = a.corresponds(b)(_.length == _)

println(y)

//task09
def corresponds [A,B](a:Seq[A], b:Seq[B], f: (A,B) => Boolean)=(a zip b).map(x => f(x._1, x._2)).count(!_) == 0
val a1 = Array("Hello", "beautiful", "world", "!")
val b1 = a1.map(_.length)
println(a1.mkString(", "))
println(b1.mkString(", "))
val y1 = corresponds(a, b, (x: String, y: Int) => x.length == y)

//task10
def unless(condition: => Boolean)(block: => Unit) { if (!condition) { block } }

unless (0 > 1) { println("Unless!") }
