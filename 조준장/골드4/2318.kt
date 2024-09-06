class `2138` {
    val d = listOf(-1, 0, 1)

    fun switch(
        start: Int,
        n: Int,
        after: MutableList<Int>,
        before: MutableList<Int>,
    ): Int {
        var cnt = 0

        if (start == 0) {
            cnt++
            repeat(3) {
                val nd = start + d[it]
                if (nd in 0 until n) {
                    if (after[nd] == 1) {
                        after[nd] = 0
                    } else {
                        after[nd] = 1
                    }
                }
            }
        }

        for (i in 1 until n) {
            if (after[i - 1] != before[i - 1]) {
                cnt++
                repeat(3) {
                    val nd = i + d[it]
                    if (nd in 0 until n) {
                        if (after[nd] == 1) {
                            after[nd] = 0
                        } else {
                            after[nd] = 1
                        }
                    }
                }
            }
        }
        if (before == after) {
            return cnt
        }
        return -1
    }

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val before = br.readLine().map { it.toString().toInt() }
        val after = br.readLine().map { it.toString().toInt() }

        val a = switch(1, n, after.toMutableList(), before.toMutableList())
        val b = switch(0, n, after.toMutableList(), before.toMutableList())

        if (a == -1 || b == -1) {

            sb.append(maxOf(a, b))
        } else {
            sb.append(minOf(a, b))
        }

        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `2138`().solution()
}
