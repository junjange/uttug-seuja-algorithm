class `13144` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val nums = br.readLine().split(" ").map { it.toLong() }
        var answer = 0L
        var end = 0
        val visited = BooleanArray(1000002)
        var start = 0
        while (start < n && end < n) {
            val sN = nums[start].toInt()
            val eN = nums[end].toInt()
            if (visited[eN].not()) {
                visited[eN] = true
                end++
                answer += (end - start)
                continue
            }
            visited[sN] = false
            start++
        }

        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `13144`().solution()
}


/**
 *
 * start : 0 end : 0 nums.size : [1] answer : 0
 * start : 0 end : 1 nums.size : [1] answer : 0
 * start : 1 end : 1 nums.size : [1] answer : 1
 * start : 1 end : 2 nums.size : [1] answer : 1
 * start : 2 end : 2 nums.size : [1] answer : 2
 * start : 2 end : 3 nums.size : [1] answer : 2
 * start : 3 end : 3 nums.size : [1] answer : 3
 * start : 3 end : 4 nums.size : [1] answer : 3
 * start : 4 end : 4 nums.size : [1] answer : 4
 *
 *
 * 5
 * 1 2 3 1 2
 *
 * 시작
 * 1
 * 1 2
 * 1 2 3
 * 1 2 3 1 -> n(n+1)/2
 * 2 3 1
 * 2 3 1 2 -> n(n+1)/2
 * 3 1 2
 * 끝
 *
 * n(n+1)/2
 *
 *
 * 1
 * 1 2
 * 1 2 3
 * 2
 * 2 3
 * 2 3 1
 * 3
 * 3 1
 * 3 1 2
 * 1 2
 * 1
 * 2
 *
 *
 *
 * 1 2 3 2 1
 *
 * 1 2 3 -> 6
 * 2 3 -> 3
 * 3 2 1 -> 6
 *
 *
 *
 * 5
 * 1 2 3 2 1
 *
 * 1
 * 1 2
 * 1 2 3
 * 2
 * 2 3
 * 3
 * 3 2
 * 3 2 1
 * 2
 * 2 1
 * 1
 *
 * */
