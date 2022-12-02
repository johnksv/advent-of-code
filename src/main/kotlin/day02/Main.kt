package day02

import day02.GameResult.*
import day02.HandShape.*
import java.nio.file.Files
import java.nio.file.Path

// Rock Paper Scissors
fun main() {

    //Task 1
    val gamesTask1 = parseInputTask1(Path.of(ResourceUtil::class.java.getResource("/day02/input.txt")!!.toURI()))
    val resultTask1 = gamesTask1.sumOf { it.playAndSumGame() }
    println(resultTask1)

    //Task 2
    val gamesTask2 = parseInputTask2(Path.of(ResourceUtil::class.java.getResource("/day02/input.txt")!!.toURI()))
    val resultTask2 = gamesTask2.sumOf { it.playAndSumGame() }
    println(resultTask2)
}

fun parseInputTask1(path: Path): List<Game> = Files.lines(path)
    .map {
        val hands = it.split(" ").map { code -> HandShape.fromCode(code) }
        return@map Game(opponent = hands.first(), player = hands.last())
    }
    .toList()

fun parseInputTask2(path: Path): List<Game> = Files.lines(path)
    .map {
        val handAndOutcome = it.split(" ")
        val opponentHand = HandShape.fromCode(handAndOutcome.first())
        val playHand = resolvePlayerHand(opponentHand, handAndOutcome.last())
        return@map Game(opponent = opponentHand, player = playHand)
    }
    .toList()

fun resolvePlayerHand(opponentHand: HandShape, outcome: String) = when(outcome) {
    "X" -> Game.WIN_LIST.first { it.first == opponentHand }.second
    "Y" -> opponentHand
    "Z" -> Game.LOSE_LIST.first { it.first == opponentHand }.second
    else -> throw IllegalArgumentException()
}

// Hack to access getResource-method for correct path
class ResourceUtil