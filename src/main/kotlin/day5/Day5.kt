package day5

import java.io.File

fun main() {
    val input = File("inputs/day5.txt").readLines().first()
    println(compute(input))
}

fun compute(input: List<Int>): List<Int> {
    val memory = input.toMutableList()

    var index = 0

    while (true) {
        if (memory[index] == 99) break
        index = performOperation(index, memory)
    }


    return memory
}

fun compute(input: String): List<Int> {
    val program = input.split(",")
        .map { it.toInt() }

    return compute(program)
}

private fun performOperation(index: Int, memory: MutableList<Int>): Int {
    val operationCode = memory[index]

    val operation: (Int, MutableList<Int>) -> Int = when (operationCode) {
        1 -> ::opCode1
        2 -> ::opCode2
        else -> throw NotImplementedError("Operation $operationCode not implemented")
    }

    return operation(index, memory)
}

fun opCode1(index: Int, memory: MutableList<Int>): Int {
    memory[memory[index + 3]] = memory[memory[index + 1]] + memory[memory[index + 2]]

    return index + 4
}

fun opCode2(index: Int, memory: MutableList<Int>): Int {
    memory[memory[index + 3]] = memory[memory[index + 1]] * memory[memory[index + 2]]

    return index + 4
}