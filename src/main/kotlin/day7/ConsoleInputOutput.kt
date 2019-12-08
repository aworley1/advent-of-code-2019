package day7

import kotlinx.coroutines.channels.Channel

interface Inputter {
    suspend fun getInput(): Int
}

interface Outputter {
    suspend fun output(value: Int)
}

data class SimpleInputter(val inputs: List<Int>) : Inputter {

    private val inputIterator: Iterator<Int>

    init {
        inputIterator = inputs.iterator()
    }
    override suspend fun getInput() = inputIterator.next()

}

data class SimpleOutputter(val output: MutableList<Int> = mutableListOf()) : Outputter {
    override suspend fun output(value: Int) {
        output.add(value)
    }
}

class ChannelInputter(val channel: Channel<Int>): Inputter {
    override suspend fun getInput(): Int {
        println("waiting for input")
        val value = channel.receive()
        println ("received $value")
        return value
    }
}

class ChannelOutputter(val channel: Channel<Int>): Outputter {
    override suspend fun output(value: Int) {
        println("sending $value")
        channel.send(value)
    }
}
