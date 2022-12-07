package dev.scotthammer.advent22.day4

object Day4App {
    @JvmStatic
    fun main(args: Array<String>) {
        var inputs: Array<String> = Day4App::class.java
            .getResourceAsStream("/day4_input.txt")
            .bufferedReader().readLines().toTypedArray()
        val analyzer = SectionAnalyzer()

        var overlapCount = 0
        for (input in inputs) {
            val( range1: kotlin.ranges.IntRange, range2: kotlin.ranges.IntRange) = calcRanges(input)
            if (analyzer.oneContainsOther(range1, range2))
                overlapCount += 1
        }
        println("Day 4, Answer 1: $overlapCount")

        overlapCount = 0
        for (input in inputs) {
            val( range1: kotlin.ranges.IntRange, range2: kotlin.ranges.IntRange) = calcRanges(input)
            if (analyzer.oneOverlapsOther(range1, range2))
                overlapCount += 1
        }
        println("Day 4, Answer 2: $overlapCount")
    }

    private fun calcRanges(input: String): Pair<IntRange, IntRange> {
        val ranges = input.split(",")
        val range1 = ranges[0].split("-")
        val range2 = ranges[1].split("-")
        return Pair(
            IntRange(range1[0].toInt(),range1[1].toInt()),
            IntRange(range2[0].toInt(),range2[1].toInt())
        )
    }
}