class Solution {
    fun solution(elements: IntArray): Int {
        val answer : MutableSet<Int> = mutableSetOf<Int>()
        var newElements = elements + elements
        elements.indices.forEach{ i ->
            elements.indices.forEach{ j ->
                answer.add(newElements.slice(i..i+j).sum())
                
            }
        }
        
        return answer.size
    }
}
