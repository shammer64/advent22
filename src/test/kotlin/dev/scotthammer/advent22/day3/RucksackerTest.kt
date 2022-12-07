package dev.scotthammer.advent22.day3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RucksackerTest {

    @Test
    fun shouldFindDuplicateIn2CharacterString() {
        val input = "BB"
        val rucksacker = Rucksacker()

        val duplicate: Char? = rucksacker.findDuplicate(input)

        assertEquals('B', duplicate)
    }

    @Test
    fun shouldFindDuplicateIn14CharacterString() {
        val input = "aaaBaaacccBccc";
        val rucksacker = Rucksacker()

        val duplicate: Char? = rucksacker.findDuplicate(input)

        assertEquals('B', duplicate)
    }

    @Test
    fun shouldFindDuplicatesInSampleStrings() {
        val inputs = listOf<String>(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw",
        )
        val expectedDuplicates = listOf<Char>('p', 'L', 'P', 'v', 't', 's')
        val duplicates = mutableListOf<Char>()
        val rucksacker = Rucksacker()

        for (input in inputs) {
            val duplicate: Char? = rucksacker.findDuplicate(input)
            duplicate?.let { duplicates.add(it) }
        }

        assertEquals(expectedDuplicates, duplicates)
    }

    @Test
    fun shouldFindPriorityIn2CharacterUpperCaseString() {
        val input = "BB"
        val rucksacker = Rucksacker()

        val priority: Int? = rucksacker.findPriority(input)

        assertEquals(28, priority)
    }

    @Test
    fun shouldFindPriorityIn2CharacterLowerCaseString() {
        val input = "ee"
        val rucksacker = Rucksacker()

        val priority: Int? = rucksacker.findPriority(input)

        assertEquals(5, priority)
    }

    @Test
    fun shouldFindPrioritiesInSampleStrings() {
        val inputs = listOf<String>(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw",
        )
        val expectedPriorities = listOf<Int>(16, 38, 42, 22, 20, 19)
        val priorities = mutableListOf<Int>()
        val rucksacker = Rucksacker()

        for (input in inputs) {
            val priority: Int? = rucksacker.findPriority(input)
            priority?.let { priorities.add(it) }
        }

        assertEquals(expectedPriorities, priorities)
    }

    @Test
    fun shouldFindDuplicateBadgeAmong3Strings() {
        val input1 = "vJrwpWtwJgWrhcsFMMfFFhFp"
        val input2 = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"
        val input3 = "PmmdzqPrVvPwwTWBwg"
        val rucksacker = Rucksacker()

        val badge = rucksacker.findBadgeDuplicate(input1, input2, input3)

        assertEquals('r', badge)
    }

    @Test
    fun shouldFindDuplicateBadgePriorityAmong3Strings() {
        val input1 = "vJrwpWtwJgWrhcsFMMfFFhFp"
        val input2 = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"
        val input3 = "PmmdzqPrVvPwwTWBwg"
        val rucksacker = Rucksacker()

        val priority = rucksacker.findBadgePriority(input1, input2, input3)

        assertEquals(18, priority)
    }

}