class `22233`() {
    fun solution() {
        val br = System.`in`.buffered().bufferedReader()
        val bw = System.out.buffered().bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val keyword = mutableMapOf<String, Int>()
        repeat(n) {
            keyword[br.readLine()] = 1
        }

        val results = List(m) {
            br.readLine().split(",").toList()
        }

        results.forEach { result ->
            result.forEach {
                if (keyword[it] != null) {
                    keyword.remove(it)
                }
            }
            sb.append(keyword.size.toString() + "\n")
        }

        sb.dropLast(1)
        bw.write(sb.toString())

        bw.close()
        br.close()

    }

}


fun main() {
    `22233`().solution()
}
