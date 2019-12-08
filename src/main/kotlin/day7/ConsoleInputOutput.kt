package day7

interface Inputter {
    fun getInput(): Int
}

interface Outputter {
    fun output(value: Int)
}

data class SimpleInputter(val inputs: List<Int>) : Inputter {

    private val inputIterator: Iterator<Int>

    init {
        inputIterator = inputs.iterator()
    }
    override fun getInput() = inputIterator.next()

}

data class SimpleOutputter(val output: MutableList<Int> = mutableListOf()) : Outputter {
    override fun output(value: Int) {
        output.add(value)
    }
}