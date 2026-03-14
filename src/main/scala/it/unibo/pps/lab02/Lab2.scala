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
  val p1: Point3D = Point3D(1, 2, 3)
  def flattenYZ(p: Point3D): Point3D = p match
    case Point3D(x, _, _) => Point3D(x, 0, 0)
  println(flattenYZ(p1)) // Point3D(1.0, 0.0, 0.0)

  // Task 2, svolto da solo
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