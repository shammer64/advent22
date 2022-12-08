package dev.scotthammer.advent22.day6

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MarkerFinderTest {
    @Test
    fun shouldFindMarkerAfterChar5() {
        val input = "bvwbjplbgvbhsrlpgdmjqwftvncz"

        assertEquals(5, MarkerFinder.findMarker(input))
    }

    @Test
    fun shouldFindMarkerAfterChar6() {
        val input = "nppdvjthqldpwncqszvftbrmjlhg"

        assertEquals(6, MarkerFinder.findMarker(input))
    }

    @Test
    fun shouldFindMarkerAfterChar10() {
        val input = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"

        assertEquals(10, MarkerFinder.findMarker(input))
    }

    @Test
    fun shouldFindMessageAfterChar19() {
        val input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"

        assertEquals(19, MarkerFinder.findMessage(input))
    }

    @Test
    fun shouldFindMessageAfterChar26() {
        val input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"

        assertEquals(26, MarkerFinder.findMessage(input))
    }
}