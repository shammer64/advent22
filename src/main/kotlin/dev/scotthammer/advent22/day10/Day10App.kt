package dev.scotthammer.advent22.day10

import dev.scotthammer.advent22.AdventSolver

object Day10App {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = AdventSolver.parseInputFile("/day10_input.txt")

        val crt = CathodeRayTube(input)
        val reports = crt.getReports()
        val total = reports.sum()
        println("Day 10, Answer 1: $total")

        val crt2 = CathodeRayTube(input)
        println("Day 10, Answer 2:")
        println(crt2.drawScreen())

    }
}