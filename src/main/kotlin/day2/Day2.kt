package day2

fun compute(input: String): List<Int> {
    val memory = input.split(",")
        .map { it.toInt() }
        .toMutableList()

    val operation = memory[0]
    val firstValue = memory[1]
    val secondValue = memory[2]
    val outLocation = memory[3]

    memory[outLocation] = firstValue + secondValue

    return memory
}