class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray>
    = Array(arr1.size){ i ->
        IntArray(arr2[0].size){ j ->
            var value : Int = 0
            arr2.indices.forEach{ k -> value += arr1[i][k] * arr2[k][j] }
            value
        }            
    }
}
