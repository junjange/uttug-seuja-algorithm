class `23830` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toLong() }.sorted()
        val (p, q, r, s) = br.readLine().split(" ").map { it.toLong() }

        var start = 1
        var end = 110000
        var mid = 0
        var answer = -1
        while (start <= end) {
            mid = (start + end) / 2
            var total = 0L
            arr.forEach {
                if (mid + r < it) {
                    total -= p
                }

                if (it < mid) {
                    total += q
                }

                total += it
            }

            if (s <= total) {
                answer = mid
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `23830`().solution()
}
