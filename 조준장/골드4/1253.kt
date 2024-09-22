class `1253` {
    fun solution() {

        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toLong() }.sorted()

        var answer = 0
        for (i in 0 until n) {
            var start = 0
            var end = n - 1
            var total = 0L
            while (start < end) {
                total = arr[start] + arr[end]

                if (total <= arr[i]) {
                    if (total == arr[i]) {
                        if (start != i && end != i && start != end) break
                        if (end == i) {
                            end--
                            continue
                        }
                    }
                    start++
                } else {
                    end--
                }
            }

            if (start in 0..n - 1 && end in 0..n - 1) {
                total = arr[start] + arr[end]

                if (total == arr[i]) {
                    if (start != i && end != i && start != end && start < end) {
                        answer++
                    }
                }
            }
        }

        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `1253`().solution()
}

/**
 *
 * 10
 * 1 2 3 4 5 7 8 9 10 16
 *
 * 1 10
 * 2 10
 * 3 10
 * 4 10
 * 5 10
 *
 * */
