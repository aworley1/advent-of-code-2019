package day4

import assertk.assertThat
import assertk.assertions.isEqualTo
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

    describe("part 2 password validator") {
        it("should not validate if number is not 6 digits") {
            assertThat(validatePasswordPart2("1123")).isFalse()
            assertThat(validatePasswordPart2("112344444444")).isFalse()
        }

        it("should not validate if there are no repeating digits") {
            assertThat(validatePasswordPart2("123456")).isFalse()
        }

        it("should not validate if there are digits which decrease") {
            assertThat(validatePasswordPart2("113436")).isFalse()
        }

        it("should validate if there are repeating digits which never decrease") {
            assertThat(validatePasswordPart2("112345")).isTrue()
        }

        it("should match test input 1") {
            assertThat(validatePasswordPart2("112233")).isTrue()
        }

        it("should match test input 2") {
            assertThat(validatePasswordPart2("123444")).isFalse()
        }

        it("should match test input 3") {
            assertThat(validatePasswordPart2("111122")).isTrue()
        }

    }

    describe("repeating digit counter") {
        it("should correctly count groups of repeats") {
            assertThat(countRepeatingDigits("1112222")).isEqualTo(listOf(3,4))
        }
    }
})