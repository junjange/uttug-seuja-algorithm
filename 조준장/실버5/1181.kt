data class Node(val word: String, val wordLength: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val m =
        List(n) { br.readLine() }
            .toSet()
            .map { Node(it, it.length) }
            .sortedWith(compareBy<Node> { it.wordLength }.thenBy { it.word })

    m.forEach {
        sb.append("${it.word}\n")
    }

    bw.write(sb.toString())
    br.close()
    bw.close()
}
