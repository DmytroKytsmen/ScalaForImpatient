import scala.collection.mutable

val scores = new mutable.HashMap[String, Int]
scores("Bob") = 100
val bobsScore = scores("Bob")

object Name {
  def unapply(input: String) = {
    val pos = input.indexOf(" ")
    if (pos == -1) None
    else Some((input.substring(0, pos), input.substring(pos + 1)))
  }
}

object Number {
  def unapply(input: String): Option[Int] =
    try {
      Some(Integer.parseInt(input.trim))
    }
    catch {
      case ex: NumberFormatException => None
    }
}


val Number(n) = "1729"


object IsCompound {
  def unapply(input: String) = {
    input.contains(" ")
  }
}


3 + 4 -> 5
3 -> (4 + 5)


//task01
class Fraction(n: Int, d: Int) {
  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  override def toString = num + "/" + den

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  def gcd(a: Int, b: Int): Int = if (b == 0) math.abs(a) else gcd(b, a % b)

  def +(that: Fraction) = {
    new Fraction(this.num * that.den + that.num * this.den, this.den * that.den)
  }

  def -(that: Fraction) = {
    new Fraction(this.num * that.den - that.num * this.den, this.den * that.den)
  }

  def *(that: Fraction) = {
    new Fraction(this.num * that.num, this.den * that.den)
  }

  def /(that: Fraction) = {
    new Fraction(this.num * that.den, this.den * that.num)
  }
}

object Fraction {
  def apply(n: Int, d: Int): Fraction = new Fraction(n, d)
}

val x4 = Fraction(2, 4)
val y4 = Fraction(-1, 2)

println(x4 + y4)
println(x4 - y4)
println(x4 * y4)
println(x4 / y4)
//task04
class Money(dollar: Int, cent: Int) extends Ordered[Money] {
  val dollars: Int = dollar + cent / 100
  val cents: Int = cent % 100
  def toCents(): Int = dollars * 100 + cents

  def fromCents(cents: Int) = new Money(cents / 100, cents % 100)

  override def toString = "%d.%d".format(dollars, cents)

  override def compare(that: Money): Int = this.toCents.compare(that.toCents)

  def +(that: Money) = fromCents(this.toCents() + that.toCents())

  def -(that: Money) = fromCents(this.toCents() - that.toCents())

}

object Money {
  def apply(dol: Int, cent: Int): Money = new Money(dol, cent)
}

val x1 = Money(10, 4500)
val y1 = Money(20, 40)
println(x1 + y1)
println(x1 - y1)
println(x1 > y1)
//task05
import collection.mutable.ArrayBuffer
class Table {
  private val elements = new ArrayBuffer[String]()
  def |(element: String) = {
    elements += "<td>%s</td>\n".format(element)
  }

  def ||(element: String) = {
    elements += "</tr><tr>\n<td>%s</td>".format(element)

  }

  override def toString: String = "<table><tr>\n%s</tr></table>".format(elements.mkString)

}

object Table {
  def applt() = new Table()
}
//task06
class ASCIIPicture(val picture: String) {
  def +(that: ASCIIPicture) = new ASCIIPicture(
    picture.split("\n").zip(that.picture.split("\n")).map(x => x._1 + x._2).mkString("\n")
  )

  def ^(that: ASCIIPicture) = new ASCIIPicture(
    picture + "\n" + that.picture
  )

  override def toString: String = picture
}

val x2 = new ASCIIPicture(
  """ /\_/\
( ' ' )
(  -  )
    | | |
(__|__)""")
val y2 = new ASCIIPicture(
  """   -----
 / Hello \
<  Scala |
 \ Coder /
   -----""")
println(x2 + y2)
println(x2 ^ y2)
//task07
class BitSequence(private var sequence: Long = 0) {
  implicit def booleanToInteger(bool: Boolean) = if (bool) 1 else 0
  override def toString: String = "%64s".format(sequence.toBinaryString).replace(" ", "0")
  def update(bit: Int, state: Int) = sequence |= (state & 1L) << bit % 64
  def apply(bit: Int): Int = if ((sequence & 1L << bit % 64) > 0) 1 else 0
}
//task08
class Matrix(val m: Int, val n: Int) {
  private val value = Array.ofDim[Double](m, n)
  def update(x: Int, y: Int, v: Double) = value(x)(y) = v
  def apply(x: Int, y: Int) = value(x)(y)

  def +(that: Matrix): Matrix = {
    require(this.n == that.n)
    require(this.m == that.m)
    var result = new Matrix(m, n)
    for (i <- 0 until m; j <- 0 until n) {
      result(i, j) = this.value(i)(j) + that.value(i)(j)
    }
    result
  }

  def -(that: Matrix): Matrix = {
    this + that * -1
  }

  def *(factor: Double) = {
    var result = new Matrix(m, n)
    for (i <- 0 until m; j <- 0 until n) {
      result(i, j) = this.value(i)(j) * factor
    }
    result
  }

  private def prod(that: Matrix, i: Int, j: Int) = {
    (for (k <- 0 until n) yield value(i)(k) * that.value(j)(k)).sum
  }

  def *(that: Matrix): Matrix = {
    require(n == that.m)
    var result = new Matrix(m, n)
    for (i <- 0 until m; j <- 0 until n) {
      result(i, j) = prod(that, i, j)
    }
    result
  }

  override def toString: String = value.map(_.mkString(" ")).mkString("\n")
}

val xmatrix = new Matrix(2, 2)
xmatrix(0, 0) = 1
xmatrix(0, 1) = 2
xmatrix(1, 0) = 3
xmatrix(1, 1) = 4

println(xmatrix)
println()
println(xmatrix * 2)
println()
println(xmatrix * 2 - xmatrix)
println()
println((xmatrix * 2) * (xmatrix * 3))
//task09
class RichFile {
  def unapply(path: String): Unit = {
    val possition = path.lastIndexOf("/")
    if (possition == -1) None else Some((path.substring(0, possition), path.substring(possition + 1)))
  }

  def unaaplySequence(path:String):Option[Seq[String]] ={
    if (path.trim == "") None else Some(path.trim.split("/"))
  }
}
//task10