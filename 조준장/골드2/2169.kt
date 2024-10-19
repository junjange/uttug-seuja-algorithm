import java.util.*

class `2169` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val graph = listOf(List(m + 1) { 0 }) + List(n) {
            listOf(0) + br.readLine().split(" ").map { it.toInt() } + listOf(0)
        } + listOf(List(m + 1) { 0 })

        val dp = graph.map { it.toMutableList() }

        for (i in 1..m) {
            dp[1][i] += dp[1][i - 1]
        }

        for (i in 2..n) {
            val newDp = IntArray(m + 2) { -100 }
            val newDpReversed = IntArray(m + 2) { -100 }

            newDp[1] = dp[i - 1][1] + graph[i][1]
            for (j in 2..m) {
                newDp[j] = dp[i][j] + maxOf(dp[i - 1][j], newDp[j - 1])
            }

            newDpReversed[m] = dp[i - 1][m] + graph[i][m]
            for (j in (m - 1 downTo 1)) {
                newDpReversed[j] = dp[i][j] + maxOf(dp[i - 1][j], newDpReversed[j + 1])
            }

            for (j in 1..m) {
                dp[i][j] = maxOf(newDp[j], newDpReversed[j])
            }
        }

        sb.append(dp[n][m])
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `2169`().solution()
}
