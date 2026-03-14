package it.unibo.pps.lab02

object Lab2 extends App:
  //Task 1, svolto da solo
  println("Hello, Scala")
  def divide(x: Double, y: Double): Double = x / y
  def divideCurried(x: Double)(y: Double): Double = x / y
  println(divide(10, 5)) //2.0
  println(divideCurried(10)(5)) //2.0
  val divideCurriedAsFunction: Double => Double => Double = x => y => x / y
  println(divideCurriedAsFunction(10)(5)) //2.0
  val divideTenBy: Double => Double = divideCurried(10)
  println(divideTenBy(5)) //2.0
  println(divideTenBy(2)) //5.0
  println(divideTenBy(0)) //infinity