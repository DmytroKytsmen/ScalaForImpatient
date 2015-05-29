import java.io.File
import java.util
import java.util.Scanner

import scala.collection.mutable

val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
var score = scala.collection.mutable.Map("Alice" -> 10, "bob" -> 3, "Cindy" -> 8)
val scors = new mutable.HashMap[String, Int]
val bobsScore = scores("Bob")
val bobScore = if (scores.contains("Bob")) scores("Bob") else 0
val bosScore = scores.getOrElse("Bob", 0)
val newScores = scores +("Bob" -> 10, "Fred" -> 7)
for ((k, v) <- scores) println(k, v)
scores.keySet
for (v <- scores.values) println(v)
for ((k, v) <- scores) yield (v, k)
val tree = scala.collection.immutable.SortedMap("Alice" -> 10, "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8);
val months = scala.collection.mutable.LinkedHashMap("January" -> 1, "February" -> 2, "March" -> 3, "April" -> 4);
for ((k, v) <- months) println(k, v)

import scala.collection.JavaConversions.mapAsScalaMap

val goals: scala.collection.mutable.Map[String, Int] = new util.TreeMap[String, Int]

import scala.collection.JavaConversions.propertiesAsScalaMap

val props: scala.collection.Map[String, String] = System.getProperties()

import java.awt.font.TextAttribute._

import scala.collection.JavaConversions.mapAsJavaMap

val attrs = Map(FAMILY -> "Serif", SIZE -> 12)
val font = new java.awt.Font(attrs)
val t = (1, 3.14, "Fred")
val secondtest = t._2
val (first, second, third) = t
val (firsttest, secondtest2, _) = t
"New York".partition(_.isUpper)
var symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)
symbols.zip(counts).toMap
//task01
val prices = Map("Pizza" -> 40, "Coca-Cola" -> 10, "Oranges" -> 30)
val discountPrices = for ((k, v) <- prices) yield (k, v * 0.9)

//task02
//val in = new Scanner(new java.io.File("myfile.txt"));
//val mMap = new mutable.HashMap[String, Int]()
//def process(s:String) = {
//  val c = mMap.getOrElse(s, 0);
//  mMap(s) = c + 1
//}
//
//while (in.hasNext()) process(in.next())
//mMap


//task03
//var immutableMap = Map[String, Int]()
//
//def immutableProcess(s:String) = {
//  val c = immutableMap.getOrElse(s,0)
//  immutableMap += (s -> (c+1))
//}
//
//val in = new Scanner(new File(filename))
//while(in.hasNext()) immutableProcess(in.next())
//immutableMap

//task04
//
//var sortMap = scala.collection.immutable.SortedMap[String, Int]()
//
//def sortedProcess(s: String) = {
//  val c = sortMap.getOrElse(s, 0)
//  sortMap += (s -> (c + 1))
//}
//
//val in = new Scanner(new File(filename))
//while(in.hasNext()) sortedProcess(in.next())
//sortMap


//task05