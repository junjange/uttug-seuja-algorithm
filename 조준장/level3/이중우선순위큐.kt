class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        operations
            .map{it.split(" ")}
            .map{Pair(it[0], it[1].toInt())}
            .forEach{ 
                when (it.first){
                    "I" -> answer.add(it.second)
                    "D" -> { 
                        if (!answer.isEmpty()){
                            val num : Int = 
                            if (it.second == 1) { answer.maxOf{it} }
                            else { answer.minOf{it}}
                            answer.remove(num)
                        }
                    }
                }
            }
            
           return if (answer.isEmpty()) intArrayOf(0, 0)
           else intArrayOf(answer.maxOf{it}, answer.minOf{it})
    }
}
