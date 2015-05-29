val x = math.random
val s = if (x > 0) 1 else -1
for (i <- 1 to 10) yield i % 3
for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar
//task 1
def signum(parametr: Int): Int = {
  if (parametr > 0) 1 else if (parametr < 0) -1 else 0
}
signum(-1)
signum(10)
signum(0)

//task 2
var value = {}

//task 3
var y: Int = 0
var z: Unit = y = 1

//task 4
for (i <- 10 to(0, -1)) println(i)
//task 5
def countdown(n: Int): Unit = {
  for (i <- n to(0, -1)) println(i)
}

countdown(10)
//task 6
var multiplied = 1L
for (i <- "Hello") {
  multiplied *= i
}
multiplied

//task 7
"Hello".foldLeft(1L)((a, b) => a * b)

//task 8
def product(s: String) = s.foldLeft(1L)((a, b) => a * b)
product("Hello")

//task 9
def productRec(s: String): Long = {
  if (s.length == 0) 1
  else s(0) * productRec(s drop 1)
}

productRec("Hello")

//task 10
def xPowToN(x: BigInt, n: Int): BigInt = {
  if (n > 0 && n % 2 == 0) xPowToN(x, n / 2) * xPowToN(x, n / 2)
  else if (n > 0) x * xPowToN(x, n - 1)
  else if (n == 0) 1
  else 1 / xPowToN(x, -n)
}

xPowToN(2, 1024)