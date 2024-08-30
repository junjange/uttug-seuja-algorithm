class `28422` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }
        val dp = MutableList(n) { 0 }

        if (n > 1) {
            dp[1] = Integer.toBinaryString(arr[0] xor arr[1]).count { it == '1' }
        }

        if (n > 2) {
            dp[2] = Integer.toBinaryString(arr[0] xor arr[1] xor arr[2]).count { it == '1' }
        }
        if (n > 3) {
            dp[3] = Integer.toBinaryString(arr[2] xor arr[3]).count { it == '1' } + dp[1]
        }

        for (i in 4 until n) {
            val two = Integer.toBinaryString(arr[i] xor arr[i - 1]).count { it == '1' } + dp[i - 2]
            val three = Integer.toBinaryString(arr[i] xor arr[i - 1] xor arr[i - 2]).count { it == '1' } + dp[i - 3]

            dp[i] = maxOf(two, three)
        }

        sb.append(dp.last())
        bw.write(sb.toString())

        bw.close()
        br.close()

    }
}


fun main() {
    `28422`().solution()
}
