class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = IntArray(numbers.size) { -1 }
        
        val stack = mutableListOf<Int>()
        
        numbers.indices.forEach {
            while (!stack.isEmpty() && numbers[stack.last()] < numbers[it]){
                answer[stack.removeLast()] = numbers[it]
            }
            stack.add(it)
        }
        
        return answer
    }
}
