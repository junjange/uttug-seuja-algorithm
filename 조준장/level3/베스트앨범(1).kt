class Solution {
    fun solution(
        genres: Array<String>,
        plays: IntArray,
    ): IntArray {
        var answer = mutableListOf<Int>()

        val m = mutableMapOf<String, Int>()
        val mist = mutableMapOf<String, MutableList<Pair<Int, Int>>>()

        genres.forEachIndexed { idx, genre ->
            if (genre !in m) {
                m[genre] = plays[idx]
                mist[genre] = mutableListOf(Pair(plays[idx], idx))
            } else {
                m[genre] = m[genre]!! + plays[idx]
                mist[genre]?.add(Pair(plays[idx], idx))
            }
        }

        val ms = m.entries.sortedByDescending { it.value }


        ms.forEach { msItem ->
            println(msItem)
            val key = msItem.key

            mist[key]!!.sortedBy { it.second }.sortedByDescending { it.first }.take(2).forEach {
                answer.add(it.second)
            }
        }

        return answer.toIntArray()
    }
}
