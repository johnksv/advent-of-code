package day05

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

fun createStacks(stackDefinition: String): Map<String, MutableList<Char>> {
    val rows = stackDefinition.split("\n")
    val stacks = rows.last()
        .split("  ")
        .map { it.trim() }
        .associateWith { mutableListOf<Char>() }

    rows.dropLast(1)
        .reversed() // Bottom is index 0, top is the highest index
        .map {
            it.toCharArray()
                .filterIndexed { index, _ -> (index - 1) % 4 == 0 }
                .mapIndexed { index, c ->
                    val column = index + 1
                    column.toString() to c
                }
                .filter { c -> c.second.isLetter() }
                .forEach { stackElement -> stacks[stackElement.first]!!.add(stackElement.second) }
        }

    return stacks
}

val regex = Regex("move (\\d+) from (\\d+) to (\\d+)")
fun parseInstructions(instructions: String) =
    instructions.split("\n").filter { it.isNotEmpty() }.map { regex.find(it)!!.destructured }

fun task1(input: String): String {
    val parts = input.split("\n\n")
    val stacks = createStacks(parts.first())

    parseInstructions(parts.last())
        .forEach { (moveCount, fromStack, toStack) ->
            for (i in 1..moveCount.toInt()) {
                val charToBeMoved = stacks[fromStack]!!.removeLast()
                stacks[toStack]!!.add(charToBeMoved)
            }
        }
    return stacks.values.map { it.last() }.joinToString(separator = "")
}

fun task2(input: String): String {
    val parts = input.split("\n\n")
    val stacks = createStacks(parts.first())

    parseInstructions(parts.last())
        .forEach { (moveCount, fromStack, toStack) ->
            val elementsToMove = mutableListOf<Char>()
            for (i in 1..moveCount.toInt()) {
                elementsToMove.add(stacks[fromStack]!!.removeLast())
            }
            stacks[toStack]!!.addAll(elementsToMove.reversed())
        }
    return stacks.values.map { it.last() }.joinToString(separator = "")
}
