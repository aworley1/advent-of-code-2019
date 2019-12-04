package day4

import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Day4Test :  Spek({
    describe("password validator") {
        it("should not validate if number is not 6 digits") {
            assertThat(validatePassword("1123")).isFalse()
            assertThat(validatePassword("112344444444")).isFalse()
        }

        it("should not validate if there are no repeating digits") {
            assertThat(validatePassword("123456")).isFalse()
        }

        it("should not validate if there are digits which decrease") {
            assertThat(validatePassword("113436")).isFalse()
        }

        it("should validate if there are repeating digits which never decrease") {
            assertThat(validatePassword("111111")).isTrue()
        }

    }
})