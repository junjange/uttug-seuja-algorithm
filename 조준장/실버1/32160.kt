class `31260` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = ArrayDeque(List(n - 1) { it + 1 })
        val answer = mutableListOf<String>()
        while (arr.size > 1) {
            val last1 = arr.removeLast()
            val last2 = arr.removeLast()
            arr.addFirst(kotlin.math.abs((last1 - last2)))

            answer.add("$last1 $last2\n")
        }

        sb.append("${n - arr.first()}\n")
        answer.forEach { a ->
            sb.append(a)
        }
        sb.append("$n ${arr.first()}\n")

        bw.write(sb.dropLast(1).toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `31260`().solution()
}
