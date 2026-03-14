package task4

import org.junit.Test
import org.junit.Assert.*
import it.unibo.pps.lab02.Lab2.Expr
import it.unibo.pps.lab02.Lab2.Expr.*

class ExprTest:

  @Test
  def testLiteralEvaluation(): Unit =
    val literalTest = 5
    val e: Expr = Literal(literalTest)
    assertEquals(literalTest, evaluate(e))

  @Test
  def testAddEvaluation(): Unit =
    val literalTestL = 10
    val literalTestR = 5
    val literalAdd = 15
    val e: Expr = Add(Literal(literalTestL), Literal(literalTestR))
    assertEquals(literalAdd, evaluate(e))

  @Test
  def testMultiplyEvaluation(): Unit =
    val literalTestL = 3
    val literalTestR = 12
    val literalMultiply = 36
    val e: Expr = Multiply(Literal(literalTestL), Literal(literalTestR))
    assertEquals(literalMultiply, evaluate(e))

  @Test
  def testComplexEvaluation(): Unit =
    val literalAddL = 2
    val literalAddR = 3
    val literalTestR = 5
    val literalComplex = 25
    val e: Expr = Multiply(Add(Literal(literalAddL), Literal(literalAddR)), Literal(literalTestR))
    assertEquals(literalComplex, evaluate(e))

  @Test
  def testShowEvaluation(): Unit =
    val literalAddL = 5
    val literalAddR = 10
    val literalTestR = 10
    val stringExpected = "((5 + 10) * 10)"
    val e: Expr = Multiply(Add(Literal(5), Literal(10)), Literal(10))
    assertEquals(stringExpected, show(e))