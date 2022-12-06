package day06

// Calorie Counting
fun main() {
    print("Test input Task 1: ")
    println(task1And2(testInput, 4))

    print("Task 1: ")
    println(task1And2(taskInput, 4))

    print("Test input Task 2: ")
    println(task1And2(testInput, 14))

    print("Task 2: ")
    println(task1And2(taskInput, 14))
}

fun task1And2(input: List<String>, windowSize: Int) = input
    .filter { it.isNotEmpty() }
    .map { line ->
        line
            .windowed(windowSize)
            .map { it.toCharArray() }
            .indexOfFirst { it.distinct().size == windowSize }

    }
    .map { it + windowSize }
