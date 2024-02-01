package implementation


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val graph = MutableList<MutableList<Int>>(n) { mutableListOf() }.map {
        br.readLine().split(" ").map { it.toInt() }.toMutableList()
    }.toMutableList()

    sb.append(bfs(graph = graph, m = m, n = n))

    bw.write(sb.toString())
    br.close()
    bw.close()

}


fun bfs(graph: MutableList<MutableList<Int>>, m: Int, n: Int): Int {

    var answer = 0
    val queue = ArrayDeque<List<Int>>()

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 1) queue.add(listOf(i, j))
        }
    }

    val dx = listOf(0, 0, 1, -1)
    val dy = listOf(1, -1, 0, 0)

    while (true) {
        val newQueue = ArrayDeque<List<Int>>()

        while (queue.isNotEmpty()) {

            val (x, y) = queue.removeFirst()

            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx in 0 until n && ny in 0 until m) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = 1
                        newQueue.addLast(listOf(nx, ny))
                    }

                }
            }
        }

        queue.addAll(newQueue)
        if (queue.isEmpty()) break
        answer++

    }

    graph.forEach { graph_item ->
        if (graph_item.any { it == 0 }) return -1
    }

    return answer
}
