package day03

// Calorie Counting
fun main() {
    print("Test input Task 1: ")
    println(task1(testInput))

    print("Task 1: ")
    println(task1(task1Input))

    print("Test input Task 2: ")
    println(task2(testInput))

    print("Task 2: ")
    println(task2(task2Input))
}

fun task1(input: String): Int {
    return input.split("\n")
        .map { it.toCharArray() }
        .filter { it.isNotEmpty() }
        .sumOf { rucksackItems ->
            val middleIndex = rucksackItems.lastIndex / 2
            val firstCompartment = rucksackItems.slice(0 ..middleIndex)
            val lastCompartment = rucksackItems.slice(middleIndex + 1..rucksackItems.lastIndex)

            firstCompartment.filter { c -> lastCompartment.contains(c) }
                .distinct()
                .map { char -> char.code }
                .sumOf { if (it >= 97) it - 96 else it - 38 }
        }
}

fun task2(input: String): Int {
     return input.split("\n")
        .map { it.toCharArray().toList() }
        .filter { it.isNotEmpty() }
        .chunked(3)
         .flatMap { group ->
             group.first()
                 .filter { char -> group[1].contains(char) && group.last().contains(char) }
                 .distinct()
         }
         .map { char -> char.code }
         .sumOf { if (it >= 97) it - 96 else it - 38 }

}
