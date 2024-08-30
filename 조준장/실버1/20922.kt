class `20922`() {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val arr = br.readLine().split(" ").map { it.toInt() }

        val numberMap = mutableMapOf<Int, Int>()
        var start = 0
        var end = 0
        var count = 0

        var answer = Int.MIN_VALUE

        while (start < n) {
            while (end < n) {
                val value = numberMap.getOrDefault(arr[end], 0)
                if (value >= m) {
                    break
                }
                numberMap[arr[end++]] = value + 1
                count++
            }
            answer = answer.coerceAtLeast(count--)
            numberMap[arr[start]] = numberMap[arr[start]]!! - 1
            start++

        }
        sb.append(answer)

        bw.write(sb.toString())

        bw.close()
        br.close()

    }

}


fun main() {
    `20922`().solution()
}
