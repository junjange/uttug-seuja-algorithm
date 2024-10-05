class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0
        
        var start = 1
        var end = stones.maxOf{ it }
        
        while (start <= end) {
            var mid = (start + end) / 2
            
            var cnt = 0
            for (stone in stones) {
                if (stone - mid >= 0) {
                    cnt = 0
                } else {
                    cnt++
                }
                
                if (cnt >= k) {
                    break
                }
            }
            
            if (cnt < k) {
                answer = mid
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        
        return answer
    }
}
