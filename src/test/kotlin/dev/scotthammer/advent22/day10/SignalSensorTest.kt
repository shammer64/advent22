package dev.scotthammer.advent22.day10

import dev.scotthammer.advent22.AdventSolver
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SignalSensorTest {

    @Test
    fun baseStateSignalStrengthIsZero() {
        val ss = SignalSensor(arrayOf<String>())

        assertEquals(0, ss.signalStrength)
    }

    @Test
    fun singleNoopCommandSignalStrengthIsOne() {
        val ss = SignalSensor(arrayOf<String>("noop"))

        assertEquals(1, ss.signalStrength)
    }

    @Test
    fun singleAddxCommandSignalStrengthIs22() {
        val ss = SignalSensor(arrayOf<String>("addx 10"))

        assertEquals(22, ss.signalStrength)
    }

    @Test
    fun twoAddxCommandSignalStrengthIsOne() {
        val ss = SignalSensor(arrayOf<String>("addx 10", "addx 7"))

        assertEquals(72, ss.signalStrength)
    }

    @Test
    fun multipleNoopCommandSignalStrengthIsOne() {
        var numNoops: Long = 2
        var noopArray = mutableListOf<String>()
        for (i in 0 until numNoops)
            noopArray.add("noop")
        val ss = SignalSensor(noopArray.toTypedArray())

        assertEquals(numNoops, ss.signalStrength)
    }

    @Test
    fun shouldReportSignalStrengthOn20thCycle() {
        val input = arrayOf(
            "addx 15", "addx -11", "addx 6", "addx -3",
            "addx 5", "addx -1", "addx -8", "addx 13",
            "addx 4", "noop", "addx -1",
        )
        val ss = SignalSensor(input)

        assertEquals(1, ss.getReport().size)
        assertEquals(420, ss.getReport()[0])
    }

    @Test
    fun shouldReportSignalStrengthTestInputsFile() {
        val input = AdventSolver.parseInputFile("/day10_test_input.txt")
        val ss = SignalSensor(input)

        assertEquals(6, ss.getReport().size)
        assertEquals(420, ss.getReport()[0])
        assertEquals(1140, ss.getReport()[1])
        assertEquals(1800, ss.getReport()[2])
        assertEquals(2940, ss.getReport()[3])
        assertEquals(2880, ss.getReport()[4])
        assertEquals(3960, ss.getReport()[5])
    }

}