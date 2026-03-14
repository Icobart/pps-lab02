package it.unibo.pps.lab02

object Lab2 extends App:
  // Task 1, svolto da solo
  println("Hello, Scala")
  def divide(x: Double, y: Double): Double = x / y
  def divideCurried(x: Double)(y: Double): Double = x / y
  println(divide(10, 5)) // 2.0
  println(divideCurried(10)(5)) // 2.0
  val divideCurriedAsFunction: Double => Double => Double = x => y => x / y
  println(divideCurriedAsFunction(10)(5)) //2.0
  val divideTenBy: Double => Double = divideCurried(10)
  println(divideTenBy(5)) // 2.0
  println(divideTenBy(2)) // 5.0
  println(divideTenBy(0)) // infinity

  def applyTwice(f: Int => Int, x: Int): Int = f(f(x))
  println(applyTwice(_ + 1, 10)) // 12
  println(applyTwice(_ * 5, 10)) // 250

  val divideHundred: (Double, Double => Double) => Double = (y, g) => g(y)
  val multHundred: (Double, Double => Double) => Double = (z, h) => h(z)
  def checkDivideOrMult(x: Double, f: Double => Double): Double = f(x) match
    case n if n >= 100 => divideHundred(n, _ / 100)
    case n => multHundred(n, _ * 100)
  println(checkDivideOrMult(40, _ * 20)) // 8.0
  println(checkDivideOrMult(8, _ * 5)) // 4000.0

  case class Point3D(x: Double, y: Double, z: Double)
  val point1: Point3D = Point3D(1, 2, 3)
  def flattenYZ(p: Point3D): Point3D = p match
    case Point3D(x, _, _) => Point3D(x, 0, 0)
  println(flattenYZ(point1)) // Point3D(1.0, 0.0, 0.0)

  // Task 2, svolto da solo
  // 3a
  val positiveVal: Int => String = _ match
    case x if x > 0 => "positive"
    case _ => "negative"
  println(positiveVal(10)) // positive
  println(positiveVal(-5)) // negative
  def positiveDef(x: Int): String = x match
    case n if n > 0 => "positive"
    case _ => "negative"
  println(positiveDef(10)) // positive
  println(positiveDef(-5)) // negative
  // 3b
  val negVal: (String => Boolean) => (String => Boolean) = f => !f(_)
  def negDef(f: String => Boolean): String => Boolean = !f(_)
  val empty: String => Boolean = _ == "" // predicate on strings
  val notEmpty = negDef(empty) // String => Boolean
  println(notEmpty("foo")) // true
  println(notEmpty("")) // false
  println(notEmpty("foo") && !notEmpty("")) // true
  // 4
  // val, non curried
  val p1: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z
  // val, curried
  val p2: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  // def, non curried
  def p3(x: Int, y: Int, z: Int): Boolean = x <= y && y == z
  // def, curried
  def p4(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
  println("\n"+"Task 2: 4")
  println(p1(1, 2, 2)) // true
  println(p2(1)(2)(2)) // true
  println(p3(1, 2, 2)) // true
  println(p4(1)(2)(3)) // false
  // 5
  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
  println("\n" + "Task 2: 5")
  println(compose(_ - 1, _ * 2)(5)) // 9

  // Task 3, svolto da solo
  // 7
  // standard recursion
  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1.0
    case n => base * power(base, n - 1)
  // tail recursion
  def powerTail(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def _power(e: Double, acc: Double): Double = e match
      case 0 => acc
      case n => _power(n - 1, acc * base)
    _power(exponent, 1.0)
  println("\n" + "Task 3: 7")
  println(power(2, 3)) // 8.0
  println(powerTail(5, 2)) // 25.0
  // 8
  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def _reverse(rem: Int, acc: Int): Int = rem match
      case 0 => acc
      case r => _reverse(rem / 10, rem % 10 + acc * 10)
    _reverse(n, 0)
  println("\n" + "Task 3: 8")
  println(reverseNumber(12345)) // 54321