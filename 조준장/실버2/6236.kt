class `6236` {

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val arr = List(n) { br.readLine().toInt() }

        var start = 1
        var end = arr.sum()
        var mid = 0
        while (start <= end) {
            mid = (start + end) / 2

            var cnt = 0
            var money = 0
            arr.forEach {
                if (money < it) {
                    money = mid
                    cnt += 1
                }
                money -= it

                if (money < 0) {
                    cnt = 100001
                    return@forEach
                }
            }

            if (cnt <= k) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        sb.append(start)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `6236`().solution()
}
