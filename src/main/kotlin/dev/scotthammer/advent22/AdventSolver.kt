package dev.scotthammer.advent22

object AdventSolver {

    fun parseInputFile(inputFileName: String): Array<String> {
        return this::class.java
            .getResourceAsStream(inputFileName)
            .bufferedReader().readLines().toTypedArray()
    }
}



