package day5

import assertk.assertThat
import assertk.assertions.isEqualTo
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
    }
})