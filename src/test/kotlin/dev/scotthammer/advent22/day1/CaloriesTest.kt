package dev.scotthammer.advent22.day1

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CaloriesTest {
    var fileInput: Array<String>? = null

    @BeforeAll
    internal fun setUp() {
        fileInput = readFromInputFile("/calories_input.txt")
    }

    @Test
    fun shouldHandleEmptyArray() {
        val input = emptyArray<String>()
        val caloriesCalc = CaloriesCalc(input)

        val maxElf = caloriesCalc.findElfWithMostest()

        assertNull(maxElf)
    }

    @Test
    fun shouldHandleOneElfSingleItemArray() {
        val input = arrayOf<String>("1000")
        val caloriesCalc = CaloriesCalc(input)

        val maxElf = caloriesCalc.findElfWithMostest()

        assertNotNull(maxElf)
        assertEquals(1, maxElf.id)
        assertEquals(1000, maxElf.calories)
    }

    @Test
    fun shouldHandleTwoElfSingleItemArray() {
        val input = arrayOf<String>("1000", "", "2000")
        val caloriesCalc = CaloriesCalc(input)

        val maxElf = caloriesCalc.findElfWithMostest()

        assertNotNull(maxElf)
        assertEquals(2, maxElf.id)
        assertEquals(2000, maxElf.calories)
    }

    @Test
    fun shouldHandleExerciseExample() {
        val input = arrayOf<String>(
            "1000", "2000", "",
            "4000", "",
            "5000", "6000", "",
            "7000", "8000", "9000", "",
            "10000"
        )
        val caloriesCalc = CaloriesCalc(input)

        val maxElf = caloriesCalc.findElfWithMostest()

        assertNotNull(maxElf)
        assertEquals(4, maxElf.id)
        assertEquals(24000, maxElf.calories)
    }

    @Test
    fun shouldHandleLargeArrayFromFile() {
        val caloriesCalc = fileInput?.let { CaloriesCalc(it) }

        val maxElf = caloriesCalc?.findElfWithMostest()

        assertNotNull(maxElf)
        assertEquals(7, maxElf.id)
        assertEquals(67633, maxElf.calories)
    }

    @Test
    fun shouldHandleLargeArrayFromFileTop3() {
        val caloriesCalc = fileInput?.let { CaloriesCalc(it) }

        val maxElves = caloriesCalc?.findTop3ElvesWithMostest()

        assertNotNull(maxElves)
        assertEquals(7, maxElves[0].id)
        assertEquals(67633, maxElves[0].calories)
        assertEquals(149, maxElves[1].id)
        assertEquals(66296, maxElves[1].calories)
        assertEquals(158, maxElves[2].id)
        assertEquals(65699, maxElves[2].calories)
    }

    private fun readFromInputFile(inputFileName: String): Array<String> {
        return this::class.java.getResourceAsStream(inputFileName)
            .bufferedReader().readLines().toTypedArray()
    }

}