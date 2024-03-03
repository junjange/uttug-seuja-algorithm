package implementation


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val m = List(5) { br.readLine().toInt() }.sorted()

    sb.append("${m.sum() / 5}\n")
    sb.append("${m[2]}")


    bw.write(sb.toString())
    br.close()
    bw.close()
}
