package dev.scotthammer.advent22.day5

class CrateStacker(val initialState: Array<String>) {
    private var stacks: MutableMap<Int, ArrayDeque<String>>? = null

    init {
        for (line in initialState.reversed()) {
            if (stacks == null) {
                createStacks(line)
            } else {
                stackCrates(line)
            }
        }
    }

    private fun createStacks(line: String) {
        val stackNums = line.split(" +".toRegex())
        stacks = mutableMapOf<Int, ArrayDeque<String>>()
        for (stackNum in stackNums) {
            if (stackNum.isEmpty()) continue
            stacks!![stackNum.trim().toInt()] = ArrayDeque<String>()
        }
    }

    private fun stackCrates(line: String) {
        val crates = line.split(" +".toRegex())
        var searchIndex = 0
        for (crate in crates) {
            if (crate.isEmpty()) continue
            val crateIndex = line.indexOf(crate, searchIndex)
            val stackNum = 1 + crateIndex/4
            searchIndex = crateIndex + 1
            stacks!![stackNum]!!.add(crate.trim())
        }
    }

    fun get(stackNum: Int): ArrayDeque<String>? {
        return stacks!![stackNum]
    }

    fun move(instruction: String) {
        val instructions = instruction.split(" ".toRegex())
        val count = instructions[1].toInt()
        val fromStack = instructions[3].toInt()
        val toStack = instructions[5].toInt()
        for (i in 1..count)
            moveOneFrom(fromStack, toStack)
    }

    private fun moveOneFrom(fromStack: Int, toStack: Int) {
        val crate = stacks!!.get(fromStack)!!.removeLast()
        stacks!!.get(toStack)!!.add(crate)
    }

    fun stackCount(): Int {
        return stacks?.size ?: 0
    }

    fun moveMulti(instruction: String) {
        val instructions = instruction.split(" ".toRegex())
        val count = instructions[1].toInt()
        val fromStack = instructions[3].toInt()
        val toStack = instructions[5].toInt()
        moveMultiFrom(count, fromStack, toStack)
    }

    private fun moveMultiFrom(count: Int, fromStack: Int, toStack: Int) {
        val tempStack = ArrayDeque<String>(count)
        for (i in 1..count)
            tempStack.add(stacks!![fromStack]!!.removeLast())
        stacks!![toStack]!!.addAll(tempStack.reversed())
    }

}
