package day02

import day02.GameResult.*
import day02.HandShape.*

data class Game(val opponent: HandShape, val player: HandShape) {
    fun playRockPaperScissors() = when {
        player == opponent -> DRAW
        player to opponent in WIN_LIST -> WIN
        player to opponent in LOSE_LIST -> LOSE
        else -> throw IllegalArgumentException()
    }

    fun playAndSumGame() = player.points + playRockPaperScissors().points

    companion object {
        val LOSE_LIST = listOf(ROCK to PAPER, PAPER to SCISSORS, SCISSORS to ROCK)
        val WIN_LIST = listOf(ROCK to SCISSORS, PAPER to ROCK, SCISSORS to PAPER)
    }
}