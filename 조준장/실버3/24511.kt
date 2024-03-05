fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val num = br.readLine().toInt()
    val mode = br.readLine().split(" ").map { it.toInt() }
    val queueStack = br.readLine().split(" ").map { it.toInt() }
    var m = br.readLine().toInt()
    val insert = br.readLine().split(" ").map { it.toInt() }

    for (i in num - 1 downTo 0) {
        if (m == 0) break
        if (mode[i] == 0) {
            sb.append("${queueStack[i]} ")
            m--
        }
    }

    for (i in insert.indices) {
        if (m == 0) break
        sb.append("${insert[i]} ")
        m--
    }

    bw.write(sb.toString())
    br.close()
    bw.close()
}
