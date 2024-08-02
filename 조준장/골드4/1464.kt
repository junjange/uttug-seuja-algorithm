class `1464` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val words = br.readLine().map { it.toString() }

        val answer = mutableListOf(words.first())

        for (i in 1..<words.size) {
            if (words[i] <= answer.first()) {
                answer.add(0, words[i])
            } else {
                answer.add(words[i])
            }
        }

        sb.append(answer.joinToString(""))
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

}

fun main() {
    `1464`().solution()
}
