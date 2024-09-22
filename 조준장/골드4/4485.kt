import java.util.PriorityQueue

class `4485` {
    data class Node(val x: Int, val y: Int, val k: Int)

    lateinit var graph: MutableList<List<Int>>
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()
        var cnt = 1

        while (true) {
            val n = br.readLine().toInt()
            if (n == 0) break

            graph = MutableList(n) {
                br.readLine().split(" ").map { it.toInt() }
            }
            sb.append("Problem $cnt: ${bfs(n)}\n")
            cnt++
        }

        bw.append(sb.dropLast(1).toString())
        br.close()
        bw.close()

    }

    fun bfs(n: Int): Int {
        val dx = listOf(1, -1, 0, 0)
        val dy = listOf(0, 0, 1, -1)
        val visited = MutableList(n) { MutableList(n) { false } }
        val queue = PriorityQueue<Node> { o1, o2 ->
            o1.k - o2.k
        }

        queue.add(Node(0, 0, graph[0][0]))
        visited[0][0] = true

        while (queue.isNotEmpty()) {
            val tNode = queue.poll()

            if (tNode.x == n - 1 && tNode.y == n - 1) {
                return tNode.k
            }

            repeat(4) {
                val nx = tNode.x + dx[it]
                val ny = tNode.y + dy[it]

                if (nx in 0..<n && ny in 0..<n && !visited[nx][ny]) {
                    queue.add(Node(nx, ny, tNode.k + graph[nx][ny]))
                    visited[nx][ny] = true
                }
            }


        }
        return -1
    }
}

fun main() {
    `4485`().solution()
}
