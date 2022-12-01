package day01

import java.nio.file.Files
import java.nio.file.Path

// Calorie Counting
fun main() {
    //Task 1
    val elfsCalories = parseInput(Path.of(ResourceUtil::class.java.getResource("/day01/input.txt")!!.toURI()))
    println(mostCaloriesCarrying(elfsCalories))

    //Task 2
    println(mostCaloriesCarrying(elfsCalories, elfsToSum = 3))
}

fun parseInput(path: Path): List<List<Int>> {
    val input = Files.readAllLines(path)
    return parseInput(input)
}

fun parseInput(input: List<String>): List<List<Int>> {
    val elfsCalories = mutableListOf<MutableList<Int>>(mutableListOf())
    for (line in input) {
        when {
            line.isEmpty() -> elfsCalories.add(mutableListOf())
            else -> elfsCalories.last().add(line.toInt())
        }
    }
    return elfsCalories
}

fun mostCaloriesCarrying(elfsCalories: List<List<Int>>, elfsToSum: Int = 1): Int {
    return elfsCalories
        .map { elfItem -> elfItem.sumOf { it } }
        .sorted()
        .run {
//            TODO change for something else, to avoid run-block
            subList(size - elfsToSum, size)
        }
        .sum()
}

// Hack to access getResource-method for correct path
class ResourceUtil