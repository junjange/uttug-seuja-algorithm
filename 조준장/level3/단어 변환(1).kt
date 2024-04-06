import kotlin.math.min

data class Node(val word : String, val count : Int)

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = Int.MAX_VALUE

        var deque = ArrayDeque<Node>()
        deque.add(Node(begin, 0))

        val visited = mutableSetOf<String>()
        visited.add(begin)
        
        if (!words.contains(target)) return 0
        
        while (deque.isNotEmpty()) {
            val (targetDeque, count) = deque.removeFirst()

            if (targetDeque == target) {
              answer = min(answer, count)
              continue
            } 

            for (word in words) {
                if (word in visited) continue
                var cnt = 0
                word.indices.forEach {
                    if (word[it] != targetDeque[it]) cnt++
                }
            

                if (cnt == 1) {
                    deque.add(Node(word, count+1))
                    visited.add(word)
                }

            }


        }

        return answer
    }
}
