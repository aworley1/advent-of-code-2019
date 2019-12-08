package day7

import com.google.common.collect.Collections2
import kotlinx.coroutines.runBlocking
import java.io.File

fun main() {
    val program = File("inputs/day7.txt").readLines().first()

    println("Part1: ${part1(program)}")
}

fun part1(program: String): Int {
    val phases = listOf(0, 1, 2, 3, 4)

    val outputsForAllPhasePermutations = Collections2.permutations(phases)
        .map { calculateAmplifierOutput(program, it) }

    return outputsForAllPhasePermutations.max()!!
}

fun calculateAmplifierOutput(program: String, phases: List<Int>): Int {
    val outputter = SimpleOutputter(mutableListOf(0))

    for (phase in phases) {
        val inputter = SimpleInputter(listOf(phase, outputter.output.last()))
        compute(program, inputter, outputter)
    }

    return outputter.output.last()
}

fun compute(
    input: List<Int>,
    reader: Inputter = SimpleInputter(emptyList()),
    writer: Outputter = SimpleOutputter(mutableListOf())
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
    reader: Inputter = SimpleInputter(emptyList()),
    writer: Outputter = SimpleOutputter(mutableListOf())
): List<Int> {
    val program = input.split(",")
        .map { it.toInt() }

    return compute(program, reader, writer)
}

private fun performOperation(
    index: Int,
    memory: MutableList<Int>,
    reader: Inputter,
    writer: Outputter
): Int {
    val operation =
        parseOpCode(index, memory, reader, writer)

    return runBlocking { operation.function(memory) }
}

fun MutableList<Int>.readFromMemory(locationOfLocationToRead: Int): Int {
    return this[this[locationOfLocationToRead]]
}