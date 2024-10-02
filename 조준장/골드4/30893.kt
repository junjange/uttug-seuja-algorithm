class `30893` {

    enum class User {
        FIRST, SECOND;

        fun change(): User {
            return if (this == FIRST) SECOND else FIRST
        }
    }

    val MAX = 100001
    val graph = Array(MAX) { mutableListOf<Int>() }
    val visit = BooleanArray(MAX)
    var n = 0
    var s = 0
    var e = 0


    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val line = br.readLine().split(" ").map { it.toInt() }
        n = line.first()
        s = line[1]
        e = line.last()

        repeat(n - 1) {
            val (u, v) = br.readLine().split(" ").map { it.toInt() }
            graph[u].add(v)
            graph[v].add(u)
        }

        val success = if (dfs(s, User.FIRST)) "First" else "Second"
        sb.append(success)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }

    private fun dfs(v: Int, user: User): Boolean {
        if (v == e) return true
        visit[v] = true

        var cnt = 0
        var flag = false
        for (next in graph[v]) {
            if (visit[next]) continue
            flag = flag || dfs(next, user.change())
            cnt++
        }
        if (user == User.SECOND && cnt > 1) return false

        return flag
    }
}

fun main() {
    `30893`().solution()
}
