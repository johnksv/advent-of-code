package day01

import java.nio.file.Files
import java.nio.file.Path

// Calorie Counting
fun main(args: Array<String>) {
    println("Hello World!")

    println("Program arguments: ${args.joinToString()}")
    val input = Files.readAllLines(Path.of(ResourceUtil::class.java.getResource("/day01/input.txt").toURI()))
    val elfsCalories = parseInput(input)
    println(mostCaloriesCarrying(elfsCalories))
}

fun parseInput(input: MutableList<String>): List<List<Int>> {
    val elfsCalories = mutableListOf<MutableList<Int>>(mutableListOf())
    for (line in input) {
        when {
            line.isEmpty() -> elfsCalories.add(mutableListOf())
            else -> elfsCalories.last().add(line.toInt())
        }
    }
    return elfsCalories
}

fun mostCaloriesCarrying(elfsCalories: List<List<Int>>): Int {
    return elfsCalories.maxOf { elfItemsCalories -> elfItemsCalories.sumOf { it } }
}

// Hack to access getResource-method for correct path
class ResourceUtil{}