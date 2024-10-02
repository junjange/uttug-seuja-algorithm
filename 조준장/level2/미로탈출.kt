
import java.util.*

class Solution {
    data class Node(val x: Int, val y: Int, val time: Int = 0)

    var n = 0
    var m = 0
    var graph: List<List<String>> = emptyList()
    fun solution(maps: Array<String>): Int {
        var answer: Int = 0
        graph = maps.map { map -> map.map { it.toString() } }
        n = graph.size
        m = graph.first().size
        var s = Node(0, 0)
        var e = Node(0, 0)
        var l = Node(0, 0)

        graph.forEachIndexed { i, items ->
            items.forEachIndexed { j, item ->
                if (item == "S") {
                    s = Node(i, j)
                }

                if (item == "E") {
                    e = Node(i, j)
                }

                if (item == "L") {
                    l = Node(i, j)
                }
            }
        }

        val sl = bfs(s, l)
        if (sl == -1) return -1
        val le = bfs(l, e)
        if (le == -1) return -1

        return sl + le
    }


    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)


    fun bfs(s: Node, e: Node): Int {
        val queue = PriorityQueue<Node>() { o1, o2 ->
            o1.time - o2.time
        }
        queue.add(s)
        
        val visited = Array(n) { Array(m) { false } }
        visited[s.x][s.y] = true

        while (queue.isNotEmpty()) {
            val (cx, cy, ct) = queue.poll()

            if (cx == e.x && cy == e.y) {
                return ct
            }

            for (i in 0..3) {
                val nx = cx + dx[i]
                val ny = cy + dy[i]

                if (nx in 0..n - 1 && ny in 0..m - 1) {
                    if (!visited[nx][ny] && graph[nx][ny] != "X") {
                        visited[nx][ny] = true
                        queue.add(Node(nx, ny, ct + 1))
                    }
                }

            }
        }

        return -1
    }
}
