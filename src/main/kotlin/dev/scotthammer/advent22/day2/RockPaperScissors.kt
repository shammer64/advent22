package dev.scotthammer.advent22.day2

class RockPaperScissors {

    fun playRound(p1PlayCode: String, p2PlayCode: String) {
        playRound(RPSPlay.translate(p1PlayCode), RPSPlay.translate(p2PlayCode))
    }

    fun playRound(playCode: String) {
        var playCodes = playCode.split(" ")
        playRound(playCodes[0], playCodes[1])
    }

    fun playRound(p1Play: RPSPlay, p2Play: RPSPlay) {
        var result: ResulType = determineP2Result(p1Play, p2Play)
        when (result) {
            ResulType.DRAW -> handleDraw(p1Play, p2Play)
            ResulType.WIN -> handleWin(p1Play, p2Play)
            ResulType.LOSE -> handleLoss(p1Play, p2Play)
        }
    }

    private fun handleLoss(p1Play: RPSPlay, p2Play: RPSPlay) {
        p1Score += (ResulType.WIN.score + p1Play.score);
        p2Score += (ResulType.LOSE.score + p2Play.score);
    }

    private fun handleWin(p1Play: RPSPlay, p2Play: RPSPlay) {
        p1Score += (ResulType.LOSE.score + p1Play.score);
        p2Score += (ResulType.WIN.score + p2Play.score);
    }

    private fun determineP2Result(p1Play: RPSPlay, p2Play: RPSPlay): ResulType {
        // Result is from player2 perspective
        return when (p1Play.ordinal - p2Play.ordinal) {
            0 -> ResulType.DRAW
            1, -2 -> ResulType.LOSE
            else -> ResulType.WIN
        }
    }

    private fun handleDraw(p1Play: RPSPlay, p2Play: RPSPlay) {
        p1Score += (ResulType.DRAW.score + p1Play.score);
        p2Score += (ResulType.DRAW.score + p2Play.score);
    }

    var p1Score: Long = 0
    var p2Score: Long = 0
}

enum class ResulType(val score: Int) {
    WIN(6), LOSE(0), DRAW(3);
}

enum class RPSPlay(val score: Int) {
    ROCK(1), PAPER(2), SCISSORS(3);

    companion object {
        fun translate(code: String): RPSPlay {
            return when (code) {
                "A", "X" -> ROCK
                "B", "Y" -> PAPER
                "C", "Z" -> SCISSORS
                else -> throw Exception("Value not allowed")
            }
        }
    }
}
