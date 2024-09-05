class `4179`() {
    data class Node(val c: Int, val r: Int, val depth: Int = 1)

    lateinit var graph: List<MutableList<String>>
    var answer: Int? = null
    val jQueue = ArrayDeque<Node>()

    val fQueue = ArrayDeque<Node>()
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()



        val (r, c) = br.readLine().split(" ").map { it.toInt() }
        graph = List(r) {
            val column = br.readLine().map { it.toString() }
            column.forEachIndexed { idx, item ->
                if (item == "J") {
                    jQueue.add(Node(it, idx))
                }
                if (item == "F") {
                    fQueue.add(Node(it, idx))
                }
            }
            column.toMutableList()
        }

        answer = if (graph.first().all { it == "#" } && graph.last().all { it == "#" } && graph.map { it.first() }
                .all { it == "#" } && graph.map { it.last() }.all { it == "#" }) {
            null
        } else {
            bfs(r, c)
        }

        if (answer == null) {
            sb.append("IMPOSSIBLE")
        } else {
            sb.append(answer)
        }
        bw.write(sb.toString())
        br.close()
        bw.close()
    }

    fun bfs(r: Int, c: Int): Int? {
        val dr = listOf(1, -1, 0, 0)
        val dc = listOf(0, 0, 1, -1)


        while (jQueue.isNotEmpty()) {
            repeat(jQueue.size) {
                val (tr, tc, depth) = jQueue.removeFirst()
                if (graph[tr][tc] != "F" && graph[tr][tc] != "#") {
                    if (tr == 0 || tc == 0 || tr == r - 1 || tc == c - 1) {
                        return depth
                    }

                    repeat(4) {
                        val nr = tr + dr[it]
                        val nc = tc + dc[it]

                        if (nr in 0..<r && nc in 0..<c && graph[nr][nc] == ".") {
                            graph[nr][nc] = "J"
                            jQueue.add(Node(nr, nc, depth + 1))
                        }
                    }
                }
            }

            repeat(fQueue.size) {
                val (gr, gc) = fQueue.removeFirst()
                repeat(4) {
                    val nr = gr + dr[it]
                    val nc = gc + dc[it]

                    if (nr in 0..<r && nc in 0..<c && (graph[nr][nc] == "." || graph[nr][nc] == "J")) {
                        fQueue.add(Node(nr, nc))
                        graph[nr][nc] = "F"
                    }
                }
            }
        }

        return null
    }
}

fun main() {
    `4179`().solution()
}
