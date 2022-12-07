package dev.scotthammer.advent22.day2

object RPSApp {

    @JvmStatic fun main(args: Array<String>) {
        // Question 1
        val rpsGame = RockPaperScissors()
        var input: Array<String> = rpsGame::class.java
            .getResourceAsStream("/rochambeau_input.txt")
            .bufferedReader().readLines().toTypedArray()

        for (round in input) {
            var plays = round.split(" ")
            rpsGame.playRound(RPSPlay.translate(plays[0]), RPSPlay.translate(plays[1]))
        }
        System.out.println("Day 2, Answer 1: " + rpsGame.p2Score)

        // Question 2
        val rpsGame2 = RockPaperScissors()
        for (round in input) {
            var plays = round.split(" ")
            val p1Play = RPSPlay.translate(plays[0])
            val p2Play = when (plays[1]) {
                "X" -> pickLosingPlay(p1Play) // LOSE
                "Y" -> p1Play  // DRAW
                else -> pickWinningPlay(p1Play) //  WIN
            }
            rpsGame2.playRound(p1Play, p2Play)
        }
        System.out.println("Day 2, Answer 2: " + rpsGame2.p2Score)
    }

    private fun pickWinningPlay(p1Play: RPSPlay): RPSPlay {
        val ordinal = (p1Play.ordinal + 1) % 3
        return RPSPlay.values()[ordinal]
    }

    private fun pickLosingPlay(p1Play: RPSPlay): RPSPlay {
        val ordinal = (p1Play.ordinal - 1 + 3) % 3
        return RPSPlay.values()[ordinal]
    }
}