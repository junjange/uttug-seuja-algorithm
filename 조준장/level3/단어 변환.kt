import kotlin.math.min

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        
        if (!words.contains(target)) return 0
        
        var answer = 1e9.toInt()
        var queue = ArrayList<Pair<String, Int>>()
        val visited = MutableList<Boolean>(words.size){false}
        
        queue.add(Pair(begin, 0))
        
        while (!queue.isEmpty()){
            val (newBegin, cnt) = queue.removeAt(0)
            
            if (newBegin == target) answer = min(answer, cnt)
            
            words.indices.forEach{
                if (wordCheck(newBegin, words[it]) && !visited[it]){
                    visited[it] = true
                    queue.add(Pair(words[it], cnt+1))
                }
            }
        }
        
        return answer
    }
    
    fun wordCheck(begin: String, target: String) : Boolean {
        var cnt : Int = 0
        begin.indices.forEach{
            if (begin[it] != target[it]) cnt ++ 
        }
        return if (cnt == 1) true else false 
    }
}
