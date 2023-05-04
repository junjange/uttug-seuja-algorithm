class Solution {
    fun solution(s: String): IntArray = s.substring(2 until s.length-2)
        .split("},{", ",")
        .groupBy { it }
        .toList()
        .sortedByDescending { it.second.count() }
        .map{it.first.toInt()}
        .toIntArray()
}
