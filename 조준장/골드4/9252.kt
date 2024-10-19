class `9252` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val words1 = br.readLine().map { it.toString() }
        val words2 = br.readLine().map { it.toString() }

        val dp = Array(words1.size + 1) { Array(words2.size + 1) { 0 } }

        for (i in 1..words1.size) {
            for (j in 1..words2.size) {
                if (words1[i - 1] == words2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        val size = dp[words1.size][words2.size]
        sb.append(size)
        if (size != 0) {
            sb.append("\n")
            var i = words1.size
            var j = words2.size
            var answer = ""
            while (i > 0) {
                when (dp[i][j]) {
                    dp[i - 1][j] -> i--
                    dp[i][j - 1] -> j--
                    else -> {
                        i--
                        j--
                        answer = "${words1[i]}$answer"
                    }
                }
            }

            sb.append(answer)
        }

        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `9252`().solution()
}
