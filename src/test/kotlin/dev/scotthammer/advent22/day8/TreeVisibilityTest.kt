package dev.scotthammer.advent22.day8

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TreeVisibilityTest {

    @Test
    fun emptyGridHasZeroVisibleTrees() {
        val tv = TreeVisibility(arrayOf<String>())

        assertEquals(0, tv.visibleTrees())
    }

    @Test
    fun singleTreeGridHasOneVisibleTree() {
        val tv = TreeVisibility(arrayOf<String>("6"))

        assertEquals(1, tv.visibleTrees())
    }

    @Test
    fun singleRowGridHasAllVisibleTrees() {
        val tv = TreeVisibility(arrayOf<String>("647"))

        assertEquals(3, tv.visibleTrees())
    }

    @Test
    fun singleColumnGridHasAllVisibleTrees() {
        val tv = TreeVisibility(arrayOf<String>("6", "4", "7"))

        assertEquals(3, tv.visibleTrees())
    }

    @Test
    fun twoRowGridHasAllVisibleTrees() {
        val tv = TreeVisibility(arrayOf<String>("647", "159"))

        assertEquals(6, tv.visibleTrees())
    }

    @Test
    fun twoColumnGridHasAllVisibleTrees() {
        val tv = TreeVisibility(arrayOf<String>("64", "71", "59"))

        assertEquals(6, tv.visibleTrees())
    }

    @Test
    fun threeByThreeGridWithShortMiddleTreeHasAllButOneVisibleTrees() {
        val tv = TreeVisibility(arrayOf<String>("645", "702", "584"))

        assertEquals(8, tv.visibleTrees())
    }

    @Test
    fun threeByThreeGridWithTallMiddleTreeHasAllVisibleTrees() {
        val tv = TreeVisibility(arrayOf<String>("645", "792", "584"))

        assertEquals(9, tv.visibleTrees())
    }

    @Test
    fun threeByThreeGridWithTreeObscuredInColumnHasAllVisibleTrees() {
        val tv = TreeVisibility(arrayOf<String>("695", "772", "584"))

        assertEquals(9, tv.visibleTrees())
    }

    @Test
    fun threeByThreeGridWithTreeObscuredInRowHasAllVisibleTrees() {
        val tv = TreeVisibility(arrayOf<String>("695", "772", "584"))

        assertEquals(9, tv.visibleTrees())
    }

    @Test
    fun exampleGridHas21VisibleTrees() {
        val tv = TreeVisibility(
            arrayOf<String>("30373", "25512", "65332", "33549", "35390")
        )

        assertEquals(21, tv.visibleTrees())
    }

    @Test
    fun emptyGridHasScenicScoreZero() {
        val tv = TreeVisibility(arrayOf<String>())

        val (x, y, score) = tv.maxScenicScore()
        assertEquals(-1, x)
        assertEquals(-1, y)
        assertEquals(0, score)
    }

    @Test
    fun singleTreeGridHasScenicScoreZero() {
        val tv = TreeVisibility(arrayOf<String>("7"))

        val (x, y, score) = tv.maxScenicScore()
        assertEquals(0, x)
        assertEquals(0, y)
        assertEquals(0, score)
    }

    @Test
    fun singleRowTwoTreeGridHasScenicScoreOne() {
        val tv = TreeVisibility(arrayOf<String>("59"))

        val (x, y, score) = tv.maxScenicScore()
        assertEquals(0, x)
        assertEquals(0, y)
        assertEquals(0L, score)
    }

    @Test
    fun threeByThreeGridWithShortTreeHasScenicScoreOne() {
        val tv = TreeVisibility(arrayOf<String>("594", "404", "289"))

        val (x, y, score) = tv.maxScenicScore()
        assertEquals(1, x)
        assertEquals(1, y)
        assertEquals(1L, score)
    }

    @Test
    fun exampleGridHasMaxScenicScoreEight() {
        val tv = TreeVisibility(
            arrayOf<String>(
                "30373",
                "25512",
                "65332",
                "33549",
                "35390")
        )

        val (x, y, score) = tv.maxScenicScore()
        assertEquals(2, x)
        assertEquals(3, y)
        assertEquals(8L, score)
    }

}