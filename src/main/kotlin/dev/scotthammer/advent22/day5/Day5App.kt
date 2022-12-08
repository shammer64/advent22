package dev.scotthammer.advent22.day5

import dev.scotthammer.advent22.AdventSolver

object Day5App {

    @JvmStatic
    fun main(arguments: Array<String>) {
        val input1: Array<String> = AdventSolver.parseInputFile("/day5_input_1.txt")
        val input2: Array<String> = AdventSolver.parseInputFile("/day5_input_2.txt")

        val stacker = CrateStacker(input1)
        for (instruction in input2)
            stacker.move(instruction)

        var topStack = ""
        for (i in 1..stacker.stackCount()) {
            topStack += stacker.get(i)?.last() ?: ""
        }
        topStack = topStack.replace("[", "")
        topStack = topStack.replace("]", "")
        println("Day 5, Answer 1: $topStack")

        val stacker2 = CrateStacker(input1)
        for (instruction in input2)
            stacker2.moveMulti(instruction)

        topStack = ""
        for (i in 1..stacker2.stackCount()) {
            topStack += stacker2.get(i)?.last() ?: ""
        }
        topStack = topStack.replace("[", "")
        topStack = topStack.replace("]", "")
        println("Day 5, Answer 2: $topStack")

    }


}