import java.util.*

class `1197` {

    data class Node(val a: Int, val b: Int, val c: Int)

    private var parent: MutableList<Int> = mutableListOf()

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (v, e) = br.readLine().split(" ").map { it.toInt() }

        parent = MutableList(v + 1) { it }
        val queue = PriorityQueue<Node> { o1, o2 ->
            o1.c - o2.c
        }

        repeat(e) {
            val node = br.readLine().split(" ").map { it.toInt() }.run { Node(this[0], this[1], this[2]) }
            queue.add(node)
        }

        val answer = mutableListOf<Node>()
        while (answer.size < v - 1 && queue.isNotEmpty()) {
            val (a, b, c) = queue.poll()

            if (find(a) == find(b)) continue
            union(a, b)
            answer.add(Node(a, b, c))
        }

        sb.append(answer.sumOf { it.c })
        bw.write(sb.toString())
        br.close()
        bw.close()
    }

    private fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

    private fun union(u: Int, v: Int) {
        val root1 = find(u)
        val root2 = find(v)

        parent[root1] = root2
    }
}


fun main() {
    `1197`().solution()
}
