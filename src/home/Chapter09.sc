import java.io.PrintWriter

import scala.collection.mutable.ArrayBuffer

//import com.sun.java.util.jar.pack.Package.File

import scala.io.Source

var source = Source.fromFile("Chapter01.sc", "UTF-8")
var lineIterator = source.getLines().toArray


for (i <- lineIterator) println(i)
var lines = source.getLines.toArray
var contents = source.mkString
for (i <- contents) println(i)
var iter = source.buffered

val tokens = source.mkString.split("\\s+")
val numbers = for (w <- tokens) yield w.toDouble
val numberstwo = tokens.map(_.toDouble)

print("How old are you? ")
val age = scala.io.StdIn.readInt()

val source1 = Source.fromURL("http//horstmann.com", "UTF-8")
val source2 = Source.fromString("Hello, World!")
val source3 = Source.stdin


//val file = new File(filename)
//val in = new FileInputStream(file)
//val bytes = new Array[Byte](file.length.toInt)
//in.read(bytes)
//in.close()


val out = new PrintWriter("numbers.txt")
for (i <- 1 to 100) out.println(i)
out.close()

import java.io.File

def subdirs(dir: File): Iterator[File] = {
  val children = dir.listFiles.filter(_.isDirectory)
  children.toIterator ++ children.toIterator.flatMap(subdirs _)

}

@SerialVersionUID(42L) class Person extends Serializable

//task01
val out1 = new PrintWriter("new.txt")
val source33 = Source.fromFile("new.txt").getLines().toArray[String]
source33.reverse.foreach(out.println(_))
out.close()

//task02
//n = wide of column
var n = 10
val source34 = Source.fromFile("new.txt")
val out3 = new PrintWriter("new.txt")
val lines1 = source34.getLines().toArray
for (line <- lines1) {
  val mask = line.split( """\t""")
  for (oneline <- mask) out3.print(oneline + " " * (n - oneline.length))
  out3.println
}
out3.close()

//task03
for (line <- Source.fromFile("anyfile.txt").getLines)
  for (word <- line.split( """\s+""") if word.size > 12) println(word)

//task04 {
var numbers = Source.fromFile("Input.txt").mkString.split( """\s+""").map(_.toFloat)
println(numbers.sum)
println(numbers.max)
println(numbers.min)
println(numbers.sum / numbers.length)
}

//task05

for (i <- 0 to 20) {
  val first = math.pow(2, i).toInt.toString
  val second = math.pow(2, -i).toInt.toString
  println(first + " " * (10 - first.size) + second)
}

//task06 {
val file = Source.fromFile("input.txt").mkString
val regexParsed = """(?:\\"|.)*?""".r.findAllIn(file).toList
print(regexParsed)
}

//task07 {
val file = Source.fromFile("input.txt").mkString
val line = file.split( """-?(\d\.\d*|\.\d+)""").toList
for (string <- line) println("^" + string + "$")
}

//task08 {
val file = Source.fromURL("http://google.com").mkString
val regex = """<\s*?img\s+[^>]*s+src="(.*?)"\s:+[^>]*>""".r
for (regex(imgsource) <- regex.findAllIn(file)) println(imgsource)
}


//task09
import sys.process._
def getFileTree(f:File): Stream[File] = {
  f #:: (if (f.isDirectory) f.listFiles().toStream.flatMap(getFileTree) else Stream.empty)
}


//task10
class Person1(val name:String) extends Serializable{
  private val friends = new ArrayBuffer[Person1]()
  def friend(f : Person1): Unit = {
    friends += f
  }
  override def toString = "%s {%s}".format(name,friends.map(_.name).mkString)
}

object Person1{
  def apply(name :String) = new Person1(name)
}