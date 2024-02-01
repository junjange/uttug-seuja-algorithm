package implementation

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine()!!.toInt()
    val deque = ArrayDeque<Int>()
    repeat(n) {

        val order = br.readLine()!!.split(" ").map { it.toInt() }

        when (order[0]) {
            1 -> deque.addFirst(order[1])
            2 -> deque.addLast(order[1])
            3 -> if (deque.isEmpty()) sb.append("-1\n") else sb.append("${deque.removeFirst()}\n")
            4 -> if (deque.isEmpty()) sb.append("-1\n") else sb.append("${deque.removeLast()}\n")
            5 -> sb.append("${deque.size}\n")
            6 -> if (deque.isEmpty()) sb.append("1\n") else sb.append("0\n")
            7 -> if (deque.isEmpty()) sb.append("-1\n") else sb.append("${deque.first}\n")
            8 -> if (deque.isEmpty()) sb.append("-1\n") else sb.append("${deque.last}\n")
        }
    }


    bw.write(sb.toString())
    bw.close()
    br.close()
}
