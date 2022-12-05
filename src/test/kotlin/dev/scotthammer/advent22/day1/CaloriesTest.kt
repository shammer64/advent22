package dev.scotthammer.advent22.day1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CaloriesTest {

    @Test
    fun shouldHandleEmptyArray() {
        val input = emptyArray<String>()
        val caloriesCalc = CaloriesCalc(input)

        assertEquals(-1, caloriesCalc.findElfWithMostest())
    }

    @Test
    fun shouldHandleOneElfSingleItemArray() {
        val input = arrayOf<String>("1000")
        val caloriesCalc = CaloriesCalc(input)

        assertEquals(1, caloriesCalc.findElfWithMostest())
    }

}