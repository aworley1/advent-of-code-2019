package day5

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Day5Test : Spek({
    describe("intcode computer") {
        it("should match sample input 1") {
            val input = "1,0,0,0,99"

            val expectedResult = listOf(2, 0, 0, 0, 99)

            assertThat(compute(input)).isEqualTo(expectedResult)
        }

        it("should match sample input 2") {
            val input = "2,3,0,3,99"

            val expectedResult = listOf(2, 3, 0, 6, 99)

            assertThat(compute(input)).isEqualTo(expectedResult)
        }

        it("should match sample input 3") {
            val input = "2,4,4,5,99,0"

            val expectedResult = listOf(2, 4, 4, 5, 99, 9801)

            assertThat(compute(input)).isEqualTo(expectedResult)
        }

        it("should match sample input 4") {
            val input = "1,1,1,4,99,5,6,0,99"

            val expectedResult = listOf(30, 1, 1, 4, 2, 5, 6, 0, 99)

            assertThat(compute(input)).isEqualTo(expectedResult)
        }

        it("should perform opcode 3 and 4 instruction") {
            val consoleReader = mockk<ConsoleReader>()
            every { consoleReader() } returns "17"
            val consoleWriter = mockk<ConsoleWriter>(relaxed = true)
            val input = "3,0,4,0,99"

            val expectedResult = listOf(17, 0, 4, 0, 99)

            assertThat(compute(input, consoleReader, consoleWriter)).isEqualTo(expectedResult)
            verify { consoleWriter("17") }
        }

        it("should run a program with parameter mode operations") {
            val program = "1002,4,3,4,33"

            val expectedResult = listOf(1002, 4, 3, 4, 99)

            assertThat(compute(program)).isEqualTo(expectedResult)
        }

        it("opcode 5 should jump pointer for non-zero") {
            val program = "1105,1,4,100,99"
            val expectedResult = listOf(1105, 1, 4, 100, 99)

            assertThat(compute(program)).isEqualTo(expectedResult)
        }

        it("opcode 5 should not jump pointer for zero") {
            val program = "1105,0,4,99"
            val expectedResult = listOf(1105, 0, 4, 99)

            assertThat(compute(program)).isEqualTo(expectedResult)
        }

        it("opcode 6 should not jump pointer for non-zero") {
            val program = "1106,1,4,99"
            val expectedResult = listOf(1106, 1, 4, 99)

            assertThat(compute(program)).isEqualTo(expectedResult)
        }

        it("opcode 6 should jump pointer for zero") {
            val program = "1106,0,4,100,99"
            val expectedResult = listOf(1106, 0, 4, 100, 99)

            assertThat(compute(program)).isEqualTo(expectedResult)
        }
    }
})