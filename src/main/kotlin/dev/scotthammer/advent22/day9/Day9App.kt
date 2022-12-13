package dev.scotthammer.advent22.day9

import dev.scotthammer.advent22.AdventSolver

object Day9App {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = AdventSolver.parseInputFile("/day9_input.txt")

        val rm1 = RopeMotion(0, 0)
        for (instruction in input)
            rm1.move(instruction)
        println("Day 9, Answer1: ${rm1.visitedSet.size}")

        val rm2 = RopeMotion(0, 0, 9)
        for (instruction in input)
            rm2.move(instruction)
        println("Day 9, Answer2: ${rm2.visitedSet.size}")

    }
}