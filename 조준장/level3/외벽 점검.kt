import kotlin.math.min

class Solution {
    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        val len = weak.size
        val extended = IntArray(len * 2)
        for (i in weak.indices) {
            extended[i] = weak[i]
            extended[i + len] = weak[i] + n
        }

        var answer = Int.MAX_VALUE

        val permutations = mutableListOf<List<Int>>()
        permute(dist, 0, permutations)

        for (start in 0 until len) {
            for (friends in permutations) {
                var count = 1
                var coverage = extended[start] + friends[0]

                // 청소 범위 체크
                for (idx in start until start + len) {
                    // 청소를 못하면 새로운 친구가 청소
                    if (extended[idx] > coverage) {
                        count++
                        if (count > friends.size) break
                        coverage = extended[idx] + friends[count - 1]
                    }
                }

                if (count <= friends.size) {
                    answer = min(answer, count)
                }
            }
        }

        return if (answer == Int.MAX_VALUE) -1 else answer
    }

    private fun permute(arr: IntArray, start: Int, result: MutableList<List<Int>>) {
        if (start == arr.size) {
            result.add(arr.toList())
            return
        }
        for (i in start until arr.size) {
            arr.swap(start, i)
            permute(arr, start + 1, result)
            arr.swap(start, i)
        }
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }
}
