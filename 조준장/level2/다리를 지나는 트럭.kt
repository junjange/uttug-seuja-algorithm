class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        var truckWeights = truck_weights.toMutableList()
        var bridge = MutableList(bridge_length){0}
        
        while (!bridge.isEmpty()){
            answer++
            bridge.removeFirst()
            if (!truckWeights.isEmpty()){
                if (bridge.sum() + truckWeights[0] <= weight){
                    bridge.add(truckWeights.removeFirst())
                    continue
                } 
                bridge.add(0)
                
            }
            
        }
        
        
        return answer
    }
}
