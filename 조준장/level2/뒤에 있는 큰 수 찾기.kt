class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = IntArray(numbers.size){0}
        var stack = ArrayList<Int>()
        
        numbers.indices.forEach{
            while (!stack.isEmpty() && numbers[stack.last()] < numbers[it]){
                answer[stack.removeLast()] = numbers[it]
            }
            stack.add(it)
            
        }
        
        stack.forEach{
            answer[it] = -1
        }
        
        return answer
    }
}
