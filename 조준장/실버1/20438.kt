class `20438` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, k, q, m) = br.readLine().split(" ").map { it.toInt() }
        val sleepStudents = br.readLine().split(" ").map { it.toInt() }
        val qrStudents = br.readLine().split(" ").map { it.toInt() }
        val visited = MutableList(n + 3) { 1 }
        val sleep = MutableList(n + 3) { false }

        sleepStudents.forEach {
            sleep[it] = true
        }

        qrStudents.forEach { studentNum ->
            if (!sleep[studentNum]) {
                for (s in studentNum until n + 3 step studentNum) {
                    if (sleep[s]) continue
                    visited[s] = 0
                }
            }
        }

        repeat(m) {
            val (s, e) = br.readLine().split(" ").map { it.toInt() }
            val answer = visited.subList(s, e + 1).count { it == 1 }
            sb.append("$answer\n")
        }
        bw.write(sb.dropLast(1).toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `20438`().solution()
}
