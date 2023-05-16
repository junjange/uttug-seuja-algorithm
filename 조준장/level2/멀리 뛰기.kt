class Solution {
    fun solution(n: Int): Long {
        var answer: Long = 0
        var dp : IntArray = IntArray(n+1){1}
        (2..n).forEach{dp[it] = (dp[it-1] + dp[it-2]) % 1234567}
        return dp[n] % 1234567
    }
}
