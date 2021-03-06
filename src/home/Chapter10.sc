//trait Logger {
//  def log(msg: String)
//}

//
//class ConsoleLogger extends Logger with Cloneable with Serializable{
//  def log(msg: String){println(msg)}
//}

//trait ConsoleLogger {
//  def log(msg: String): Unit = {
//    println(msg)
//  }
//}

//trait FileLogger extends Logger {
//  val filename: String
//  val out = new PrintStream(filename)
//
//  def log(msg: String) = {
//    out.println(msg);
//    out.flush()
//  }
//}
//
//trait LoggedException extends Exception with Logged {
//  def log() {
//
//  }
//}

//task01
trait RectangleLike {
  def translate(dx: Double, dy: Double) = {
    setFrame(getX() + dx, getY() + dy, getWidth(), getHeight())
  }

  def grow(dx: Double, dy: Double) = {
    setFrame(getX() - dx, getY() - dy, getWidth() + 2 * dx, getHeight() + 2 * dy)
  }

  def getX(): Double

  def getY(): Double

  def getWidth(): Double

  def getHeight(): Double

  def setFrame(x: Double, y: Double, width: Double, height: Double)
}

val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
println(egg)
egg.translate(20, -20)
println(egg)
egg.grow(10, 20)
println(egg)
//task02

import java.awt.Point
import java.beans.PropertyChangeEvent

class OrderedPoint(x: Int, y: Int) extends Point(x, y) with math.Ordered[Point] {
  def compare(that: Point): Int = {
    if (this.x <= that.x) {
      if (this.x == that.x) {
        if (this.y < that.y) -1
        else if (this.y > that.y) 1
        else 0
      } else -1
    } else 1
  }

  override def toString = "[" + getX + " " + getY + "]"
}

val x1 = new OrderedPoint(1, 1)
val x2 = new OrderedPoint(1, -1)
val x3 = new OrderedPoint(2, 1)
println(x1 < x2)
println(x1 > x2)
println(x1 >= x3)

//task04
trait Logger {
  def log(msg: String) = {}
}

trait ConsoleLogger extends Logger {
  override def log(msg: String) = println(msg)
}

trait CasearLogger extends Logger {
  val shift: Int = 3

  override def log(msg: String) = {
    super.log((for (x <- msg) yield (x + shift).toChar).mkString)
    super.log(msg.map((x: Char) => (x + shift).toChar).mkString)
  }
}

class Sample extends Logger {
  def doSmt() = {
    log("Some Log Message")
  }
}

val newInstance = new Sample with CasearLogger
newInstance.doSmt()

val newInstance2 = new Sample with ConsoleLogger with CasearLogger
newInstance2.doSmt()
val newInstance3 = new {
  override val shift = -3
} with Sample with ConsoleLogger with CasearLogger
newInstance3.doSmt()

//task05

import java.beans.{PropertyChangeListener, PropertyChangeSupport}

trait PropertyChangeSupportLike {
  private val support = new PropertyChangeSupport(this)

  def addPropertyChangeListener(listener: PropertyChangeListener): Unit = {
    support.addPropertyChangeListener(listener)
  }

  def addPropertyChangeListener(propertyName: String, listener: PropertyChangeListener): Unit = {
    support.addPropertyChangeListener(propertyName, listener)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Boolean, newValue: Boolean): Unit = {
    support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Int, newValue: Int): Unit = {
    support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Object, newValue: Object): Unit = {
    support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

  def firePropertyChange(evt: PropertyChangeEvent): Unit = {
    support.firePropertyChange(evt)
  }

  def firePropertyChange(propertyName: String, oldValue: Boolean, newValue: Boolean): Unit = {
    support.firePropertyChange(propertyName, oldValue, newValue)
  }

  def filePropertyChange(propertyName: String, oldValue: Object, newValue: Object): Unit = {
    support.firePropertyChange(propertyName, oldValue, newValue)
  }

  def getPropertyChangeListeners(): Array[PropertyChangeListener] = support.getPropertyChangeListeners()

  def getPropertyChangeListeners(propertyName: String): Array[PropertyChangeListener] = support.getPropertyChangeListeners(propertyName)

  def hasListeners(propertyName: String): Boolean = support.hasListeners(propertyName)

  def removePropertyChangeListener(listener: PropertyChangeListener) = support.removePropertyChangeListener(listener)

}

class BeansPoint(x: Int, y: Int, listener: () => ()) extends java.awt.Point(x, y) with PropertyChangeSupportLike {
  def this() = this(0, 0)
}

val x = new BeansPoint()

//task07

trait Animal {
  val name: String

  def sound: String = ""

  def say = println("%s: %s".format(name, sound))
}

trait Endothermy

trait Hypothermy

trait Mammal extends Animal with Endothermy

class Dog extends Mammal {
  val name = "Sharik"
  override val sound = "Gav-Gav"
}

class Cat extends Mammal {
  val name = "Murzik"
  override val sound = "Meow"

  override def say: Unit = {
    print("Cat: %s".format(name));
    super.say
  }
}


//task08&09
package {

  trait Logger {
    def log(message: String)
  }

  trait NoneLogger extends Logger

}