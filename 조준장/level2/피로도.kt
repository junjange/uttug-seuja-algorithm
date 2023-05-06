class Solution {
    var answer: Int = 0

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val visited = BooleanArray(dungeons.size){false}
        backTracking(k, dungeons, visited, 0)
        return answer
    }
    
    fun backTracking(k: Int, dungeons: Array<IntArray>, visited : BooleanArray, cnt : Int){
        if (cnt > answer){
            answer = cnt
        }
        
        for (i in dungeons.indices){
            if (!visited[i] && k >= dungeons[i][0]){
                visited[i] = true
                backTracking(k - dungeons[i][1] , dungeons, visited, cnt+1)
                visited[i] = false
            }
        }   
    }
}
