class Solution {
    fun solution(storey: Int): Int {
        var answer: Int = 0
        
        var newStorey = storey
        
        while(newStorey != 0) {
            val n = newStorey % 10
            
            if (n > 5) {
                answer += 10 - n
                newStorey += n
            } else if (n < 5) {
                answer += n
                newStorey -= n
            } else {
                println((newStorey / 10) % 10)
                if ((newStorey / 10) % 10 > 4) {
                    newStorey += 10
                }
                answer += n
                
            }
           newStorey /= 10
        }
            
        return answer
    }
}
