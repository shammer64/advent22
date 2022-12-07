package dev.scotthammer.advent22.day4

class SectionAnalyzer {
    fun oneContainsOther(range1: IntRange, range2: IntRange): Boolean {
        val intersect = range1.toSet().intersect(range2.toSet())
        return intersect == range1.toSet() || intersect == range2.toSet()
    }

    fun oneOverlapsOther(range1: IntRange, range2: IntRange): Boolean {
        val intersect = range1.toSet().intersect(range2.toSet())
        return intersect.isNotEmpty();
    }

}
