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

fun MutableList<Int>.readFromMemory(locationOfLocationToRead: Int): Int {
    return this[this[locationOfLocationToRead]]
}