package dev.scotthammer.advent22.day3

class Rucksacker {
    fun findDuplicate(rucksack: String): Char? {
        val len = rucksack.length
        val compartment1 = rucksack.slice(0 until len/2)
        val compartment2 = rucksack.slice(len/2 until len)

        val intersect = compartment1.toSet().intersect(compartment2.toSet())
        return intersect.elementAtOrNull(0)
    }

    fun findPriority(rucksack: String): Int? {
        val duplicate: Char? = findDuplicate(rucksack)
        duplicate?.let {
            return calculatePriority(it)
        }
        return 0
    }

    private fun calculatePriority(it: Char): Int? {
        return when (it.isUpperCase()) {
            true -> 27 + it.minus('A')
            false -> 1 + it.minus('a')
        }
    }

    fun findBadgeDuplicate(rucksack1: String, rucksack2: String, rucksack3: String): Char? {
        val intersect = rucksack1.toSet()
            .intersect(rucksack2.toSet())
            .intersect(rucksack3.toSet())
        return intersect.elementAtOrNull(0)
    }

    fun findBadgePriority(rucksack1: String, rucksack2: String, rucksack3: String): Int? {
        val badge = findBadgeDuplicate(rucksack1, rucksack2, rucksack3)
        return badge?.let { calculatePriority(it) }
    }

}
