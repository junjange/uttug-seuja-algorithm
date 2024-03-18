class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0

        val newQueue1 = ArrayDeque<Long>()
        val newQueue2 = ArrayDeque<Long>()
        
        var sumQueue1 = queue1.sum().toLong()
        var sumQueue2 = queue2.sum().toLong()
        
         for (i in queue1.indices) {
            newQueue1.add(queue1[i].toLong())
            newQueue2.add(queue2[i].toLong())
        }
       
        while (sumQueue1 != sumQueue2) {

            if (answer > queue1.size * 3) {
                return@solution -1
            }
            
            if (sumQueue1 > sumQueue2) {
                val target = newQueue1.removeFirst()
                sumQueue1 -= target
                sumQueue2 += target
                newQueue2.add(target)
                
            } else {
                val target = newQueue2.removeFirst()
                sumQueue2 -= target
                sumQueue1 += target
                newQueue1.add(target)
                
            }
            
            answer += 1
            
        }



        return answer
    }
}
