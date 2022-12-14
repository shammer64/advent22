package dev.scotthammer.advent22.day10

class SignalSensor(input: Array<String>) {
    private var cycle: Int = 0
    var register: Long = 1
    var signalStrength: Long = 0
        get() = calculateSignalStrength()

    init {
        for (command in input)
            cycle += 1
    }
    private fun calculateSignalStrength(): Long {
        return cycle * register
    }

}
