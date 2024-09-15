class `16401` {

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (m, n) = br.readLine().split(" ").map { it.toInt() }
        val arr = br.readLine().split(" ").map { it.toInt() }.sorted()

        var start = 1
        var end = arr.last()
        var mid = 0
        var answer = 0
        while (start <= end) {
            mid = (start + end) / 2
            var cnt = 0

            arr.forEach {
                cnt += it / mid
                if (cnt >= m) return@forEach
            }

            if (cnt < m) {
                end = mid - 1
            } else {
                answer = mid
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
    `16401`().solution()

}


/**
 * 55
 * 3
 * 18
 *
 * 1 2 3 4 5 6 7 8 9 10
 * 10, 8
 * 9, 7, 2
 * 3 4 5 6
 *
 * */
