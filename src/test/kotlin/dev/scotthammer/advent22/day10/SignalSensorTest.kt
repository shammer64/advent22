package dev.scotthammer.advent22.day10

import dev.scotthammer.advent22.AdventSolver
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SignalSensorTest {

    @Test
    fun baseStateSignalStrengthIsZero() {
        val ss = SignalSensor(arrayOf())

        assertEquals(0, ss.signalStrength)
    }

    @Test
    fun singleNoopCommandSignalStrengthIsOne() {
        val ss = SignalSensor(arrayOf("noop"))

        assertEquals(1, ss.signalStrength)
    }

    @Test
    fun singleAddxCommandSignalStrengthIs22() {
        val ss = SignalSensor(arrayOf("addx 10"))

        assertEquals(22, ss.signalStrength)
    }

    @Test
    fun twoAddxCommandSignalStrengthIsOne() {
        val ss = SignalSensor(arrayOf("addx 10", "addx 7"))

        assertEquals(72, ss.signalStrength)
    }

    @Test
    fun multipleNoopCommandSignalStrengthIsOne() {
        val ss = SignalSensor(arrayOf("noop", "noop"))

        assertEquals(2, ss.signalStrength)
    }

    @Test
    fun shouldReportSignalStrengthOn20thCycle() {
        val input = arrayOf(
            "addx 15", "addx -11", "addx 6", "addx -3",
            "addx 5", "addx -1", "addx -8", "addx 13",
            "addx 4", "noop", "addx -1",
        )
        val ss = SignalSensor(input)

        assertEquals(1, ss.getReports().size)
        assertEquals(420, ss.getReports()[0])
    }

    @Test
    fun shouldReportSignalStrengthTestInputsFile() {
        val input = AdventSolver.parseInputFile("/day10_test_input.txt")
        val ss = SignalSensor(input)

        assertEquals(6, ss.getReports().size)
        assertEquals(420, ss.getReports()[0])
        assertEquals(1140, ss.getReports()[1])
        assertEquals(1800, ss.getReports()[2])
        assertEquals(2940, ss.getReports()[3])
        assertEquals(2880, ss.getReports()[4])
        assertEquals(3960, ss.getReports()[5])
    }

}