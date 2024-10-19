class `2143` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val t = br.readLine().toInt()
        val n = br.readLine().toInt()
        val aArr = br.readLine().split(" ").map { it.toInt() }
        val m = br.readLine().toInt()
        val bArr = br.readLine().split(" ").map { it.toInt() }


        val sumA = mutableListOf<Int>()
        val sumB = mutableListOf<Int>()

        for (i in 0 until n) {
            var sum = aArr[i]
            sumA.add(sum)
            for (j in i + 1 until n) {
                sum += aArr[j]
                sumA.add(sum)
            }
        }

        for (i in 0 until m) {
            var sum = bArr[i]
            sumB.add(sum)
            for (j in i + 1 until m) {
                sum += bArr[j]
                sumB.add(sum)
            }
        }

        sumA.sort()
        sumB.sort()

        var answer = 0L

        sumA.forEach { sa ->
            val target = t - sa
            var left = 0
            var right = sumB.size - 1


            var start = 0
            var end = sumB.size - 1
            while (start <= end) {
                val mid = (start + end) / 2

                if (sumB[mid] >= target) {
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            }

            left = end

            start = 0
            end = sumB.size - 1
            while (start <= end) {
                val mid = (start + end) / 2

                if (sumB[mid] > target) {
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            }

            right = end

            answer += right - left
        }

        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `2143`().solution()
}
