package dev.scotthammer.advent22.day7

import dev.scotthammer.advent22.AdventSolver

object Day7App {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = AdventSolver.parseInputFile("/day7_input.txt")

        val fs = FileSystemExplorer(input)
        val directories1 = fs.directories().filter { it.size() <= 100000 }
        val sumOfSizes = directories1.sumOf { it.size() }
        // println(fs.toString())
        println("Day 7, Answer 1: $sumOfSizes")

        val usedSpace = fs.find("/")!!.size()
        val availableSpace = 70000000 - usedSpace
        val directories2 = fs.directories().filter { it.size() > (30000000 -availableSpace)}
        val smallestDir = directories2.minBy { it.size() }
        println("Day 7, Answer 2: $smallestDir.size()")
        println(smallestDir.size())
    }
}