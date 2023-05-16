import kotlin.math.*

class Solution {
    fun solution(citations: IntArray) : Int = 
    citations.sortedDescending()
        .mapIndexed { idx, item -> min(idx + 1, item) }
        .maxOf{it}

}
