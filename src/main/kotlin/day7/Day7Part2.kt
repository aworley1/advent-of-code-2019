package day7

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

const val NUMBER_OF_AMPLIFIERS = 5

fun part2(program: String): Int {

    val inputChannels = (0..NUMBER_OF_AMPLIFIERS).map { Channel<Int>(10) }
    val outputChannels = inputChannels.subList(1, NUMBER_OF_AMPLIFIERS) + inputChannels[0]

    val output = runBlocking {
        (1..NUMBER_OF_AMPLIFIERS).map {
            val index = it - 1
            launch { compute(program, ChannelInputter(inputChannels[index]), ChannelOutputter(outputChannels[index])) }
        }

        val phases = listOf(9, 8, 7, 6, 5)

        phases.mapIndexed { index, phase ->
            launch { inputChannels[index].send(phase) }
        }

        println("about to send first input")
        launch {
            inputChannels[0].send(0)
            println("sent first input")
        }

        //outputChannels[NUMBER_OF_AMPLIFIERS - 1].receive()
    }

    return 0
}

