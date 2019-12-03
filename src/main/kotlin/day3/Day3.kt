package day3

fun solvePuzzle(input: List<String>): Int {
    return 0
}

fun parse(input: List<String>): List<List<Instruction>> {
    return input.map { it.split(",") }
        .map {
            it.map {
                Instruction(
                    operation = Operation.valueOf(it.substring(0, 1)),
                    amount = it.substring(1).toInt()
                )
            }
        }
}

fun findCoordsForWire(instructions: List<Instruction>): List<Coord> {
    var startingCoord = Coord(0, 0)
    val coords = mutableListOf<Coord>()

    instructions.forEach {
        val addedCoords = it.operation.op(startingCoord, it.amount)
        val endCoord = addedCoords.last()
        coords.addAll(addedCoords)
        startingCoord = endCoord
    }

    return coords.toList()
}

data class Instruction(val operation: Operation, val amount: Int)

data class Coord(val up: Int, val right: Int)

enum class Operation(val op: (Coord, Int) -> List<Coord>) {
    U(addToCoord { coord, i -> coord.copy(up = coord.up + i) }),
    D(addToCoord { coord, i -> coord.copy(up = coord.up - i) }),
    L(addToCoord { coord, i -> coord.copy(right = coord.right - i) }),
    R(addToCoord { coord, i -> coord.copy(right = coord.right + i) })
}

private fun addToCoord(addInDirection: (Coord, Int) -> Coord): (Coord, Int) -> List<Coord> {
    return fun(startingCoord: Coord, amount: Int): List<Coord> {
        return (1..amount).map { addInDirection(startingCoord, it) }
    }
}