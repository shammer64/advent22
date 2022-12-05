package dev.scotthammer.advent22.day1

class CaloriesCalc(private val input: Array<String>) {
    private var elves = mutableSetOf<Elf>();
    private var sortedElves = mutableListOf<Elf>()
    init {
        var currElfNum: Long = 1
        var currElf: Elf = Elf(currElfNum, 0)
        for (item in input) {
            if (item.isEmpty()) {
                currElfNum += 1
                currElf = Elf(currElfNum, 0)
            } else {
                elves.add(currElf)
                val cals = item.toLong()
                currElf.calories += cals
            }
        }
        sortedElves = elves.toMutableList()
        sortedElves.sort()
    }

    fun findElfWithMostest(): Elf? {
        var maxElf: Elf? = sortedElves.getOrNull(0)
        return maxElf
    }

    fun findTop3ElvesWithMostest(): List<Elf> {
        return listOf(
            sortedElves[0],
            sortedElves[1],
            sortedElves[2]
        )
    }

    class Elf(id: Long, calories: Long) : Comparable<Elf> {
        var id: Long = id
        var calories: Long = calories
        override fun compareTo(other: Elf): Int {
            return if (calories - other.calories <= 0) 1 else -1
        }
    }

}
