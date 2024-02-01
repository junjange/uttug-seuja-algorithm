package implementation

import java.util.*

data class Balloon(
    val index: Int,
    val moved: Int
)

fun main() {
    val n = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    val answer = mutableListOf<Int>()

    val deque: ArrayDeque<Balloon> = ArrayDeque()

    repeat(n) {
        deque.add(Balloon(it + 1, numbers[it]))
    }

    while (true) {
        val target =  deque.removeFirst()
        answer.add(target.index)

        if (deque.size == 0) break

        if (target.moved > 0) {
            for (i in 1 until target.moved) deque.addLast(deque.removeFirst())
        } else{
            for (i in target.moved until 0) deque.addFirst(deque.removeLast())

        }
    }
    println(answer.joinToString(" "))
}
