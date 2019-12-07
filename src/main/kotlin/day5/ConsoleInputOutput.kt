package day5

typealias ConsoleReader = () -> String
typealias ConsoleWriter = (String) -> Unit

val consoleReader: ConsoleReader = { readLine()!! }
val consoleWriter: ConsoleWriter = fun(output: String) { return println(output) }