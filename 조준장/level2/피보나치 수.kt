class Solution {
    fun solution(n: Int): Int {
        var answer = IntArray(n+1){1}
        (3..n).forEach{ answer[it] = (answer[it-2] + answer[it-1]) % 1234567}
        return answer[n]
    }
}
