package dev.scotthammer.advent22.day10

import dev.scotthammer.advent22.AdventSolver
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CathodeRayTubeTest {

    @Test
    fun baseStateSignalStrengthIsZero() {
        val crt = CathodeRayTube(arrayOf())

        assertEquals(0, crt.signalStrength)
    }

    @Test
    fun singleNoopCommandSignalStrengthIsOne() {
        val crt = CathodeRayTube(arrayOf("noop"))

        assertEquals(1, crt.signalStrength)
    }

    @Test
    fun singleAddxCommandSignalStrengthIs22() {
        val crt = CathodeRayTube(arrayOf("addx 10"))

        assertEquals(22, crt.signalStrength)
    }

    @Test
    fun twoAddxCommandSignalStrengthIsOne() {
        val crt = CathodeRayTube(arrayOf("addx 10", "addx 7"))

        assertEquals(72, crt.signalStrength)
    }

    @Test
    fun multipleNoopCommandSignalStrengthIsOne() {
        val crt = CathodeRayTube(arrayOf("noop", "noop"))

        assertEquals(2, crt.signalStrength)
    }

    @Test
    fun shouldReportSignalStrengthOn20thCycle() {
        val input = arrayOf(
            "addx 15", "addx -11", "addx 6", "addx -3",
            "addx 5", "addx -1", "addx -8", "addx 13",
            "addx 4", "noop", "addx -1",
        )
        val crt = CathodeRayTube(input)

        assertEquals(1, crt.getReports().size)
        assertEquals(420, crt.getReports()[0])
    }

    @Test
    fun shouldReportSignalStrengthTestInputsFile() {
        val input = AdventSolver.parseInputFile("/day10_test_input.txt")
        val crt = CathodeRayTube(input)

        assertEquals(6, crt.getReports().size)
        assertEquals(420, crt.getReports()[0])
        assertEquals(1140, crt.getReports()[1])
        assertEquals(1800, crt.getReports()[2])
        assertEquals(2940, crt.getReports()[3])
        assertEquals(2880, crt.getReports()[4])
        assertEquals(3960, crt.getReports()[5])
    }

    @Test
    fun firstThreePixelsShouldBeLit() {
        val crt = CathodeRayTube(arrayOf("noop", "noop", "noop"))

        val screen = crt.drawScreen()

        assertEquals("###", screen.substring(0, 3))
    }

    @Test
    fun secondThreePixelsShouldBeDark() {
        val crt = CathodeRayTube(arrayOf(
            "noop", "noop", "noop", 
            "noop", "noop", "noop"))

        val screen = crt.drawScreen()

        assertEquals("...", screen.substring(3, 6))
    }

    @Test
    fun pixelsAlternateInGroupsOfTwo() {
        val crt = CathodeRayTube(arrayOf(
            "addx 15", "addx -11", "addx 6",
            "addx -3", "addx 5", "addx -1"))

        val screen = crt.drawScreen()

        assertEquals("##..##..##..", screen)
    }

    @Test
    fun pixelsMatchTestExample() {
        val input = AdventSolver.parseInputFile("/day10_test_input.txt")
        val crt = CathodeRayTube(input)
        val expected = """
##..##..##..##..##..##..##..##..##..##..
###...###...###...###...###...###...###.
####....####....####....####....####....
#####.....#####.....#####.....#####.....
######......######......######......####
#######.......#######.......#######.....
""".trimStart()
        val screen = crt.drawScreen()

        assertEquals(expected, screen)
    }
}