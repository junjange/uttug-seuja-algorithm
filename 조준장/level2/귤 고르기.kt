class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var limit : Int = 0
        
        tangerine.groupBy{it}.toList()
            .sortedByDescending{it.second.size}.forEach{
                if (limit >= k){
                    return answer
                }
                
                answer ++
                limit += it.second.size            
        }

        return answer
    }
}
