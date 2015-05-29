import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}
import java.util
import java.util.Random
import scala.collection.mutable.ArrayBuffer
val nums = new Array[Int](10)
val s = Array("Hello", "World")
s(0) = "Goodbye"
val b = ArrayBuffer[Int]()
val a = new ArrayBuffer[Int]
b += 1
b +=(1, 2, 3, 5)
b ++= Array(8, 13, 21)
b.trimEnd(5)
b.insert(2, 6)
b.insert(2, 7, 8, 9)
b.remove(2)
b.remove(2, 2)
b.toBuffer
for (i <- 0 until b.length)
  print(i + ": " + b(i) + "\n")
//task01
val array = new Array[Int](10)
val newArray = for (i <- 0 until array.length) yield i

//task02
var array2 = Array(1,2,3,4,5)
var arrayshuffled = scala.util.Random.shuffle(array2.toSeq)

//task03
var shuffled = scala.util.Random.shuffle(arrayshuffled.toSeq)

//task04
var task = Array[Int](2,6,-1,9,0,-4,-6)
var positive = new ArrayBuffer[Int]
var negative = new ArrayBuffer[Int]
var zero = new ArrayBuffer[Int]
for(i <- 0 until  task.length){
  if (task(i) < 0) negative += i
  else if (task(i) > 0 ) positive += i
  else if (task(i) == 0) zero += i
}
print(positive, negative, zero)
var result = new ArrayBuffer[Int]
result ++= (for(i <- positive) yield task(i))
result ++= (for(i <- negative) yield task(i))
result ++= (for(i <- zero) yield task(i))
result.toArray
//task05
var task5 = Array[Double](1.0, 2.0, 3.0, 4.0 ,5.0)
var summary = task5.sum
var average = summary/task5.length
//task06
var task6result = result.sortWith(_ > _)
var taskresult = task5.sortWith(_ > _)
print(task6result.toArray.toString())
//task07
var task7 = Array[Int](4, 5,0 ,6 ,3,1,2 ,2,4,-3 ,5 ,2)
task7.distinct

//task08
var ab = ArrayBuffer[Int](2, 6, -1, 9, 0, -4, 6, -1, 8)
var indexes = (for (i <- 0 until a.length if a(i) < 0) yield i)

indexes = indexes.drop(1)
for (j <- indexes.reverse) ab.remove(j)

//task09
var timezones = java.util.TimeZone.getAvailableIDs().filter(_.startsWith("America/")).map((s) => s.stripPrefix("America/"))
timezones

var flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
var nativesForFlavors = flavors.getNativesForFlavors(Array(DataFlavor.imageFlavor))
val vals = collection.JavaConversions.asScalaBuffer(new util.LinkedList(nativesForFlavors.values()))