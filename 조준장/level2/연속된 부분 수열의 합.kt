data class Node(val length : Int, val start : Int, val end : Int)

class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: MutableList<Node> = mutableListOf()
        val n = sequence.size
        var sum_sequence = 0
        var end = 0
        
        for (start in sequence.indices){
            while (sum_sequence < k && end < n){
                sum_sequence += sequence[end]
                end += 1
            }
            
            if (sum_sequence == k) {
                answer.add(Node(end - start, start, end - 1))
            }
            sum_sequence -= sequence[start]
                        
        }
        
        answer.sortWith(compareBy<Node> { it.length }.thenBy { it.start })
        
        
        return intArrayOf(answer.first().start, answer.first().end)
    }
}
