import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        var box = 1
        var index = 0
        val temp = Stack<Int>()

        while (index < order.size) {
            if (order[index] == box) {
                index ++ 
            } else if (order[index] > box) {
                temp.push(box)
            } else {
                if (temp.size == 0) break
                if (temp.pop() == order[index]) {
                    index ++
                    continue
                } else {
                    break
                }
            }
            box ++
        }
        
        
        return index
    }
}
