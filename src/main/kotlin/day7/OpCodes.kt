package day7

fun createOpCode1(index: Int, inputs: InputsAndWriteLocation): (MutableList<Int>) -> Int {
    return fun(memory: MutableList<Int>): Int {
        memory[inputs.writeLocation!!] = inputs.inputs[0] + inputs.inputs[1]

        return index + inputs.memoryOccupied
    }
}

fun createOpCode2(index: Int, inputs: InputsAndWriteLocation): (MutableList<Int>) -> Int {
    return fun(memory: MutableList<Int>): Int {
        memory[inputs.writeLocation!!] = inputs.inputs[0] * inputs.inputs[1]

        return index + inputs.memoryOccupied
    }
}

fun createOpCode3(index: Int, inputs: InputsAndWriteLocation, reader: Inputter): (MutableList<Int>) -> Int {
    return fun(memory: MutableList<Int>): Int {
        val input = reader.getInput()

        memory[inputs.writeLocation!!] = input.toInt()

        return index + inputs.memoryOccupied
    }
}

fun createOpCode4(index: Int, inputs: InputsAndWriteLocation, writer: Outputter): (MutableList<Int>) -> Int {
    return fun(_: MutableList<Int>): Int {

        writer.output(inputs.inputs[0])

        return index + inputs.memoryOccupied
    }
}

fun createOpCode5(index: Int, inputs: InputsAndWriteLocation): (MutableList<Int>) -> Int {
    return fun(_: MutableList<Int>): Int {
        return if (inputs.inputs[0] == 0)
            index + inputs.memoryOccupied
        else
            inputs.inputs[1]
    }
}

fun createOpCode6(index: Int, inputs: InputsAndWriteLocation): (MutableList<Int>) -> Int {
    return fun(_: MutableList<Int>): Int {
        return if (inputs.inputs[0] != 0)
            index + inputs.memoryOccupied
        else
            inputs.inputs[1]
    }
}

fun createOpCode7(index: Int, inputs: InputsAndWriteLocation): (MutableList<Int>) -> Int {
    return fun(memory: MutableList<Int>): Int {
        memory[inputs.writeLocation!!] = if (inputs.inputs[0] < inputs.inputs[1]) {
            1
        } else {
            0
        }

        return index + inputs.memoryOccupied
    }
}

fun createOpCode8(index: Int, inputs: InputsAndWriteLocation): (MutableList<Int>) -> Int {
    return fun(memory: MutableList<Int>): Int {
        memory[inputs.writeLocation!!] = if (inputs.inputs[0] == inputs.inputs[1]) {
            1
        } else {
            0
        }

        return index + inputs.memoryOccupied
    }
}