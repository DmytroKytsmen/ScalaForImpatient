

object Accounts {
  private var lastNumber = 0

  def newUniqueNumber() = {
    lastNumber += 1;
    lastNumber
  }
}

//class Account {
//  var id = Account.newUniqueNumber()
//  private var balance = 0.0
//
//  def deposit(amount: Double) = {
//    balance += amount
//  }
//}
//
//object Account {
//  private var lastNumber = 0
//
//  def apply(initialBalance: Double) = new Account()
//
//  private def newUniqueNumber() {
//    lastNumber += 1;
//    lastNumber
//  }
//}

abstract class UndoableAction(val description: String) {
  def undo(): Unit

  def redo(): Unit
}

object DoNothingAction extends UndoableAction("Do nothing") {
  override def undo() {}

  override def redo() {}

}
object Hello {
  def main(args: Array[String]) {
    println("Hello, World")
  }
}
object Hello1 extends App {
  println("Hello, World!")
}
object TrafficLightColor extends Enumeration {
  val Red, Yellow, Green = Value
}
for (c <- TrafficLightColor.values) println(c.id + ": " + c)
//task01
object Conversions {
  def inchesToCentimeters(inches: Double): Double = {
    inches * 2.54
  }
  def gallonsToLiters(gallons: Double): Double = {
    gallons * 3.78541
  }

  def milesToKilometers(miles: Double): Double = {
    miles * 1.60934
  }
}
//task02
class UnitConversion(val conversionCoef: Double) {
  private def conver(value: Double) = value * conversionCoef
  def apply(value:Double) = conver(value)
}
object InchesToCentimetersImproved extends UnitConversion(2.54){}
object GallonsToLitersImproved extends UnitConversion(3.78541){}
object MilesToKilometersImproved extends UnitConversion(1.60934){}
//task03
object Origin extends java.awt.Point {
}
//task04
class Point(val x:Double, val y:Double){
  override def toString = "(" + x + ", " + y + ")"
}
object Point {
  def apply(x:Double, y:Double) = new Point(x,y)
}
//task05
object Reverse extends App{
  override def main (args: Array[String]) {
    println(args.reverse.mkString(" "))
  }
}

//task06 & 07

object CardSuite extends Enumeration{
  type CardSuite = Value
  val Spade = Value("?")
  val Club = Value("?")
  val Heart = Value("?")
  val Diamond = Value("?")
  def isRed(card: CardSuite):Boolean ={
    card == Diamond || card == Heart
  }
}

println(CardSuite.values)
println (for (s <- CardSuite.values) yield (s, CardSuite.isRed(s)))

//task08
object RGBCube extends Enumeration{
  val Black = Value(0x000000, "Black")
  val Red = Value(0xff0000, "Red")
  val Green = Value(0x00ff00, "Green")
  val Yellow = Value(0xffff00, "Yellow")
  val Blue = Value(0x0000ff, "Blue")
  val Cyan = Value(0x00ffff, "Cyan")
  val Magenta = Value(0xff00ff, "Magenta")
  val White = Value(0xffffff, "White")
}

println(for (s<-RGBCube.values) println("0x%06x: %s".format(s.id, s)))