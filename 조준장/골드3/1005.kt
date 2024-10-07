class `1005` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        repeat(br.readLine().toInt()) {
            val (n, k) = br.readLine().split(" ").map { it.toInt() }
            val time = listOf(0) + br.readLine().split(" ").map { it.toInt() }
            val graph = List(n + 1) { mutableListOf<Int>() }
            val inDegree = IntArray(n + 1)
            repeat(k) {
                val (x, y) = br.readLine().split(" ").map { it.toInt() }
                graph[x].add(y)
                inDegree[y]++
            }

            val w = br.readLine().toInt()

            val queue = ArrayDeque<Int>()
            val result = IntArray(n + 1)
            for (i in 1..n) {
                result[i] = time[i]
                if (inDegree[i] == 0) {
                    queue.add(i)
                }
            }

            while (queue.isNotEmpty()) {
                val now = queue.removeFirst()
                for (next in graph[now]) {
                    result[next] = maxOf(result[next], result[now] + time[next])
                    inDegree[next]--
                    if (inDegree[next] == 0) {
                        queue.add(next)
                    }
                }
            }
            sb.append(result[w]).append("\n")
        }

        bw.write(sb.dropLast(1).toString())
        br.close()
        bw.close()
    }
}


fun main() {
    `1005`().solution()
}
