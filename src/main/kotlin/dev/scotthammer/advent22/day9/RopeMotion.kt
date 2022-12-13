package dev.scotthammer.advent22.day9

import java.awt.Point
import kotlin.math.abs

class RopeMotion(initXPos: Int, initYPos: Int, private val numTails: Int) {

    constructor(initXPos: Int, initYPos: Int) : this(initXPos, initYPos, 1)

    private var startPos: Point
    var headPos: Point
    var tailPos: Point
    val visitedSet: MutableSet<String> = mutableSetOf()
    private val pointList: MutableList<Point> = mutableListOf()

    init {
        headPos = Point(initXPos, initYPos)
        startPos = Point(initXPos, initYPos)
        tailPos = Point(initXPos, initYPos)
        pointList.add(headPos)
        for (i in 1 until numTails)
            pointList.add(Point(initXPos, initYPos))
        pointList.add(tailPos)
    }

    fun move(instruction: String) {
        val direction: Char = instruction.uppercase()[0]
        val count = instruction.substring(2).toInt()
        when (direction) {
            'R','L', 'U', 'D' -> moveRope(direction, count)
            else -> println("Ignoring instruction: $instruction")
        }
    }

    private fun moveRope(direction: Char, count: Int) {
        for (i in 1..count) {
            moveHead(direction)
            for (j in 1..numTails)
                reposition(pointList[j], pointList[j - 1])
            visitedSet.add(pointList[numTails].toString())
        }
    }

    private fun moveHead(direction: Char) {
        when (direction) {
            'R' -> pointList[0].x += 1
            'L' -> pointList[0].x -= 1
            'U' -> pointList[0].y += 1
            'D' -> pointList[0].y -= 1
            else -> {}
        }
    }

    private fun adjacent(childPos: Point, parentPos: Point): Boolean {
        return abs(childPos.x - parentPos.x) <= 1 && abs(childPos.y - parentPos.y) <= 1
    }

    private fun reposition(childPos: Point, parentPos: Point) {
        if (adjacent(childPos, parentPos)) return
        if (diagonal(childPos, parentPos))
            handleDiagonal(childPos, parentPos)
        if (parentPos.x - childPos.x == 2) {
            childPos.x = parentPos.x - 1
            childPos.y = parentPos.y
        } else if (parentPos.x - childPos.x == -2) {
            childPos.x = parentPos.x + 1
            childPos.y = parentPos.y
        } else if (parentPos.y - childPos.y == 2)  {
            childPos.y = parentPos.y - 1
            childPos.x = parentPos.x
        } else if (parentPos.y - childPos.y == -2)  {
            childPos.y = parentPos.y + 1
            childPos.x = parentPos.x
        }
    }

    private fun handleDiagonal(childPos: Point, parentPos: Point) {
       when (parentPos.x - childPos.x) {
            2 -> childPos.x = parentPos.x - 1
            -2 -> childPos.x = parentPos.x + 1
        }

        when (parentPos.y - childPos.y) {
            2 -> childPos.y = parentPos.y - 1
            -2 -> childPos.y = parentPos.y + 1
        }
    }

    private fun diagonal(childPos: Point, parentPos: Point): Boolean {
        return abs(childPos.x - parentPos.x) == 2 && abs(childPos.y - parentPos.y) == 2
    }

}
