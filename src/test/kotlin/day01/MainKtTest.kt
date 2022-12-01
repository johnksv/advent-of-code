package day01

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.nio.file.Path

class MainKtTest : BehaviorSpec({
    val testInput = Path.of(MainKtTest::class.java.getResource("/day01/test_input.txt").toURI())

    given("parseInput") {
        val elves = parseInput(testInput)
        elves.size shouldBe 5
    }

    given("mostCaloriesCarrying task 1") {
        val elves = parseInput(testInput)
        val caloriesCount = mostCaloriesCarrying(elves)
        caloriesCount shouldBe 24000
    }

    given("mostCaloriesCarrying task 2") {
        val elves = parseInput(testInput)
        val caloriesCount = mostCaloriesCarrying(elves, 3)
        caloriesCount shouldBe 45000
    }
})
