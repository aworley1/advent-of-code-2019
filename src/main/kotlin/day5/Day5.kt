package day5

import java.io.File

fun main() {
    val input = File("inputs/day5.txt").readLines().first()
    println(compute(input))
}

fun compute(
    input: List<Int>,
    reader: ConsoleReader = consoleReader,
    writer: ConsoleWriter = consoleWriter
): List<Int> {
    val memory = input.toMutableList()

    var index = 0

    while (true) {
        if (memory[index] == 99) break
        index = performOperation(index, memory, reader, writer)
    }


    return memory
}

fun compute(
    input: String,
    reader: ConsoleReader = consoleReader,
    writer: ConsoleWriter = consoleWriter
): List<Int> {
    val program = input.split(",")
        .map { it.toInt() }

    return compute(program, reader, writer)
}

private fun performOperation(
    index: Int,
    memory: MutableList<Int>,
    reader: ConsoleReader,
    writer: ConsoleWriter
): Int {
    val operation =
        parseOpCode(index, memory, reader, writer)

    return operation.function(memory)
}

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

fun createOpCode3(index: Int, inputs: InputsAndWriteLocation, reader: ConsoleReader): (MutableList<Int>) -> Int {
    return fun(memory: MutableList<Int>): Int {
        val input = reader()

        memory[inputs.writeLocation!!] = input.toInt()

        return index + inputs.memoryOccupied
    }
}

fun createOpCode4(index: Int, inputs: InputsAndWriteLocation, writer: ConsoleWriter): (MutableList<Int>) -> Int {
    return fun(_: MutableList<Int>): Int {

        writer(inputs.inputs[0].toString())

        return index + inputs.memoryOccupied
    }
}

fun MutableList<Int>.readFromMemory(locationOfLocationToRead: Int): Int {
    return this[this[locationOfLocationToRead]]
}