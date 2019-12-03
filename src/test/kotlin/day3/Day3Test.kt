package day3

import assertk.assertThat
import assertk.assertions.isEqualTo
import day3.Operation.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Day3Test : Spek({
    describe("parser") {
        it("should parse list of strings into list of ops") {
            val input = listOf("U1,D2", "L3,R4")

            val expectedResult = listOf(
                listOf(Instruction(U, 1), Instruction(D, 2)),
                listOf(Instruction(L, 3), Instruction(R, 4))
            )

            assertThat(parse(input)).isEqualTo(expectedResult)
        }
    }

    describe("coord finder") {
        it("should find coords for a list of instructions") {
            val instructions = listOf(
                Instruction(U, 2),
                Instruction(R, 3),
                Instruction(D, 2),
                Instruction(L, 1)
            )

            val expectedCoords = listOf(
                Coord(up = 1, right = 0),
                Coord(up = 2, right = 0),
                Coord(up = 2, right = 1),
                Coord(up = 2, right = 2),
                Coord(up = 2, right = 3),
                Coord(up = 1, right = 3),
                Coord(up = 0, right = 3),
                Coord(up = 0, right = 2)
            )

            val result = findCoordsForWire(instructions)
            assertThat(result).isEqualTo(expectedCoords)
        }
    }

    describe("day3 part1") {
        it("should calculate for first test input") {
            val input = listOf("R8,U5,L5,D3", "U7,R6,D4,L4")

            val result = solvePuzzle(input)

            assertThat(result).isEqualTo(6)
        }

        it("should calculate for test input1") {
            val input = listOf("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83")

            val result = solvePuzzle(input)

            assertThat(result).isEqualTo(159)
        }

        it("should calculate for test input2") {
            val input = listOf("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")

            val result = solvePuzzle(input)

            assertThat(result).isEqualTo(135)
        }
    }

    describe("day3 part2") {
        it("should calculate for test input1") {
            val input = listOf("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83")

            val result = solvePuzzlePart2(input)

            assertThat(result).isEqualTo(610)
        }

        it("should calculate for test input2") {
            val input = listOf("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")

            val result = solvePuzzlePart2(input)

            assertThat(result).isEqualTo(410)
        }
    }
})