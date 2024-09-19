class `14503` {
    data class Node(val r: Int, val c: Int, val d: Int)

    fun solution() {
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = readln().split(" ").map { it.toInt() }
        val (r, c, d) = readln().split(" ").map { it.toInt() }
        val graph = List(n) {
            readln().split(" ").map { it.toInt() }.toMutableList()
        }

        val queue = ArrayDeque<Node>()

        queue.add(Node(r, c, d))

        val direction = mapOf(
            0 to Pair(-1, 0),
            1 to Pair(0, 1),
            2 to Pair(1, 0),
            3 to Pair(0, -1),
        )

        var answer = 0
        while (queue.isNotEmpty()) {
            val target = queue.removeFirst()

            if (graph[target.r][target.c] == 0) {
                graph[target.r][target.c] = 2
                answer++
            }

            var flag = false
            for (i in 0..3) {
                val (checkR, checkC) = direction[i] ?: return
                val cr = target.r + checkR
                val cc = target.c + checkC

                if (cr in 0..n - 1 && cc in 0..m - 1) {
                    if (graph[cr][cc] == 0) {
                        flag = true
                        break
                    }
                }
            }

            if (flag) {
                val nd = when (target.d) {
                    0 -> 3
                    1 -> 0
                    2 -> 1
                    3 -> 2
                    else -> return
                }

                val (visitedR, visitedC) = direction[nd] ?: return
                val vr = target.r + visitedR
                val vc = target.c + visitedC

                if (vr in 0..n - 1 && vc in 0..m - 1) {
                    if (graph[vr][vc] == 0) {
                        queue.add(Node(vr, vc, nd))
                    } else {
                        queue.add(Node(target.r, target.c, nd))
                    }
                }
            } else {
                val nd = when (target.d) {
                    0 -> 2
                    1 -> 3
                    2 -> 0
                    3 -> 1
                    else -> return
                }

                val (visitedR, visitedC) = direction[nd] ?: return
                val vr = target.r + visitedR
                val vc = target.c + visitedC

                if (vr in 0..n - 1 && vc in 0..m - 1) {
                    if (graph[vr][vc] != 1) {
                        queue.add(Node(vr, vc, target.d))
                    }
                }
            }
        }
        sb.append(answer)
        bw.write(sb.toString())
        bw.close()
    }
}

fun main() {
    `14503`().solution()
}
