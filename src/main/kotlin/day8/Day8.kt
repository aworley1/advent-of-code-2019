package day8

import java.io.File

fun main() {
    val input = File("inputs/day8.txt").readLines().first()

    part1(input)

    println(part2(input, 25, 6))

}

fun part1(input: String) {
    val layers = input.windowed(150, 150)

    val layerFewestZeros = layers.map { layer -> layer to layer.count { it == '0' } }
        .minBy { it.second }!!
        .first

    println("Part 1:")
    println(layerFewestZeros.count { it == '1' } * layerFewestZeros.count { it == '2' })
}

fun part2(input: String, width: Int, height: Int): String {
    println("Part 2:")

    val layers = input.windowed(width * height, width * height)

    val resolved = (0..(layers[0].length - 1)).map { index ->
        resolve(index, layers)
    }.joinToString("")

    return resolved
        .windowed(width, width)
        .joinToString("\n")
        .replace('0', ' ')
        .replace('1', '*')

}

private fun resolve(index: Int, layers: List<String>): String {
    for (layer in layers) {
        if (layer[index] in listOf('0', '1')) {
            return layer[index].toString()
        }
    }
    return ""
}
