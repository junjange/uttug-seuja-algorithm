class Solution {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        val belt = MutableList(order.size) { it + 1 }
        val stack = mutableListOf<Int>()
        
        belt.forEach { beltItem ->
            if (beltItem == order[answer]) {
                answer++
            } else{
                stack.add(beltItem)
            }
            
            while (stack.isNotEmpty() && stack.last() == order[answer]) {
                stack.removeLast()
                answer ++ 
            }
            
        }
        
        
        
        return answer
    }
}
