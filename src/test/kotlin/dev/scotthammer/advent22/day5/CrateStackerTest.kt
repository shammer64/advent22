package dev.scotthammer.advent22.day5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail

class CrateStackerTest {

    @Test
    fun shouldInitWithSingleEmptyStack() {
        val input = arrayOf(" 1 ")
        val stacker = CrateStacker(input)

        stacker.get(1)?.let { assertTrue(it.isEmpty()) } ?: fail("Oh shit!")
    }

    @Test
    fun shouldInitWithSingleOneItemStack() {
        val input = arrayOf("[A] ", " 1 ")
        val stacker = CrateStacker(input)

        stacker.get(1)?.let {
            assertFalse(it.isEmpty())
            assertEquals("[A]", it.last())
        } ?: fail("Oh shit!")
    }

    @Test
    fun shouldInitWithTwoOneItemStacks() {
        val input = arrayOf("[A] [B]", " 1   2")
        val stacker = CrateStacker(input)

        stacker.get(1)?.let {
            assertFalse(it.isEmpty())
            assertEquals("[A]", it.last())
        } ?: fail("Oh shit!")
        stacker.get(2)?.let {
            assertFalse(it.isEmpty())
            assertEquals("[B]", it.last())
        } ?: fail("Oh shit!")
    }

    @Test
    fun shouldInitWithTwoOneItemStacksWithDuplicates() {
        val input = arrayOf("[A] [A]", " 1   2")
        val stacker = CrateStacker(input)

        stacker.get(1)?.let {
            assertFalse(it.isEmpty())
            assertEquals(1, it.size)
            assertEquals("[A]", it.last())
        } ?: fail("Oh shit!")
        stacker.get(2)?.let {
            assertFalse(it.isEmpty())
            assertEquals(1, it.size)
            assertEquals("[A]", it.last())
        } ?: fail("Oh shit!")
    }

    @Test
    fun shouldInitWithTwoDifferentSizedStacks() {
        val input = arrayOf("    [F]", "    [E]", "[C] [D]", "[A] [B]", " 1   2")
        val stacker = CrateStacker(input)

        stacker.get(1)?.let {
            assertFalse(it.isEmpty())
            assertEquals(2, it.size)
            assertEquals("[C]", it.last())
        } ?: fail("Oh shit!")
        stacker.get(2)?.let {
            assertFalse(it.isEmpty())
            assertEquals(4, it.size)
            assertEquals("[F]", it.last())
        } ?: fail("Oh shit!")
    }

    @Test
    fun shouldInitWithExample() {
        val input = arrayOf("    [D]    ", "[N] [C]    ", "[Z] [M] [P]", " 1   2   3 ")
        val stacker = CrateStacker(input)

        stacker.get(1)?.let {
            assertFalse(it.isEmpty())
            assertEquals(2, it.size)
            assertEquals("[N]", it.last())
        } ?: fail("Oh shit!")
        stacker.get(2)?.let {
            assertFalse(it.isEmpty())
            assertEquals(3, it.size)
            assertEquals("[D]", it.last())
        } ?: fail("Oh shit!")
        stacker.get(3)?.let {
            assertFalse(it.isEmpty())
            assertEquals(1, it.size)
            assertEquals("[P]", it.last())
        } ?: fail("Oh shit!")
    }

    @Test
    fun shouldMoveItemFromStack2ToStack1() {
        val input = arrayOf("    [D]    ", "[N] [C]    ", "[Z] [M] [P]", " 1   2   3 ")
        val stacker = CrateStacker(input)

        stacker.move("move 1 from 2 to 1")

        stacker.get(1)?.let {
            assertFalse(it.isEmpty())
            assertEquals(3, it.size)
            assertEquals("[D]", it.last())
        } ?: fail("Oh shit!")
        stacker.get(2)?.let {
            assertFalse(it.isEmpty())
            assertEquals(2, it.size)
            assertEquals("[C]", it.last())
        } ?: fail("Oh shit!")
    }

    @Test
    fun shouldExecuteTwoMoves() {
        val input = arrayOf("    [D]    ", "[N] [C]    ", "[Z] [M] [P]", " 1   2   3 ")
        val stacker = CrateStacker(input)

        stacker.move("move 1 from 2 to 1")
        stacker.move("move 3 from 1 to 3")

        stacker.get(1)?.let {
            assertTrue(it.isEmpty())
        } ?: fail("Oh shit!")
        stacker.get(2)?.let {
            assertFalse(it.isEmpty())
            assertEquals(2, it.size)
            assertEquals("[C]", it.last())
        } ?: fail("Oh shit!")
        stacker.get(3)?.let {
            assertFalse(it.isEmpty())
            assertEquals(4, it.size)
            assertEquals("[Z]", it.last())
        } ?: fail("Oh shit!")
    }

    @Test
    fun shouldExecuteFourMoves() {
        val input = arrayOf("    [D]    ", "[N] [C]    ", "[Z] [M] [P]", " 1   2   3 ")
        val stacker = CrateStacker(input)

        stacker.move("move 1 from 2 to 1")
        stacker.move("move 3 from 1 to 3")
        stacker.move("move 2 from 2 to 1")
        stacker.move("move 1 from 1 to 2")

        stacker.get(1)?.let {
            assertFalse(it.isEmpty())
            assertEquals(1, it.size)
            assertEquals("[C]", it.last())
        } ?: fail("Oh shit!")
        stacker.get(2)?.let {
            assertFalse(it.isEmpty())
            assertEquals(1, it.size)
            assertEquals("[M]", it.last())
        } ?: fail("Oh shit!")
        stacker.get(3)?.let {
            assertFalse(it.isEmpty())
            assertEquals(4, it.size)
            assertEquals("[Z]", it.last())
        } ?: fail("Oh shit!")
    }

    @Test
    fun shouldGiveStackCount() {
        val input = arrayOf("    [D]    ", "[N] [C]    ", "[Z] [M] [P]", " 1   2   3 ")
        val stacker = CrateStacker(input)

        assertEquals(3, stacker.stackCount())
    }

    @Test
    fun shouldExecuteMultiMoves() {
        val input = arrayOf("    [D]    ", "[N] [C]    ", "[Z] [M] [P]", " 1   2   3 ")
        val stacker = CrateStacker(input)

        stacker.moveMulti("move 1 from 2 to 1")
        stacker.moveMulti("move 3 from 1 to 3")

        stacker.get(1)?.let {
            assertTrue(it.isEmpty())
        } ?: fail("Oh shit!")
        stacker.get(2)?.let {
            assertFalse(it.isEmpty())
            assertEquals(2, it.size)
            assertEquals("[C]", it.last())
        } ?: fail("Oh shit!")
        stacker.get(3)?.let {
            assertFalse(it.isEmpty())
            assertEquals(4, it.size)
            assertEquals("[D]", it.last())
        } ?: fail("Oh shit!")
    }


}