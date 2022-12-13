package dev.scotthammer.advent22.day8

class TreeVisibility(val input: Array<String>) {
    private val grid: MutableList<MutableList<Int>>
        = MutableList(input.size) { mutableListOf<Int>() }

    init {
        var idx = 0
        for (line in input) {
            val row = mutableListOf<Int>()
            for (treeHeight: Char in line.toCharArray()) {
                row.add(treeHeight.digitToInt())
            }
            this.grid[idx] = row
            idx += 1
        }
    }

    fun visibleTrees(): Long {
        if (grid.size == 0) return 0
        return if (grid.size <= 2 || grid[0].size <= 2)
            (grid.size * grid[0].size).toLong()
        else {
            val edgeCount = calcEdgeCount()
            val innerCount = calcInnerCount()
            edgeCount + innerCount
        }
    }

    private fun calcEdgeCount(): Long =
        (grid.size * 2 + grid[0].size * 2 - 4).toLong()

    private fun calcInnerCount(): Long {
        var innerCount: Long = 0
        for (y in 1 until grid.size - 1)
            for (x in 1 until grid[0].size - 1) {
                if (isVisibleInRow(y, x) || isVisibleInColumn(y, x))
                    innerCount += 1
            }
        return innerCount
    }

    private fun isVisibleInColumn(y: Int, x: Int): Boolean {
        val treeHeight = grid[y][x]
        val col = deriveColumn(x)
        val upperMax = col.subList(0, y).max()
        val lowerMax = col.subList(y + 1, col.size).max()
        return treeHeight > upperMax || treeHeight > lowerMax

    }

    private fun deriveColumn(x: Int): List<Int> {
        val column = mutableListOf<Int>()
        for (row in grid) {
            column.add(row[x])
        }
        return column
    }

    private fun isVisibleInRow(y: Int, x: Int): Boolean {
        val treeHeight = grid[y][x]
        val row = grid[y]
        val leftMax = row.subList(0, x).max()
        val rightMax = row.subList(x + 1, row.size).max()
        return treeHeight > leftMax || treeHeight > rightMax
    }

    fun maxScenicScore(): Triple<Int, Int, Long> {
        if (grid.size == 0)
            return Triple(-1, -1, 0L)
        else if (grid.size <= 2 || grid[0].size <= 2)
            return Triple(0, 0, 0L)
        else
            return findMaxScenicScore()
    }

    private fun findMaxScenicScore(): Triple<Int, Int, Long> {
        var x = 0; var y = 0; var score = 0L

        for (iy in 1 until grid.size - 1) {
            val row = grid[iy]
            for (ix in 1 until row.size - 1) {
                val treeHeight = row[ix]
                val horizScore = computeHorizontalScore(row, ix, treeHeight)

                val col = deriveColumn(ix)
                val vertScore = computeVerticalScore(col, iy, treeHeight)

                val treeScore = horizScore * vertScore
                if (treeScore > score) {
                    score = treeScore; x = ix; y = iy
                }
            }
        }
        return Triple(x, y, score)
    }

    private fun computeVerticalScore(col: List<Int>, yPos: Int, treeHeight: Int): Long {
        val up = col.subList(0, yPos).reversed()
        val down = col.subList(yPos + 1, col.size)
        val upScore = computeScore(up, treeHeight)
        val downScore = computeScore(down, treeHeight)
        return upScore * downScore
    }

    private fun computeHorizontalScore(row: MutableList<Int>, xPos: Int, treeHeight: Int): Long {
        val left = row.subList(0, xPos).reversed()
        val right = row.subList(xPos + 1, row.size)
        val leftScore = computeScore(left, treeHeight)
        val rightScore = computeScore(right, treeHeight)
        return leftScore * rightScore
    }

    private fun computeScore(trees: List<Int>, treeHeight: Int): Long {
        var tempScore = 0L
        for (height in trees) {
            tempScore += 1
            if (height >= treeHeight)
                break
        }
        return tempScore
    }

}
