import scala.beans.BeanProperty

//class Person {
//  private var privateAge = 0
//
//  def age = privateAge
//
//  def age_=(newvalue: Int) = {
//    privateAge = newvalue
//  }
//
//}

//var fred = new Person
//fred.age = 30
//fred.age = 21

//class Counter {
//  private var value = 0
//  def increment() {value += 1}
//  def current = value
//  def isLess(other: Counter) = value < other.value
//}

//class Person {
//  private var name = ""
//  private var age = 0
//
//  def this(name : String){
//    this()
//    this name = name
//  }
//
//  def this (name:String, age: Int){
//    this(name)
//    this.age = age
//  }
//}
//
//
//var p1 = new Person()
//var p2 = new Person("Fred")
//var p3 = new Person("Fred", 42)


//class  Person(val name:String = "", val age:Int = 0){
//  println("Just constructed another person")
//  def description = name + " is "+ age + " years old"
//}
//
//import scala.collection.mutable.ArrayBuffer
//
//class  Network{
//  class Member(val name: String){
//    val contacts = new ArrayBuffer[Member]()
//  }
//
//  private val members = new ArrayBuffer[Member]()
//
//  def join(name: String) ={
//    val m = new Member(name)
//    members += m
//    m
//  }
//}
//
//var chatter = new Network
//var myFace = new Network
//
//var fred = chatter.join("Fred")
//var wilma = chatter.join("Wilma")
//fred.contacts += wilma
//val barney = myFace.join("Barney")

//task01
class Counter {
  private var value = 0

  def increment() {
    if (value < Int.MaxValue) value += 1
  }

  def current = value

  def isLess(other: Counter) = value < other.value
}

//task02
class BankAccount(private var _balance: Double) {


  def balance = _balance

  def deposit(money: Double) = _balance += money

  def withdraw(money: Double) = if (money < _balance) _balance -= money
}

val account = new BankAccount(0)
account.deposit(1000)
println(account.balance)
account.withdraw(999)
println(account.balance)

//task03
//class Time(private var _hours: Int, private var _minutes: Int) {
//  def hours = _hours
//
//  def minutes = _minutes
//
//  def before(other: Time): Boolean = {
//    (hours < other.hours) || (hours == other.hours && minutes < other.minutes)
//  }
//
//
//}
//
//val time = new Time(1,30)
//
//println(time.before(new Time(0,30)))
//task04
class Time(hours: Int, minutes: Int) {
  private val _time = hours * 60 + minutes

  def time = _time

  def before(other: Time): Boolean = {
    (time < other.time)
  }


}

val time = new Time(1, 30)

println(time.before(new Time(0, 30)))

//task05

class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {}


//task06
//class Person(var name:String = "",var age:Int = 0){
//  if(age < 0 ) age = 0
//}

//task07
class Person(name: String) {
  private var nameSurname = name.split(" ")
  private var _firstname = nameSurname(0)
  private var _lastname = nameSurname(1)

  def firstname = _firstname

  def lastname = _lastname

}

//task08
////with default constructor parameters
//class Car(val manufacturer: String, val modelName: String, val modelYear: Int = -1, val licenseId: String = "") {
//  def this(manufacturer: String, modelName: String) = {
//    this(manufacturer, modelName, -1, "")
//  }
//override def toString = {
//  "[" + manufacturer + ", " + modelName + ", " + modelYear + ", " + licenseId
//}
//}

//without default constructors
class Car(val manufacturer: String, val modelName: String, val modelYear: Int, var licenseId: String) {
  def this(manufacturer: String, modelName: String, licenseId: String) {
    this(manufacturer, modelName, -1, licenseId)
  }

  def this(manufacturer: String, modelName: String) {
    this(manufacturer, modelName, -1, "")
  }

  override def toString = {
    "[" + manufacturer + ", " + modelName + ", " + modelYear + ", " + licenseId
  }

}

//task10

class Employee() {
  private var _name: String = "John Q. Public"
  var _salary: Double = 0.0

  def this(name: String, salary: Double) = {
    this()
    _name = name
    _salary = salary
  }

  def salary = _salary

  def name = _name
}