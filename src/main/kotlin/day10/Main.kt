package day10

// Calorie Counting
fun main() {
    print("Test input Task 1: ")
    val testCycleList = cycleList(testInput)
    println(task1(testCycleList, 20, 60, 100, 140, 180, 220))

    print("Task 1: ")
    val cycleListTask1 = cycleList(taskInput)
    println(task1(cycleListTask1, 20, 60, 100, 140, 180, 220))
//    println(task1And2(taskInput, 4))
//
//    print("Test input Task 2: ")
//    println(task1And2(testInput, 14))
//
//    print("Task 2: ")
//    println(task1And2(taskInput, 14))
}


data class Cycle(val during: Int, val after: Int)

fun cycleList(input: List<String>): MutableList<Cycle> {
    val initialX = 1
    val cycleList = mutableListOf(Cycle(initialX, initialX))
    input.forEach { instruction ->
        // two instruciton, noop or addx
        when (instruction) {
            "noop" -> {
                val afterLastCyleValue = cycleList.last().after
                cycleList.add(Cycle(afterLastCyleValue, afterLastCyleValue))
            }

            else -> {
                val value = instruction.removePrefix("addx ").toInt()
                val afterLastCyleValue = cycleList.last().after
                cycleList.add(Cycle(afterLastCyleValue, afterLastCyleValue))
                cycleList.add(Cycle(afterLastCyleValue, afterLastCyleValue + value))
            }
        }
    }
    return cycleList
}

fun task1(cycleList: List<Cycle>, vararg cycleNumbers: Int) =
    cycleList
        .filterIndexed() { index, _ -> cycleNumbers.contains(index ) }
        .mapIndexed { index, cycle ->
            println("$index, ${cycle.during},  ${cycleNumbers[index]}")
            cycle.during * cycleNumbers[index]
        }
        .sum()
