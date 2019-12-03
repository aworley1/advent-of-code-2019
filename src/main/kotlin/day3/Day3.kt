package day3

fun solvePuzzle(input: List<String>): Int {
    return 0
}

fun parse(input: List<String>): List<List<Instruction>> {
    return input.map { it.split(",") }
        .map {
            it.map {
                Instruction(
                    operation = Operation.valueOf(it.substring(0, 1)),
                    amount = it.substring(1).toInt()
                )
            }
        }
}

data class Instruction(val operation: Operation, val amount: Int)

enum class Operation {
    U,
    D,
    L,
    R
}