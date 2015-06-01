//
//
////task01
//package com {
//package horstmann {
//
//object Utils1 {
//  def percentOf(value: Double, rate: Double) = value * rate / 100
//}
//package impatient {
//
//class Employee1 {
//  def raise(salary: Double, rate: Double) = salary * Utils1.percentOf(salary, rate)
//}
//
//}
//
//}
//
//}
//
//class Manager1 {
//  def raise(salary: Double, rate: Double) =
//    salary * com.horstmann.Utils1.percentOf(salary, rate) 	// Can't refer to Utils directly
//}
//task03
//package object random{
//  private var next = 1
//  def nextInt:Int = {next = (next * 1664525 + 1013904223) % math.pow(2, 32).toInt; next}
//  def nextDouble: Double = nextInt
//  def setSeed(seed :Int) = {next = seed}
//}
//
//package random{
//
//}
//import random._
////task06
import java.util.{HashMap => JavaMap}
import scala.collection.mutable.{HashMap => ScalaMap}

object HashMap extends App{
  val javaMap = new JavaMap[String,String]
  javaMap.put("1", "First")
  javaMap.put("2", "Second")
  javaMap.put("3", "Third")

  var scalaMap = new ScalaMap[String, String]

  val iterator = javaMap.entrySet().iterator()
  while  (iterator.hasNext()){
    val entryValue = iterator.next()
    scalaMap += ((entryValue.getKey(),entryValue.getValue()))
  }

  println(scalaMap)
}

//task07
object HashMap1 extends App{
  import java.util.{HashMap => JavaMap}
  import scala.collection.mutable.{HashMap => ScalaMap}
  val javaMap = new JavaMap[String,String]
  javaMap.put("1", "First")
  javaMap.put("2", "Second")
  javaMap.put("3", "Third")

  var scalaMap = new ScalaMap[String, String]

  val iterator = javaMap.entrySet().iterator()
  while  (iterator.hasNext()){
    val entryValue = iterator.next()
    scalaMap += ((entryValue.getKey(),entryValue.getValue()))
  }

  println(scalaMap)
}

//task09
import java.lang.System

object Greeting extends App{
  val username = System.getProperty("user.name")
  print("Password for " + username + ": " )
  val password = Console.readLine()
  if (password.length() < 10) System.out.println("Hello" + username)
  else System.err.println("Invalid password")
}