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

}