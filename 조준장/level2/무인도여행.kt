class Solution {
    data class Node(val x : Int, val y : Int)
    val visited = Array(101) { Array(101) { false }}
    var graph : List<List<String>> = emptyList()
    var n = 0
    var m = 0
    fun solution(maps: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        
        graph = maps.map { it.map { it.toString() } }
        n = graph.size
        m = graph.first().size
        
        repeat(n) { i ->
            repeat(m) { j ->
                if (graph[i][j] != "X" && !visited[i][j]) {
                    answer.add(bfs(Node(i, j)))
                }
            }
        }
        
        return if (answer.isEmpty()) intArrayOf(-1)
        else answer.sorted().toIntArray()
    }
    
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    fun bfs(node : Node) : Int {
        val queue = ArrayDeque<Node>()
        queue.add(node)
        visited[node.x][node.y] = true
        var answer = graph[node.x][node.y].toInt()
        while (queue.isNotEmpty()) {
            val next = queue.removeFirst()
            
            repeat(4) {
                val nx = next.x + dx[it]
                val ny = next.y + dy[it]
                
                if (nx in 0 until n && ny in 0 until m) {
                    if (!visited[nx][ny] && graph[nx][ny] != "X") {
                        answer += graph[nx][ny].toInt()
                        queue.addFirst(Node(nx, ny))
                        visited[nx][ny] = true
                    }
                }
            }
        }
        return answer
    }
}
