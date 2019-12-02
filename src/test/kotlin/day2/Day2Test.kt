package day2

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Day2Test : Spek({
describe("intcode computer") {
    it("should add two numbers, and write to the correct location") {
        val input = "1,2,3,4,0"

        val expectedResult = listOf(1,2,3,4,5)

        assertThat(compute(input)).isEqualTo(expectedResult)
    }
}
})