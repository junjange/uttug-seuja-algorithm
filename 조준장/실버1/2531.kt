class `2531` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, d, k, c) = br.readLine().split(" ").map { it.toInt() }
        val sushis = MutableList(n) { br.readLine().toInt() }
        sushis += sushis.subList(0, k)

        val arr = ArrayDeque<Int>(sushis.subList(0, k))
        var answer = arr.toSet().size
        if (!arr.contains(c)) {
            answer += 1
        }

        for (i in k until sushis.size) {
            arr.removeFirst()
            arr.add(sushis[i])
            var temp = arr.toSet().size
            if (!arr.contains(c)) {
                temp += 1
            }
            answer = maxOf(answer, temp)
        }

        sb.append(answer)

        bw.write(sb.toString())
        bw.close()
        br.close()
    }
}

fun main() {
    `2531`().solution()
}
