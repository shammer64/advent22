package dev.scotthammer.advent22.day9

import org.junit.jupiter.api.Test
import java.awt.Point
import kotlin.test.assertEquals

class RopeMotionTest {

    @Test
    fun samePositionMoveRightTailStaysPut() {
        val rm = RopeMotion(0, 0)

        rm.move("R 1")

        assertEquals(Point(0, 0), rm.tailPos)
    }

    @Test
    fun samePositionMoveLeftTailStaysPut() {
        val rm = RopeMotion(0, 0)

        rm.move("L 1")

        assertEquals(Point(0, 0), rm.tailPos)
    }

    @Test
    fun samePositionMoveUpTailStaysPut() {
        val rm = RopeMotion(0, 0)

        rm.move("U 1")

        assertEquals(Point(0, 0), rm.tailPos)
    }

    @Test
    fun samePositionMoveDownTailStaysPut() {
        val rm = RopeMotion(0, 0)

        rm.move("D 1")

        assertEquals(Point(0, 0), rm.tailPos)
    }

    @Test
    fun leftOfHeadMoveRightTailMovesRight() {
        val rm = RopeMotion(0, 0)
        rm.move("R 1")

        rm.move("R 1")

        assertEquals(Point(1, 0), rm.tailPos)
    }

    @Test
    fun rightOfHeadMoveRightTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(1, 0)

        rm.move("R 1")

        assertEquals(Point(1, 0), rm.tailPos)
    }

    @Test
    fun aboveHeadMoveRightTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(0, 1)

        rm.move("R 1")

        assertEquals(Point(0, 1), rm.tailPos)
    }

    @Test
    fun belowHeadMoveRightTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(0, -1)

        rm.move("R 1")

        assertEquals(Point(0, -1), rm.tailPos)
    }

    @Test
    fun leftOfHeadMoveLeftTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(-1, 0)

        rm.move("L 1")

        assertEquals(Point(-1, 0), rm.tailPos)
    }

    @Test
    fun rightOfHeadMoveLeftTailMovesLeft() {
        val rm = RopeMotion(0, 0)
        rm.move("L 1")

        rm.move("L 1")

        assertEquals(Point(-1, 0), rm.tailPos)
    }

    @Test
    fun aboveHeadMoveLeftTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(0, 1)

        rm.move("L 1")

        assertEquals(Point(0, 1), rm.tailPos)
    }

    @Test
    fun belowHeadMoveLeftTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(0, -1)

        rm.move("L 1")

        assertEquals(Point(0, -1), rm.tailPos)
    }

    @Test
    fun belowHeadMoveUpTailMovesUp() {
        val rm = RopeMotion(0, 0)
        rm.move("U 1")

        rm.move("U 1")

        assertEquals(Point(0, 1), rm.tailPos)
    }

    @Test
    fun aboveHeadMoveUpTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(0, 1)

        rm.move("U 1")

        assertEquals(Point(0, 1), rm.tailPos)
    }

    @Test
    fun rightOfHeadMoveUpTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(1, 0)

        rm.move("U 1")

        assertEquals(Point(1, 0), rm.tailPos)
    }

    @Test
    fun leftOfHeadMoveUpTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(-1, 0)

        rm.move("U 1")

        assertEquals(Point(-1, 0), rm.tailPos)
    }

    @Test
    fun aboveHeadMoveDownTailMovesDown() {
        val rm = RopeMotion(0, 0)
        rm.move("D 1")

        rm.move("D 1")

        assertEquals(Point(0, -1), rm.tailPos)
    }

    @Test
    fun belowHeadMoveDownTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(0, -1)

        rm.move("D 1")

        assertEquals(Point(0, -1), rm.tailPos)
    }

    @Test
    fun rightOfHeadMoveDownTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(1, 0)

        rm.move("D 1")

        assertEquals(Point(1, 0), rm.tailPos)
    }

    @Test
    fun leftOfHeadMoveDownTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(-1, 0)

        rm.move("D 1")

        assertEquals(Point(-1, 0), rm.tailPos)
    }

    @Test
    fun southWestOfHeadMoveRightTailMovesDiagonally() {
        val rm = RopeMotion(0, 0)
        rm.move("U 1")

        rm.move("R 1")

        assertEquals(Point(0, 0), rm.tailPos)

    }

    @Test
    fun southEastOfHeadMoveRightTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(1, -1)

        rm.move("R 1")

        assertEquals(Point(1, -1), rm.tailPos)

    }

    @Test
    fun northWestOfHeadMoveRightTailMovesDiagonally() {
        val rm = RopeMotion(0, 0)
        rm.move("D 1")

        rm.move("R 1")

        assertEquals(Point(0, 0), rm.tailPos)
    }

    @Test
    fun northEastOfHeadMoveRightTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(1, 1)

        rm.move("R 1")

        assertEquals(Point(1, 1), rm.tailPos)
    }

    @Test
    fun southWestOfHeadMoveLeftTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(-1, -1)

        rm.move("L 1")

        assertEquals(Point(-1, -1), rm.tailPos)

    }

    @Test
    fun southEastOfHeadMoveLeftTailMovesDiagonally() {
        val rm = RopeMotion(0, 0)
        rm.move("U 1")

        rm.move("L 1")

        assertEquals(Point(0, 0), rm.tailPos)

    }

    @Test
    fun northWestOfHeadMoveLeftTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(-1, 1)

        rm.move("L 1")

        assertEquals(Point(-1, 1), rm.tailPos)
    }

    @Test
    fun northEastOfHeadMoveLeftTailMovesDiagonally() {
        val rm = RopeMotion(0, 0)
        rm.move("D 1")

        rm.move("L 1")

        assertEquals(Point(0, 0), rm.tailPos)
    }

    @Test
    fun southWestOfHeadMoveUpTailMovesDiagonally() {
        val rm = RopeMotion(0, 0)
        rm.move("R 1")

        rm.move("U 1")

        assertEquals(Point(0, 0), rm.tailPos)

    }

    @Test
    fun southEastOfHeadMoveUpTailMovesDiagonally() {
        val rm = RopeMotion(0, 0)
        rm.move("L 1")

        rm.move("U 1")

        assertEquals(Point(0, 0), rm.tailPos)

    }

    @Test
    fun northWestOfHeadMoveUpTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(-1, 1)

        rm.move("U 1")

        assertEquals(Point(-1, 1), rm.tailPos)
    }

    @Test
    fun northEastOfHeadMoveUpTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(1, 1)

        rm.move("U 1")

        assertEquals(Point(1, 1), rm.tailPos)
    }

    @Test
    fun southWestOfHeadMoveDownTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(-1, -1)

        rm.move("D 1")

        assertEquals(Point(-1, -1), rm.tailPos)

    }

    @Test
    fun southEastOfHeadMoveDownTailStaysPut() {
        val rm = RopeMotion(0, 0)
        rm.tailPos = Point(1, -1)

        rm.move("D 1")

        assertEquals(Point(1, -1), rm.tailPos)

    }

    @Test
    fun northWestOfHeadMoveDownTailMovesDiagonally() {
        val rm = RopeMotion(0, 0)
        rm.move("R 1")

        rm.move("D 1")

        assertEquals(Point(0, 0), rm.tailPos)
    }

    @Test
    fun northEastOfHeadMoveDownTailMovesDiagonally() {
        val rm = RopeMotion(0, 0)
        rm.move("L 1")

        rm.move("D 1")

        assertEquals(Point(0, 0), rm.tailPos)
    }

    @Test
    fun moveRightMultipleMovesTail() {
        val rm = RopeMotion(0, 0)

        rm.move("R 3")

        assertEquals(Point(3, 0), rm.headPos)
        assertEquals(Point(2, 0), rm.tailPos)
    }

    @Test
    fun moveLeftMultipleMovesTail() {
        val rm = RopeMotion(0, 0)

        rm.move("L 3")

        assertEquals(Point(-3, 0), rm.headPos)
        assertEquals(Point(-2, 0), rm.tailPos)
    }

    @Test
    fun moveUpMultipleMovesTail() {
        val rm = RopeMotion(0, 0)

        rm.move("U 3")

        assertEquals(Point(0, 3), rm.headPos)
        assertEquals(Point(0, 2), rm.tailPos)
    }

    @Test
    fun moveDownMultipleMovesTail() {
        val rm = RopeMotion(0, 0)

        rm.move("D 3")

        assertEquals(Point(0, -3), rm.headPos)
        assertEquals(Point(0, -2), rm.tailPos)
    }

    @Test
    fun northWestMoveLeftMultipleMovesTail() {
        val rm = RopeMotion(0, 0)

        rm.move("D 3")

        assertEquals(Point(0, -3), rm.headPos)
        assertEquals(Point(0, -2), rm.tailPos)
    }

    @Test
    fun exampleMovesTailToAppropriatePlace() {
        val rm = RopeMotion(0, 0)
        val instructions = listOf<String>(
            "R 4", "U 4", "L 3", "D 1",
            "R 4", "D 1", "L 5", "R 2")

        for (instruction in instructions)
            rm.move(instruction)

        assertEquals(Point(2, 2), rm.headPos)
        assertEquals(Point(1, 2), rm.tailPos)
        assertEquals(13, rm.visitedSet.size)
    }

    @Test
    fun multiTailExampleOneMovesTailToAppropriatePlace() {
        val rm = RopeMotion(0, 0, 9)
        val instructions = listOf<String>(
            "R 4", "U 4", "L 3", "D 1",
            "R 4", "D 1", "L 5", "R 2")

        for (instruction in instructions)
            rm.move(instruction)

        assertEquals(Point(2, 2), rm.headPos)
        assertEquals(Point(0, 0), rm.tailPos)
        assertEquals(1, rm.visitedSet.size)
    }

    @Test
    fun multiTailExampleTwoMovesTailToAppropriatePlace() {
        val rm = RopeMotion(11, 5, 9)
        val instructions = listOf<String>(
            "R 5", "U 8", "L 8", "D 3",
            "R 17", "D 10", "L 25", "U 20",
        )

        for (instruction in instructions)
            rm.move(instruction)

        assertEquals(Point(0, 20), rm.headPos)
        assertEquals(Point(0, 11), rm.tailPos)
        assertEquals(36, rm.visitedSet.size)
    }
}