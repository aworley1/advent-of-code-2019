package day4

fun main() {
    val validPasswords = (128392..643281)
        .map { it.toString() }
        .mapNotNull { if (validatePassword(it)) it else null }

    val validPasswordsPart2 = (128392..643281)
        .map { it.toString() }
        .mapNotNull { if (validatePasswordPart2(it)) it else null }

    println("${validPasswords.size} passwords are valid")
    println("${validPasswordsPart2.size} part 2 passwords are valid")
}

fun validatePassword(password: String): Boolean {
    return when {
        isSixDigits(password) && containsRepeatingDigits(password) && onlyIncreases(password) -> true
        else -> false
    }
}

fun validatePasswordPart2(password: String): Boolean {
    return when {
        isSixDigits(password)
                && containsRepeatingDigits(password)
                && onlyIncreases(password)
                && hasCorrectRepeatingDigits(password) -> true
        else -> false
    }
}

private fun isSixDigits(password: String): Boolean {
    return password.length == 6
}

private fun containsRepeatingDigits(password: String): Boolean {
    return password.windowed(2).any { it[0] == it[1] }
}

private fun onlyIncreases(password: String): Boolean {
    return password.windowed(2).all { it[0].toInt() <= it[1].toInt() }
}

private fun hasCorrectRepeatingDigits(password: String): Boolean {
    return countRepeatingDigits(password).contains(2)
}

fun countRepeatingDigits(password: String): List<Int> {
    val numbersOfRepeats = mutableListOf<Int>()
    var numberOfRepeats = 0

    password.forEachIndexed { index, c ->
        val nextChar =
            if (index + 1 != password.length) {
                password[index + 1]
            } else null

        numberOfRepeats++

        if (nextChar != c) {
            numbersOfRepeats.add(numberOfRepeats)
            numberOfRepeats = 0
        }
    }

    return numbersOfRepeats.toList()
}