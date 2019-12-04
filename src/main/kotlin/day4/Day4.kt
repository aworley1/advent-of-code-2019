package day4

fun validatePassword(password: String): Boolean {
    return when {
        isSixDigits(password) && containsRepeatingDigits(password) && onlyIncreases(password) -> true
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
