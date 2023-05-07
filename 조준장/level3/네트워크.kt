class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val queue = mutableListOf<Int>()
        val visited = mutableListOf<Int>()
        
        (0 until n).forEach{
            if(!visited.contains(it)){
                queue.add(it)
                answer ++ 
                while (!queue.isEmpty()){

                    var target = queue.removeAt(0)
                    
                    for (i in 0 until n){
                        if (computers[target][i] == 1 && !visited.contains(i)){
                            visited.add(i)
                            queue.add(i)
                        }
                    }
                }
            }
        }
        
        return answer
    }
}
