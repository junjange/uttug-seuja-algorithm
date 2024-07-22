class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        val visited = BooleanArray(1000000001) { false }
        val queue = ArrayDeque<Node>()
        queue.add(Node(x, 0))
        visited[x] = true
        
        while (queue.isNotEmpty()) {
            val target = queue.removeFirst()
            
            if (target.x == y) return target.count
            if (target.x > y) continue
            
            val first = target.x + n
            val second = target.x * 2
            val third = target.x * 3
            
            if (!visited[first]) {
                visited[first] = true
                queue.add(Node(first, target.count + 1))
            }
            
            if (!visited[second]) {
                visited[second] = true
                queue.add(Node(second, target.count + 1))
            }
            
            if (!visited[third]) {
                visited[third] = true
                queue.add(Node(third, target.count + 1))
            }
        }
        
        return -1
    }
}

data class Node (
    val x : Int,
    val count : Int
)
