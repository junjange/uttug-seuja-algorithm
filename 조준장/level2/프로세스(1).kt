class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        var newPriorities = priorities.toMutableList()
        var target = newPriorities.maxOf { it }
        
        while (true) {
            newPriorities.indices.forEach {
                if (newPriorities[it] == target) {
                    answer++
                    
                    if (it == location) {
                        return@solution answer
                    }
                    
                    newPriorities[it] = 0
                    target = newPriorities.maxOf { it }
                }
                
            }
        }
        
        
        return answer
    }
}
