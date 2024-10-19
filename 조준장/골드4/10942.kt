class `10942` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }
        val m = br.readLine().toInt()

        val dp = Array(n) { Array(n) { 0 } }
        for (i in 0 until n) {
            for (j in i until n) {
                var newI = i
                var newJ = j
                while (arr[newI] == arr[newJ]) {
                    if (newJ <= newI) {
                        dp[i][j]++
                        break
                    }
                    newI++
                    newJ--
                }
            }
        }

        repeat(m) {
            val (s, e) = br.readLine().split(" ").map { it.toInt() }
            sb.append(dp[s - 1][e - 1]).append("\n")
        }

        bw.write(sb.dropLast(1).toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `10942`().solution()
}
