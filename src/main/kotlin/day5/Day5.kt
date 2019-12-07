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

fun createOpCode1(index: Int, inputs: List<Int>): (MutableList<Int>) -> Int {
    return fun (memory: MutableList<Int>): Int {
        val added = memory.readFromMemory(index + 1) + memory.readFromMemory(index + 2)
        memory.writePositionMode(locationOfParameter = index + 3, value = added)

        return index + 4
    }
}

fun createOpCode2(index: Int, inputs: List<Int>): (MutableList<Int>) -> Int {
    return fun(memory: MutableList<Int>): Int {
        val multiplied = memory.readFromMemory(index + 1) * memory.readFromMemory(index + 2)
        memory.writePositionMode(locationOfParameter = index + 3, value = multiplied)

        return index + 4
    }
}

fun createOpCode3(index: Int, inputs: List<Int>, reader: ConsoleReader): (MutableList<Int>) -> Int {
    return fun(memory: MutableList<Int>): Int {
        val input = reader()

        memory.writePositionMode(locationOfParameter = index + 1, value = input.toInt())

        return index + 2
    }
}

fun createOpCode4(index: Int, inputs: List<Int>,writer: ConsoleWriter): (MutableList<Int>) -> Int {
    return fun(memory: MutableList<Int>): Int {

        writer(memory.readFromMemory(index + 1).toString())

        return index + 2
    }
}

private fun MutableList<Int>.writePositionMode(locationOfParameter: Int, value: Int) {
    this[this[locationOfParameter]] = value
}

private fun MutableList<Int>.readFromMemory(locationOfLocationToRead: Int): Int {
    return this[this[locationOfLocationToRead]]
}