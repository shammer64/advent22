package dev.scotthammer.advent22.day4

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SectionAnalyzerTest {

    @Test
    fun shouldNotReportContainmentWithNoOverlap() {
        val input = "2-4,6-8"
        val( range1: IntRange, range2: IntRange) = calcRanges(input)
        val analyzer = SectionAnalyzer()

        val oneContainsOther = analyzer.oneContainsOther(range1, range2)

        assertFalse(oneContainsOther)
    }

    @Test
    fun shouldNotReportContainmentWithPartialOverlap() {
        val input = "5-7,7-9"
        val( range1: IntRange, range2: IntRange) = calcRanges(input)
        val analyzer = SectionAnalyzer()

        val oneContainsOther = analyzer.oneContainsOther(range1, range2)

        assertFalse(oneContainsOther)
    }

    @Test
    fun shouldReportContainmentWithFullOverlap() {
        val input = "2-8,3-7"
        val( range1: IntRange, range2: IntRange) = calcRanges(input)
        val analyzer = SectionAnalyzer()

        val oneContainsOther = analyzer.oneContainsOther(range1, range2)

        assertTrue(oneContainsOther)
    }

    @Test
    fun shouldNotReportOverlapWithNoOverlap() {
        val input = "2-4,6-8"
        val( range1: IntRange, range2: IntRange) = calcRanges(input)
        val analyzer = SectionAnalyzer()

        val oneOverlapsOther = analyzer.oneOverlapsOther(range1, range2)

        assertFalse(oneOverlapsOther)
    }

    @Test
    fun shouldReportOverlapWithPartialOverlap() {
        val input = "5-7,7-9"
        val( range1: IntRange, range2: IntRange) = calcRanges(input)
        val analyzer = SectionAnalyzer()

        val oneOverlapsOther = analyzer.oneOverlapsOther(range1, range2)

        assertTrue(oneOverlapsOther)
    }

    @Test
    fun shouldReportOverlapWithFullOverlap() {
        val input = "2-8,3-7"
        val( range1: IntRange, range2: IntRange) = calcRanges(input)
        val analyzer = SectionAnalyzer()

        val oneOverlapsOther = analyzer.oneOverlapsOther(range1, range2)

        assertTrue(oneOverlapsOther)
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