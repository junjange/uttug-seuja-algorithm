class Solution {
    fun solution(numbers: IntArray): String {
        var answer = numbers.sortedByDescending { it.toString().repeat(3).take(4) }.joinToString("")
            
        return if (answer.startsWith("0")) {
             "0"
        } else {
             answer
        }
    }
}
