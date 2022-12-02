package day02

import day02.GameResult.*
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.nio.file.Path

class MainKtTest : BehaviorSpec({
    val testInput = Path.of(MainKtTest::class.java.getResource("/day02/test_input.txt").toURI())

    given("parseInput") {
        val games = parseInputTask1(testInput)
        games.size shouldBe 3
    }

    given("points for win lose draw task 1") {
        val games = parseInputTask1(testInput)
        games[0].playRockPaperScissors() shouldBe WIN
        games[1].playRockPaperScissors() shouldBe LOSE
        games[2].playRockPaperScissors() shouldBe DRAW
    }

    given("points for game , task 1") {
        val games = parseInputTask1(testInput)
        games[0].playAndSumGame() shouldBe 8
        games[1].playAndSumGame() shouldBe 1
        games[2].playAndSumGame() shouldBe 6
    }

    given("task 2, pick correct hand") {
        val games = parseInputTask2(testInput)

        games[0].playAndSumGame() shouldBe 4
        games[1].playAndSumGame() shouldBe 1
        games[2].playAndSumGame() shouldBe 7
    }
})
