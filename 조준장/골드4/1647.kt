import java.util.*

class `1647` {

    data class Node(val a: Int, val b: Int, val c: Int)

    var parent: MutableList<Int> = mutableListOf()
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        parent = MutableList(n + 1) { it }
        val queue = PriorityQueue<Node> { o1, o2 ->
            o1.c - o2.c
        }

        repeat(m) {
            val node = br.readLine().split(" ").map { it.toInt() }.run { Node(this[0], this[1], this[2]) }
            queue.add(node)
        }

        val answer = mutableListOf<Node>()

        while (answer.size < n - 1 && queue.isNotEmpty()) {
            val next = queue.poll()

            if (find(next.a) == find(next.b)) continue
            union(next.a, next.b)
            answer.add(next)
        }

        val max = answer.maxBy { it.c }
        sb.append(answer.filter { it != max }.sumOf { it.c })
        bw.write(sb.toString())
        br.close()
        bw.close()
    }

    fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }


    fun union(u: Int, v: Int) {
        val root1 = find(u)
        val root2 = find(v)
        parent[root1] = root2
    }
}

fun main() {
    `1647`().solution()
}
