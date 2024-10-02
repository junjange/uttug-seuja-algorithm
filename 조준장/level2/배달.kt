import java.util.*

class Solution {
    data class Node(val position : Int, val time : Int = 0)
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 0
        
      val graph = Array(N + 1) { mutableListOf<Node>() }
        road.forEach {
            val a = it.first()
            val b = it[1]
            val c = it.last()
            graph[a].add(Node(b, c))
            graph[b].add(Node(a, c))
        }

        val queue = PriorityQueue<Node>() { o1, o2 ->
            o2.time - o1.time
        }
        val visited = IntArray(N + 1) { Int.MAX_VALUE }
        visited[1] = 0
        queue.add(Node(1))
        
        while (queue.isNotEmpty()) {
            val (targetPosition, targetTime) = queue.poll()
            
            for (next in graph[targetPosition]) {
                val totalTime = next.time + targetTime
                if (totalTime <= k && totalTime < visited[next.position]) {
                    visited[next.position] = totalTime
                    queue.add(Node(next.position, totalTime))
                }
            }
        }
        
        for (v in visited) {
            if (v != Int.MAX_VALUE) answer ++
        }

        return answer
    }
}
