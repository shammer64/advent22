package dev.scotthammer.advent22.day10

class SignalSensor(input: Array<String>) {
    private var cycle: Int = 0
    private var register: Long = 1
    val signalStrength: Long
        get() = calculateSignalStrength()
    private val reportList = mutableListOf<Long>()

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
        if (cycle % 40 == 20)
            reportList.add(this.signalStrength)
    }

    private fun calculateSignalStrength(): Long {
        return cycle * register
    }

    fun getReports(): List<Long> {
        return reportList
    }

}
