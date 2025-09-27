class Solution {
    fun solution(line: Array<IntArray>): Array<String> {
        var answer: MutableList<String> = mutableListOf<String>()
        val n = line.size

        val crossMap = mutableMapOf<Long, MutableSet<Long>>()
        var minX = Long.MAX_VALUE
        var maxX = Long.MIN_VALUE
        var minY = Long.MAX_VALUE
        var maxY = Long.MIN_VALUE

        for (i in 0 until n) {
            val (a, b, e) = line[i].map{ it.toLong() }
            for (j in i + 1 until n) {
                val (c, d, f) = line[j].map{ it.toLong() }

                val bottom : Long = a * d - b * c
                val xTop : Long = b * f- e * d
                val yTop : Long = e * c - a * f

                if (bottom == 0L || xTop % bottom != 0L || yTop % bottom != 0L) continue

                val x : Long = xTop / bottom
                val y : Long = yTop / bottom

                minX = minOf(x, minX)
                maxX = maxOf(x, maxX)
                minY = minOf(y, minY)
                maxY = maxOf(y, maxY)

                if (crossMap.containsKey(x)) {
                    crossMap[x]!!.add(y)
                } else {
                    crossMap[x] = mutableSetOf(y)
                }
            }
        }


        for (y in maxY downTo minY) {
            val sb = StringBuilder()

            for (x in minX .. maxX) {
                if (crossMap.containsKey(x) && crossMap[x]!!.contains(y)) {
                    sb.append("*")
                } else {
                    sb.append(".")
                }
            }
            answer.add(sb.toString())
        }

        return answer.toTypedArray()
    }
}
