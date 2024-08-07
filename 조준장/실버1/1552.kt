class `1522` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val words = br.readLine().map { it.toString() }.toMutableList()

        val b = words.count { it == "b" }

        words += words.subList(0, b)

        var answer = Int.MAX_VALUE

        for (i in 0 until words.size - b) {
            answer = minOf(answer, words.subList(i, i + b).count { it == "a" })
        }

        sb.append(answer)
        bw.write(sb.toString())
        bw.close()
        br.close()
    }
}

fun main() {
    `1522`().solution()
}
