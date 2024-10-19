class Solution {
    var binaryString = ""
    fun solution(numbers: LongArray): IntArray {
        
        var answer: MutableList<Int> = mutableListOf()
        numbers.forEach { number ->
            binaryString = number.toString(2)
            val closestPowerOfTwo = nextPowerOfTwo(binaryString.length)
            var difference = closestPowerOfTwo - binaryString.length - 1
            binaryString = "0".repeat(difference) + binaryString
            var flag = 0
            if (dfs(binaryString)) flag = 1
            answer.add(flag)
            
        }
        return answer.toIntArray()
    }

    fun nextPowerOfTwo(n: Int): Int {
        var power = 1
        while (power <= n) {
            power *= 2
        }
        return power
    }
    
    fun dfs(number: String): Boolean {
        val mid = (number.length - 1) / 2
        val root = number[mid]
        val left = number.substring(0, mid)
        val right = number.substring(mid + 1, number.length)

        if (root == '0' && (left[(left.length - 1) / 2] == '1' || right[(right.length - 1) / 2] == '1')) {
            return false
        }

        var valid = true
        if (left.length >= 3) {
            valid = dfs(left)
            if (valid) {
                valid = dfs(right)
            }
        }
        return valid
    }
}
