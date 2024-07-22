class Solution {
    fun solution(
        fees: IntArray,
        records: Array<String>,
    ): IntArray {
        var answer: IntArray = intArrayOf()
        val resultMap =
            records
                .map { it.split(" ") }
                .groupBy({ it[1] }, { it[0] }).toMutableMap()

        resultMap.forEach {
            if (it.value.size % 2 != 0) {
                resultMap[it.key] = resultMap[it.key]!! + "23:59"
            }
        }

        val answerMap =
            resultMap.entries.map { (key, value) ->
                var time = 0
                for (i in 0..value.size - 2 step 2) {
                    time += value[i + 1].toTime() - value[i].toTime()
                }
                key to calculate(fees, time)
            }

        val sortAnswerMap = answerMap.sortedBy { it.first }.map { it.second }

        return sortAnswerMap.toIntArray()
    }

    fun calculate(
        fees: IntArray,
        time: Int,
    ): Int {
        var nTime = time
        var coin = 0

        if (nTime <= fees[0]) return fees[1]
        coin += fees[1]
        nTime -= fees[0]

        var m = nTime / fees[2]
        val n = nTime % fees[2]
        
        if (n != 0) m++

        coin += fees[3] * m
        return coin
    }

    fun String.toTime(): Int {
        val (hours, min) = this.split(":")
        return hours.toInt() * 60 + min.toInt()
    }
}
