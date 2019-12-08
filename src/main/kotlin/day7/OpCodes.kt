package day7

fun createOpCode1(index: Int, inputs: InputsAndWriteLocation): suspend (MutableList<Int>) -> Int {
    return { memory: MutableList<Int> ->
        memory[inputs.writeLocation!!] = inputs.inputs[0] + inputs.inputs[1]

        index + inputs.memoryOccupied
    }
}

fun createOpCode2(index: Int, inputs: InputsAndWriteLocation): suspend (MutableList<Int>) -> Int {
    return { memory: MutableList<Int> ->
        memory[inputs.writeLocation!!] = inputs.inputs[0] * inputs.inputs[1]

        index + inputs.memoryOccupied
    }
}

fun createOpCode3(index: Int, inputs: InputsAndWriteLocation, reader: Inputter): suspend (MutableList<Int>) -> Int {
    return { memory: MutableList<Int> ->
        val input = reader.getInput()

        memory[inputs.writeLocation!!] = input.toInt()

        index + inputs.memoryOccupied
    }
}

fun createOpCode4(index: Int, inputs: InputsAndWriteLocation, writer: Outputter): suspend (MutableList<Int>) -> Int {
    return { memory: MutableList<Int> ->

        writer.output(inputs.inputs[0])

        index + inputs.memoryOccupied
    }
}

fun createOpCode5(index: Int, inputs: InputsAndWriteLocation): suspend (MutableList<Int>) -> Int {
    return { memory: MutableList<Int> ->
        if (inputs.inputs[0] == 0)
            index + inputs.memoryOccupied
        else
            inputs.inputs[1]
    }
}

fun createOpCode6(index: Int, inputs: InputsAndWriteLocation): suspend (MutableList<Int>) -> Int {
    return { memory: MutableList<Int> ->
        if (inputs.inputs[0] != 0)
            index + inputs.memoryOccupied
        else
            inputs.inputs[1]
    }
}

fun createOpCode7(index: Int, inputs: InputsAndWriteLocation): suspend (MutableList<Int>) -> Int {
    return { memory: MutableList<Int> ->
        memory[inputs.writeLocation!!] = if (inputs.inputs[0] < inputs.inputs[1]) {
            1
        } else {
            0
        }

        index + inputs.memoryOccupied
    }
}

fun createOpCode8(index: Int, inputs: InputsAndWriteLocation): suspend (MutableList<Int>) -> Int {
    return { memory: MutableList<Int> ->
        memory[inputs.writeLocation!!] = if (inputs.inputs[0] == inputs.inputs[1]) {
            1
        } else {
            0
        }

        index + inputs.memoryOccupied
    }
}