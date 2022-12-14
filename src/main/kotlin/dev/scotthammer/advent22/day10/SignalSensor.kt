package dev.scotthammer.advent22.day10

class SignalSensor(input: Array<String>) {
    private var cycle: Int = 0
    var register: Long = 1
    var signalStrength: Long = 0
        get() = calculateSignalStrength()

    init {
        for (command in input) {
            when (command[0]) {
                'n' -> {
                    cycle += 1
                }

                'a' -> {
                    cycle += 1
                    cycle += 1
                    val increment = command.substring(5).toLong()
                    register += increment
                }

                else -> {}
            }
        }
    }

    private fun calculateSignalStrength(): Long {
        return cycle * register
    }

}
