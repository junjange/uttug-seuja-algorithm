class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var new_a : Int = a
        var new_b : Int = b
        while (new_a != new_b){
            answer += 1
            new_a = (new_a + 1) / 2
            new_b = (new_b + 1) / 2
        }
        
        return answer
    }
}
