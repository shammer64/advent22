package dev.scotthammer.advent22.day6

import dev.scotthammer.advent22.AdventSolver

object Day6App {
    @JvmStatic
    fun main(arguments: Array<String>) {
        val input: String = AdventSolver.parseInputFile("/day6_input.txt")[0]

        val marker = MarkerFinder.findMarker(input)
        println("Day 6, Answer 1: $marker")

        val message = MarkerFinder.findMessage(input)
        println("Day 6, Answer 2: $message")

    }
}