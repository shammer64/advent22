package dev.scotthammer.advent22.day6

class MarkerFinder {
    companion object {
        fun findMarker(input: String): Long {
            return findUniqueSequenceOf(4, input)
        }

        private fun findUniqueSequenceOf(len: Int, input: String): Long {
            for (i in len until input.length) {
                val testString = input.subSequence(i - len, i)
                val testSet = testString.toSet()
                if (testString.length == testSet.size) {
                    return i.toLong()
                }
            }
            return -1
        }

        fun findMessage(input: String): Long {
            return findUniqueSequenceOf(14, input)
        }
    }

}
