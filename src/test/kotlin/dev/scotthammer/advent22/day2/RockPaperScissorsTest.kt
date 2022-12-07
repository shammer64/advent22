package dev.scotthammer.advent22.day2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RockPaperScissorsTest {

    @Test
    fun newGameShouldScoreZeroForBothPlayers() {
        val game = RockPaperScissors()

        assertEquals(0, game.p1Score)
        assertEquals(0, game.p2Score)
    }

    @Test
    fun shouldScoreRockDrawAppropriately() {
        val game = RockPaperScissors()

        game.playRound("A", "X")

        assertEquals(4, game.p1Score)
        assertEquals(4, game.p2Score)
    }

    @Test
    fun shouldScorePaperDrawAppropriately() {
        val game = RockPaperScissors()

        game.playRound("B", "Y")

        assertEquals(5, game.p1Score)
        assertEquals(5, game.p2Score)
    }

    @Test
    fun shouldScoreScissorsDrawAppropriately() {
        val game = RockPaperScissors()

        game.playRound("C", "Z")

        assertEquals(6, game.p1Score)
        assertEquals(6, game.p2Score)
    }

    @Test
    fun shouldScoreRockWinAppropriately() {
        val game = RockPaperScissors()

        game.playRound("C X")

        assertEquals(3, game.p1Score)
        assertEquals(7, game.p2Score)
    }

    @Test
    fun shouldScorePaperWinAppropriately() {
        val game = RockPaperScissors()

        game.playRound("A Y")

        assertEquals(1, game.p1Score)
        assertEquals(8, game.p2Score)
    }

    @Test
    fun shouldScoreScissorsWinAppropriately() {
        val game = RockPaperScissors()

        game.playRound("B Z")

        assertEquals(2, game.p1Score)
        assertEquals(9, game.p2Score)
    }

    @Test
    fun shouldScoreRockLossAppropriately() {
        val game = RockPaperScissors()

        game.playRound("B X")

        assertEquals(8, game.p1Score)
        assertEquals(1, game.p2Score)
    }

    @Test
    fun shouldScorePaperLossAppropriately() {
        val game = RockPaperScissors()

        game.playRound("C Y")

        assertEquals(9, game.p1Score)
        assertEquals(2, game.p2Score)
    }

    @Test
    fun shouldScoreMultiplePlayExampleAppropriately() {
        val game = RockPaperScissors()

        game.playRound("A Y")
        game.playRound("B X")
        game.playRound("C Z")

        assertEquals(15, game.p2Score)
    }

    @Test
    fun shouldScoreScissorsLossAppropriately() {
        val game = RockPaperScissors()

        game.playRound("A Z")

        assertEquals(7, game.p1Score)
        assertEquals(3, game.p2Score)
    }

    @Test
    fun shouldHandleSingleStringInput() {
        val game = RockPaperScissors()

        game.playRound("C Z")
        assertEquals(6, game.p1Score)
        assertEquals(6, game.p2Score)
    }

    @Test
    fun shouldHandleEnumInput() {
        val game = RockPaperScissors()

        game.playRound(RPSPlay.SCISSORS, RPSPlay.SCISSORS)
        assertEquals(6, game.p1Score)
        assertEquals(6, game.p2Score)
    }

}