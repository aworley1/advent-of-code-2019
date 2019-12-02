package day2

fun compute(input: String): List<Int> {
    val memory = input.split(",")
        .map { it.toInt() }
        .toMutableList()

    var index = 0

    while (true) {
        if (memory[index] == 99) break
        performOperation(index, memory)
        index += 4
    }


    return memory
}

private fun performOperation(index: Int, memory: MutableList<Int>) {
    val operationCode = memory[index]

    val operation: (Int, Int) -> Int = when (operationCode) {
        1 -> { a, b -> a + b }
        2 -> { a, b -> a * b }
        else -> throw NotImplementedError("Operation $operationCode not implemented")
    }

    val firstValue = memory[index + 1]
    val secondValue = memory[index + 2]
    val outLocation = memory[index + 3]

    memory[outLocation] = operation(firstValue, secondValue)
}