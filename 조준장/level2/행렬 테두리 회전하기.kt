class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val answer = mutableListOf<Int>()
        
        val graph : MutableList<MutableList<Int>> = mutableListOf()
        
        var cnt = 1
        repeat(rows) { i ->
            val tempGraph = mutableListOf<Int>()
            repeat(columns) { j ->
                tempGraph.add(cnt)
                cnt++
            }
            graph.add(tempGraph)
        }
        
        for (querie in queries) {
            val sx = querie[0] - 1
            val sy = querie[1] - 1
            val ex = querie[2] - 1
            val ey = querie[3] - 1
            
            val newGraph = MutableList(rows) { MutableList(columns) { 0 } }
            var minValue = Int.MAX_VALUE
            
            // 오른쪽
            for (ny in sy until ey) {
                newGraph[sx][ny + 1] = graph[sx][ny]
                minValue = minOf(minValue, graph[sx][ny])
            }
            
            // 아래
            for (nx in sx until ex) {
                newGraph[nx + 1][ey] = graph[nx][ey]
                minValue = minOf(minValue, graph[nx][ey])
            }

            // 왼쪽
            for (ny in sy until ey) {
                newGraph[ex][ny] = graph[ex][ny + 1]
                minValue = minOf(minValue, graph[ex][ny + 1])
            }

            // 위로
            for (nx in sx until ex) {
                newGraph[nx][sy] = graph[nx + 1][sy]
                minValue = minOf(minValue, graph[nx + 1][sy])
            }

            repeat(rows) { i ->
                repeat(columns) { j ->
                    if(newGraph[i][j] != 0) {
                        graph[i][j] = newGraph[i][j]
                    }
                    
                }
            }
            answer.add(minValue)
        }
        
        return answer.toIntArray()
    }
}
