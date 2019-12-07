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
    val wholeOperation = memory[index].toString().padStart(5, '0')

    val opCode = wholeOperation.substring(3, 5).toInt()

    val parameterModes = listOf(wholeOperation[2].toInt(), wholeOperation[1].toInt(), wholeOperation[0].toInt())

    val function = when (opCode) {
        1 -> createOpCode1(index, createInputs(2, true, parameterModes, index, memory))
        2 -> createOpCode2(index, createInputs(2, true, parameterModes, index, memory))
        3 -> createOpCode3(index, createInputs(0, true, parameterModes, index, memory), reader)
        4 -> createOpCode4(index, createInputs(1, false, parameterModes, index, memory), writer)
        else -> throw NotImplementedError("Operation $wholeOperation not implemented")
    }

    return Operation(function)
}

private fun createInputs(
    numberOfInputs: Int,
    writableParameter: Boolean,
    parameterModes: List<Int>,
    index: Int,
    memory: MutableList<Int>
): InputsAndWriteLocation {
    val inputs = (1..numberOfInputs).map { memory.readFromMemory(index + it) }
    return InputsAndWriteLocation(
        inputs = inputs,
        writeLocation = if (writableParameter) memory[index + numberOfInputs + 1] else null,
        memoryOccupied = if (writableParameter) numberOfInputs + 2 else numberOfInputs + 1
    )
}

data class InputsAndWriteLocation(
    val inputs: List<Int>,
    val writeLocation: Int?,
    val memoryOccupied: Int
)
