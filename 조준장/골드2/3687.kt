import kotlin.math.min

class `3687` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val minDP = LongArray(101) { Long.MAX_VALUE }
        val maxDP = Array<String>(101) { "" }
        val arr = intArrayOf(0, 0, 1, 7, 4, 2, 0, 8)
        minDP[2] = 1
        minDP[3] = 7
        minDP[4] = 4
        minDP[5] = 2
        minDP[6] = 6
        minDP[7] = 8
        minDP[8] = 10
        for (i in 9..100) {
            for (j in 2..7) {
                minDP[i] = minOf(minDP[i], minDP[i - j] * 10 + arr[j])
            }
        }
        maxDP[2] = "1"
        maxDP[3] = "7"
        for (i in 4..100) {
            maxDP[i] = maxDP[i - 2] + "1"
        }

        repeat(br.readLine().toInt()) {
            val num = br.readLine().toInt()
            sb.append("${minDP[num]} ${maxDP[num]}\n")
        }

        bw.write(sb.dropLast(1).toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `3687`().solution()
}
