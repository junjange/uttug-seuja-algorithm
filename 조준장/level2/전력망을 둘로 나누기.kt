import kotlin.math.abs
import kotlin.math.min

class Solution {
    var graph = mutableListOf<MutableList<Int>>()
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer = 100
        
        graph = MutableList<MutableList<Int>>(n + 1) {mutableListOf<Int>()}
        wires.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }
        
        wires.forEach {
            answer = min(answer, bfs(n, it[0], it[1]))
        }
        
        return answer
    }
    
    fun bfs(n: Int, x : Int, y : Int) : Int{
        val deque = ArrayDeque<Int>()
        deque.add(x)
        val visited = MutableList(n + 1) { false }
        visited[x] = true
        var cnt = 1
        // println(deque) 

        while (deque.isNotEmpty()) {
            // println(deque)
            val target = deque.removeFirst()
            
            for (nx in graph[target]) {
                if (visited[nx] == false) {
                    visited[nx] = true
                    
                    if (nx == y) continue
                    
                    deque.add(nx)
                    cnt += 1
                }
            }
        }
        
        return abs(n - cnt - cnt) 
        
    }
}
