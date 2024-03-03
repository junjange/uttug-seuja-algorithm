data class Node(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val m =
        List(n) { br.readLine().split(" ").map { it.toInt() } }
            .map { Node(it[0], it[1]) }
            .sortedWith(compareBy<Node> { it.y }.thenBy { it.x })

    m.forEach {
        sb.append("${it.x} ${it.y}\n")
    }

    bw.write(sb.toString())
    br.close()
    bw.close()
}
