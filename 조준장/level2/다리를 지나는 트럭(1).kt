class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        val newTruckWeights = truck_weights.toMutableList()
        val deque = ArrayDeque<Int>()
        
        repeat(bridge_length) {
            deque.add(0)
        }
        
        while (deque.sum() != 0 || newTruckWeights.isNotEmpty()) {
            if (newTruckWeights.isNotEmpty()) {
                if (deque.sum() + newTruckWeights.first() <= weight) {
                    deque.removeFirst()
                    deque.add(newTruckWeights.removeFirst())
                    
                } else {
                    deque.removeFirst()
                    
                    if (newTruckWeights.isNotEmpty() && deque.sum() + newTruckWeights.first() <= weight) {
                        deque.add(newTruckWeights.removeFirst())
                    
                    } else {
                        deque.add(0)
                    }
                    
                }
                
            } else {
                    deque.removeFirst()
                    deque.add(0)
                }
            answer ++
            
        }
        
        
        return answer
    }
}
