package task5

import org.junit.*
import org.junit.Assert.*
import it.unibo.pps.lab02.Lab2.OptionalInt
import it.unibo.pps.lab02.Lab2.OptionalInt.*

class OptionalIntTest:
  @Test def emptyOptionalShouldBeEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(OptionalInt.isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertFalse(OptionalInt.isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertEquals(0, OptionalInt.orElse(nonEmpty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(1, OptionalInt.orElse(empty, 1))

  /** Task 5: do test for map **/
  @Test def mapIntShouldTransformValueIfPresent(): Unit =
    val opt = OptionalInt.Just(5)
    assertEquals(OptionalInt.Just(6), mapInt(opt)(_ + 1))

  @Test def mapIntShouldReturnEmptyIfEmpty(): Unit =
    val opt = OptionalInt.Empty()
    assertEquals(OptionalInt.Empty(), mapInt(opt)(_ + 1))