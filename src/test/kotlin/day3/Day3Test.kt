package day3

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Day3Test : Spek({
    describe("day3") {
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
})