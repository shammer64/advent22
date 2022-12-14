package dev.scotthammer.advent22.day10

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
    fun singleAddxCommandSignalStrengthIsOne() {
        val ss = SignalSensor(arrayOf<String>("addx 10"))

        assertEquals(22, ss.signalStrength)
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

}