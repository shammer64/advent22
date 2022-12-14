package dev.scotthammer.advent22.day10

import java.lang.Math.abs

class CathodeRayTube(input: Array<String>) {
    private var cycle: Int = 0
    private var register: Long = 1
    val signalStrength: Long
        get() = calculateSignalStrength()
    private val reportList = mutableListOf<Long>()
    private val screen = mutableListOf<Char>()


    init {
        for (command in input) {
            when (command[0]) {
                'n' -> {
                    incrementCycle()
                }
                'a' -> {
                    incrementCycle()
                    incrementCycle()
                    val increment = command.substring(5).toLong()
                    register += increment
                }
                else -> {}
            }
        }
    }

    private fun incrementCycle() {
        cycle += 1
        drawPixel(cycle)
        if (cycle % 40 == 20)
            reportList.add(this.signalStrength)
    }

    private fun drawPixel(cycle: Int) {
        val pixel = (cycle - 1) % 40
        if (kotlin.math.abs(register - pixel) <= 1)
            screen.add(Companion.PIXEL_LIT)
        else
            screen.add(Companion.PIXEL_DARK)
    }

    private fun calculateSignalStrength(): Long {
        return cycle * register
    }

    fun getReports(): List<Long> {
        return reportList
    }

    fun drawScreen(): String {
        val drawnScreen = StringBuilder()
        var cycle = 1
        for (pixel in screen) {
            drawnScreen.append(pixel)
            if (cycle % 40 == 0)
                drawnScreen.append("\n")
            cycle += 1
        }
        return drawnScreen.toString()
    }

    companion object {
        private const val PIXEL_DARK: Char = '.'
        private const val PIXEL_LIT: Char = '#'
    }

}
