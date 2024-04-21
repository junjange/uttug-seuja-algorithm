class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0

        val a = mutableMapOf<Int, Int>()
        val b = mutableSetOf<Int>()

        topping.toSet().forEach { t ->
            a += t to topping.count { it == t }
        }
        
        topping.forEach {
            a[it] = a[it]!! - 1
            b.add(it)
            
            if (a[it] == 0) a.remove(it)
            if (a.size == b.size) answer ++
        }

        return answer
    }
}
