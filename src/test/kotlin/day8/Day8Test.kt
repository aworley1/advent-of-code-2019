package day8

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Day8Test : Spek({
    describe("part 2") {
        it("should resolve example as given") {
            val result = part2("0222112222120000", 2, 2)

            val expectedResult = """ *
                |* 
            """.trimMargin()

            assertThat(result).isEqualTo(expectedResult)
        }
    }
})
