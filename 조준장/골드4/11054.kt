package implementation

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }

    val answer = MutableList(n) { 0 }
    val answerReserved = MutableList(n) { 0 }

    val dp = mutableListOf<Int>()
    val dpReversed = mutableListOf<Int>()


    for (i in 0 until n) {
        if (dp.isEmpty()) {
            dp.add(a[i])
        } else {
            if (dp.last() < a[i]) {
                dp.add(a[i])
            } else {
                val index = dp.binarySearch(a[i])
                if (index < 0) dp[-(index + 1)] = a[i]
                else dp[index] = a[i]
            }
        }

        answer[i] = dp.size

        if (dpReversed.isEmpty()) {
            dpReversed.add(a[n - i - 1])
        } else {
            if (dpReversed.last() < a[n - i - 1]) {
                dpReversed.add(a[n - i - 1])
            } else {
                val index = dpReversed.binarySearch(a[n - i - 1])
                if (index < 0) dpReversed[-(index + 1)] = a[n - i - 1]
                else dpReversed[index] = a[n - i - 1]
            }
        }

        answerReserved[n - i - 1] = dpReversed.size
    }


    val answerResult = MutableList(n) { 0 }
    repeat(n) {
        answerResult[it] = answer[it] + answerReserved[it]
    }

    sb.append(answerResult.max() - 1)
    bw.write(sb.toString())

    br.close()
    bw.close()

}
