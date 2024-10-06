class `15681` {
    var graph: Array<MutableList<Int>> = arrayOf()
    var visited: Array<Boolean> = arrayOf()
    var answer: MutableList<Int> = mutableListOf()
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, r, q) = br.readLine().split(" ").map { it.toInt() }
        graph = Array(n + 1) { mutableListOf<Int>() }
        visited = Array(n + 1) { false }.apply { this[r] = true }
        answer = MutableList(n + 1) { 1 }
        repeat(n - 1) {
            val (u, v) = br.readLine().split(" ").map { it.toInt() }
            graph[u].add(v)
            graph[v].add(u)
        }

        backtracking(r, 0)
        repeat(q) {
            val num = br.readLine().toInt()
            sb.append("${answer[num]}\n")
        }

        bw.write(sb.dropLast(1).toString())
        br.close()
        bw.close()


    }

    private fun backtracking(start: Int, depth: Int): Int {
        if (depth > graph.size) return 0

        for (next in graph[start]) {
            if (!visited[next]) {
                visited[next] = true
                answer[start] += backtracking(next, depth + 1)
            }
        }

        return answer[start]
    }
}

fun main() {
    `15681`().solution()
}
