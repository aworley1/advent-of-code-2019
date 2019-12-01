package day1

import java.io.File

fun main() {
    println(run("inputs/day1.txt"))
}

fun run(filename: String): String {
    return File(filename).readLines()
        .map { calculateFuel(it.toInt()) }
        .sum()
        .toString()
}

fun calculateFuel(mass: Int): Int {
    return (mass / 3) - 2
}