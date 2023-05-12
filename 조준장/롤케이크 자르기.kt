class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        var a = HashMap<Int, Int>()
        var b = mutableSetOf<Int>()
        topping.toSet().forEach{ num ->
            a += num to topping.count{it == num}
        }
        
        topping.forEach{ tp ->
            a[tp] = a[tp]!! - 1
            b.add(tp)
            
            if (a[tp] == 0) a.remove(tp)
            if (a.size == b.size) answer++
    
        }
        
        
        return answer
    }
}
