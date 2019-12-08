package day7


data class Operation(
    val function: suspend (MutableList<Int>) -> Int
)

fun parseOpCode(
    index: Int,
    memory: MutableList<Int>,
    reader: Inputter,
    writer: Outputter
): Operation {
    val wholeOperation = memory[index].toString().padStart(5, '0')

    val opCode = wholeOperation.substring(3, 5).toInt()

    val parameterModes = listOf(
        wholeOperation.substring(2, 3).toInt(),
        wholeOperation.substring(1, 2).toInt(),
        wholeOperation.substring(0, 1).toInt()
    )

    val function = when (opCode) {
        1 -> createOpCode1(index, createInputs(2, true, parameterModes, index, memory))
        2 -> createOpCode2(index, createInputs(2, true, parameterModes, index, memory))
        3 -> createOpCode3(index, createInputs(0, true, parameterModes, index, memory), reader)
        4 -> createOpCode4(index, createInputs(1, false, parameterModes, index, memory), writer)
        5 -> createOpCode5(index, createInputs(2, false, parameterModes, index, memory))
        6 -> createOpCode6(index, createInputs(2, false, parameterModes, index, memory))
        7 -> createOpCode7(index, createInputs(2, true, parameterModes, index, memory))
        8 -> createOpCode8(index, createInputs(2, true, parameterModes, index, memory))
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
    val inputs = (1..numberOfInputs).map {
        val parameterMode = parameterModes[it - 1]
        when (parameterMode) {
            0 -> memory.readFromMemory(index + it)
            1 -> memory[index + it]
            else -> throw IllegalArgumentException("Invalid mode code $parameterMode")
        }
    }
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
