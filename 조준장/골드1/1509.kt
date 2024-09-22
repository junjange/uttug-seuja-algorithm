class `1509` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val word = br.readLine().toString()
        val n = word.length
        val dp = MutableList(n) { i ->
            MutableList(n) { j ->
                if (i == j) {
                    1
                } else {
                    0
                }
            }
        }

        repeat(n - 1) {
            if (word[it] == word[it + 1]) {
                dp[it][it + 1] = 1
            }
        }

        for (i in 3 until n + 1) {
            for (start in 0 until n - i + 1) {
                val end = start + i - 1
                if (word[start] == word[end] && dp[start + 1][end - 1] == 1) {
                    dp[start][end] = 1
                }
            }
        }

        val answer = MutableList(n + 1) { 2500 }
        for (end in 0 until n) {
            repeat(end + 1) { start ->
                if (dp[start][end] == 1) {
                    val newStart = if (start - 1 >= 0) answer[start - 1] else 0
                    answer[end] = minOf(answer[end], newStart + 1)
                } else {
                    val newEnd = if (end - 1 >= 0) answer[end - 1] else 0
                    answer[end] = minOf(answer[end], newEnd + 1)
                }
            }
        }
        sb.append(answer[n - 1])
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}


fun main() {
    `1509`().solution()
}


/**
 * BBCDDECAECBDABADDCEBACCCBDCAABDBADD
 * 11111111111111111111111111111111111
 * BB
 *
 *
 * */
