package implementation

import java.util.*


data class Node(
    val v: Int,
    val w: Int
)

fun main() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val (V, E) = br.readLine().split(" ").map { it.toInt() }
    val K = br.readLine().toInt()

    val graph = List(V + 1) { mutableListOf<Node>() }

    repeat(E) {
        val (u, v, w) = br.readLine().split(" ").map { it.toInt() }
        graph[u].add(Node(v, w))
    }

    fun solution(start: Int) {
        val queue = PriorityQueue<Node>(compareBy<Node> { it.w })
        queue.add(Node(start, 0))
        val answer = mutableListOf<Int>()

        val visited = IntArray(V + 1) { Int.MAX_VALUE }
        visited[start] = 0

        while (queue.isNotEmpty()) {
            val (sv, sw) = queue.remove()

            for ((nv, nw) in graph[sv]) {

                if (sw + nw < visited[nv]) {
                    visited[nv] = sw + nw
                    queue.add(Node(nv, sw + nw))
                }
            }
        }


        for (i in 1..V) {
            if (visited[i] != Int.MAX_VALUE) sb.append("${visited[i]}\n")
            else sb.append("INF\n")
        }
    }

    solution(K)

    bw.write(sb.toString())
    br.close()
    bw.close()

}
