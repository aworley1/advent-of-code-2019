package day7

data class Inputter(val inputs: List<Int>) {
    private val inputIterator: Iterator<Int>

    init {
        inputIterator = inputs.iterator()
    }

    fun getInput() = inputIterator.next()
}

data class Outputter(val output: MutableList<Int> = mutableListOf()) {
    fun output(value: Int) {
        output.add(value)
    }
}