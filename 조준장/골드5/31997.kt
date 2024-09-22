class `31997` {
    fun solution2() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()
        val (n, m, t) = br.readLine().split(" ").map { it.toInt() }

        val starts = MutableList(t + 1) { mutableListOf<Int>() }
        val ends = MutableList(t + 1) { mutableListOf<Int>() }
        val friends = MutableList(n + 1) { mutableListOf<Int>() }

        repeat(n) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            starts[a].add(it + 1)
            ends[b].add(it + 1)
        }

        repeat(m) {
            val (c, d) = br.readLine().split(" ").map { it.toInt() }
            friends[c].add(d)
            friends[d].add(c)
        }

        val joined = MutableList(n + 1) { false }
        var answer = 0

        for (i in 0 until t) {
            for (c in ends[i]) {
                joined[c] = false

                for (d in friends[c]) {
                    if (joined[d]) {
                        answer--
                    }
                }
            }

            for (c in starts[i]) {
                joined[c] = true

                for (d in friends[c]) {
                    if (joined[d]) {
                        answer++
                    }
                }
            }

            sb.append("$answer\n")
        }

        bw.write(sb.dropLast(1).toString())
        br.close()
        bw.close()
    }
}


fun main() {
    `31997`().solution2()
}
