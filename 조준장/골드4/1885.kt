class `1885`() {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val visited = BooleanArray(10001)
        var answer = 1
        var cnt = 0

        repeat(n) {
            val t = br.readLine().toInt()

            if (!visited[t]) {
                cnt++
                visited[t] = true
            }

            if (cnt == k) {
                answer++
                visited.fill(false)
                cnt = 0
            }
        }

        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `1885`().solution()
}
