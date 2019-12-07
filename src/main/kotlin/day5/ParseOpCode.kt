package day5


data class Operation(
    val function: (MutableList<Int>) -> Int
)

fun parseOpCode(
    index: Int,
    memory: MutableList<Int>,
    reader: ConsoleReader,
    writer: ConsoleWriter
): Operation {
    val operationCode = memory[index]

    val function = when (operationCode) {
        1 -> createOpCode1(index, createInputs(3))
        2 -> createOpCode2(index, createInputs(3))
        3 -> createOpCode3(index, createInputs(1), reader)
        4 -> createOpCode4(index, createInputs(1), writer)
        else -> throw NotImplementedError("Operation $operationCode not implemented")
    }

    return Operation(function)
}

private fun createInputs(numberOfInputs: Int): List<Int> {
    return emptyList()
}