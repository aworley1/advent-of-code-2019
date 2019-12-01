package day1

import java.io.File
import java.lang.Integer.max

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
    val extraFuel = max((mass / 3) - 2, 0)

    return when (extraFuel) {
        0 -> 0
        else -> {
            extraFuel + calculateFuel(extraFuel)
        }
    }
}