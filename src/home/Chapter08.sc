////task01
//class BankAccount(initialBalance:Double){
//  private var balance = initialBalance
//  def deposit(amount: Double) = {balance += amount; balance}
//  def withdraw(amount : Double) = {balance -= amount; balance}
//  override def toString = "Balance = %f".format(balance)
//}
//class CheckingAccount(initialBalance: Double, var commision:Double = 1.0) extends BankAccount(initialBalance){
//  override def deposit(amount: Double) = super.deposit(amount - commision)
//  override def withdraw(amount: Double) = super.withdraw(amount - commision)
//}

//task02
class BankAccount(initialBalance: Double) {
  private var _balance = initialBalance

  def deposit(amount: Double) = {
    _balance += amount;
    _balance
  }

  def withdraw(amount: Double) = {
    _balance -= amount;
    _balance
  }

  def balance(): Double = _balance

  override def toString = "Balance = %f".format(balance)
}

class SavingsAccount(
                      initialBalance: Double,
                      val interestRateYear: Double = 0.10,
                      val freeTransactions: Int = 3,
                      val comission: Double = 1.0
                      ) extends BankAccount(initialBalance) {

  var transactionsInMonth: Int = 0

  def isFreeTransaction() = transactionsInMonth <= freeTransactions

  override def deposit(amount: Double) = {
    transactionsInMonth += 1
    super.deposit(amount - (if (isFreeTransaction()) 0 else comission))

  }

  override def withdraw(amount: Double) = {
    transactionsInMonth += 1
    super.withdraw(amount + (if (isFreeTransaction()) 0 else comission))
  }

  def earnMonthlyInterest = {
    transactionsInMonth = 0
    super.deposit(balance() * interestRateYear / 12)
  }
}

//task03
//abstract class Shape{
//  val name:String
//  override def toString = name
//}
//trait Drawable{
//  def draw() = println(toString)
//}
//class Point(val x:Int, val y:Int){
//  override def toString = "%d,%d".format(x,y)
//}
//object Point{
//  def apply(x:Int = 0, y:Int = 0) = new Point(x,y)
//}
//class Rectangle(val topLeft:Point, val bottomRight:Point) extends Shape with Drawable{
//  override val name = "Rectangle"
//  override def toString = {
//    "%s (%s - %s)".format(name,topLeft.toString,bottomRight.toString)
//  }
//}
//class Circle(val centre: Point, val radius:Int) extends Shape with Drawable{
//  override val  name = "Circle"
//  override def toString = {
//    "%s (%s: %d)".format(name, centre.toString,radius.toString)
//  }
//}
//task04
abstract class Item {
  def price: Double

  def description: String

  override def toString = "%s(%s: %f)".format(this.getClass.getSimpleName, description, price)
}

class SimpleItem(override val description: String, override val price: Double) extends Item

class Bundle extends Item {
  private var items: List[Item] = List()

  def add(item: Item) = {
    items = item :: items
  }

  def price: Double = items.map(_.price).sum

  def description: String = items.map(_.description).mkString(" ,")
}

//task05
class Point1(val x: Int, val y: Int) {
  override def toString = "%d,%d".format(x, y)
}

object Point1 {
  def apply(x: Int = 0, y: Int = 0) = new Point1(x, y)
}

class LabeledPoint(x: Int, y: Int, val description: String) extends Point1(x, y) {
  override def toString = {
    "LabeledPoint(%s, %d, %d)".format(description, x, y)
  }
}

object LabeledPoint {
  def apply(x: Int = 0, y: Int = 0, description: String) = new LabeledPoint(x, y, description)
}

//task06
abstract class Shape {
  val name: String

  override def toString = name

  def centerPoint: Point1
}

class Rectangle(val topLeft: Point1, val bottomRight: Point1) extends Shape {
  override def toString = {
    "%s (%s - %s)".format(name, topLeft.toString, bottomRight.toString)
  }

  override val name = "Rectangle"

  override def centerPoint: Point1 = Point1((bottomRight.x - topLeft.x) / 2, (topLeft.y - bottomRight.y) / 2)
}

class Circle(val centre: Point1, val radius: Int) extends Shape {
  override val name = "Circle"

  override def centerPoint: Point1 = centre

  override def toString = {
    "%s (%s: %d)".format(name, centre.toString, radius.toString)
  }
}

//task07

class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width) {
  def this() = this(0, 0, 0)

  def this(width: Int) = this(0, 0, width)
}

//task08
class Person(val name: String) {
  override def toString = getClass.getName + "[name=" + name + "]"
}

class SecretAgent(codename: String) extends Person(codename) {
  override val name = "Secret"
  override val toString = "secret"
}

//task09
class Creature {
  def range: Int = 10

  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override def range = 2
}

//def in overriding works like val, so it doesn't cause
//inititalization errors like 0