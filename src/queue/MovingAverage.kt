package queue

import java.util.*

fun main() {
    MovingAverage(3).apply {
        next(1)
        next(10)
        next(3)
        next(5)
    }
}

class MovingAverage(val size: Int) {
    val queue = ArrayDeque<Int>(size)

    fun next(`val`: Int): Double {
        if (size == queue.size){
            queue.pop()
        }
        queue.add(`val`)
        var sum: Double = 0.0
        queue.forEach {
            sum += it
        }
        return (sum / queue.size).also {
            println(it)
        }
    }

}