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
    val operationCode = memory[index]

    val operation: (Int, MutableList<Int>) -> Int = when (operationCode) {
        1 -> ::opCode1
        2 -> ::opCode2
        3 -> createOpCode3(reader)
        4 -> createOpCode4(writer)
        else -> throw NotImplementedError("Operation $operationCode not implemented")
    }

    return operation(index, memory)
}

fun opCode1(index: Int, memory: MutableList<Int>): Int {
    val added = memory[memory[index + 1]] + memory[memory[index + 2]]
    memory.writePositionMode(locationOfParameter = index + 3, value = added)

    return index + 4
}

fun opCode2(index: Int, memory: MutableList<Int>): Int {
    val multiplied = memory[memory[index + 1]] * memory[memory[index + 2]]
    memory.writePositionMode(locationOfParameter = index + 3, value = multiplied)

    return index + 4
}

fun createOpCode3(reader: ConsoleReader): (Int, MutableList<Int>) -> Int {
    return fun(index: Int, memory: MutableList<Int>): Int {
        val input = reader()

        memory.writePositionMode(locationOfParameter = index + 1, value = input.toInt())

        return index + 2
    }
}

fun createOpCode4(writer: ConsoleWriter): (Int, MutableList<Int>) -> Int {
    return fun(index: Int, memory: MutableList<Int>): Int {

        writer(memory[memory[index + 1]].toString())

        return index + 2
    }
}

private fun MutableList<Int>.writePositionMode(locationOfParameter: Int, value: Int) {
    this[this[locationOfParameter]] = value
}