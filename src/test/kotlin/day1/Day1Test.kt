package day1

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Day1Test : Spek({
    describe("day1") {
        it("should calculate single fuel requirement for number divisible by 3") {
            assertThat(calculateFuel(12)).isEqualTo(2)
        }

        it("should calculate single fuel requirement for number not divisible by 3") {
            assertThat(calculateFuel(14)).isEqualTo(2)
        }

        it("should not include negative fuel requirements") {
            assertThat(calculateFuel(2)).isEqualTo(0)
        }

        it("should add extra fuel for the extra fuel (and extra fuel for that extra fuel") {
            assertThat(calculateFuel(1969)).isEqualTo(966)
        }

        it("should read input from a file and add results together") {
            assertThat(run("inputs/test/day1.txt")).isEqualTo("51312")
        }
    }
})