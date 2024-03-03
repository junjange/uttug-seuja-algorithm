package implementation


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val x = br.readLine().split(" ").map { it.toInt() }.sortedDescending()

    sb.append("${x[k-1]}")

    bw.write(sb.toString())
    br.close()
    bw.close()
}
