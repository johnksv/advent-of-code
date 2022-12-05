package day04

// Calorie Counting
fun main() {
    print("Test input Task 1: ")
    println(task1(testInput))

    print("Task 1: ")
    println(task1(taskInput))

    print("Test input Task 2: ")
    println(task2(testInput))

    print("Task 2: ")
    println(task2(taskInput))
}

fun task1(input: String): Int {
    return input.split("\n")
        .filter { it.isNotEmpty() }
        .map {
            val ranges = it.split(",").map {
                val range = it.split("-").map { it.toInt() }
                range.first()..range.last()
            }
            ranges
        }.filter {
            val firstRange = it.first()
            val lastRange = it.last()
            lastRange.contains(firstRange.first) && lastRange.contains(firstRange.last) ||
                    firstRange.contains(lastRange.first) && firstRange.contains(lastRange.last)
        }.size

}

fun task2(input: String): Int {
    return input.split("\n")
        .filter { it.isNotEmpty() }
        .map {
            val ranges = it.split(",").map {
                val range = it.split("-").map { it.toInt() }
                range.first()..range.last()
            }
            val firstRange = ranges.first()
            val lastRange = ranges.last()
            firstRange intersect lastRange
        }.filter { it.isNotEmpty() }
        .size

}
