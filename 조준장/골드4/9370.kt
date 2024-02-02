package implementation

import java.util.*


fun main() {

    data class Node(
        val destination: Int,
        val length: Int
    )

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val T = br.readLine().toInt()

    repeat(T) {
        val (n, m, t) = br.readLine().split(" ").map { it.toInt() }
        val (s, g, h) = br.readLine().split(" ").map { it.toInt() }
        val graph = List(n + 1) { mutableListOf<Node>() }

        repeat(m) {
            val (a, b, d) = br.readLine().split(" ").map { it.toInt() }
            graph[a].add(Node(b, d))
            graph[b].add(Node(a, d))
        }

        val destinations = mutableListOf<Int>()

        repeat(t) {
            destinations.add(br.readLine().toInt())
        }

        fun solution(start: Int): IntArray {
            val visited = IntArray(n + 1) { Int.MAX_VALUE }
            val queue = PriorityQueue<Node>(compareBy<Node> { it.length })
            queue.add(Node(start, 0))
            visited[start] = 0

            while (queue.isNotEmpty()) {
                val (sd, sl) = queue.remove()

                for ((nd, nl) in graph[sd]) {
                    if (sl + nl < visited[nd]) {
                        visited[nd] = sl + nl
                        queue.add(Node(nd, sl + nl))
                    }
                }
            }

            return visited
        }

        val fromS = solution(s)
        val fromG = solution(g)
        val fromH = solution(h)

        val answer = mutableListOf<Int>()

        for (destination in destinations) {

            if ((fromS[g] + fromG[h] + fromH[destination] == fromS[destination]) || (fromS[h] + fromH[g] + fromG[destination] == fromS[destination])) {
                answer.add(destination)
            }
        }
        sb.append("${answer.sorted().joinToString(" ")}\n")

    }

    bw.write(sb.toString())
    br.close()
    bw.close()


}
