import kotlin.math.min

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        
        if (x == y) return 0
        
        val visited = Array<Boolean>(1000001){false}
        var queue = ArrayList<Pair<Int, Int>>()
        queue.add(x to 1)
        
        while (!queue.isEmpty()){
            val (target, cnt) = queue.removeAt(0)
            val first = target + n
            val second = target * 2
            val third = target * 3
            
            if (first == y || second == y || third == y) return cnt
            else {
                if (first < y && !visited[first]){
                    queue.add(first to cnt+1)
                    visited[first] = true
                }
                if (second < y && !visited[second]) {
                    queue.add(second to cnt+1)
                    visited[second] = true
                    
                }
                if (third < y && !visited[third]){
                    queue.add(third to cnt+1)
                    visited[third] = true
                }

            }
        }
        
        return -1 
    }
}
