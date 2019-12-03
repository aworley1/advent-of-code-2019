package day2

import java.io.File

fun main() {
    for (noun in 0..100) {
        for (verb in 0..100) {
//            println("Run noun: $noun, verb: $verb")
            val program = File("inputs/day2.txt").readLines()
                .first()
                .split(",")
                .map { it.toInt() }
                .toMutableList()

            program[1] = noun
            program[2] = verb

            val output = compute(program)[0]

            if (output == 19690720) println("noun: $noun, verb: $verb, answer: ${100 * noun + verb}")
        }
    }
}