package implementation

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()

    val queue = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n) {
        val x = br.readLine().toInt()
        if (x == 0) if (queue.isEmpty()) sb.append("0\n") else sb.append("${queue.poll()}\n")
        else queue.offer(x)
    }

    bw.write(sb.toString())
    bw.close()
    br.close()

}
