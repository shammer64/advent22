package dev.scotthammer.advent22.day8

import dev.scotthammer.advent22.AdventSolver

object Day8App {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = AdventSolver.parseInputFile("/day8_input.txt")

        val tv = TreeVisibility(input)
        println("Day 8, Answer1: ${tv.visibleTrees()}")
        println("Day 8, Answer2: ${tv.maxScenicScore()}")
    }
}