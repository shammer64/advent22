package dev.scotthammer.advent22.day3

object Day3App {
    @JvmStatic fun main(args: Array<String>) {
        val rucksacker = Rucksacker()
        var input: Array<String> = Day3App::class.java
            .getResourceAsStream("/day3_input.txt")
            .bufferedReader().readLines().toTypedArray()

        var sumOfPriorities: Long = 0
        for (rucksack in input) {
            val priority = rucksacker.findPriority(rucksack)
            priority?.let { sumOfPriorities += it }
        }
        println("Day 3, Answer 1: $sumOfPriorities")

        sumOfPriorities = 0
        for (i in input.indices step 3) {
            val priority = rucksacker.findBadgePriority(
                input[i], input[i + 1], input[i + 2]
            )
            priority?.let { sumOfPriorities += it }
        }
        println("Day 3, Answer 2: $sumOfPriorities")

    }
}