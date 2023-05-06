class Solution {
    fun solution(numbers: IntArray, target: Int): Int = 
    numbers.fold(listOf(0)){ list, i ->
        list.run{ 
            map{it+i} + map{it-i}
        }
    }.count{it == target}
}
